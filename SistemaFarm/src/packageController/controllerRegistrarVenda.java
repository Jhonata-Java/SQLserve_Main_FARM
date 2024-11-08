package packageController;

import java.net.URL;
import java.time.LocalDate;
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
	private TableView<Compra> tbProdutoSelecionado;

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
	private Label txtValorTotal;

	Produto produto = new Produto();
	public ObservableList<Produto> ArrayProduto;
	public ObservableList<Compra> ArrayCompra;
	public static ProdutoDAO produtoDAO = new ProdutoDAO();

	double PrecoFinal;
	double desconto;
	double precoTotal;

	@FXML
	void ActionbtAdicionar(ActionEvent event) {
		if (btAdicionar != null && txtCodigo != null && txtProduto != null && txtQuantidade != null
				&& txtDesconto != null) {

		}
		CarregarProduto();
		txtCodigo.setText("");
		txtProduto.setText("");
		txtQuantidade.setText("");
		txtPrecoUnitario.setText("");
		System.out.println(PrecoFinal);
	}

	@FXML
	void ActionbtCancelarVenda(ActionEvent event) {
		Stage stage = (Stage) btCancelarVenda.getScene().getWindow();
		stage.close();

		Main.changeScreen("dashboard");
	}

	@FXML
	void ActionbtConfirmarVenda(ActionEvent event) {
		if (produto != null && txtCPFFarmaceutico != null) {
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
				compraDAO.create(compra);
				// compra.setQuantidade(); EM ANDAMENTO

			} else {
				Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
				mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
				mensagemDeExclusao.show();
			}
		}
	}

	@FXML
	void ActionbtExcluir(ActionEvent event) {

	}

	@FXML
	void ActionbtPesquisarProduto(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtResultadoPesquisa.getText()));
		CarregarInfoTable();
	}

	@FXML
	void definirDesconto(KeyEvent event) {
		if (txtQuantidade.getText() != "" && txtQuantidade.getText() != null) {

			double quantidade = Double.parseDouble(txtQuantidade.getText());

			if (quantidade < 5) {
				precoTotal = Double.parseDouble(txtPrecoUnitario.getText())
						* Double.parseDouble(txtQuantidade.getText());
			} else {
				precoTotal = (Double.parseDouble(txtPrecoUnitario.getText())
						* Double.parseDouble(txtQuantidade.getText())) * 0.15;
				desconto = precoTotal * 0.15;
				txtDesconto.setText(Double.toString(Math.round((desconto * 100.0) / 100.0)));
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

	public void CarregarProduto() {

		// Simulando a lista de produtos
		ObservableList<Produto> ArrayProduto = FXCollections.observableArrayList();

		ObservableList<Produto> ArrayProdutoSelecionado = FXCollections.observableArrayList(ArrayProduto);
		TableView<Produto> tbProdutoParaselecionar = new TableView<>();

		tcID2.setCellValueFactory(new PropertyValueFactory<>(txtCodigo.getText()));
		tcProduto2.setCellValueFactory(new PropertyValueFactory<>(txtProduto.getText()));
		tcQuantidade2.setCellValueFactory(new PropertyValueFactory<>(txtQuantidade.getText()));
		tcPrecoUnitario2.setCellValueFactory(new PropertyValueFactory<>(
				Double.toString(((Double.parseDouble(produto.getPreocoUN()) * 100.0) / 100.0))));
		tcPrecoTotal2.setCellValueFactory(new PropertyValueFactory<>(Double.toString(precoTotal)));

		tbProdutoParaselecionar.setItems(ArrayProdutoSelecionado);
		tbProdutoParaselecionar.refresh();
		PrecoFinal += precoTotal;

	}
//	
//	public void CarregarProduto(ObservableList produtos) {
//		ArrayProdutoSelecionado = FXCollections.observableArrayList(produtos);
//
//		tcID2.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
//		tcProduto2.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
//		tcPrecoUnitario2.setCellValueFactory(new PropertyValueFactory<>("preocoUN"));
//		tcQuantidade2.setCellValueFactory(new PropertyValueFactory<>("estoque"));
//
//		tbProdutoParaselecionar.setItems(ArrayProdutoSelecionado);
//		 
//
//	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		LocalDate dataAtual = LocalDate.now();
		CarregarInfoTable();
		txtCPFFarmaceutico.setText(controllerLogin.farmaceutico.getCPF());
		txtNomeFarmaceutico.setText(controllerLogin.farmaceutico.getNome());
		txtIDFarmaceutico.setText(controllerLogin.farmaceutico.getIdVendedor());
		txtDataCompra.setText(dataAtual.toString());

		tbProdutoParaselecionar.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = tbProdutoParaselecionar.getSelectionModel().getSelectedIndex();
				produto = tbProdutoParaselecionar.getItems().get(i);
				txtCodigo.setText(produto.getIdProduto());
				Double.toString(Math.round((Double.parseDouble(produto.getPreocoUN()) * 100.0) / 100.0));
				txtPrecoUnitario.setText(
						Double.toString(Math.round((Double.parseDouble(produto.getPreocoUN()) * 100.0) / 100.0)));
				txtProduto.setText(produto.getNomeComecial());

			}
		});

	}
}
