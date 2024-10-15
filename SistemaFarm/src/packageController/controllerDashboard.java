package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import packageControle.ProdutoDAO;
import packageModel.Produto;

public class controllerDashboard  implements Initializable {

    @FXML
    private Hyperlink btAtualizar;
    
    @FXML
    private Button btCadastrarFarmaceutico;

    @FXML
    private Button btCadastrarFornecedor;

    @FXML
    private Button btCadastrarProduto;

    @FXML
    private Button btDashboard;

    @FXML
    private Button btFarmaceutico;

    @FXML
    private Button btFarmaceuticos;

    @FXML
    private Button btFornecedor;

    @FXML
    private Button btProdutos;

    @FXML
    private Button btRegistraVenda;

    @FXML
    private Button btRelatorioVendas;

    @FXML
    private Button btSair;

    @FXML
    private TableColumn<Produto,String> columnID1;

    @FXML
    private TableColumn<Produto,String> columnID2;

    @FXML
    private TableColumn<Produto,String> columnLocalizacao1;

    @FXML
    private TableColumn<Produto,String> columnLocalizacao2;

    @FXML
    private TableColumn<Produto,String> columnNome1;

    @FXML
    private TableColumn<Produto,String> columnNome2;

    @FXML
    private TableColumn<Produto,String> columnQuantidade;

    @FXML
    private TableColumn<Produto,String> columnVencimento;

    @FXML
    private Label labelNome;

    @FXML
    private TableView<Produto> tabelaEstoque;

    @FXML
    private TableView<Produto> tabelaVencer;
    
    private ObservableList<Produto> ArrayProdutos;
    
    private ProdutoDAO produto = new ProdutoDAO();

    @FXML
    void btCadastrarFarmaceutico(MouseEvent event)throws IOException  {
         Main.TelaCadastraFarmaceutico();
    }

    @FXML
    void btCadastrarFornecedor(MouseEvent event)throws IOException {
    	Main.TelaCadastraFornecedor();
    }

    @FXML
    void btCadastrarProduto(MouseEvent event)throws IOException {
    	Main.TelaCadastroProduto() ;
    }

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
    void btProdutos(ActionEvent event) {
    	 Main.changeScreen("produto");
    }

    @FXML
    void btRegistraVenda(ActionEvent event) {
    	 Main.changeScreen("registraVenda");
    }

    @FXML
    void btRelatorioVendas(ActionEvent event) {
    	 Main.changeScreen("relatorioVenda");
    }

    @FXML
    void btSair(ActionEvent event) {
    	 Main.changeScreen("login");
    }
    
    @FXML
    void Atualizar(ActionEvent event) {
    	CarregarTable();
    }
    
    public void CarregarTable()
    {
    	ArrayProdutos = FXCollections.observableArrayList(produto.read());

    	columnID1.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnID2.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnLocalizacao1.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	columnLocalizacao2.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	columnNome1.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
    	columnNome2.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
    	columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	columnVencimento.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
    	tabelaEstoque.setItems(ArrayProdutos);
    	tabelaVencer.setItems(ArrayProdutos);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		labelNome.setText(controllerLogin.farmaceutico.getNome());
		CarregarTable();
	}
}

