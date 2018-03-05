/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.Pagamento;
import br.edu.qi.model.PagamentoBO;
import br.edu.qi.model.Proprietario;
import br.edu.qi.util.HelperAlert;
import br.edu.qi.util.HelperDate;
import br.edu.qi.util.HelperNumbers;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class PagamentoEditController implements Initializable {

    private ObservableList<Pagamento> dados;
    private PagamentoBO pagamentoBo = new PagamentoBO();

    @FXML
    private TableView<Pagamento> tvConsulta;
    @FXML
    private Button btnBaixar;
    @FXML
    private Label lblDataPagamento;
    @FXML
    private DatePicker dpDataPagamento;
    @FXML
    private Label lblMulta;
    @FXML
    private TextField txtMulta;
    @FXML
    private TableColumn idCOL;
    @FXML
    private TableColumn nroCOL;
    @FXML
    private TableColumn dtVenctoCOL;
    @FXML
    private TableColumn dtPagtoCOL;
    @FXML
    private TableColumn multaCOL;
    @FXML
    private TableColumn valorliquidoCOL;
    @FXML
    private TableColumn liquidadoCOL;
    @FXML
    private TableColumn nomeCOL;
    @FXML
    private Button btnSelecionar;
    @FXML
    private Label lblID;
    @FXML
    private TextField txtID;
    @FXML
    private Label lblNro;
    @FXML
    private Label lblDataVencimento;
    @FXML
    private DatePicker dpDataVencimento;
    @FXML
    private TextField txtVlr;
    @FXML
    private TextField txtNro;
    @FXML
    private Label lblProprietario;
    @FXML
    private Label lblPago;
    @FXML
    private Button btnPesquisar;
    @FXML
    private ComboBox<String> cbProprietario;
    @FXML
    private ComboBox<String> cbPago;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dados = FXCollections.observableArrayList();
        idCOL.setCellValueFactory(new PropertyValueFactory<>("idPagamento"));
        nomeCOL.setCellValueFactory(new PropertyValueFactory<>("venda"));
        nroCOL.setCellValueFactory(new PropertyValueFactory<>("nroPagamento"));
        dtVenctoCOL.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
        dtPagtoCOL.setCellValueFactory(new PropertyValueFactory<>("dataPagamento"));
        multaCOL.setCellValueFactory(new PropertyValueFactory<>("multa"));
        valorliquidoCOL.setCellValueFactory(new PropertyValueFactory<>("valorLiquido"));
        liquidadoCOL.setCellValueFactory(new PropertyValueFactory<>("liquidacao"));
        atualizarTabela();
        carregaComboProprietarios(dados);
        carregaComboPagamento();
        tvConsulta.setItems(dados);
        btnBaixar.setVisible(false);
    }

    private void carregaComboPagamento() {
        cbPago.getItems().add("[Selecione...]");
        cbPago.getItems().addAll("1", "0");
        cbPago.getSelectionModel().select(0);
    }

    private void atualizarTabela() {
        tvConsulta.getItems().clear();
        List<Pagamento> pagtos = carregarPagamento();
        dados.addAll(pagtos);
    }

    private void carregaComboProprietarios(List<Pagamento> pagtos) {
        cbProprietario.getItems().add("[Selecione...]");
        List<Proprietario> proprietariosFull = new ArrayList<>();
        pagtos.forEach((pagto) -> {
            proprietariosFull.add(pagto.getVenda().getProprietario());
        });
        List<Proprietario> proprietarios = new ArrayList<>();
        proprietarios = proprietariosFull.stream().distinct().collect(Collectors.toList());
        for (Proprietario p : proprietarios) {
            cbProprietario.getItems().add(p.toString());
        }
        cbProprietario.getSelectionModel().select(0);
    }

    private List<Pagamento> carregarPagamento() {
        try {
            return pagamentoBo.findAllWithoutClose();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
        return null;
    }

    @FXML
    private void HandlerSelecionar(ActionEvent event) {
        Pagamento p = tvConsulta.getSelectionModel().getSelectedItem();
        if (p != null) {
            txtID.setText(p.getIdPagamento().toString());
            txtNro.setText(p.getNroPagamento());

            dpDataVencimento.setValue(HelperDate.toLocalDate(p.getDataVencimento()));
            dpDataPagamento.setValue(LocalDate.now());
            if (txtMulta.getText().isEmpty()) {
                txtMulta.setText("0");
            } else {
                txtMulta.setText(p.getMulta().toString());
            }
            txtVlr.setText(p.getValorLiquido().toString());
            btnBaixar.setVisible(true);
        }
    }

    @FXML
    private void HandlerBaixar(ActionEvent event) {
        try {
            Pagamento p = tvConsulta.getSelectionModel().getSelectedItem();
            if (p.getLiquidacao() != null) {
                throw new Exception("Lançamento já encontra-se quitado!");
            }
            Period period = Period.between(dpDataVencimento.getValue(), dpDataPagamento.getValue());
            if (validationJuros(period)) {
                validation();
                p.setValorLiquido(pagamentoBo.GetNovoValorLiquido(Double.parseDouble(txtMulta.getText()), p.getValorLiquido().doubleValue()));
                p.setMulta(BigDecimal.valueOf(Double.parseDouble(txtMulta.getText())));
                txtVlr.setText(p.getValorLiquido().toString());
            }
            dados.remove(p);
            p.setLiquidacao(HelperNumbers.converterBooleanToByte(Boolean.TRUE));
            p.setDataPagamento(Date.valueOf(dpDataPagamento.getValue()));
            pagamentoBo.update(p);
            dados.add(p);
            HelperAlert.msgDialog("Pagamento baixado com sucesso!", getClass().getName(), Alert.AlertType.INFORMATION);
            clear();
            btnBaixar.setVisible(false);
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    private boolean validationJuros(Period period) throws Exception {
        return !period.isNegative() && !period.isZero();
    }

    private void validation() throws Exception {
        if (txtMulta.getText().isEmpty() || !HelperNumbers.isNumericDouble(txtMulta.getText())) {
            throw new Exception("Informe um valor de juros valido!");
        }

    }

    private void clear() {
        txtID.setText("");
        txtNro.setText("");
        dpDataVencimento.setValue(null);
        dpDataPagamento.setValue(null);
        txtMulta.setText("");
        txtVlr.setText("");
    }

    private List<Pagamento> filtrarPagto(List<Pagamento> pagamentos) {
        Byte i = Byte.parseByte(cbPago.getSelectionModel().getSelectedItem());
        if (i == 0) {
            return pagamentos.stream().filter(p -> p.getLiquidacao() == null).collect(Collectors.toList());
        }
        return pagamentos.stream().filter(p -> p.getLiquidacao() == i).collect(Collectors.toList());
    }

    private List<Pagamento> filtrarProprietario(List<Pagamento> pagamentos) {
        String s = cbProprietario.getSelectionModel().getSelectedItem();
        return pagamentos.stream().filter(p -> p.getVenda().toString().equals(s)).collect(Collectors.toList());
    }

    @FXML
    private void HandlePesquisar(ActionEvent event) {
        if (cbPago.getSelectionModel().getSelectedIndex() == 0 && cbProprietario.getSelectionModel().getSelectedIndex() == 0) {
            atualizarTabela();
        }
        if (cbPago.getSelectionModel().getSelectedIndex() != 0 && cbProprietario.getSelectionModel().getSelectedIndex() == 0) {
            tvConsulta.getItems().clear();
            List<Pagamento> pagtosFull = carregarPagamento();
            List<Pagamento> pagtos = filtrarPagto(pagtosFull);
            dados.addAll(pagtos);
        }
        if (cbPago.getSelectionModel().getSelectedIndex() == 0 && cbProprietario.getSelectionModel().getSelectedIndex() != 0) {
            tvConsulta.getItems().clear();
            List<Pagamento> pagtosFull = carregarPagamento();
            List<Pagamento> pagtos = filtrarProprietario(pagtosFull);
            dados.addAll(pagtos);
        }
        if (cbPago.getSelectionModel().getSelectedIndex() != 0 && cbProprietario.getSelectionModel().getSelectedIndex() != 0) {
            tvConsulta.getItems().clear();
            List<Pagamento> pagtosFull = carregarPagamento();
            List<Pagamento> pagtosProprietarios = filtrarProprietario(pagtosFull);
            List<Pagamento> pagtos = filtrarPagto(pagtosProprietarios);
            dados.addAll(pagtos);
        }

    }

}
