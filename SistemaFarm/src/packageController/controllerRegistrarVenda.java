package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import packageModel.Compra;
import packageModel.Produto;

public class controllerRegistrarVenda implements Initializable {

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btConfirmar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btPesquisarProduto;

    @FXML
    private TableColumn<String, Compra> columCodigo;

    @FXML
    private TableColumn<String, Produto> columCodigo1;

    @FXML
    private TableColumn<String, Compra> columDataFabricacao;

    @FXML
    private TableColumn<String, Produto> columDataFabricacao1;

    @FXML
    private TableColumn<String, Compra> columDataValidade;

    @FXML
    private TableColumn<String, Produto> columDataValidade1;

    @FXML
    private TableColumn<String, Compra> columPrecoTotal2;

    @FXML
    private TableColumn<String, Compra> columPrecoUnitario;

    @FXML
    private TableColumn<String, Produto> columPrecoUnitario1;

    @FXML
    private TableColumn<String, Compra> columProduto;

    @FXML
    private TableColumn<String, Produto> columProduto1;

    @FXML
    private TableColumn<String, Compra> columQuantidade;

    @FXML
    private TableColumn<String, Produto> columQuantidade1;

    @FXML
    private TableView<Compra> tabelaProduto;

    @FXML
    private TableView<Produto> tabelaProduto1;

    @FXML
    private TextField txtCPFFarmaceutico;

    @FXML
    private Button txtCancelar;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDataCompra;

    @FXML
    private TextField txtDesconto;

    @FXML
    private TextField txtNomeFarmaceutico;

    @FXML
    private TextField txtPesquisar;

    @FXML
    private TextField txtProduto;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private Label txtValorTotal;

    @FXML
    void btAdicionar(ActionEvent event) {

    }

    @FXML
    void btConfirmar(ActionEvent event) {

    }

    @FXML
    void btExcluir(ActionEvent event) {

    }

    @FXML
    void btPesquisarProduto(ActionEvent event) {

    }

    @FXML
    void txtCancelar(ActionEvent event) {

    }
    
    void CarregarTabelaProduto() {
    	
    }
    
    void CarregarTabelaProdutosSelecionados() {
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
