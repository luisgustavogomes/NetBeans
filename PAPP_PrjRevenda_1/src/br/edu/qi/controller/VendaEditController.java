/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.Carro;
import br.edu.qi.model.CarroBO;
import br.edu.qi.model.Pagamento;
import br.edu.qi.model.PagamentoBO;
import br.edu.qi.model.Proprietario;
import br.edu.qi.model.ProprietarioBO;
import br.edu.qi.model.Venda;
import br.edu.qi.model.VendaBO;
import br.edu.qi.util.HelperAlert;
import br.edu.qi.util.HelperNumbers;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class VendaEditController implements Initializable {

    private ObservableList<Venda> dados;
    private CarroBO carroBo = new CarroBO();
    private ProprietarioBO proprietarioBo = new ProprietarioBO();
    private VendaBO vendaBo = new VendaBO();
    private PagamentoBO pagamentoBo = new PagamentoBO();

    @FXML
    private Label lbAcessorios;
    @FXML
    private CheckBox ckArCondicionado;
    @FXML
    private CheckBox ckTocaFita;
    @FXML
    private CheckBox ckRodaLiga;
    @FXML
    private CheckBox ckTapetes;
    @FXML
    private CheckBox ckAlarme;
    @FXML
    private Label lbTipo;
    @FXML
    private RadioButton rbUtilitario;
    @FXML
    private ToggleGroup tgTipo;
    @FXML
    private RadioButton rbPasseio;
    @FXML
    private RadioButton rbOffRood;
    @FXML
    private RadioButton rbEsportivo;
    @FXML
    private RadioButton rbComercial;
    @FXML
    private Label lbEstado;
    @FXML
    private RadioButton rbNovo;
    @FXML
    private ToggleGroup tgEstado;
    @FXML
    private RadioButton rbUsado;
    @FXML
    private HBox hbKM;
    @FXML
    private Label lbKM;
    @FXML
    private Label lblNroVenda;
    @FXML
    private TextField txtNroVenda;
    @FXML
    private Label lblData;
    @FXML
    private DatePicker dpData;
    @FXML
    private TextField txtAno;
    @FXML
    private ComboBox<Proprietario> cbProprietario;
    @FXML
    private ComboBox<Carro> cbCarro;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private RadioButton rbAvista;
    @FXML
    private ToggleGroup tgEstado1;
    @FXML
    private RadioButton rbPrazo;
    @FXML
    private Label lblQtdeParcela;
    @FXML
    private TextField txtQtdeParcela;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnRemover;
    @FXML
    private TableView<Venda> tvConsulta;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn nroVendaCol;
    @FXML
    private TableColumn proprietarioCol;
    @FXML
    private TableColumn carroCol;
    @FXML
    private TableColumn estadoCol;
    @FXML
    private TableColumn valorCol;
    @FXML
    private TextField txtKM;
    @FXML
    private TextField txtValor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dados = FXCollections.observableArrayList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("idVenda"));
        nroVendaCol.setCellValueFactory(new PropertyValueFactory<>("nro"));
        proprietarioCol.setCellValueFactory(new PropertyValueFactory<>("proprietario"));
        carroCol.setCellValueFactory(new PropertyValueFactory<>("carro"));
        estadoCol.setCellValueFactory(new PropertyValueFactory<>("estado"));
        valorCol.setCellValueFactory(new PropertyValueFactory<>("valor"));
        DefaultRadion();
        tvConsulta.setItems(dados);
        carregarProprietario();
        carregarCarro();
        dados.addAll(carregarVenda());

    }

    private void carregarProprietario() {
        try {
            cbProprietario.getItems().addAll(proprietarioBo.findAllWithoutClose());
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    private void carregarCarro() {
        try {
            cbCarro.getItems().addAll(carroBo.findAllWithoutClose());
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
    }

    private List<Venda> carregarVenda() {
        try {
            return vendaBo.findAllWithoutClose();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
        return null;
    }

    private void DefaultRadion() {
        lblQtdeParcela.setVisible(false);
        txtQtdeParcela.setVisible(false);
        lbKM.setVisible(false);
        txtKM.setVisible(false);
    }

    @FXML
    private void HandlerEstadoNovo(ActionEvent event) {
        if (rbNovo.isSelected()) {
            txtKM.setText("0");
            lbKM.setVisible(false);
            txtKM.setVisible(false);
        }

    }

    @FXML
    private void HaldlerEstadoUsado(ActionEvent event) {
        if (rbUsado.isSelected()) {
            lbKM.setVisible(true);
            txtKM.setVisible(true);
        }
    }

    @FXML
    private void HandlerAvista(ActionEvent event) {
        if (rbAvista.isSelected()) {
            txtQtdeParcela.setText("1");
            lblQtdeParcela.setVisible(false);
            txtQtdeParcela.setVisible(false);
        }
    }

    @FXML
    private void HaldlerPrazo(ActionEvent event) {
        if (rbPrazo.isSelected()) {
            lblQtdeParcela.setVisible(true);
            txtQtdeParcela.setVisible(true);
        }
    }

    @FXML
    private void HandlerSalvar(ActionEvent event) throws Exception {
        try {
            validantion();
            Venda venda = new Venda(
                    cbCarro.getSelectionModel().getSelectedItem(),
                    cbProprietario.getSelectionModel().getSelectedItem(),
                    Integer.parseInt(txtNroVenda.getText()),
                    Date.valueOf(dpData.getValue()),
                    Integer.parseInt(txtAno.getText()),
                    txtDescricao.getText().isEmpty() ? "" : txtDescricao.getText(),
                    HelperNumbers.converterBooleanToByte(ckArCondicionado.isSelected()),
                    HelperNumbers.converterBooleanToByte(ckTocaFita.isSelected()),
                    HelperNumbers.converterBooleanToByte(ckRodaLiga.isSelected()),
                    HelperNumbers.converterBooleanToByte(ckTapetes.isSelected()),
                    HelperNumbers.converterBooleanToByte(ckAlarme.isSelected()),
                    ((RadioButton) tgTipo.getSelectedToggle()).getText(),
                    ((RadioButton) tgEstado.getSelectedToggle()).getText(),
                    Integer.parseInt(txtKM.getText()),
                    BigDecimal.valueOf(Double.parseDouble(txtValor.getText())),
                    Integer.parseInt(txtQtdeParcela.getText()));
            vendaBo.save(venda);
            List<Pagamento> p = vendaBo.parcelas(
                    Integer.parseInt(txtNroVenda.getText()),
                    venda,
                    Date.valueOf(dpData.getValue()),
                    BigDecimal.valueOf(Double.parseDouble(txtValor.getText())),
                    Integer.parseInt(txtQtdeParcela.getText()));
            pagamentoBo.save(p);
            dados.add(venda);
            HelperAlert.msgDialog("Venda salva com sucesso!", "Venda", Alert.AlertType.INFORMATION);
            clear();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Venda", Alert.AlertType.ERROR);
        }

    }

    @FXML
    private void HandlerRemover(ActionEvent event) {
        try {
            Venda v = tvConsulta.getSelectionModel().getSelectedItem();
            vendaBo.delete(v);
            dados.remove(v);
            HelperAlert.msgDialog("Venda removida com sucesso!", "Venda", Alert.AlertType.ERROR);
            clear();
        } catch (Exception e) {
            HelperAlert.msgDialog(e.getMessage(), "Venda", Alert.AlertType.ERROR);
        }
    }

    private void validantion() throws Exception {
        if (txtNroVenda.getText().isEmpty() || !HelperNumbers.isNumericInteger(txtNroVenda.getText())) {
            throw new Exception("Informe o número da venda!");
        }
        if (dpData.getValue() == null) {
            throw new Exception("Informe a data da venda!");
        }
        if (txtAno.getText().isEmpty() || !HelperNumbers.isNumericInteger(txtAno.getText())) {
            throw new Exception("Informe o ano!");
        }
        if (Integer.parseInt(txtAno.getText()) < 1900 || Integer.parseInt(txtAno.getText()) > 2019) {
            throw new Exception("Informe um ano valido para o veiculo!");
        }
        if (cbProprietario.getSelectionModel().getSelectedItem() == null) {
            throw new Exception("Selecione um proprietário!");
        }
        if (cbCarro.getSelectionModel().getSelectedItem() == null) {
            throw new Exception("Selecione um carro!");
        }
        if (!rbComercial.isSelected()) {
            if (!rbEsportivo.isSelected()) {
                if (!rbOffRood.isSelected()) {
                    if (!rbPasseio.isSelected()) {
                        if (!rbUtilitario.isSelected()) {
                            throw new Exception("Escolha um tipo!");
                        }
                    }
                }
            }
        }
        if (!rbNovo.isSelected()) {
            if (!rbUsado.isSelected()) {
                throw new Exception("Escolha um estado!");
            }
        }

        if (!rbNovo.isSelected()) {
            if (txtKM.getText().isEmpty() || !HelperNumbers.isNumericDouble(txtKM.getText())) {
                throw new Exception("Informe um KM valido ou maior que zero!");
            }
        }
        if (txtValor.getText().isEmpty() || !HelperNumbers.isNumericDouble(txtValor.getText())) {
            throw new Exception("Informe um valor!");
        }
        if (!rbAvista.isSelected()) {
            if (!rbPrazo.isSelected()) {
                throw new Exception("Escolha um prazo de pagamento!");
            }
        }

    }

    private void clear() {
        txtNroVenda.setText(null);
        dpData.setValue(null);
        txtAno.setText(null);
        cbProprietario.getSelectionModel().select(null);
        cbCarro.getSelectionModel().select(null);
        txtDescricao.setText(null);
        ckAlarme.setSelected(false);
        ckArCondicionado.setSelected(false);
        ckRodaLiga.setSelected(false);
        ckTapetes.setSelected(false);
        ckTocaFita.setSelected(false);
        rbAvista.setSelected(false);
        rbComercial.setSelected(false);
        rbEsportivo.setSelected(false);
        rbNovo.setSelected(false);
        rbOffRood.setSelected(false);
        rbPasseio.setSelected(false);
        rbPrazo.setSelected(false);
        rbUsado.setSelected(false);
        rbUtilitario.setSelected(false);
        txtKM.setText(null);
        txtValor.setText(null);
        txtQtdeParcela.setText(null);
    }
}
