package application;

import java.io.IOException;
import java.sql.Connection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	private static Scene produtoInfo;

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;

			primaryStage.setTitle("FARM");

			Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/packageView/viewTelaLogin.fxml"));
			login = new Scene(fxmlLogin);

			Parent fxmlMain = FXMLLoader.load(getClass().getResource("/packageView/viewTelaMain.fxml"));
			dashboard = new Scene(fxmlMain);

			Parent fxmlVendedor= FXMLLoader.load(getClass().getResource("/packageView/ViewTelaVendedor.fxml"));
			vendedor = new Scene(fxmlVendedor);

			Parent fxmlProduto = FXMLLoader.load(getClass().getResource("/packageView/viewTelaProdutos.fxml"));
			produto = new Scene(fxmlProduto);

			Parent fxmlFornecedor = FXMLLoader.load(getClass().getResource("/packageView/viewTelaFornecedor.fxml"));
			fornecedor = new Scene(fxmlFornecedor);
			
			Parent fxmlRegistraVenda = FXMLLoader.load(getClass().getResource("/packageView/viewTelaRegistraVenda.fxml"));
			registraVenda = new Scene(fxmlRegistraVenda);
			
			Parent fxmlRelatorioVenda = FXMLLoader.load(getClass().getResource("/packageView/viewRelatorioVenda.fxml"));
			relatorioVenda = new Scene(fxmlRelatorioVenda);

			Parent fxmlProdutoInfo = FXMLLoader.load(getClass().getResource("/packageView/viewTelaInfoExtraProdutos.fxml"));
			produtoInfo = new Scene(fxmlProdutoInfo);
			
			primaryStage.setScene(login);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void changeScreen(String tela) {
		if (tela.equals("login")) {
			stage.setScene(login);
			stage.centerOnScreen();
		} else if (tela.equals("dashboard")) {
			stage.setScene(dashboard);
			stage.centerOnScreen();
		} else if (tela.equals("vendedor")) {
			stage.setScene(vendedor);
			stage.centerOnScreen();
		} else if (tela.equals("produto")) {
			stage.setScene(produto);
			stage.centerOnScreen();
		} else if (tela.equals("fornecedor")) {
			stage.setScene(fornecedor);
			stage.centerOnScreen();
		}
		else if (tela.equals("registraVenda")) {
			stage.setScene(registraVenda);
			stage.centerOnScreen();
		}
		else if (tela.equals("relatorioVenda")) {
			stage.setScene(relatorioVenda);
			stage.centerOnScreen();
		}
		else if (tela.equals("produtoInfo")) {
			stage.setScene(produtoInfo);
			stage.centerOnScreen();
		}
	}

	private static Stage cadProduto;
	private static Stage cadRegistra;
	private static Stage cadFornecedor;
	private static Stage cadVendedor;
	
	public static void TelaHome() throws IOException {
		
		FXMLLoader fxmlHome = new FXMLLoader();
		fxmlHome.setLocation(Main.class.getResource("/packageView/viewTelaMain.fxml"));
		Parent TelaHome = fxmlHome.load();
		dashboard = new Scene(TelaHome);
		stage.setScene(dashboard);
		stage.setResizable(false);
		stage.show();
	
	}

	public static void TelaCadastroProduto() throws IOException {
		FXMLLoader ProdutoCadastro = new FXMLLoader();
		ProdutoCadastro.setLocation(Main.class.getResource("/packageView/viewCadastroProduto.fxml"));
		Parent cadastroProdu = ProdutoCadastro.load();
		Scene scene2 = new Scene(cadastroProdu);

		cadProduto = new Stage();
		cadProduto.setTitle("Cadastro/Edição Produto - FARM");
		cadProduto.initModality(Modality.WINDOW_MODAL);
		cadProduto.setScene(scene2);
		cadProduto.centerOnScreen();
		cadProduto.showAndWait();
	}
	
	public static void TelaRegistraVenda() throws IOException {
		FXMLLoader registraVenda = new FXMLLoader();
		registraVenda.setLocation(Main.class.getResource("/packageView/viewTelaRegistraVenda.fxml"));
		Parent cadastroProdu = registraVenda.load();
		Scene scene2 = new Scene(cadastroProdu);

		cadRegistra = new Stage();
		cadRegistra.setTitle("Registra Venda - FARM");
		cadRegistra.initModality(Modality.WINDOW_MODAL);
		cadRegistra.setScene(scene2);
		cadRegistra.centerOnScreen();
		cadRegistra.showAndWait();
	}
	public static void TelaCadastraFornecedor() throws IOException {
		FXMLLoader CadFornecedor = new FXMLLoader();
		CadFornecedor.setLocation(Main.class.getResource("/packageView/viewCadastroFornecedor.fxml"));
		Parent cadastroProdu = CadFornecedor.load();
		Scene scene2 = new Scene(cadastroProdu);

		cadFornecedor = new Stage();
		cadFornecedor.setTitle("Cadastra Fornecedor - FARM");
		cadFornecedor.initModality(Modality.WINDOW_MODAL);
		cadFornecedor.setScene(scene2);
		cadFornecedor.centerOnScreen();
		cadFornecedor.showAndWait();
	}
	public static void TelaCadastraFarmaceutico() throws IOException {
		FXMLLoader CadVendedor = new FXMLLoader();
		CadVendedor.setLocation(Main.class.getResource("/packageView/viewCadastroFarmaceutico.fxml"));
		Parent cadastroProdu = CadVendedor.load();
		Scene scene2 = new Scene(cadastroProdu);

		cadVendedor = new Stage();
		cadVendedor.setTitle("Cadastra Farmacêutico - FARM");
		cadVendedor.initModality(Modality.WINDOW_MODAL);
		cadVendedor.setScene(scene2);
		cadVendedor.centerOnScreen();
		cadVendedor.showAndWait();
	}

	public static void main(String[] args) {
		Connection con = ConnectionDATABASE.getConnection();
		ConnectionDATABASE.closeConnection(con);
		
//		ArrayList<Fornecedor> fornecedor = new ArrayList<>();
//		FornecedorDAO cp = new FornecedorDAO();
//		Fornecedor p1 = new Fornecedor();
//		
//		cp.delete("8");
//		p1.setIdCliente("10");
//		p1.setIdVendedor("1");
//		p1.setIdProduto("3");
//		p1.setQuantidade("22");
//		p1.setPrecoTotal("300.00");
//		p1.setDataFab("2006-09-30");
//		p1.setDataVal("2024-09-30");
//		cp.update(p1);
//		System.out.println(compra);
//		
//		p1.setNome("Junior");
//		p1.setIdVendedor("3");
//		p1.setIdProduto("3");
//		p1.setQuantidade("22");
//		p1.setPrecoTotal("400.00");
//		p1.setDataFab("2006-09-30");
//		p1.setDataVal("2024-09-30");
//
//		VendedorDAO c1 = new VendedorDAO();
//		cp.create(p1);
//		
//		fornecedor = cp.read();
//		for(int i = 0; i < fornecedor.size(); i++)//Mostra as informações da tabela.
//		{
//			Fornecedor plc = fornecedor.get(i);
//			System.out.println();
//			System.out.print(plc.getIdFornecedor() + "| ");
//			System.out.print(plc.getNome() + "| ");
//			System.out.print(plc.getCNPJ() + "| ");
//			System.out.print(plc.getEmail() + "| ");
//			System.out.print(plc.getTelefone() + "| ");
//			System.out.print(plc.getEndereco() + "| ");
//			System.out.print(plc.getDataVal() + "| ");
//		}
//		ClienteDAO cliente = new ClienteDAO();
//		System.out.println(cliente.read());

		launch(args);
	}
}
