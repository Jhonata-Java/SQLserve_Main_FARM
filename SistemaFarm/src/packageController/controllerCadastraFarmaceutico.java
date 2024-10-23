package packageController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.FarmaceuticoDAO;
import packageModel.Farmaceutico;

public class controllerCadastraFarmaceutico implements Initializable {

	@FXML
    private DatePicker DtDataCont;

    @FXML
    private DatePicker DtDataNasc;
	
	@FXML
	private Button btCadastrar;

	@FXML
	private Button btCancelar;

	@FXML
	private TextField textCPF;

	@FXML
	private TextField textCargaHorario;

	@FXML
	private TextField textDataContratacao;

	@FXML
	private TextField textDataNascimento;

	@FXML
	private TextField textEmail;

	@FXML
	private TextField textEnderecoResidencialCompleto;

	@FXML
	private TextField textNacionalidade;

	@FXML
	private TextField textNome;

	@FXML
	private TextField textSenha;

	@FXML
	private TextField textTelefone;

	@FXML
	void ActionBtCadastrar(ActionEvent event) {
		if (controllerFarmaceutico.farmaceuticoEditar == null) {
			Farmaceutico far = new Farmaceutico();
			far.setNome(textNome.getText());
			far.setCPF(textCPF.getText());
			far.setEmail(textEmail.getText());
			far.setTelefone(textTelefone.getText());
			far.setDataCont(DtDataCont.getValue().toString());
			far.setDataNasc(DtDataNasc.getValue().toString());
			far.setEndereco(textEnderecoResidencialCompleto.getText());
			FarmaceuticoDAO far1 = new FarmaceuticoDAO();
			far1.create(far);
			
			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		}
		else {
			Farmaceutico far = new Farmaceutico();
			far.setNome(textNome.getText());
			far.setCPF(textCPF.getText());
			far.setEmail(textEmail.getText());
			far.setTelefone(textTelefone.getText());
			far.setDataCont(DtDataCont.getValue().toString());
			far.setDataNasc(DtDataNasc.getValue().toString());
			far.setEndereco(textEnderecoResidencialCompleto.getText());
			FarmaceuticoDAO far1 = new FarmaceuticoDAO();
			far1.update(far);
			
			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		}
	}

	@FXML
	void ActionBtCancelar(ActionEvent event) {
		textNome.setText("");
		textCPF.setText("");
		textEmail.setText("");
		textTelefone.setText("");
		textEnderecoResidencialCompleto.setText("");

		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(controllerFarmaceutico.farmaceuticoEditar != null) {
			textNome.setText(controllerFarmaceutico.farmaceuticoEditar.getNome());
			textCPF.setText(controllerFarmaceutico.farmaceuticoEditar.getCPF());
			textEmail.setText(controllerFarmaceutico.farmaceuticoEditar.getEmail());
			textTelefone.setText(controllerFarmaceutico.farmaceuticoEditar.getTelefone());
			LocalDate localdateNasc = LocalDate.parse(controllerFarmaceutico.farmaceuticoEditar.getDataNasc());
	    	DtDataNasc.setValue(localdateNasc);
	    	LocalDate localdateCont = LocalDate.parse(controllerFarmaceutico.farmaceuticoEditar.getDataCont());
	    	DtDataCont.setValue(localdateCont);
			textDataNascimento.setText(controllerFarmaceutico.farmaceuticoEditar.getDataNasc());
			textDataContratacao.setText(controllerFarmaceutico.farmaceuticoEditar.getDataCont());
			textEnderecoResidencialCompleto.setText(controllerFarmaceutico.farmaceuticoEditar.getEndereco());
		}
	}
}