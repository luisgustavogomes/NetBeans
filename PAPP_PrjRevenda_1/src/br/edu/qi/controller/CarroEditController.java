/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.Carro;
import br.edu.qi.model.CarroBO;
import br.edu.qi.model.Marca;
import br.edu.qi.model.MarcaBO;
import br.edu.qi.model.Modelo;
import br.edu.qi.model.ModeloBO;
import br.edu.qi.util.HelperAlert;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class CarroEditController implements Initializable {

    private ObservableList<Carro> dados;
    private CarroBO carroBO = new CarroBO();
    private MarcaBO marcaBO = new MarcaBO();
    private ModeloBO modeloBO = new ModeloBO();

    @FXML
    private ComboBox<Modelo> cbModelo;
    @FXML
    private Label lblMarca;
    @FXML
    private ComboBox<Marca> cbMarca;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnRemover;
    @FXML
    private TableView<Carro> tvConsulta;
    @FXML
    private TableColumn idCol;
    @FXML
    private TableColumn modeloCol;
    @FXML
    private TableColumn marcaCol;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dados = FXCollections.observableArrayList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("idCarro"));
        modeloCol.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tvConsulta.setItems(dados);
        carregarMarca();
        carregarModelo();
        dados.addAll(carregarCarro());
    }

    private List<Carro> carregarCarro() {
        try {
            return carroBO.findAllWithoutClose();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
        return null;
    }

    private void carregarModelo() {
        cbModelo.getItems().add(0, new Modelo("[Selecione...]"));
        try {
            cbModelo.getItems().addAll(modeloBO.findAllWithoutClose());
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
        cbModelo.getSelectionModel().select(0);
    }

    private void carregarMarca() {
        cbMarca.getItems().add(0, new Marca("[Selecione...]"));
        try {
            cbMarca.getItems().addAll(marcaBO.findAllWithoutClose());
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), getClass().getName(), Alert.AlertType.ERROR);
        }
        cbMarca.getSelectionModel().select(0);
    }

    @FXML
    private void HandlerSalvar(ActionEvent event) {

        try {
            if (txtID.getText().isEmpty()) {
                validation();
                Carro c = new Carro();
                c.setMarca(cbMarca.getSelectionModel().getSelectedItem());
                c.setModelo(cbModelo.getSelectionModel().getSelectedItem());
                carroBO.save(c);
                try {
                    carroBO.findAll().stream().filter((carros) -> carros.getIdCarro() == c.getIdCarro()).forEachOrdered((carros) -> {
                        c.setIdCarro(carros.getIdCarro());
                    });
                } catch (Exception e) {
                    System.out.println(e);
                }
                dados.add(c);
                HelperAlert.msgDialog("Carro salvo com sucesso!", "Carro", Alert.AlertType.INFORMATION);
                clear();
            } else {
                Carro c = tvConsulta.getSelectionModel().getSelectedItem();
                dados.clear();
                c.setMarca(cbMarca.getSelectionModel().getSelectedItem());
                c.setModelo(cbModelo.getSelectionModel().getSelectedItem());
                carroBO.update(c);
                dados.addAll(carregarCarro());
                HelperAlert.msgDialog("Alterações salvas com sucesso", "Carro", Alert.AlertType.ERROR);
                clear();
            }
            
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage(), "Carro", Alert.AlertType.ERROR);
        }
        
        
    }

    @FXML
    private void HandlerRemover(ActionEvent event) {
        try {
            Carro c = tvConsulta.getSelectionModel().getSelectedItem();
            carroBO.delete(c);
            dados.remove(c);
            HelperAlert.msgDialog("Carro removido com sucesso!", "Carro", Alert.AlertType.INFORMATION);
            clear();
        } catch (Exception ex) {
            HelperAlert.msgDialog(ex.getMessage() , "Carro", Alert.AlertType.ERROR);
        }
    }

    private void clear() {
        txtID.setText(null);
        cbMarca.getSelectionModel().select(0);
        cbModelo.getSelectionModel().select(0);
    }

    private void validation() throws Exception {
        if (cbMarca.getSelectionModel().getSelectedIndex() == 0) {
            throw new Exception("Por favor, selecione uma marca!");
        }
        if (cbModelo.getSelectionModel().getSelectedIndex() == 0) {
            throw new Exception("Por favor, selecione um modelo!");
        }
    }

    @FXML
    private void HandlerEditar(ActionEvent event) {
        try {
            Carro c = tvConsulta.getSelectionModel().getSelectedItem();
            cbMarca.getSelectionModel().select(c.getMarca());
            cbModelo.getSelectionModel().select(c.getModelo());
            txtID.setText(c.getIdCarro().toString());
        } catch (Exception e) {
            HelperAlert.msgDialog(e.getMessage(), "Carro", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void HandlerCancelar(ActionEvent event) {
        clear();
    }

}
