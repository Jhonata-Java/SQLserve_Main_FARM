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
import javafx.stage.Stage;
import packageControle.ProdutoDAO;
import packageModel.Produto;
import packageModel.Venda;

public class controllerProdutos implements Initializable {

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
	private TableColumn<Produto, String> columnCod;

	@FXML
	private TableColumn<Produto, String> columnDataF;

	@FXML
	private TableColumn<Produto, String> columnDataV;

	@FXML
	private TableColumn<Produto, String> columnDose;

	@FXML
	private TableColumn<Produto, String> columnEst;

	@FXML
	private TableColumn<Produto, String> columnID;

	@FXML
	private TableColumn<Produto, String> columnNomeC;

	@FXML
	private TableColumn<Produto, String> columnPrecoUn;

	@FXML
	private TableColumn<Produto, String> columnTipoUn;

	@FXML
	private TableColumn<Produto, String> colemnPrincAtivo;

	@FXML
	private TableView<Produto> tabela;

	@FXML
	private Button btPesquisar;

	@FXML
	private TextField txtPesquisar;

	private ObservableList<Produto> ArrayProduto;
	private ProdutoDAO produtos = new ProdutoDAO();
	public static Produto produtoEditar = new Produto();
	static Produto produto = new Produto();
	static Venda compra = new Venda();

	@FXML
	void btCadastrar(ActionEvent event) throws IOException {
		produtoEditar = null;
		Main.TelaCadastroProduto();
	
    
		CarregarInfoTable();
	}

	@FXML
	void btDashboard(ActionEvent event) {
		Main.changeScreen("dashboard");
	}

	@FXML
	void btEditar(ActionEvent event) throws IOException {
		if (tabela.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro");
			mensagemDeErro.show();
		} else {
			int i = tabela.getSelectionModel().getSelectedIndex();
			produtoEditar = tabela.getItems().get(i);
			Main.TelaCadastroProduto();
		}
		CarregarInfoTable();
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
			mensagemDeErro.setContentText("Deseja realmente EXCLUIR o produto: " + p.getNomeComecial());

			Optional<ButtonType> resultado = mensagemDeErro.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ProdutoDAO PR = new ProdutoDAO();
				PR.delete(p.getCodigo());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Produto excluido com sucesso!!!");
				mensagemDeExclusao.show();
				CarregarInfoTable();
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
		Main.changeScreen("relatorioVenda");
	}

	@FXML
	void btSair(ActionEvent event) {
		Main.changeScreen("dashboard");
	}

	@FXML
	void btPesquisar(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produtos.search(txtPesquisar.getText()));

		colemnPrincAtivo.setCellValueFactory(new PropertyValueFactory<>("princAtivo"));
		columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnDataF.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
		columnDataV.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnDose.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
		columnEst.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
		columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("preocoUN"));
		columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("tipoUN"));

		tabela.setItems(ArrayProduto);
		tabela.refresh();
	}

	public void CarregarInfoTable() {
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
		columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
		columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("preocoUN"));
		columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("tipoUN"));
		colemnPrincAtivo.setCellValueFactory(new PropertyValueFactory<>("princAtivo"));

		tabela.setItems(ArrayProduto);

	}

	@FXML
	void btAtualizar(ActionEvent event) {
		CarregarInfoTable();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarInfoTable();
	}

	public void ActionBtImprimirPDF(ActionEvent event, Produto produto, Stage stage) {
		
	}

	// Método auxiliar para exibir alertas
	private void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
