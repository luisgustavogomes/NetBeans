/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.Main;
import br.edu.qi.model.CarroBO;
import br.edu.qi.model.CarroVO;
import br.edu.qi.utl.HelperAdapter;
import br.edu.qi.view.CarroModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class LocConsultaViewController implements Initializable {

    @FXML
    private Button btVoltar;
    @FXML
    private TableColumn anoCol;
    @FXML
    private TableColumn marcaCol;
    @FXML
    private TableColumn modeloCol;
    @FXML
    private TableColumn corCol;
    @FXML
    private TableColumn descricaoCol;
    @FXML
    private TableColumn tipoCol;
    @FXML
    private TableColumn estadoCol;
    @FXML
    private TableColumn kmCol;
    @FXML
    private TableColumn valorCol;
    @FXML
    private Label lbProprietario;
    @FXML
    private ComboBox<String> cbProprietario;
    @FXML
    private TableView<CarroModel> tvConsulta;
    @FXML
    private Button btConsultar;
    @FXML
    private TextField txTotalVeiculos;
    @FXML
    private Label lbTotal;
    @FXML
    private HBox hbTotal;

    private ObservableList<CarroModel> dadosConsulta;

    private String comboSelected = null;

    private int index;

    /**
     * Initializes the controller class.
     */
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        dadosConsulta = FXCollections.observableArrayList();
        List<String> proprietarioFull = new ArrayList<>();
        List<String> proprietario = new ArrayList<>();
        List<CarroVO> car = CarroBO.getInstancia().getCarroDAO().getCarroArr();
        car.stream().forEach(c -> proprietarioFull.add(c.getProprietario()));
        proprietario = proprietarioFull.stream().distinct().collect(Collectors.toList());
        proprietario.add(0, "[Selecione...]");
        txTotalVeiculos.setText("0");
        tvConsulta.setItems(dadosConsulta);
        cbProprietario.getItems().addAll(proprietario);
        cbProprietario.getSelectionModel().select(0);
        anoCol.setCellValueFactory(new PropertyValueFactory<CarroModel, Integer>("ano"));
        marcaCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("marca"));
        modeloCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("modelo"));
        corCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("cor"));
        descricaoCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("descricao"));
        tipoCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("tipo"));
        estadoCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("estado"));
        kmCol.setCellValueFactory(new PropertyValueFactory<CarroModel, Double>("km"));
        valorCol.setCellValueFactory(new PropertyValueFactory<CarroModel, Double>("valor"));
    }

    @FXML
    private void handlerVoltar(ActionEvent event) throws IOException {
        Main.changeScreen("locEditView");
    }

    @FXML
    private void handlerComboBoxProprietario(ActionEvent event) {
        dadosConsulta.clear();
        txTotalVeiculos.setText("0");
    }

    @FXML
    private void handlerConsultar(ActionEvent event) {
        if (cbProprietario.getSelectionModel().getSelectedIndex() != 0) {
            if (comboSelected != cbProprietario.getSelectionModel().getSelectedItem()) {
                comboSelected = cbProprietario.getSelectionModel().getSelectedItem();
                dadosConsulta.clear();
                dadosConsulta.addAll(HelperAdapter.adater(CarroBO.getInstancia().getCarroDAO().getCarroArr()).stream().filter(c -> c.getProprietario().equals(cbProprietario.getSelectionModel().getSelectedItem())).collect(Collectors.toList()));
                txTotalVeiculos.setText(String.valueOf(dadosConsulta.size()));
            }
        } else {
            dadosConsulta.clear();
        }

    }

}
