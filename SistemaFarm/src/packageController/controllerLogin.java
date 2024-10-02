package packageController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controllerLogin {

    @FXML
    private Button btLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtUser;

    @FXML
    void btLoginAction(ActionEvent event) {
    	Main.changeScreen("dashboard");
    }

}

