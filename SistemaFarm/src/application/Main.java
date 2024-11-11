package application;

import java.io.IOException;
import java.sql.Connection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import packageConnecting.ConnectionDATABASE;

public class Main extends Application {

	private static Stage stage;
	private static Scene login;
	private static Scene dashboard;
	private static Scene vendedor;
	private static Scene produto;
	private static Scene fornecedor;
	private static Scene registraVenda;
	private static Scene relatorioVenda;

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			stage.setTitle("FARM");

			// Carregar as cenas
			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/packageView/viewTelaLogin.fxml"));
			login = new Scene(fxmlLogin);

			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/packageView/viewTelaFarmaceutico.fxml"));
			vendedor = new Scene(fxmlMain);

			Parent fxmlProduto = FXMLLoader.load(getClass().getResource("/packageView/viewTelaProdutos.fxml"));
			produto = new Scene(fxmlProduto);

			Parent fxmlFornecedor = FXMLLoader.load(getClass().getResource("/packageView/viewTelaFornecedor.fxml"));
			fornecedor = new Scene(fxmlFornecedor);

			Parent fxmlRegistraVenda = FXMLLoader
					.load(getClass().getResource("/packageView/viewTelaRegistraVenda.fxml"));
			registraVenda = new Scene(fxmlRegistraVenda);

			Parent fxmlRelatorioVenda = FXMLLoader.load(getClass().getResource("/packageView/viewRelatorioVenda.fxml"));
			relatorioVenda = new Scene(fxmlRelatorioVenda);

			stage.getIcons().add(new Image(getClass().getResourceAsStream("/packageIcons/Instagram post - 1.png")));
			stage.setResizable(false);

