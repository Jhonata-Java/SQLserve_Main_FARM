package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class controllerInfoProduto  implements Initializable {

	@FXML
    private Button btImprimir;

    @FXML
    private Button btSair;

    @FXML
    private Label labCodigoBarras;

    @FXML
    private Label labConcent;

    @FXML
    private Label labContInd;

    @FXML
    private Label labEfeitCol;

    @FXML
    private Label labFormaFarm;

    @FXML
    private Label labIndica;

    @FXML
    private Label labLabotor;

    @FXML
    private Label labLote;

    @FXML
    private Label labNomeG;

    @FXML
    private Label labPrincAt;

    @FXML
    private Label labRegistANVISA;

    @FXML
    void btImprimir(ActionEvent event) {

    }

    @FXML
    void btSair(ActionEvent event) {
    	Main.changeScreen("produto");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		labNomeG.setText(controllerProdutos.produto.getNomeGenerico());
		labCodigoBarras.setText(controllerProdutos.produto.getCodigo());
		labConcent.setText(controllerProdutos.produto.getNomeGenerico());
		labContInd.setText(controllerProdutos.produto.getNomeGenerico());
		labEfeitCol.setText(controllerProdutos.produto.getNomeGenerico());
		labFormaFarm.setText(controllerProdutos.produto.getNomeGenerico());
		labIndica.setText(controllerProdutos.produto.getNomeGenerico());
		labLabotor.setText(controllerProdutos.produto.getNomeGenerico());
		labLote.setText(controllerProdutos.produto.getNomeGenerico());
		labRegistANVISA.setText(controllerProdutos.produto.getNomeGenerico());
		labPrincAt.setText(controllerProdutos.produto.getNomeGenerico());
	
	}

}
