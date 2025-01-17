package packageController;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import packageControle.CompraDAO;
import packageControle.ProdutoDAO;
import packageModel.Compra;
import packageModel.Produto;

public class controllerRegistrarVenda implements Initializable {

	@FXML
	private Button btAdicionar;

	@FXML
	private Button btCancelarVenda;

	@FXML
	private Button btConfirmarVenda;

	@FXML
	private Button btExcluir;

	@FXML
	private Button btPesquisar;

	@FXML
	private TableView<Produto> tbProdutoParaselecionar;

	@FXML
	private TableView<Produto> tbProdutoSelecionado;

	@FXML
	private TableColumn<Produto, String> tcDataFabricacao1;

	@FXML
	private TableColumn<Compra, String> tcDataFabricacao2;

	@FXML
	private TableColumn<Produto, String> tcDataValidade1;

	@FXML
	private TableColumn<Compra, String> tcDataValidade2;

	@FXML
	private TableColumn<Produto, String> tcID1;

	@FXML
	private TableColumn<Compra, String> tcID2;

	@FXML
	private TableColumn<Compra, String> tcPrecoTotal2;

	@FXML
	private TableColumn<Produto, String> tcPrecoUnitario1;

	@FXML
	private TableColumn<Compra, String> tcPrecoUnitario2;

	@FXML
	private TableColumn<Produto, String> tcProduto1;

	@FXML
	private TableColumn<Compra, String> tcProduto2;

	@FXML
	private TableColumn<Produto, String> tcQuantidade1;

	@FXML
	private TableColumn<Compra, String> tcQuantidade2;

	@FXML
	private TextField txtCPFFarmaceutico;

	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtDataCompra;

	@FXML
	private TextField txtDesconto;

	@FXML
	private TextField txtIDFarmaceutico;

	@FXML
	private TextField txtNomeFarmaceutico;

	@FXML
	private TextField txtPrecoUnitario;

	@FXML
	private TextField txtProduto;

	@FXML
	private TextField txtQuantidade;

	@FXML
	private TextField txtResultadoPesquisa;

	@FXML
	private Button BtLimpar;

	@FXML
	private TextField textFieldDecimal;

	@FXML
	private Label txtValorTotal;

	Produto produto = new Produto();
	public ObservableList<Produto> ArrayProduto;
	public ObservableList<Produto> ArrayProdutoSelecionado;
	public ObservableList<Produto> ProdutosTabela;
	public ObservableList<Compra> ArrayCompra;
	public static ProdutoDAO produtoDAO = new ProdutoDAO();

	double PrecoFinal;
	double desconto;
	double precoTotal;


	@FXML
	void ActionbtCancelarVenda(ActionEvent event) {
		Stage stage;
		stage = (Stage) btCancelarVenda.getScene().getWindow();
		stage.close();

		Main.changeScreen("dashboard");
	}

	@FXML
	void ActionbtConfirmarVenda(ActionEvent event) throws IOException {
		if (produto != null && txtCPFFarmaceutico != null && txtCodigo != null && txtProduto != null
				&& txtQuantidade != null) {
			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText(
					"Deseja realmente Salvar a venda para o farmacêutico : " + txtNomeFarmaceutico.getText());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Venda realizada com sucesso!");
				mensagemDeExclusao.show();
				CompraDAO compraDAO = new CompraDAO();
				Compra compra = new Compra();
				compra.setIdVendedor(txtIDFarmaceutico.getText());
				compra.setIdProduto(produto.getIdProduto());
				compra.setQuantidade(txtQuantidade.getText());
				compra.setValorTotal((Double.toString(precoTotal)));
				compraDAO.create(compra);

			}

		} else {
			Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
			mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
			mensagemDeExclusao.show();
		}
		Alert mensagemDeConfirmacao = new Alert(Alert.AlertType.CONFIRMATION);
		mensagemDeConfirmacao.setContentText(
				"Deseja realizar outra venda");

		Optional<ButtonType> confirmacao = mensagemDeConfirmacao.showAndWait();

		if (confirmacao.isPresent() && confirmacao.get() == ButtonType.OK) {		
			Stage stage = (Stage) btConfirmarVenda.getScene().getWindow();
			stage.close();		
			Main.TelaRegistraVenda();
		} else {
			Stage stage = (Stage) btCancelarVenda.getScene().getWindow();
			stage.close();

			Main.changeScreen("dashboard");
		}

	}

	@FXML
	void ActionbtPesquisarProduto(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtResultadoPesquisa.getText()));

		tcID1.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		tcProduto1.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
		tcPrecoUnitario1.setCellValueFactory(new PropertyValueFactory<>("preocoUN"));
		tcQuantidade1.setCellValueFactory(new PropertyValueFactory<>("estoque"));

		tbProdutoParaselecionar.setItems(ArrayProduto);
		tbProdutoParaselecionar.refresh();
	}

	@FXML
	void BtLimpar(ActionEvent event) {
		txtResultadoPesquisa.setText("");
		CarregarInfoTable();
	}

	@FXML
	void definirDesconto(KeyEvent event) {
		if (txtQuantidade.getText() != "" && txtQuantidade.getText() != null) {

			double quantidade = Double.parseDouble(txtQuantidade.getText());

			if (quantidade < 15) {
				precoTotal = Double.parseDouble(txtPrecoUnitario.getText())
						* Double.parseDouble(txtQuantidade.getText());

				txtValorTotal.setText(Double.toString(precoTotal));
			} else {
				precoTotal = (Double.parseDouble(txtPrecoUnitario.getText())
						* Double.parseDouble(txtQuantidade.getText()));
				desconto = precoTotal * 0.15;
				txtDesconto.setText(Double.toString(desconto));
				txtValorTotal.setText(Double.toString(precoTotal - desconto));

			}
		}
	}

	public void CarregarInfoTable() {
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.read());

		tcID1.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		tcProduto1.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
		tcPrecoUnitario1.setCellValueFactory(new PropertyValueFactory<>("preocoUN"));
		tcQuantidade1.setCellValueFactory(new PropertyValueFactory<>("estoque"));

		tbProdutoParaselecionar.setItems(ArrayProduto);
		tbProdutoParaselecionar.refresh();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		LocalDate dataAtual = LocalDate.now();
		CarregarInfoTable();
		txtQuantidade.setText("0");
		txtValorTotal.setText("0.0");

		txtCPFFarmaceutico.setText(controllerLogin.farmaceutico.getCPF());
		txtNomeFarmaceutico.setText(controllerLogin.farmaceutico.getNome());
		txtIDFarmaceutico.setText(controllerLogin.farmaceutico.getIdVendedor());
		txtDataCompra.setText(dataAtual.toString());

		tbProdutoParaselecionar.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = tbProdutoParaselecionar.getSelectionModel().getSelectedIndex();
				produto = tbProdutoParaselecionar.getItems().get(i);
				txtCodigo.setText(produto.getIdProduto());
				txtPrecoUnitario.setText(produto.getPreocoUN().toString());
				txtProduto.setText(produto.getNomeComecial());

			}
		});

	}
	
	
	//comnetnair4o3mesdizofvnrslifdlfiuesrnultbguydsbuilwrnlwt4g
}
