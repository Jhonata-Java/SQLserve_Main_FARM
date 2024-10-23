package packageController;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import packageControle.CompraDAO;
import packageControle.ProdutoDAO;
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
	private TableView<Produto> tabelaProduto;

	@FXML
	private TableView<Compra> tabelaProduto1;

	@FXML
	private TextField txtCPFFarmaceutico;

	@FXML
	private TextField txtPrecoUnitario;

	@FXML
	private Button btCancelar;

	@FXML
	private TextField txtCodigo;

	@FXML
	private TextField txtIDFarmaceutico;

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

	Produto produto = new Produto();
	public ObservableList<Produto> ArrayProduto;
	public static ProdutoDAO produtoDAO = new ProdutoDAO();

	@FXML
	void btAdicionar(ActionEvent event) { // ADICIONAR
		if (btAdicionar != null && txtCodigo != null && txtProduto != null && txtQuantidade != null
				&& txtDesconto != null) {
			CarregarTabelaProdutosSelecionados();
		}
	}

	@FXML
	void btConfirmar(ActionEvent event) {
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
	void btExcluir(ActionEvent event) {

	}

	@FXML
	void btPesquisarProduto(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtPesquisar.getText()));

		columCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		columProduto.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		columQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
		columDataValidade.setCellValueFactory(new PropertyValueFactory<>("DataVal"));
		columDataFabricacao.setCellValueFactory(new PropertyValueFactory<>("DataFab"));

		tabelaProduto.setItems(ArrayProduto);
		tabelaProduto.refresh();
	}

	@FXML
	void txtCancelar(ActionEvent event) {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}

	void CarregarTabelaProduto() {
		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtPesquisar.getText()));

		columProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columQuantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columDataValidade.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columDataFabricacao.setCellValueFactory(new PropertyValueFactory<>("dataFab"));

		tabelaProduto.setItems(ArrayProduto);
		tabelaProduto.refresh();
	}

	void CarregarTabelaProdutosSelecionados() {
		// AVALIAR PROCESSO - ESSE METODO DEVE CARREGAR AS INFORMAÇÕES A MEDIDA EM QUE
		// EU INSIRO UM NOVO
		// PRODUTO A MINHA LISTA DE COMPRA
		columProduto1.setCellValueFactory(new PropertyValueFactory<>("nome"));
		columCodigo1.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columQuantidade1.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columPrecoUnitario1.setCellValueFactory(new PropertyValueFactory<>("PrecoUnit"));
		columDataValidade1.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columDataFabricacao1.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
		columPrecoTotal2.setCellFactory(DefinirPrecoTotal());
	}

	// METODO PARA RETORNAR PARA A COLUNA O PREÇO CALCULADO - OU PEGAR SOMENTE O
	// VALOR FINAL DO METODO DE CALCULO
	private Callback<TableColumn<String, Compra>, TableCell<String, Compra>> DefinirPrecoTotal() {
		// TODO Auto-generated method stub

		return null;
	}

	@FXML
	void definirPrecoTotal(KeyEvent event) {
		if (txtQuantidade.getText() != "" && txtQuantidade.getText() != null) {

			double quantidade = Double.parseDouble(txtQuantidade.getText());

			if (quantidade < 30) {
				txtDesconto.setText("");
				double precoTotal = Double.parseDouble(columPrecoUnitario1.getText())
						* Double.parseDouble(txtQuantidade.getText());
				// txtPrecoTotal.setText(Double.toString(precoTotal));

			} else {

				double precoTotal = (Double.parseDouble(columPrecoUnitario1.getText())
						* Double.parseDouble(txtQuantidade.getText()));
				precoTotal = precoTotal * 0.85;
				// txtPrecoTotal.setText(Double.toString(precoTotal));
				Double desconto = precoTotal * 0.15;
				txtDesconto.setText(Double.toString(desconto));

			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTabelaProduto();
		CarregarTabelaProdutosSelecionados(); // AVALIAR SE ELE VAI SER INICIALIZADO DE FATO

		txtCPFFarmaceutico.setText(controllerLogin.farmaceutico.getCPF());
		txtNomeFarmaceutico.setText(controllerLogin.farmaceutico.getNome());
		txtIDFarmaceutico.setText(controllerLogin.farmaceutico.getIdVendedor());
		txtQuantidade.setText("0");

		// VERIFICAR O FUNCIONAMENTO DESSE MÉTODO
		tabelaProduto.setOnMouseClicked((MouseEvent clique) -> {
			if (clique.getClickCount() == 2) {
				int i = tabelaProduto.getSelectionModel().getSelectedIndex();
				produto = tabelaProduto.getItems().get(i);
				columCodigo.setText(produto.getCodigo());
				txtPrecoUnitario.setText(produto.getPreocoUN());
				txtProduto.setText(produto.getNomeComecial());
			}
		});

	}
}

