package packageController;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import packageControle.FarmaceuticoDAO;
import packageModel.Farmaceutico;

public class controllerFarmaceutico {

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
    
    private ObservableList<Farmaceutico> ArrayVendedor;
    
    private FarmaceuticoDAO farmaceutico = new FarmaceuticoDAO();
    
    public static Farmaceutico farmaceuticoEditar = new Farmaceutico();

    @FXML
    void ActionBtCadastrar(ActionEvent event) {
    	
    }

    @FXML
    void ActionBtDashboard(ActionEvent event) {

    }

    @FXML
    void ActionBtEditar(ActionEvent event) {

    }

    @FXML
    void ActionBtExcluir(ActionEvent event) {

    }

    @FXML
    void ActionBtFornecedor(ActionEvent event) {

    }

    @FXML
    void ActionBtImprimir(ActionEvent event) {

    }

    @FXML
    void ActionBtLimpar(ActionEvent event) {

    }

    @FXML
    void ActionBtPesquisar(ActionEvent event) {

    }

    @FXML
    void ActionBtProdutos(ActionEvent event) {

    }

    @FXML
    void ActionBtRelatorioVendas(ActionEvent event) {

    }

    @FXML
    void ActionBtSair(ActionEvent event) {

    }

}