			// Define a cena inicial como tela de login
			stage.setScene(login);
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Método de troca de tela sem transição
	public static void changeScreen(String tela) {
		switch (tela) {
		case "login":
			stage.setScene(login);
			break;
		case "dashboard":
			try {
				TelaHome();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "vendedor":
			stage.setScene(vendedor);
			break;
		case "produto":
			stage.setScene(produto);
			break;
		case "fornecedor":
			stage.setScene(fornecedor);
			break;
		case "registraVenda":
			stage.setScene(registraVenda);
			break;
		case "relatorioVenda":
			stage.setScene(relatorioVenda);
			break;
		}
	}

	// Tela Principal (Dashboard)
	public static void TelaHome() throws IOException {
		FXMLLoader fxmlHome = new FXMLLoader();
		fxmlHome.setLocation(Main.class.getResource("/packageView/viewTelaMain.fxml"));
		Parent TelaHome = fxmlHome.load();
		dashboard = new Scene(TelaHome);

		stage.setScene(dashboard);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.show();
	}

	// Tela de Cadastro Produto
	public static void TelaCadastroProduto() throws IOException {
		FXMLLoader ProdutoCadastro = new FXMLLoader();
		ProdutoCadastro.setLocation(Main.class.getResource("/packageView/viewCadastroProduto.fxml"));
		Parent cadastroProdu = ProdutoCadastro.load();
		Scene scene2 = new Scene(cadastroProdu);

		Stage cadProduto = new Stage(); // cria um novo Stage cada vez que o método é chamado
		cadProduto.setTitle("Cadastro/Edição Produto - FARM");
		cadProduto.initModality(Modality.APPLICATION_MODAL);
		cadProduto.setScene(scene2);
		cadProduto.centerOnScreen();

		cadProduto.showAndWait();
	}

	// Tela de Cadastro Venda
	public static void TelaRegistraVenda() throws IOException {
		FXMLLoader registraVenda = new FXMLLoader();
		registraVenda.setLocation(Main.class.getResource("/packageView/viewTelaRegistraVenda.fxml"));
		Parent cadastroVenda = registraVenda.load();
		Scene scene2 = new Scene(cadastroVenda);

		Stage cadRegistra = new Stage();
		cadRegistra.setTitle("Registra Venda - FARM");
		cadRegistra.initModality(Modality.APPLICATION_MODAL);
		cadRegistra.setScene(scene2);
		cadRegistra.centerOnScreen();

		cadRegistra.showAndWait();
	}

	// Tela de Cadastro Fornecedor
	public static void TelaCadastraFornecedor() throws IOException {
		FXMLLoader CadFornecedor = new FXMLLoader();
		CadFornecedor.setLocation(Main.class.getResource("/packageView/viewCadastroFornecedor.fxml"));
		Parent cadastroProdu = CadFornecedor.load();
		Scene scene2 = new Scene(cadastroProdu);

		Stage cadFornecedor = new Stage();
		cadFornecedor.setTitle("Cadastra Fornecedor - FARM");
		cadFornecedor.initModality(Modality.APPLICATION_MODAL);
		cadFornecedor.setScene(scene2);
		cadFornecedor.centerOnScreen();

		cadFornecedor.showAndWait();
	}

	// Tela de Cadastro Farmacêutico
	public static void TelaCadastraFarmaceutico() throws IOException {
		FXMLLoader CadVendedor = new FXMLLoader();
		CadVendedor.setLocation(Main.class.getResource("/packageView/viewCadastroFarmaceutico.fxml"));
		Parent cadastroProdu = CadVendedor.load();
		Scene scene2 = new Scene(cadastroProdu);

		Stage cadVendedor = new Stage();
		cadVendedor.setTitle("Cadastra Farmacêutico - FARM");
		cadVendedor.initModality(Modality.APPLICATION_MODAL);
		cadVendedor.setScene(scene2);
		cadVendedor.centerOnScreen();

		cadVendedor.showAndWait();
	}

	// Tela de Info Produto
	public static void TelaInfoProduto() throws IOException {
		FXMLLoader InfoPRODUT = new FXMLLoader();
		InfoPRODUT.setLocation(Main.class.getResource("/packageView/viewTelaInfoExtraProdutos.fxml"));
		Parent infoProdu = InfoPRODUT.load();
		Scene scene2 = new Scene(infoProdu);

		Stage infoProd = new Stage();
		infoProd.initModality(Modality.APPLICATION_MODAL);
		infoProd.setScene(scene2);
		infoProd.centerOnScreen();

		infoProd.showAndWait();
	}

	public static void main(String[] args) {
		Connection con = ConnectionDATABASE.getConnection();
		ConnectionDATABASE.closeConnection(con);

		launch(args);
	}
}

//ArrayList<Fornecedor> fornecedor = new ArrayList<>();
//FornecedorDAO cp = new FornecedorDAO();
//Fornecedor p1 = new Fornecedor();
//
//cp.delete("8");
//p1.setIdCliente("10");
//p1.setIdVendedor("1");
//p1.setIdProduto("3");
//p1.setQuantidade("22");
//p1.setPrecoTotal("300.00");
//p1.setDataFab("2006-09-30");
//p1.setDataVal("2024-09-30");
//cp.update(p1);
//System.out.println(compra);
//
//p1.setNome("Junior");
//p1.setIdVendedor("3");
//p1.setIdProduto("3");
//p1.setQuantidade("22");
//p1.setPrecoTotal("400.00");
//p1.setDataFab("2006-09-30");
//p1.setDataVal("2024-09-30");
//
//VendedorDAO c1 = new VendedorDAO();
//cp.create(p1);
//
//fornecedor = cp.read();
//for(int i = 0; i < fornecedor.size(); i++)//Mostra as informações da tabela.
//{
//	Fornecedor plc = fornecedor.get(i);
//	System.out.println();
//	System.out.print(plc.getIdFornecedor() + "| ");
//	System.out.print(plc.getNome() + "| ");
//	System.out.print(plc.getCNPJ() + "| ");
//	System.out.print(plc.getEmail() + "| ");
//	System.out.print(plc.getTelefone() + "| ");
//	System.out.print(plc.getEndereco() + "| ");
//	System.out.print(plc.getDataVal() + "| ");
//}
//ClienteDAO cliente = new ClienteDAO();
//System.out.println(cliente.read());
