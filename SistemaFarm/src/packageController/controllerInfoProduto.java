package packageController;

import java.io.IOException;
import java.util.Optional;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import packageControle.FarmaceuticoDAO;
import packageControle.ProdutoDAO;
import packageModel.Produto;

public class controllerInfoProduto {

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
    private Button btPesquisar;

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
    private TableView<Produto> tabela;
    
    private ObservableList<Produto> ArrayProduto;
    
    private ProdutoDAO produto = new ProdutoDAO();
    
    private static Produto produtoEditar = new Produto();

    @FXML
    private TextField txtPesquisar;

    @FXML
    void btCadastrar(ActionEvent event) throws IOException {
    	produtoEditar = null;
    	Main.TelaCadastroProduto();
    	CarregarTableProduto();
    }
    
    public void CarregarTableProduto() {
    	ArrayProduto = FXCollections.observableArrayList(produto.read());
    	
    	columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComercial"));
    	columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	columnDose.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
    	columnEst.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("precoUn"));
    	columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("tipoUn"));
    	columnDataF.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
    	columnDataV.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
    	
    	tabela.setItems(ArrayProduto);
    }


    @FXML
    void btEditar(ActionEvent event) throws IOException{
    	if (tabela.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Vendedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tabela.getSelectionModel().getSelectedIndex();
			produtoEditar = tabela.getItems().get(i);
			Main.TelaCadastraFarmaceutico();
		}
    	CarregarTableProduto();
    }

    @FXML
    void btExcluir(ActionEvent event) {
    	int i = tabela.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um produto primeiro!");
			mensagemDeErro.show();
		} else {
			Produto produto = new Produto();
			produto = tabela.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o Produto: " + produto.getNomeComecial());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				 FarmaceuticoDAO f = new  FarmaceuticoDAO();
				f.delete(produto.getCodigo());

				Alert mensagemDeExcluir = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExcluir.setContentText("Produto excluido com sucesso!");
				mensagemDeExcluir.show();
			}
	    	CarregarTableProduto();
		}
    }
    
    @FXML
    void ActionBtPesquisar(ActionEvent event) {
    	ArrayProduto = FXCollections.observableArrayList(produto.search(txtPesquisar.getText()));
    	
    	columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComercial"));
    	columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	columnDose.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
    	columnEst.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("precoUn"));
    	columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("tipoUn"));
    	columnDataF.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
    	columnDataV.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
    	
    	tabela.setItems(ArrayProduto);
    	tabela.refresh();
    }

    @FXML
    void btImprimir(ActionEvent event) {
    	
    }
    
    @FXML
    void btLimpar(ActionEvent event) {
    	txtPesquisar.setText("");
    }
    
    
    @FXML
    void btFarmaceuticos(ActionEvent event) {
    	Main.changeScreen("vendedor");
    }
    
    @FXML
    void btDashboard(ActionEvent event) {
    	Main.changeScreen("main");
    }

    @FXML
    void btFornecedor(ActionEvent event) {
    	Main.changeScreen("fornecdor");
    }

    @FXML
    void btInfo(ActionEvent event) {
    	
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
    	Main.changeScreen("main");
    }
}