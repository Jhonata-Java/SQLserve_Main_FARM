package packageController;

import java.util.Optional;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class controllerRegistrarVenda {

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

    @FXML
    void ActionbtAdicionar(ActionEvent event) {
    	if (btAdicionar != null && txtCodigo != null && txtProduto != null && txtQuantidade != null
				&& txtDesconto != null) {
    		CarregarTabelaProdutosSelecionados();
		}
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
    void ActionbtPesquisarProduto(MouseEvent event) {
    	ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtResultadoPesquisa.getText()));
    	//GUGAS DA GALERA
    			tcID1.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
    			tcProduto1.setCellValueFactory(new PropertyValueFactory<>("Nome"));
    			tcQuantidade1.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    			tcDataValidade1.setCellValueFactory(new PropertyValueFactory<>("DataVal"));
    			tcDataFabricacao1.setCellValueFactory(new PropertyValueFactory<>("DataFab"));
    			tcPrecoUnitario1.setCellValueFactory(new PropertyValueFactory<>("PrecoUnit"));
    		
    			//CARREGAR E SETAR NA TABELA
    			tbProdutoParaselecionar.setItems(ArrayProduto);
    			tbProdutoParaselecionar.refresh();
    }

    @FXML
    void definirDesconto(KeyEvent event) {

    }
    void CarregarTabelaProdutosSelecionados() {
		// AVALIAR PROCESSO - ESSE METODO DEVE CARREGAR AS INFORMAÇÕES A MEDIDA EM QUE
		// EU INSIRO UM NOVO
		// PRODUTO A MINHA LISTA DE COMPRA
		tcID2.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tcProduto2.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		tcQuantidade1.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		tcDataValidade1.setCellValueFactory(new PropertyValueFactory<>("DataVal"));
		tcDataFabricacao1.setCellValueFactory(new PropertyValueFactory<>("DataFab"));
    }
}



