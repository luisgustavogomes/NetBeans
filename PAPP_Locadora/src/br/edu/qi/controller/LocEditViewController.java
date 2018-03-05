package br.edu.qi.controller;

import br.edu.qi.model.LocacaoBO;
import br.edu.qi.model.LocacaoVO;
import br.edu.qi.utl.HelperNumbers;
import br.edu.qi.view.LocadoraModel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LocEditViewController implements Initializable {

    @FXML
    private Label lbNroLocacao;
    @FXML
    private Label lbVeiculo;
    @FXML
    private ComboBox cbVeiculo;
    @FXML
    private Label lbValor;
    @FXML
    private Label lbMulta;
    @FXML
    private TextField txValor;
    @FXML
    private TextField txMulta;
    @FXML
    private TextField txQtdeDias;
    @FXML
    private TextField txQtdeDiasAtraso;
    @FXML
    private Label lbAvista;
    @FXML
    private CheckBox ckAvista;
    @FXML
    private Button btCalcular;
    @FXML
    private TextField txTotal;
    @FXML
    private TextField txNroLocacao;
    @FXML
    private Label lbTotal;
    @FXML
    private Button btSalvar;
    @FXML
    private TableView<LocadoraModel> tvLocacao;
    @FXML
    private TableColumn nroLocacaoCol;
    @FXML
    private TableColumn veiculoCol;
    @FXML
    private TableColumn valorCol;
    @FXML
    private TableColumn qtdeDiasCol;
    @FXML
    private TableColumn multaCol;
    @FXML
    private TableColumn qtdeDiasAtrasadoCol;
    @FXML
    private TableColumn avistaCol;
    @FXML
    private TableColumn totalCol;
    @FXML
    private Button btLimpar;
    @FXML
    private Button btRemover;
    @FXML
    private Button btAtualizar;

    private Stage dialogStage;
    private LocacaoBO loc;
    private ObservableList<LocadoraModel> dados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbVeiculo.getItems().addAll("[Selecione...]", "Meriva", "Corsa", "Fox", "Palio");
        cbVeiculo.getSelectionModel().select(0);

        nroLocacaoCol.setCellValueFactory(new PropertyValueFactory<LocadoraModel, Integer>("nroLocacao"));
        veiculoCol.setCellValueFactory(new PropertyValueFactory<LocadoraModel, String>("veiculo"));
        valorCol.setCellValueFactory(new PropertyValueFactory<LocadoraModel, Double>("valor"));
        qtdeDiasCol.setCellValueFactory(new PropertyValueFactory<LocadoraModel, Integer>("qtdeDias"));
        multaCol.setCellValueFactory(new PropertyValueFactory<LocadoraModel, Double>("multa"));
        qtdeDiasAtrasadoCol.setCellValueFactory(new PropertyValueFactory<LocadoraModel, Integer>("qtdeDiasAtraso"));
        totalCol.setCellValueFactory(new PropertyValueFactory<LocadoraModel, Double>("total"));
        avistaCol.setCellValueFactory(new PropertyValueFactory<LocadoraModel, Double>("avista"));

        dados = FXCollections.observableArrayList();
        tvLocacao.setItems(dados);

        loc = new LocacaoBO();
    }

    public void setDialogStage(Stage dialog) {
        this.dialogStage = dialog;
    }

    private void validation() throws Exception {
        if (!HelperNumbers.isNumeric(txNroLocacao.getText()) || Integer.parseInt(txNroLocacao.getText()) <= 0) {
            throw new Exception("Informe um número de locação válido!");
        }
        if (cbVeiculo.getSelectionModel().getSelectedIndex() == 0) {
            throw new Exception("Selecione um veiculo!");
        }
        if (!HelperNumbers.isNumeric(txValor.getText()) || Double.parseDouble(txValor.getText()) <= 0) {
            throw new Exception("Informe um valor válido!");
        }
        if (!HelperNumbers.isNumeric(txQtdeDias.getText()) || Integer.parseInt(txQtdeDias.getText()) <= 0) {
            throw new Exception("Informe a quantidade de dias para locação!");
        }
        if (!txMulta.getText().isEmpty()) {
            if (!HelperNumbers.isNumeric(txMulta.getText()) || Double.parseDouble(txMulta.getText()) <= 0) {
                throw new Exception("Informe um valor válido para a multa!");
            }
        }
        if (!txQtdeDiasAtraso.getText().isEmpty()) {
            if (!HelperNumbers.isNumeric(txQtdeDiasAtraso.getText()) || Integer.parseInt(txQtdeDiasAtraso.getText()) <= 0) {
                throw new Exception("Informe um valor válido para a dias de atraso!");
            }
            if (Integer.parseInt(txQtdeDiasAtraso.getText()) >= 20) {
                throw new Exception("Não é permitido mais 20 dias atraso!");
            }
        }
        if (!txMulta.getText().isEmpty() && txQtdeDiasAtraso.getText().isEmpty()) {
            throw new Exception("Verificar o campo Dias de Atraso!");
        }
        if (txMulta.getText().isEmpty() && !txQtdeDiasAtraso.getText().isEmpty()) {
            throw new Exception("Verifica o campo Multa!");
        }

    }

    public void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Locadora");
        alert.setContentText(msg);
        alert.show();
    }

    private String resultadoTotal() {
        int qtdeDias = Integer.parseInt(txQtdeDias.getText());
        double valor = Double.parseDouble(txValor.getText());
        int qtdeDiasAtrasado = !txQtdeDiasAtraso.getText().isEmpty() ? Integer.parseInt(txQtdeDiasAtraso.getText()) : 0;
        double multa = !txMulta.getText().isEmpty() ? Double.parseDouble(txMulta.getText()) : 0;
        boolean avista = ckAvista.isSelected();
        return (loc.resultado(qtdeDias, valor, multa, qtdeDiasAtrasado, avista) + "");
    }

    @FXML
    private void handCalcular(ActionEvent event) {
        if (!txNroLocacao.getText().isEmpty()) {
            try {
                validation();
                txTotal.setText(resultadoTotal());
            } catch (Exception ex) {
                msgDialog("Dados insuficientes\n" + ex.getMessage(), Alert.AlertType.INFORMATION);
            }
        }
    }

    @FXML
    private void handSalvar(ActionEvent event) {
        try {
            validation();
            txTotal.setText(resultadoTotal());
            LocadoraModel dadosLoc = new LocadoraModel();
            dadosLoc.setNroMatricula(Integer.parseInt(txNroLocacao.getText()));
            dadosLoc.setVeiculo(cbVeiculo.getSelectionModel().getSelectedItem().toString());
            dadosLoc.setValor(Double.parseDouble(txValor.getText()));
            dadosLoc.setQtdeDias(Integer.parseInt(txQtdeDias.getText()));
            dadosLoc.setMulta(!txMulta.getText().isEmpty() ? Double.parseDouble(txMulta.getText()) : 0);
            dadosLoc.setQtdeDiasAtraso(!txQtdeDiasAtraso.getText().isEmpty() ? Integer.parseInt(txQtdeDiasAtraso.getText()) : 0);
            dadosLoc.setAvista(ckAvista.isSelected());
            dadosLoc.setTotal(Double.parseDouble(txTotal.getText()));

            loc.save(new LocacaoVO(
                    dadosLoc.getNroLocacao(),
                    dadosLoc.getVeiculo(),
                    dadosLoc.getValor(),
                    dadosLoc.getQtdeDias(),
                    dadosLoc.getMulta(),
                    dadosLoc.getQtdeDiasAtraso(),
                    dadosLoc.getTotal(),
                    dadosLoc.getAvista()));

            dados.add(dadosLoc);
            msgDialog("Locação salva com sucesso!", Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handVeiculoSelected(ActionEvent event) {
        if (cbVeiculo.getSelectionModel().getSelectedIndex() != 0) {
            if (cbVeiculo.getSelectionModel().getSelectedIndex() == 1) {
                txValor.setText("140");
            }
            if (cbVeiculo.getSelectionModel().getSelectedIndex() == 2) {
                txValor.setText("100");
            }
            if (cbVeiculo.getSelectionModel().getSelectedIndex() == 3) {
                txValor.setText("130");
            }
            if (cbVeiculo.getSelectionModel().getSelectedIndex() == 4) {
                txValor.setText("90");
            }
        } else {
            txValor.setText("");
        }
    }

    @FXML
    private void handLimpar(ActionEvent event) {
        txNroLocacao.setText("");
        cbVeiculo.getSelectionModel().select(0);
        txValor.setText("");
        txQtdeDias.setText("");
        txMulta.setText("");
        txQtdeDiasAtraso.setText("");
        ckAvista.setSelected(false);
    }

    @FXML
    private void handRemover(ActionEvent event)  {
        LocadoraModel locM = tvLocacao.getSelectionModel().getSelectedItem();
        
//        loc.remove( new LocacaoVO(
//                locM.getNroLocacao(),
//                locM.getVeiculo(),
//                locM.getValor(),
//                locM.getQtdeDias(),
//                locM.getMulta(),
//                locM.getQtdeDiasAtraso(),
//                locM.getTotal(),
//                locM.getAvista()));
    }

    @FXML
    private void handAtualizar(ActionEvent event) {
        
    }

   

    
    


}
