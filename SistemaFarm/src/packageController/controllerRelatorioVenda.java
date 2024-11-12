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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import packageControle.CompraDAO;
import packageModel.Compra;
import packageModel.Produto;
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
	private TableColumn<Compra, String> columnDataVenda;

	@FXML
	private TableColumn<Compra, String> columnFarmaceutico;

	@FXML
	private TableColumn<Compra, String> columnID;

	@FXML
	private TableColumn<Compra, String> columnPrecoTotal;

	@FXML
	private TableColumn<Compra, String> columnProduto;

	@FXML
	private TableColumn<Compra, String> columnQuantidade;

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
	void btLimpar(ActionEvent event) {
		btLimpar.setText("");
		CarregarTable();
	}

	@FXML
	void btPesquisar(ActionEvent event) {
		ArrayCompra = FXCollections.observableArrayList(compra.search(txtPesquisar.getText()));
		
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
		columnDataVenda.setCellValueFactory(new PropertyValueFactory<>("dataCompra"));
		columnFarmaceutico.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
		columnID.setCellValueFactory(new PropertyValueFactory<>("idCompra"));
		columnPrecoTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
		columnProduto.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

		tabela.setItems(ArrayCompra);
	}
	 @FXML
	    void ActionMouseINDash(MouseEvent event) {
		   btDashboard.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	    }

	    @FXML
	    void ActionMouseOUTDash(MouseEvent event) {
			   btDashboard.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	    }

	    @FXML
	    void ActionMouseINFar(MouseEvent event) {
	    	btFarmaceuticos.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	    }

	    @FXML
	    void ActionMouseOUTFar(MouseEvent event) {
	    	btFarmaceuticos.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	    }
	    
	    @FXML
	    void ActionMouseINPro(MouseEvent event) {
	    	btProdutos.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	    }
	    
	    @FXML
	    void ActionMouseOUTPro(MouseEvent event) {
	    	btProdutos.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	    }

	    @FXML
	    void ActionMouseINFor(MouseEvent event) {
	    	btFornecedor.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	    }

	    @FXML
	    void ActionMouseOUTFor(MouseEvent event) {
	    	btFornecedor.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// Formata a coluna "columnPrecoUn" para exibir valores com duas casas decimais
		columnPrecoTotal.setCellFactory(new Callback<TableColumn<Compra, String>, TableCell<Compra, String>>() {
					@Override
					public TableCell<Compra, String> call(TableColumn<Compra, String> param) {
						return new TableCell<Compra, String>() {
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

		CarregarTable();
	}

}