//public class controllerRegistrarVenda implements Initializable {
//
//	@FXML
//    private Button btAdicionar;
//
//    @FXML
//    private Button btCancelarVenda;
//
//    @FXML
//    private Button btConfirmarVenda;
//
//    @FXML
//    private Button btExcluir;
//
//    @FXML
//    private Button btPesquisar;
//
//    @FXML
//    private TableView<Produto> tbProdutoParaselecionar;
//
//    @FXML
//    private TableView<Compra> tbProdutoSelecionado;
//
//    @FXML
//    private TableColumn<Produto, String> tcDataFabricacao1;
//
//    @FXML
//    private TableColumn<Compra, String> tcDataFabricacao2;
//
//    @FXML
//    private TableColumn<Produto, String> tcDataValidade1;
//
//    @FXML
//    private TableColumn<Compra, String> tcDataValidade2;
//
//    @FXML
//    private TableColumn<Produto, String> tcID1;
//
//    @FXML
//    private TableColumn<Compra, String> tcID2;
//
//    @FXML
//    private TableColumn<Compra, String> tcPrecoTotal2;
//
//    @FXML
//    private TableColumn<Produto, String> tcPrecoUnitario1;
//
//    @FXML
//    private TableColumn<Compra, String> tcPrecoUnitario2;
//
//    @FXML
//    private TableColumn<Produto, String> tcProduto1;
//
//    @FXML
//    private TableColumn<Compra, String> tcProduto2;
//
//    @FXML
//    private TableColumn<Produto, String> tcQuantidade1;
//
//    @FXML
//    private TableColumn<Compra, String> tcQuantidade2;
//
//    @FXML
//    private TextField txtCPFFarmaceutico;
//
//    @FXML
//    private TextField txtCodigo;
//
//    @FXML
//    private TextField txtDataCompra;
//
//    @FXML
//    private TextField txtDesconto;
//
//    @FXML
//    private TextField txtIDFarmaceutico;
//
//    @FXML
//    private TextField txtNomeFarmaceutico;
//
//    @FXML
//    private TextField txtPrecoUnitario;
//
//    @FXML
//    private TextField txtProduto;
//
//    @FXML
//    private TextField txtQuantidade;
//
//    @FXML
//    private TextField txtResultadoPesquisa;
//
//    @FXML
//    private Label txtValorTotal;
//
//	Produto produto = new Produto();
//	public ObservableList<Produto> ArrayProduto;
//	public ObservableList<Compra> ArrayCompra;
//	public static ProdutoDAO produtoDAO = new ProdutoDAO();
//
//	@FXML
//	void btAdicionar(ActionEvent event) { // ADICIONAR
//		if (btAdicionar != null && txtCodigo != null && txtProduto != null && txtQuantidade != null
//				&& txtDesconto != null) {
//			CarregarTabelaProdutosSelecionados();
//		}
//	}
//
//	@FXML
//	void btConfirmar(ActionEvent event) {
//		if (produto != null && txtCPFFarmaceutico != null) {
//			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
//			mensagemDeAviso.setContentText(
//					"Deseja realmente Salvar a venda para o farmacêutico : " + txtNomeFarmaceutico.getText());
//
//			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();
//
//			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
//				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
//				mensagemDeExclusao.setContentText("Venda realizada com sucesso!");
//				mensagemDeExclusao.show();
//				CompraDAO compraDAO = new CompraDAO();
//				Compra compra = new Compra();
//				compra.setIdVendedor(txtIDFarmaceutico.getText());
//				compra.setIdProduto(produto.getIdProduto());
//				compraDAO.create(compra);
//				// compra.setQuantidade(); EM ANDAMENTO
//
//			} else {
//				Alert mensagemDeExclusao = new Alert(Alert.AlertType.ERROR);
//				mensagemDeExclusao.setContentText("Error ao salvar. Informações incompletas");
//				mensagemDeExclusao.show();
//			}
//		}
//	}
//
//	@FXML
//	void btExcluir(ActionEvent event) {
//
//	}
//
//	@FXML
//	void btPesquisarProduto(ActionEvent event) {
//		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtResultadoPesquisa.getText()));
//
//		tcID1.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
//		tcProduto1.setCellValueFactory(new PropertyValueFactory<>("Nome"));
//		tcQuantidade1.setCellValueFactory(new PropertyValueFactory<>("estoque"));
//		tcDataValidade1.setCellValueFactory(new PropertyValueFactory<>("DataVal"));
//		tcDataFabricacao1.setCellValueFactory(new PropertyValueFactory<>("DataFab"));
//		tcPrecoUnitario1.setCellValueFactory(new PropertyValueFactory<>("PrecoUnit"));
//		
//		tbProdutoParaselecionar.setItems(ArrayProduto);
//		tbProdutoParaselecionar.refresh();
//	}
//
//	@FXML
//	void txtCancelar(ActionEvent event) {
//		Stage stage = (Stage) btCancelarVenda.getScene().getWindow();
//		stage.close();
//	}
//
//	void CarregarTabelaProduto() {
//		ArrayProduto = FXCollections.observableArrayList(produtoDAO.search(txtResultadoPesquisa.getText()));
//
//		tcID1.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
//		tcProduto1.setCellValueFactory(new PropertyValueFactory<>("Nome"));
//		tcQuantidade1.setCellValueFactory(new PropertyValueFactory<>("estoque"));
//		tcDataValidade1.setCellValueFactory(new PropertyValueFactory<>("DataVal"));
//		tcDataFabricacao1.setCellValueFactory(new PropertyValueFactory<>("DataFab"));
//		
//		tbProdutoParaselecionar.setItems(ArrayProduto);
//		tbProdutoParaselecionar.refresh();
//	}
//
//	void CarregarTabelaProdutosSelecionados() {
//		// AVALIAR PROCESSO - ESSE METODO DEVE CARREGAR AS INFORMAÇÕES A MEDIDA EM QUE
//		// EU INSIRO UM NOVO
//		// PRODUTO A MINHA LISTA DE COMPRA
//		tcID2.setCellValueFactory(new PropertyValueFactory<>("nome"));
//		tcProduto2.setCellValueFactory(new PropertyValueFactory<>("Nome"));
//		tcQuantidade1.setCellValueFactory(new PropertyValueFactory<>("estoque"));
//		tcDataValidade1.setCellValueFactory(new PropertyValueFactory<>("DataVal"));
//		tcDataFabricacao1.setCellValueFactory(new PropertyValueFactory<>("DataFab"));
//	}
//
//	@FXML
//	void definirDesconto(KeyEvent event) {
//		if (txtQuantidade.getText() != "" && txtQuantidade.getText() != null) {
//
//			double quantidade = Double.parseDouble(txtQuantidade.getText());
//
//			if (quantidade < 30) {
//				txtDesconto.setText("");
//				double precoTotal = Double.parseDouble(tcPrecoUnitario1.getText())
//						* Double.parseDouble(txtQuantidade.getText());
//				txtValorTotal.setText(Double.toString(precoTotal));
//
//			} else {
//
//				double precoTotal = (Double.parseDouble(tcPrecoUnitario1.getText())
//						* Double.parseDouble(txtQuantidade.getText()));
//				precoTotal = precoTotal * 0.85;
//				Double desconto = precoTotal * 0.15;
//				txtDesconto.setText(Double.toString(desconto));
//			}
//		}
//	}
//
//
//	@Override
//	public void initialize(URL arg0, ResourceBundle arg1) {
//		// TODO Auto-generated method stub
//		CarregarTabelaProduto();
//		CarregarTabelaProdutosSelecionados(); // AVALIAR SE ELE VAI SER INICIALIZADO DE FATO
//
//		txtCPFFarmaceutico.setText(controllerLogin.farmaceutico.getCPF());
//		txtNomeFarmaceutico.setText(controllerLogin.farmaceutico.getNome());
//		txtIDFarmaceutico.setText(controllerLogin.farmaceutico.getIdVendedor());
//		txtQuantidade.setText("0");
//		txtValorTotal.setText("0");
//
//		// VERIFICAR O FUNCIONAMENTO DESSE MÉTODO
//		tbProdutoParaselecionar.setOnMouseClicked((MouseEvent clique) -> {
//			if (clique.getClickCount() == 2) {
//				int i = tbProdutoParaselecionar.getSelectionModel().getSelectedIndex();
//				produto = tbProdutoParaselecionar.getItems().get(i);
//				txtCodigo.setText(produto.getCodigo());
//				txtPrecoUnitario.setText(produto.getPreocoUN());
//				txtProduto.setText(produto.getNomeComecial());
//			}
//		});
//
//	}
//}

