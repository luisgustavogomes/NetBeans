package br.edu.qi.controller;

import br.edu.qi.Main;
import br.edu.qi.model.CarroBO;
import br.edu.qi.model.CarroVO;
import br.edu.qi.utl.HelperAdapter;
import br.edu.qi.utl.HelperNumbers;
import br.edu.qi.utl.HelperStrings;
import br.edu.qi.view.CarroModel;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

public class LocEditViewController implements Initializable {

    private CarroBO carro = CarroBO.getInstancia();

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
    @FXML
    private HBox hbKM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbMarca.getItems().addAll("[Selecione...]", "CHEVROLET", "VOLKSWAGEN", "FIAT", "MERCEDES-BENZ", "CITROEN", "CHANA", "HONDA", "SUBARU", "FERRARI", "BUGATTI", "LAMBORGHINI", "FORD", "HYUNDAI", "JAC", "KIA", "GURGEL", "DODGE", "CHRYSLER", "BENTLEY", "SSANGYONG", "PEUGEOT", "TOYOTA", "RENAULT", "ACURA", "ADAMO", "AGRALE", "ALFA ROMEO", "AMERICAR", "ASTON MARTIN", "AUDI", "BEACH", "BIANCO", "BMW", "BORGWARD", "BRILLIANCE", "BUICK", "CBT", "NISSAN", "CHAMONIX", "CHEDA", "CHERY", "CORD", "COYOTE", "CROSS LANDER", "DAEWOO", "DAIHATSU", "VOLVO", "DE SOTO", "DETOMAZO", "DELOREAN", "DKW-VEMAG", "SUZUKI", "EAGLE", "EFFA", "ENGESA", "ENVEMO", "FARUS", "FERCAR", "FNM", "PONTIAC", "PORSCHE", "GEO", "GRANCAR", "GREAT WALL", "HAFEI", "HOFSTETTER", "HUDSON", "HUMMER", "INFINITI", "INTERNATIONAL", "JAGUAR", "JEEP", "JINBEI", "JPX", "KAISER", "KOENIGSEGG", "LAUTOMOBILE", "LAUTOCRAFT", "LADA", "LANCIA", "LAND ROVER", "LEXUS", "LIFAN", "LINCOLN", "LOBINI", "LOTUS", "MAHINDRA", "MASERATI", "MATRA", "MAYBACH", "MAZDA", "MENON", "MERCURY", "MITSUBISHI", "MG", "MINI", "MIURA", "MORRIS", "MP LAFER", "MPLM", "NEWTRACK", "NISSIN", "OLDSMOBILE", "PAG", "PAGANI", "PLYMOUTH", "PUMA", "RENO", "REVA-I", "ROLLS-ROYCE", "ROMI", "SEAT", "UTILITARIOS AGRICOLAS", "SHINERAY", "SAAB", "SHORT", "SIMCA", "SMART", "SPYKER", "STANDARD", "STUDEBAKER", "TAC", "TANGER", "TRIUMPH", "TROLLER", "UNIMOG", "WIESMANN", "CADILLAC", "AM GEN", "BUGGY", "WILLYS OVERLAND", "KASEA", "SATURN", "SWELL MINI", "SKODA", "KARMANN GHIA", "KART", "HANOMAG", "OUTROS", "HILLMAN", "HRG", "GAIOLA", "TATA", "DITALLY", "RELY", "MCLAREN", "GEELY");
        cbMarca.getSelectionModel().select(0);
        cbCor.getItems().addAll("[Selecione...]", "Azul", "Vermelho", "Branco", "Verde");
        cbCor.getSelectionModel().select(0);
        dados = FXCollections.observableArrayList();
        dados.addAll(HelperAdapter.adater(carro.getCarroDAO().getCarroArr()));
        tvCarro.setItems(dados);
        rbNovo.setSelected(true);
        lbKM.setVisible(false);
        txKM.setVisible(false);
        modeloCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("modelo"));
        anoCol.setCellValueFactory(new PropertyValueFactory<CarroModel, Integer>("ano"));
        estadoCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("estado"));
        proprietarioCol.setCellValueFactory(new PropertyValueFactory<CarroModel, String>("proprietario"));
    }

    private void validation() throws Exception {

        if (txProprietario.getText().isEmpty() || !HelperStrings.isText(txProprietario.getText())) {
            throw new Exception("Informe um proprietário valido!");
        }
        if (txAno.getText().isEmpty() || !HelperNumbers.isNumericDouble(txAno.getText()) || Integer.parseInt(txAno.getText()) < 1900 || Integer.parseInt(txAno.getText()) > GregorianCalendar.getInstance().get(Calendar.YEAR) + 1) {
            throw new Exception("Informe um ano valido!");
        }
        if (cbMarca.getSelectionModel().getSelectedIndex() == 0) {
            throw new Exception("Selecione uma marcar!");
        }
        if (txModelo.getText().isEmpty() || !HelperStrings.isTextOrNumber(txModelo.getText())) {
            throw new Exception("Informe um modelo valido!");
        }
        if (cbCor.getSelectionModel().getSelectedIndex() == 0) {
            throw new Exception("Selecione uma cor!");
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
        if (txValor.getText().isEmpty() || !HelperNumbers.isNumericDouble(txValor.getText())) {
            throw new Exception("Informe um valor!");
        }

    }

    public void msgDialog(String msg, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Concessionaria");
        alert.setContentText(msg);
        alert.show();
    }

    public CarroModel buscarCarroModel() {
        CarroModel dadosCarro = new CarroModel();
        dadosCarro.setProprietario(!txProprietario.getText().isEmpty() ? txProprietario.getText().trim().toUpperCase() : "");
        dadosCarro.setAno(!txAno.getText().isEmpty() ? Integer.parseInt(txAno.getText()) : 0);
        dadosCarro.setMarca(cbMarca.getSelectionModel().getSelectedItem().trim().toUpperCase());
        dadosCarro.setModelo(txModelo.getText().trim().toUpperCase());
        dadosCarro.setCor(cbCor.getSelectionModel().getSelectedItem().trim().toUpperCase());
        dadosCarro.setDescricao(!txDescricao.getText().isEmpty() ? txDescricao.getText().trim().toUpperCase() : "");
        dadosCarro.setArCondicionado(ckArCondicionado.isSelected());
        dadosCarro.setTocaFita(ckArCondicionado.isSelected());
        dadosCarro.setRodaLiga(ckRodaLiga.isSelected());
        dadosCarro.setTapetes(ckTapetes.isSelected());
        dadosCarro.setAlarme(ckAlarme.isSelected());
        dadosCarro.setTipo(((RadioButton) tgTipo.getSelectedToggle()).getText().trim().toUpperCase());
        dadosCarro.setEstado(((RadioButton) tgEstado.getSelectedToggle()).getText().trim().toUpperCase());
        dadosCarro.setKm(!txKM.getText().isEmpty() ? Double.parseDouble(txKM.getText()) : 0);
        dadosCarro.setValor(Double.parseDouble(txValor.getText()));
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
        return HelperStrings.AdapterString(carro);
    }

    public void clear() {
        txProprietario.setText("");
        txAno.setText("");
        cbMarca.getSelectionModel().select(0);
        txModelo.setText("");
        cbCor.getSelectionModel().select(0);
        txDescricao.setText("");
        ckAlarme.setSelected(false);
        ckArCondicionado.setSelected(false);
        ckRodaLiga.setSelected(false);
        ckTapetes.setSelected(false);
        ckTocaFita.setSelected(false);
        rbComercial.setSelected(false);
        rbEsportivo.setSelected(false);
        rbOffRood.setSelected(false);
        rbPasseio.setSelected(false);
        rbUtilitario.setSelected(false);
        rbNovo.setSelected(true);
        rbUsado.setSelected(false);
        txKM.setText("");
        txValor.setText("");
        
    }

    @FXML
    private void handlerCadastrar(ActionEvent event) {
        try {
            validation();
            CarroModel cm = buscarCarroModel();
            CarroVO cv = buscarCarroVO(cm);
            carro.save(cv);
            dados.add(cm);
            msgDialog("Veiculo salvo com sucesso!", Alert.AlertType.INFORMATION);
            clear();
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
            clear();
        } catch (Exception ex) {
            msgDialog(ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handlerConsultar(ActionEvent event) throws IOException {
        Main.changeScreen("locConsultaView");
    }

    @FXML
    private void HandlerEstadoNovo(ActionEvent event) {
        if (rbNovo.isSelected()) {
            txKM.setText("0");
            lbKM.setVisible(false);
            txKM.setVisible(false);
        }

    }

    @FXML
    private void HaldlerEstadoUsado(ActionEvent event) {
        if (rbUsado.isSelected()) {
            lbKM.setVisible(true);
            txKM.setVisible(true);
        }
    }

}
