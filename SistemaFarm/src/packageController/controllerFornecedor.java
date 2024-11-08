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
import javafx.scene.input.MouseEvent;
import packageControle.FornecedorDAO;
import packageModel.Fornecedor;

public class controllerFornecedor implements Initializable{

    @FXML
    private Button BtPesquisarFor;

    @FXML
    private TableColumn<Fornecedor, String> ColumnCNPJ;

    @FXML
    private TableColumn<Fornecedor, String> ColumnEmail;

    @FXML
    private TableColumn<Fornecedor, String> ColumnEndereco;

    @FXML
    private TableColumn<Fornecedor, String> ColumnID;

    @FXML
    private TableColumn<Fornecedor, String> ColumnInscricaoEstadual;

    @FXML
    private TableColumn<Fornecedor, String> ColumnNome;

    @FXML
    private TableColumn<Fornecedor, String> ColumnRamoAtua;

    @FXML
    private TableColumn<Fornecedor, String> ColumnResponsavel;

    @FXML
    private TableColumn<Fornecedor, String> ColumnTelefone;

    @FXML
    private Button btCadastraFor;

    @FXML
    private Button btDashboard;

    @FXML
    private Button btEditarFor;

    @FXML
    private Button btExcluirFor;

    @FXML
    private Button btFarmaceuticos;

    @FXML
    private Button btImprimir;

    @FXML
    private Button btLimpar;

    @FXML
    private Button btProdutos;

    @FXML
    private Button btRelatorioVendas;

    @FXML
    private Button btSair;

    @FXML
    private TableView<Fornecedor> tabelaFor;

    @FXML
    private TextField txtPesquisar;
    
    private ObservableList<Fornecedor> ArrayFornecedor;
    
    private FornecedorDAO fornecedor = new FornecedorDAO();
    
    public static Fornecedor fornecedorEditar = new Fornecedor();
    
    public void CarregarTableFornecedor() {
    	ArrayFornecedor = FXCollections.observableArrayList(fornecedor.search(txtPesquisar.getText()));
    	
    	ColumnID.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
    	ColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	ColumnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
    	ColumnInscricaoEstadual.setCellValueFactory(new PropertyValueFactory<>("inscricaoEstadual"));
    	ColumnResponsavel.setCellValueFactory(new PropertyValueFactory<>("nomeResponsavel"));
    	ColumnRamoAtua.setCellValueFactory(new PropertyValueFactory<>("ramoAtuacao"));
    	ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    	ColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
    	ColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("enderco"));
    	
    	tabelaFor.setItems(ArrayFornecedor);
    }

    @FXML
    void ActionBtEditar(ActionEvent event) throws IOException{
    	
    	if (tabelaFor.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Fornecedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tabelaFor.getSelectionModel().getSelectedIndex();
			fornecedorEditar = tabelaFor.getItems().get(i);
			Main.TelaCadastraFornecedor();
		}
    	CarregarTableFornecedor();
    }
    
    @FXML
    void ActionBtExcluir(ActionEvent event) {
    	int i = tabelaFor.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Fornecdor primeiro!");
			mensagemDeErro.show();
		} else {
			Fornecedor forn = new Fornecedor();
			forn = tabelaFor.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o Fornecedor: " + forn.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				FornecedorDAO f = new FornecedorDAO();
				f.delete(forn.getCNPJ());

				Alert mensagemDeExcluir = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExcluir.setContentText("Fornecedor excluido com sucesso!");
				mensagemDeExcluir.show();
				CarregarTableFornecedor();
			}
		}
    }
    
    @FXML
    void ActionBtPesquisarFor(ActionEvent event) {
    	ArrayFornecedor = FXCollections.observableArrayList(fornecedor.search(txtPesquisar.getText()));
    	
    	ColumnID.setCellValueFactory(new PropertyValueFactory<>("idFornecedor"));
    	ColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	ColumnCNPJ.setCellValueFactory(new PropertyValueFactory<>("CNPJ"));
    	ColumnInscricaoEstadual.setCellValueFactory(new PropertyValueFactory<>("inscricaoEstadual"));
    	ColumnResponsavel.setCellValueFactory(new PropertyValueFactory<>("nomeResponsavel"));
    	ColumnRamoAtua.setCellValueFactory(new PropertyValueFactory<>("ramoAtuacao"));
    	ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    	ColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
    	ColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("enderco"));
    	
    	tabelaFor.setItems(ArrayFornecedor);
    	tabelaFor.refresh();
    }
    
    @FXML
    void ActionBtCadastra(ActionEvent event)throws IOException {
    	fornecedorEditar = null;
    	Main.TelaCadastraFornecedor();
    	CarregarTableFornecedor();
    }
    
    @FXML
    void ActionBtImprimir(ActionEvent event) {
    	
    }
    
    @FXML
    void ActionBtLimpar(ActionEvent event) {
    	txtPesquisar.setText("");
    	CarregarTableFornecedor();
    }
    
    @FXML
    void ActionbtFarmaceuticos(ActionEvent event) {
    	Main.changeScreen("vendedor");
    }
    
    @FXML
    void ActionbtDashboard(ActionEvent event) {
    	Main.changeScreen("dashboard");
    }

    @FXML
    void ActionbtProdutos(ActionEvent event) {
    	Main.changeScreen("produto");
    }

    @FXML
    void ActionbtRelatorioVendas(ActionEvent event) {
    	Main.changeScreen("relatorioVenda");
    }

    @FXML
    void ActionBtSair(ActionEvent event) {
    	Main.changeScreen("dashboard");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableFornecedor();	
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
	    void ActionMouseINRela(MouseEvent event) {
	    	btRelatorioVendas.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
	    }

	    @FXML
	    void ActionMouseOUTRela(MouseEvent event) {
	    	btRelatorioVendas.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
	    }
}