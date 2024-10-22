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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControle.CompraDAO;
import packageModel.Compra;
import packageModel.Venda;

public class controllerRelatorioVenda implements Initializable {

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
    private TableColumn<Compra,String> columnDataVenda;

    @FXML
    private TableColumn<Compra,String> columnFarmaceutico;

    @FXML
    private TableColumn<Compra,String> columnID;

    @FXML
    private TableColumn<Compra,String> columnPrecoTotal;

    @FXML
    private TableColumn<Compra,String> columnProduto;

    @FXML
    private TableColumn<Compra,String> columnQuantidade;

    @FXML
    private TableView<Compra> tabela;

    @FXML
    private TextField txtPesquisar;
    
    public static Venda CompraEditar = new Venda();
    private CompraDAO compra = new CompraDAO();
    private ObservableList<Compra> ArrayCompra;
    
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
     btLimpar.setText("");
    }

    @FXML
    void btPesquisar(ActionEvent event) {

    	columnDataVenda.setCellValueFactory(new PropertyValueFactory<>("dataCompra"));
    	columnFarmaceutico.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
       	columnID.setCellValueFactory(new PropertyValueFactory<>("idCompra"));
    	columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
    	columnProduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

		tabela.setItems(ArrayCompra);
		tabela.refresh();
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

    	ArrayCompra = FXCollections.observableArrayList(compra.read());

    	columnDataVenda.setText(controllerProdutos.compra.getDataVenda());
    	columnFarmaceutico.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
       	columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
    	columnProduto.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	

    	tabela.setItems(ArrayCompra);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTable();
	}

}
