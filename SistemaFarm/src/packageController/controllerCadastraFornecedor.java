package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.FornecedorDAO;
import packageModel.Fornecedor;

public class controllerCadastraFornecedor implements Initializable{

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btCancelar;

    @FXML
    private TextField textCNPJ;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textEnder;

    @FXML
    private TextField textFone;

    @FXML
    private TextField textInscEsta;

    @FXML
    private TextField textNomeLab;

    @FXML
    private TextField textRamoAtuac;

    @FXML
    private TextField textRespons;

    @FXML
    void btCadastrar(ActionEvent event) {
    	if(controllerFornecedor.fornecedorEditar == null) {
    		Fornecedor fornecedor = new Fornecedor();
    		fornecedor.setNome(textNomeLab.getText());
    		fornecedor.setCNPJ(textCNPJ.getText());
    		fornecedor.setInscricaoEstadual(textInscEsta.getText());
    		fornecedor.setEmail(textEmail.getText());
    		fornecedor.setTelefone(textFone.getText());
    		fornecedor.setNomeResponsavel(textRespons.getText());
    		fornecedor.setRamoAtuacao(textRamoAtuac.getText());
    		fornecedor.setEnderco(textEnder.getText());
    		
    		FornecedorDAO forn = new FornecedorDAO();
    		forn.create(fornecedor);
    		
    		Stage stage = (Stage) btCancelar.getScene().getWindow();
    		stage.close();
    	}
    	else {
    		Fornecedor fornecedor = new Fornecedor();
    		fornecedor.setNome(textNomeLab.getText());
    		fornecedor.setCNPJ(textCNPJ.getText());
    		fornecedor.setInscricaoEstadual(textInscEsta.getText());
    		fornecedor.setEmail(textEmail.getText());
    		fornecedor.setTelefone(textFone.getText());
    		fornecedor.setNomeResponsavel(textRespons.getText());
    		fornecedor.setRamoAtuacao(textRamoAtuac.getText());
    		fornecedor.setEnderco(textEnder.getText());
    		
    		FornecedorDAO forn = new FornecedorDAO();
    		forn.update(fornecedor);
    		
    		Stage stage = (Stage) btCancelar.getScene().getWindow();
    		stage.close();
    	}
    }

    @FXML
    void btCancelar(ActionEvent event) {
    	textNomeLab.setText("");
		textCNPJ.setText("");
		textInscEsta.setText("");
		textEmail.setText("");
		textFone.setText("");
		textRespons.setText("");
		textRamoAtuac.setText("");
		textEnder.setText("");
		
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(controllerFornecedor.fornecedorEditar != null) {
			textNomeLab.setText(controllerFornecedor.fornecedorEditar.getNome());
			textCNPJ.setText(controllerFornecedor.fornecedorEditar.getCNPJ());
			textInscEsta.setText(controllerFornecedor.fornecedorEditar.getInscricaoEstadual());
			textEmail.setText(controllerFornecedor.fornecedorEditar.getEmail());
			textFone.setText(controllerFornecedor.fornecedorEditar.getTelefone());
			textRespons.setText(controllerFornecedor.fornecedorEditar.getNomeResponsavel());
			textRamoAtuac.setText(controllerFornecedor.fornecedorEditar.getRamoAtuacao());
			textEnder.setText(controllerFornecedor.fornecedorEditar.getEnderco());
		}
	}
}