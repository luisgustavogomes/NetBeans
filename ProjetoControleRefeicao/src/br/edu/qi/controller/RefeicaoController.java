/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.entity.Foto;
import br.edu.qi.entity.Refeicao;
import br.edu.qi.service.FotoService;
import br.edu.qi.service.IService;
import br.edu.qi.service.RefeicaoService;
import br.edu.qi.utl.HelperDate;
import br.edu.qi.utl.HelperNotification;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import tray.notification.NotificationType;

/**
 * FXML Controller class
 *
 * @author lg
 */
public class RefeicaoController implements Initializable {

    private ObservableList<Refeicao> dados;

    private IService refeicaoService;
    private IService fotoService;

    private Foto foto = new Foto();

    @FXML
    private TextField txtID;
    @FXML
    private DatePicker dpData;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private TableView<Refeicao> tvConsulta;
    @FXML
    private TableColumn dataCol;
    @FXML
    private TableColumn descricaoCol;
    @FXML
    private ImageView ivFoto;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dados = FXCollections.observableArrayList();
        refeicaoService = new RefeicaoService();
        fotoService = new FotoService();
        dataCol.setCellValueFactory(new PropertyValueFactory<>("dataCadastro"));
        descricaoCol.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        carregarRefeicoes();
        tvConsulta.setItems(dados);
    }

    @FXML
    private void hendlerSalvar(ActionEvent event) {

        try {
            if (txtID.getText().isEmpty()) {

                validation();
                fotoService.save(foto);
                Refeicao refeicao = new Refeicao(foto, txtDescricao.getText(), Date.valueOf(dpData.getValue()));
                refeicaoService.save(refeicao);
                dados.add(refeicao);
                clear();
                HelperNotification.Notification("Refeição", "Refeição salva com sucesso!", NotificationType.SUCCESS);
            } else {
                Refeicao r = tvConsulta.getSelectionModel().getSelectedItem();
                Refeicao rr = new Refeicao(Integer.parseInt(txtID.getText()),
                        foto, txtDescricao.getText(),
                        Date.valueOf(dpData.getValue()));
                if (!r.equals(rr)) {
                    refeicaoService.update(rr);
                    dados.clear();
                    carregarRefeicoes();
                    HelperNotification.Notification("Refeição", "Alterações realizadas com sucesso!", NotificationType.SUCCESS);
                } else {
                    HelperNotification.Notification("Refeição", "Não há alterações!", NotificationType.INFORMATION);
                }
                clear();
            }
        } catch (Exception e) {
            HelperNotification.Notification("Refeição", e.getMessage(), NotificationType.ERROR);
            clear();
        }

    }

    @FXML
    private void handlerEditar(ActionEvent event) throws Exception {
        Refeicao r = tvConsulta.getSelectionModel().getSelectedItem();
        if (r != null) {
            txtID.setText(String.valueOf(r.getIdRefeicao()));
            txtDescricao.setText(r.getDescricao());
            dpData.setValue(HelperDate.toLocalDate(r.getDataCadastro()));
            carregaImagem(r.getFoto().getIdFoto());
        }
    }

    @FXML
    private void handlerRemover(ActionEvent event) throws Exception {
        try {
            Refeicao r = tvConsulta.getSelectionModel().getSelectedItem();
            if (r != null) {
                refeicaoService.delete(r);
                //fotoService.delete(r.getFoto());
                dados.remove(r);
                HelperNotification.Notification("Refeição", "Refeição foi removida com sucesso!", NotificationType.SUCCESS);
                clear();
                return;
            }
            HelperNotification.Notification("Refeição", "Selecione o item para remoção!", NotificationType.ERROR);
        } catch (Exception e) {
            HelperNotification.Notification("Refeição", e.getMessage(), NotificationType.ERROR);
        }
    }

    @FXML
    private void handlerCancelar(ActionEvent event) {
        clear();
    }

    @FXML
    private void handlerSelecione(ActionEvent event) {
        selecioneImagem();
    }

    private void loadImage(File file) {
        if (file != null) {
            try {
                BufferedImage bimg = ImageIO.read(file);
                Image img = SwingFXUtils.toFXImage(bimg, null);
                ivFoto.setImage(img);
            } catch (IOException e) {
                HelperNotification.Notification("Refeição", e.getMessage(), NotificationType.ERROR);
            }
        } else {
            HelperNotification.Notification("Refeição", "Não foi possivel carregar imagem", NotificationType.ERROR);
        }
    }

    private void selecioneImagem() {
        try {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);
            byte[] arr = new byte[(int) file.length()];
            loadImage(file);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                fileInputStream.read(arr);
                foto.setImage(arr);
                fileInputStream.close();
            } catch (IOException e) {
                HelperNotification.Notification("Refeição", e.getMessage(), NotificationType.ERROR);
            }
        } catch (Exception e) {
            HelperNotification.Notification("Refeição", "Nenhum arquivo seleciona!", NotificationType.INFORMATION);
        }
    }

    private void carregaImagem(int id) throws Exception {
        foto = (Foto) fotoService.findByCod(id);
        if (foto != null) {
            ivFoto.setImage(new Image(new ByteArrayInputStream(foto.getImage())));
        }
    }

    private void clear() {
        txtDescricao.setText("");
        dpData.setValue(null);
        txtID.setText("");
        ivFoto.setImage(null);
        foto.setImage(null);
    }

    private void carregarRefeicoes() {
        tvConsulta.getItems().clear();
        List<Refeicao> arr = null;
        try {
            arr = refeicaoService.findAllWithoutClose();
        } catch (Exception ex) {
            HelperNotification.Notification("Refeição", ex.getMessage(), NotificationType.ERROR);
        }
        dados.addAll(arr);
    }

    private void validation() throws Exception {
        if (txtDescricao.getText().isEmpty()) {
            throw new Exception("Informe a descrição da refeição!");
        }
        if (dpData.getValue() == null) {
            throw new Exception("Informe a data da refeição!");
        }
//        if (foto.getImage() == null) {
//            throw new Exception("Selecione uma foto!");
//        }
    }

}
