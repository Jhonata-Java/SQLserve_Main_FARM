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
import packageControle.FarmaceuticoDAO;
import packageModel.Farmaceutico;

public class controllerFarmaceutico implements Initializable{

    @FXML
    private TableColumn<Farmaceutico, String> ColumnCPF;

    @FXML
    private TableColumn<Farmaceutico, String> ColumnContra;

    @FXML
    private TableColumn<Farmaceutico, String> ColumnEmail;

    @FXML
    private TableColumn<Farmaceutico, String> ColumnEndereco;

    @FXML
    private TableColumn<Farmaceutico, String> ColumnID;

    @FXML
    private TableColumn<Farmaceutico, String> ColumnNacimento;

    @FXML
    private TableColumn<Farmaceutico, String> ColumnNome;

    @FXML
    private TableColumn<Farmaceutico, String> ColumnTelefone;
    
    @FXML
    private TableColumn<Farmaceutico, String> ColumnTotalVend;
    
    @FXML
    private TableColumn<Farmaceutico, String> ColumnCRF;

    @FXML
    private Button btCadastrar;

    @FXML
    private Button btDashboard;

    @FXML
    private Button btEditar;

    @FXML
    private Button btExcluir;

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
    private TableView<Farmaceutico> tabelaFarmaceutico;

    @FXML
    private TextField txtPesquisar;
    
    private ObservableList<Farmaceutico> ArrayFarmaceutico;
    
    private FarmaceuticoDAO farmaceutico = new FarmaceuticoDAO();
    
    public static Farmaceutico farmaceuticoEditar = new Farmaceutico();

    @FXML
    void ActionBtCadastrar(ActionEvent event) throws IOException {
    	farmaceuticoEditar = null;
    	Main.TelaCadastraFarmaceutico();
    	CarregarTableFarmaceudico();
    }

    @FXML
    void ActionBtDashboard(ActionEvent event) throws IOException {
    	Main.TelaHome();
    }

    @FXML
    void ActionBtEditar(ActionEvent event) throws IOException {
    	if (tabelaFarmaceutico.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Vendedor para editar primeiro!");
			mensagemDeErro.show();
		} else {
			int i = tabelaFarmaceutico.getSelectionModel().getSelectedIndex();
			farmaceuticoEditar = tabelaFarmaceutico.getItems().get(i);
			Main.TelaCadastraFarmaceutico();
		}
    	CarregarTableFarmaceudico();
    }

    @FXML
    void ActionBtExcluir(ActionEvent event) {
    	int i = tabelaFarmaceutico.getSelectionModel().getSelectedIndex();
		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um Farmacêutico primeiro!");
			mensagemDeErro.show();
		} else {
			Farmaceutico vendedor = new Farmaceutico();
			vendedor = tabelaFarmaceutico.getItems().get(i);

			Alert mensagemDeAviso = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeAviso.setContentText("Deseja realmente excluir o Farmacêutico: " + vendedor.getNome());

			Optional<ButtonType> resultado = mensagemDeAviso.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				 FarmaceuticoDAO f = new  FarmaceuticoDAO();
				f.delete(vendedor.getCPF());

				Alert mensagemDeExcluir = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExcluir.setContentText("Farmacêutico excluido com sucesso!");
				mensagemDeExcluir.show();
			}
			CarregarTableFarmaceudico();
		}
    }

    @FXML
    void ActionBtPesquisar(ActionEvent event) {
    	ArrayFarmaceutico = FXCollections.observableArrayList(farmaceutico.search(txtPesquisar.getText()));
    	
    	ColumnID.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
		ColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		ColumnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
		ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		ColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		ColumnNacimento.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
		ColumnContra.setCellValueFactory(new PropertyValueFactory<>("dataCont"));
		ColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		ColumnTotalVend.setCellValueFactory(new PropertyValueFactory<>("totalVend"));
		ColumnCRF.setCellValueFactory(new PropertyValueFactory<>("crf"));
		
		tabelaFarmaceutico.setItems(ArrayFarmaceutico);
		tabelaFarmaceutico.refresh();
    }
    
    @FXML
    void ActionBtLimpar(ActionEvent event) {
    	txtPesquisar.setText("");
    	CarregarTableFarmaceudico();
    }
    
    public void CarregarTableFarmaceudico() {
    	ArrayFarmaceutico = FXCollections.observableArrayList(farmaceutico.read());
    	
    	ColumnID.setCellValueFactory(new PropertyValueFactory<>("idVendedor"));
    	ColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	ColumnCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
    	ColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    	ColumnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
    	ColumnNacimento.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
    	ColumnContra.setCellValueFactory(new PropertyValueFactory<>("dataCont"));
    	ColumnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	ColumnTotalVend.setCellValueFactory(new PropertyValueFactory<>("totalVend"));
    	ColumnCRF.setCellValueFactory(new PropertyValueFactory<>("crf"));
    	
    	tabelaFarmaceutico.setItems(ArrayFarmaceutico);
    }
    
    @FXML
    void ActionBtFornecedor(ActionEvent event) {
    	Main.changeScreen("fornecedor");
    }

    @FXML
    void ActionBtProdutos(ActionEvent event) {
    	Main.changeScreen("produto");
    }

    @FXML
    void ActionBtRelatorioVendas(ActionEvent event) {
    	Main.changeScreen("relatorioVenda");
    }

    @FXML
    void ActionBtSair(ActionEvent event) {
    	Main.changeScreen("login");
    }

    @FXML
    void btActionFarmaceutico(ActionEvent event) {
    	Main.changeScreen("vendedor");
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarTableFarmaceudico();
	}
	
	

}
