package packageController;
//teste
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import packageControle.CompraDAO;
import packageControle.FarmaceuticoDAO;
import packageControle.ProdutoDAO;
import packageModel.Produto;

public class controllerDashboard  implements Initializable {

    @FXML
    private Hyperlink btAtualizar;
    
    @FXML
    private Button btCadastrarFarmaceutico;

    @FXML
    private Button btCadastrarFornecedor;

    @FXML
    private Button btCadastrarProduto;

    @FXML
    private Button btDashboard;

    @FXML
    private Button btFarmaceuticos;

    @FXML
    private Button btFornecedor;

    @FXML
    private Button btProdutos;

    @FXML
    private Button btRegistraVenda;

    @FXML
    private Button btRelatorioVendas;

    @FXML
    private Button btSair;

    @FXML
    private TableColumn<Produto,String> columnID1;

    @FXML
    private TableColumn<Produto,String> columnID2;

    @FXML
    private TableColumn<Produto,String> columnLocalizacao1;

    @FXML
    private TableColumn<Produto,String> columnLocalizacao2;

    @FXML
    private TableColumn<Produto,String> columnNome1;

    @FXML
    private TableColumn<Produto,String> columnNome2;

    @FXML
    private TableColumn<Produto,String> columnQuantidade;

    @FXML
    private TableColumn<Produto,String> columnVencimento;

    @FXML
    private Label labelNome;
    
    @FXML
    private Label labelNomeFuncio;
    
    @FXML
    private Label lbFaturamento;

    @FXML
    private Label lbFuncionarioVenda;

    @FXML
    private Label lbMedicamentos;

    @FXML
    private TableView<Produto> tabelaEstoque;

    @FXML
    private TableView<Produto> tabelaVencer;
    
    private ObservableList<Produto> ArrayProdutos;
    private ProdutoDAO produto = new ProdutoDAO();

    @FXML
    void btCadastrarFarmaceutico(ActionEvent event)throws IOException  {
    	controllerFarmaceutico.farmaceuticoEditar = null;
         Main.TelaCadastraFarmaceutico();
    }

    @FXML
    void btCadastrarFornecedor(ActionEvent event)throws IOException {
    	Main.TelaCadastraFornecedor();
    }

    @FXML
    void btCadastrarProduto(ActionEvent event)throws IOException {
    	controllerProdutos.produtoEditar = null;
    	Main.TelaCadastroProduto() ;
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
    void btProdutos(ActionEvent event) {
    	 Main.changeScreen("produto");
    }

    @FXML
    void btRegistraVenda(ActionEvent event) throws IOException {
    	Main.TelaRegistraVenda();
    }

    @FXML
    void btRelatorioVendas(ActionEvent event) {
    	 Main.changeScreen("relatorioVenda");
    }

    @FXML
    void btSair(ActionEvent event) {
    	 Main.changeScreen("login");
    }
    
    @FXML
    void Atualizar(ActionEvent event) {
    	CarregarTableEstoque();
    	CarregarTableVencer();
    }
    
    public void CarregarTableEstoque()
    {
    	ArrayProdutos = FXCollections.observableArrayList(produto.readEstoqueAcabando());

    	columnID1.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnLocalizacao1.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	columnNome1.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
    	columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
    	tabelaEstoque.setItems(ArrayProdutos);
    }
    public void CarregarTableVencer()
    {
    	ArrayProdutos = FXCollections.observableArrayList(produto.readDadaVal());

    	columnID2.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
    	columnLocalizacao2.setCellValueFactory(new PropertyValueFactory<>("endereco"));
    	columnNome2.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
    	columnVencimento.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
    	tabelaVencer.setItems(ArrayProdutos);
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
    void ActionMouseINRela(MouseEvent event) {
    	btRelatorioVendas.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #0009ff; -fx-font-weight: bold; -fx-border-color: #0009ff;-fx-border-radius: 10;");
    }

    @FXML
    void ActionMouseOUTRela(MouseEvent event) {
    	btRelatorioVendas.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #9c9c9c;");
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
   
    //teste
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		System.out.println(FarmaceuticoDAO.maiorVenda());
		labelNome.setText(controllerLogin.farmaceutico.getNome());
		lbFuncionarioVenda.setText(FarmaceuticoDAO.maiorVenda());
		double n = Double.parseDouble(CompraDAO.Faturamento());
		String result = String.format("%.2f", n);
		lbFaturamento.setText("R$" + result);
		lbMedicamentos.setText(ProdutoDAO.MedicamentosTotais());
		CarregarTableEstoque();
    	CarregarTableVencer();
	}
}

