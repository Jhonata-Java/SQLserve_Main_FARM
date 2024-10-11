package packageController;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControle.ProdutoDAO;
import packageModel.Farmaceutico;
import packageModel.Produto;

public class controllerProdutos implements Initializable{

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btDashboard;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btFarmaceuticos;

    @FXML
    private Button btFornecedor;

    @FXML
    private Button btImprimir;

    @FXML
    private Button btInfo;

    @FXML
    private Button btLimpar;

    @FXML
    private Button btProdutos;

    @FXML
    private Button btRelatorioVendas;

    @FXML
    private Button btSair;

    @FXML
    private TableColumn<Produto,String> columnCod;

    @FXML
    private TableColumn<Produto,String> columnDataF;

    @FXML
    private TableColumn<Produto,String> columnDataV;

    @FXML
    private TableColumn<Produto,String> columnDose;

    @FXML
    private TableColumn<Produto,String> columnEst;

    @FXML
    private TableColumn<Produto,String> columnID;

    @FXML
    private TableColumn<Produto,String> columnNomeC;

    @FXML
    private TableColumn<Produto,String> columnPrecoUn;

    @FXML
    private TableColumn<Produto,String> columnTipoUn;

    @FXML
    private TableView<Produto> tabela;

    @FXML
    private TextField txtPesquisar;
    
    private ObservableList<Produto> ArrayProduto;
    private ProdutoDAO produtos = new ProdutoDAO();
    public static Produto produtoEditar = new Produto();
    static Produto produto = new Produto();

    @FXML
    void btCadastrar(ActionEvent event) throws IOException {
    	produtoEditar = null;
		Main.TelaCadastroProduto();
    }

    @FXML
    void btDashboard(ActionEvent event) {
    	 Main.changeScreen("dashboard");
    }

    @FXML
    void btEditar(ActionEvent event) throws IOException{
    	if (tabela.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro");
			mensagemDeErro.show();
		} else {
			int i = tabela.getSelectionModel().getSelectedIndex();
			produtoEditar = tabela.getItems().get(i);
			Main.TelaCadastroProduto();
		}
    }

    @FXML
    void btExcluir(ActionEvent event) {
    	int i = tabela.getSelectionModel().getSelectedIndex();

		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um produto primeiro");
			mensagemDeErro.show();
		} else {
			Produto p = new Produto();
			p = tabela.getItems().get(i);

			Alert mensagemDeErro = new Alert(Alert.AlertType.CONFIRMATION);
		//	mensagemDeErro.setContentText("Deseja realmente EXCLUIR o produto: " + p.getnomeComercial());

			Optional<ButtonType> resultado = mensagemDeErro.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ProdutoDAO PR = new ProdutoDAO();
			//	PR.delete(p.getcodigo());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Produto excluido com sucesso!!!");
				mensagemDeExclusao.show();
				CarregarInfTable();
			}
		}
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
    void btInfo(ActionEvent event) {
    	Main.changeScreen("produtoInfo");
    }

    @FXML
    void btLimpar(ActionEvent event) {
    	 txtPesquisar.setText("");
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
   	 Main.changeScreen("dashboard");
    }
    
    public void CarregarInfTable()
    {
    	ArrayProduto = FXCollections.observableArrayList(produtos.read());

    	columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	columnDataF.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
    	columnDataV.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
    	columnDose.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
    	columnEst.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComercial"));
    	columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("precoUn"));
    	columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("TipoUn"));
    	
    	tabela.setItems(ArrayProduto);
    
    }
    @FXML
    void btAtualizar(ActionEvent event) {
    	CarregarInfTable();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarInfTable();
	}
}
