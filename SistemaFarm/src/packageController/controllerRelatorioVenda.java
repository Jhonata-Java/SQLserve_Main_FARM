package packageController;

import java.io.IOException;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControle.ProdutoDAO;
import packageModel.Produto;
import packageModel.Venda;

public class controllerRelatorioVenda {

    @FXML
    private Button btCadastrar;

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
    private TableColumn<Produto,String> columnDataVenda;

    @FXML
    private TableColumn<Produto,String> columnFarmaceutico;

    @FXML
    private TableColumn<Produto,String> columnID;

    @FXML
    private TableColumn<Produto,String> columnPrecoTotal;

    @FXML
    private TableColumn<Produto,String> columnProduto;

    @FXML
    private TableColumn<Produto,String> columnQuantidade;

    @FXML
    private TableView<Produto> tabela;

    @FXML
    private TextField txtPesquisar;
    
    private ObservableList<Produto> ArrayProduto;
    public static Venda CompraEditar = new Venda();
    private ProdutoDAO produto = new ProdutoDAO();
    
    @FXML
    void btCadastrar(ActionEvent event) throws IOException {
    	CompraEditar = null;
		Main.TelaRegistraVenda();
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
    void btImprimir(ActionEvent event) {

    }

    @FXML
    void btLimpar(ActionEvent event) {

    }

    @FXML
    void btPesquisar(ActionEvent event) {

    }

    @FXML
    void btProdutos(ActionEvent event) {
    	Main.changeScreen("produto");
    }

    @FXML
    void btRelatorioVendas(ActionEvent event) {
    	Main.changeScreen("relatorioVenda");
    }

    @FXML
    void btSair(ActionEvent event) {
    	Main.changeScreen("dashboard");
    } 
    
    public void CarregarTable() {

    	ArrayProduto = FXCollections.observableArrayList(produto.read());

    	columnDataVenda.setText(controllerProdutos.compra.getDataVenda());
    	columnFarmaceutico.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
       	columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
    	columnProduto.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	

    	tabela.setItems(ArrayProduto);
    }

}
