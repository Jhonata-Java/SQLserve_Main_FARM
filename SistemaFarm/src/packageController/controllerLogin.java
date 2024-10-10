package packageController;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import packageControle.FarmaceuticoDAO;
import packageModel.Farmaceutico;

public class controllerLogin {

	@FXML
	private Button btLogin;

	@FXML
	private PasswordField txtPassword;

	@FXML
	private ToggleButton VerSenha;
	
	@FXML
	private TextField txtUser;
	
    @FXML
    private TextField txtSenha;

	FarmaceuticoDAO f = new FarmaceuticoDAO();
	static Farmaceutico farmaceutico = new Farmaceutico();

	@FXML
	void btLoginAction(ActionEvent event) throws IOException {
		txtPassword.setVisible(true);

		farmaceutico = f.autenticarUser(txtUser.getText(), txtPassword.getText());

		if (farmaceutico.getPassword() != null && farmaceutico.getCPF() != null) {
			Alert saudacao = new Alert(AlertType.CONFIRMATION);
			saudacao.setHeaderText("Saudações");
			saudacao.setTitle("Bem vindo!");
			saudacao.setContentText("Seja bem vindo de volta " + farmaceutico.getNome() + "!");
			saudacao.show();
			txtUser.setText("");
			txtPassword.setText("");
			Main.TelaHome();

			
			
		} else {
			Alert erro = new Alert(Alert.AlertType.ERROR);
			erro.setTitle("Falha ao realizar o login!");
			erro.setHeaderText("Erro!");
			erro.setContentText("Usuario ou senha incorretos! Verifique as informações e tente novamente.");
			erro.show();
		}
	}

	@FXML
	void VerSenha(ActionEvent event) {
		if (VerSenha.isSelected()) {
			txtSenha.setText(txtPassword.getText());
			txtPassword.setVisible(false);
			txtSenha.setVisible(true);
			txtSenha.setEditable(true);
		} else {
			txtPassword.setText(txtSenha.getText());
			txtPassword.setVisible(true);
			txtSenha.setVisible(false);
		}
	}
}
