/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.Main;
import br.edu.qi.model.CarroBO;
import br.edu.qi.model.CarroVO;
import br.edu.qi.view.CarroModel;
import java.io.IOException;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class LocEditViewController implements Initializable {

    private Stage dialogStage;

    private CarroBO carro;

    private ObservableList<CarroModel> dados;

    @FXML
    private Label lbProprietario;
    @FXML
    private Label lbAno;
    @FXML
    private Label lbMarca;
    @FXML
    private Label lbCor;
    @FXML
    private Label lbModelo;
    @FXML
    private Label lbDescricao;
    @FXML
    private Label lbAcessorios;
    @FXML
    private Label lbTipo;
    @FXML
    private Label lbEstado;
    @FXML
    private TextField txProprietario;
    @FXML
    private TextField txAno;
    @FXML
    private ComboBox<String> cbMarca;
    @FXML
    private CheckBox ckArCondicionado;
    @FXML
    private CheckBox ckTocaFita;
    @FXML
    private CheckBox ckRodaLiga;
    @FXML
    private CheckBox ckAlarme;
    @FXML
    private CheckBox ckTapetes;
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
    private RadioButton rbNovo;
    @FXML
    private ToggleGroup tgEstado;
    @FXML
    private RadioButton rbUsado;
    @FXML
    private Button btCadastrar;
    @FXML
    private Button btRemover;
    @FXML
    private Button btConsultar;
    @FXML
    private TableView<CarroModel> tvCarro;
    @FXML
    private ComboBox<String> cbCor;
    @FXML
    private TableColumn modeloCol;
    @FXML
    private TableColumn anoCol;
    @FXML
    private TableColumn estadoCol;
    @FXML
    private TableColumn proprietarioCol;
    @FXML
    private TextField txModelo;
    @FXML
    private TextArea txDescricao;
    @FXML
    private Label lbKM;
    @FXML
    private TextField txKM;
    @FXML
    private TextField txValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carro = new CarroBO();
        cbMarca.getItems().addAll("[Selecione...]",
                "Chevrolet Captiva ",
                "Chevrolet Celta ",
                "Chevrolet Classic ",
                "Chevrolet Cobalt ",
                "Chevrolet Cruze ",
                "Toyota Hilux SW4 ",
                "Toyota Hilux ",
                "Toyota Corolla ",
                "Toyota Camry ");
        cbMarca.getSelectionModel().select(0);
        cbCor.getItems().addAll("[Selecione...]",
                "Azul",
                "Vermelho",
                "Branco",
                "Verde");
        cbCor.getSelectionModel().select(0);
        dados = FXCollections.observableArrayList();
        tvCarro.setItems(dados);
        modeloCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("modelo"));
        anoCol.setCellValueFactory(new PropertyValueFactory<CarroModel, Integer>("ano"));
        estadoCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("estado"));
        proprietarioCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("proprietario"));
    }

    public void setDialogStage(Stage dialog) {
        this.dialogStage = dialog;
    }

    private void validation() throws Exception {

    }

    public void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Locadora");
        alert.setContentText(msg);
        alert.show();
    }

    public CarroModel buscarCarroModel() {
        CarroModel dadosCarro = new CarroModel();
        dadosCarro.setProprietario(!txProprietario.getText().isEmpty() ? txProprietario.getText() : "");
        dadosCarro.setAno(!txAno.getText().isEmpty() ? Integer.parseInt(txAno.getText()) : 0);
        dadosCarro.setMarca(cbMarca.getSelectionModel().getSelectedItem());
        dadosCarro.setModelo(txModelo.getText());
        dadosCarro.setCor(cbCor.getSelectionModel().getSelectedItem());
        dadosCarro.setDescricao(txDescricao.getText());
        dadosCarro.setArCondicionado(ckArCondicionado.isSelected());
        dadosCarro.setTocaFita(ckArCondicionado.isSelected());
        dadosCarro.setRodaLiga(ckRodaLiga.isSelected());
        dadosCarro.setTapetes(ckTapetes.isSelected());
        dadosCarro.setAlarme(ckAlarme.isSelected());
        dadosCarro.setTipo(((RadioButton) tgTipo.getSelectedToggle()).getText());
        dadosCarro.setEstado(((RadioButton) tgEstado.getSelectedToggle()).getText());
        dadosCarro.setKm(!txKM.getText().isEmpty() ? Double.parseDouble(txKM.getText()) : 0);
        dadosCarro.setValor(!txValor.getText().isEmpty() ? Double.parseDouble(txValor.getText()) : 0);
        return dadosCarro;
    }

    public CarroVO buscarCarroVO(CarroModel dadosCarro) throws Exception {
        if (dadosCarro == null) {
            throw new Exception("Por favor, selecione um registro para remoção!");
        }
        CarroVO carro = new CarroVO(
                dadosCarro.getProprietario(),
                dadosCarro.getAno(),
                dadosCarro.getMarca(),
                dadosCarro.getModelo(),
                dadosCarro.getCor(),
                dadosCarro.getDescricao(),
                dadosCarro.getArCondicionado(),
                dadosCarro.getTocaFita(),
                dadosCarro.getRodaLiga(),
                dadosCarro.getTapetes(),
                dadosCarro.getAlarme(),
                dadosCarro.getTipo(),
                dadosCarro.getEstado(),
                dadosCarro.getKm(),
                dadosCarro.getValor());
        return carro;
    }

    @FXML
    private void handlerCadastrar(ActionEvent event) {
        try {
            CarroModel cm = buscarCarroModel();
            CarroVO cv = buscarCarroVO(cm);
            carro.save(cv);
            dados.add(cm);
            msgDialog("Veiculo salvo com sucesso!", Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handlerRemover(ActionEvent event) {
        try {
            CarroModel cm = tvCarro.getSelectionModel().getSelectedItem();
            CarroVO cv = buscarCarroVO(cm);
            carro.remove(cv);
            dados.remove(cm);
            msgDialog("Veiculo excluido com sucesso!", Alert.AlertType.INFORMATION);
        } catch (Exception ex) {
            msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handlerConsultar(ActionEvent event) throws IOException {
        try {
            Main.changeScreen("ConsultaView");
        } catch (Exception ex) {
            msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
