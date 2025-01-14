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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
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
	private ProdutoDAO produtoDAO = new ProdutoDAO();
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
	void ActionBtInfor(ActionEvent event) throws IOException {
		if (tabela.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um produto primeiro");
			mensagemDeErro.show();
		} else {
			int i = tabela.getSelectionModel().getSelectedIndex();
			produto = tabela.getItems().get(i);
			Main.TelaInfoProduto();
		}
		CarregarInfoTable();
	}

	@FXML
	void btLimpar(ActionEvent event) {
		txtPesquisar.setText("");
		CarregarInfoTable();
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
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtPesquisar.getText()));

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
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.read());

		columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnDataF.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
		columnDataV.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnDose.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
		columnEst.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComercial"));
		columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("TipoUn"));
		columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
		columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("preocoUN"));
		columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("tipoUN"));
		colemnPrincAtivo.setCellValueFactory(new PropertyValueFactory<>("princAtivo"));

		tabela.setItems(ArrayProduto);
	}

	@FXML
	void ActionMouseINDash(MouseEvent event) {
		btDashboard.setStyle(
				"-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	}

	@FXML
	void ActionMouseOUTDash(MouseEvent event) {
		btDashboard.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	}

	@FXML
	void ActionMouseINFar(MouseEvent event) {
		btFarmaceuticos.setStyle(
				"-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	}

	@FXML
	void ActionMouseOUTFar(MouseEvent event) {
		btFarmaceuticos.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	}

	@FXML
	void ActionMouseINFor(MouseEvent event) {
		btFornecedor.setStyle(
				"-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	}

	@FXML
	void ActionMouseOUTFor(MouseEvent event) {
		btFornecedor.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	}

	@FXML
	void ActionMouseINRela(MouseEvent event) {
		btRelatorioVendas.setStyle(
				"-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	}

	@FXML
	void ActionMouseOUTRela(MouseEvent event) {
		btRelatorioVendas.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	}

	@FXML
	void btAtualizar(ActionEvent event) {
		CarregarInfoTable();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Carrega informações na tabela
		CarregarInfoTable();


		// Formata a coluna "columnPrecoUn" para exibir valores com duas casas decimais
		columnPrecoUn.setCellFactory(new Callback<TableColumn<Produto, String>, TableCell<Produto, String>>() {
			@Override
			public TableCell<Produto, String> call(TableColumn<Produto, String> param) {
				return new TableCell<Produto, String>() {
					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						if (empty || item == null) {
							setText(null);
						} else {
							try {
								// Converte o valor para Double e formata com 2 casas decimais
								Double valorDouble = Double.parseDouble(item);
								setText(String.format("%.2f", valorDouble));
							} catch (NumberFormatException e) {
								// Em caso de erro de conversão, exibe o valor como está
								setText(item);
							}
						}
					}
				};
			}
		});
	}
}