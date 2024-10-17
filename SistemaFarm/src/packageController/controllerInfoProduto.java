package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import packageControle.ProdutoDAO;

public class controllerInfoProduto implements Initializable{

    @FXML
    private Button btDashboard;

    @FXML
    private Button btFarmaceuticos;

    @FXML
    private Button btFornecedor;

    @FXML
    private Button btImprimir;

    @FXML
    private Button btLimpar;

    @FXML
    private Button btPesquisar;

    @FXML
    private Button btProdutos;

    @FXML
    private Button btRelatorioVendas;

    @FXML
    private Button btSair;

    @FXML
    private Label labCodBarras;

    @FXML
    private Label labConcent;

    @FXML
    private Label labContraInd;

    @FXML
    private Label labFormaFarm;

    @FXML
    private Label labInd;

    @FXML
    private Label labLabor;

    @FXML
    private Label labLote;

    @FXML
    private Label labNomeGen;

    @FXML
    private Label labPrincAtivo;

    @FXML
    private Label labEfeitCol;
    
    @FXML
    private Label labRegistANVISA;
    
    @FXML
    private ChoiceBox<String> txtpesquisaBusca;

    @FXML
    private TextField txtPesquisar;
   

    @FXML
    void btDashboard(ActionEvent event) {
    	 Main.changeScreen("dashboard");
    }

    @FXML
    void btFarmaceuticos(ActionEvent event) {
    	 Main.changeScreen("vendedor");
    }

    @FXML
    void btFornecedor(ActionEvent event) {
    	Main.changeScreen("fornecedor");
    }

    @FXML
    void btImprimir(ActionEvent event) {
    	
    }

    @FXML
    void btLimpar(ActionEvent event) {
    	 txtPesquisar.setText("");
    }

    @FXML
    void btPesquisar(ActionEvent event) {
        	
    	labNomeGen.setText(controllerProdutos.produtoEditar.getNomeGenerico());
    	labCodBarras.setText(controllerProdutos.produtoEditar.getCodigo());
    	labConcent.setText(controllerProdutos.produto.getConcentracao());
    	labContraInd.setText(controllerProdutos.produto.getContraInd());
    	labFormaFarm.setText(controllerProdutos.produto.getFormaFarmaceutica());
    	labInd.setText(controllerProdutos.produto.getIndicacoes());
    	labLabor.setText(controllerProdutos.produto.getLaboratorio());
    	labLote.setText(controllerProdutos.produto.getLote());
    	labPrincAtivo.setText(controllerProdutos.produto.getPrincAtivo());
    	labRegistANVISA.setText(controllerProdutos.produto.getRegistroAnvisa());
    	labEfeitCol.setText(controllerProdutos.produto.getEfeitosColaterais());
    	
    }

    @FXML
    void btProdutos(ActionEvent event) {
    	Main.changeScreen("produto");
    }

    @FXML
    void btRelatorioVendas(ActionEvent event) {
    	 Main.changeScreen("registraVenda");
    }

    @FXML
    void btSair(ActionEvent event) {
    	 Main.changeScreen("produto");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ProdutoDAO produto = new ProdutoDAO();
    	txtpesquisaBusca.setItems(produto.readNome());
  
    	
	}

}
