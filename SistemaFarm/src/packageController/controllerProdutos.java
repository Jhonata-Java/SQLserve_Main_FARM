package packageController;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontFactory;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;

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
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import packageControle.ProdutoDAO;
import packageModel.Produto;
import packageModel.Venda;

public class controllerProdutos implements Initializable {

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
	private TableColumn<Produto, String> colemnPrincAtivo;

	@FXML
	private TableView<Produto> tabela;

	@FXML
	private Button btPesquisar;

	@FXML
	private TextField txtPesquisar;

	private ObservableList<Produto> ArrayProduto;
	private ProdutoDAO produtos = new ProdutoDAO();
	public static Produto produtoEditar = new Produto();
	static Produto produto = new Produto();
	static Venda compra = new Venda();

	@FXML
	void btCadastrar(ActionEvent event) throws IOException {
		produtoEditar = null;
		Main.TelaCadastroProduto();
<<<<<<< HEAD
    }
=======
		CarregarInfTable();
	}
>>>>>>> branch 'master' of https://github.com/Jhonata-Java/Sistema-FARM.git

	@FXML
	void btDashboard(ActionEvent event) {
		Main.changeScreen("dashboard");
	}

	@FXML
	void btEditar(ActionEvent event) throws IOException {
		if (tabela.getSelectionModel().getSelectedIndex() == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um vendedor primeiro");
			mensagemDeErro.show();
		} else {
			int i = tabela.getSelectionModel().getSelectedIndex();
			produtoEditar = tabela.getItems().get(i);
			Main.TelaCadastroProduto();
		}
		CarregarInfTable();
	}

	@FXML
	void btExcluir(ActionEvent event) {
		int i = tabela.getSelectionModel().getSelectedIndex();

		if (i == -1) {
			Alert mensagemDeErro = new Alert(Alert.AlertType.INFORMATION);
			mensagemDeErro.setContentText("Selecione um produto primeiro");
			mensagemDeErro.show();
		} else {
			Produto p = new Produto();
			p = tabela.getItems().get(i);

			Alert mensagemDeErro = new Alert(Alert.AlertType.CONFIRMATION);
			mensagemDeErro.setContentText("Deseja realmente EXCLUIR o produto: " + p.getNomeComecial());

			Optional<ButtonType> resultado = mensagemDeErro.showAndWait();

			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ProdutoDAO PR = new ProdutoDAO();
				PR.delete(p.getCodigo());

				Alert mensagemDeExclusao = new Alert(Alert.AlertType.INFORMATION);
				mensagemDeExclusao.setContentText("Produto excluido com sucesso!!!");
				mensagemDeExclusao.show();
				CarregarInfTable();
			}
		}
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
	void btImprimir(ActionEvent event) {
		ActionBtImprimirPDF(event, produto, null);
	}

	@FXML
	void btInfo(ActionEvent event) {
		Main.changeScreen("produtoInfo");
		
	}

	//METODO DE LIMPAR
	@FXML
	void btLimpar(ActionEvent event) {
		txtPesquisar.setText("");
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

	@FXML
	void btPesquisar(ActionEvent event) {
		ArrayProduto = FXCollections.observableArrayList(produtos.search(txtPesquisar.getText()));

		colemnPrincAtivo.setCellValueFactory(new PropertyValueFactory<>("princAtivo"));
		columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnDataF.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
		columnDataV.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnDose.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
		columnEst.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
		columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("preocoUN"));
		columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("tipoUN"));

		tabela.setItems(ArrayProduto);
		tabela.refresh();
	}

	public void CarregarInfTable() {
		ArrayProduto = FXCollections.observableArrayList(produtos.read());

		columnCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnDataF.setCellValueFactory(new PropertyValueFactory<>("dataFab"));
		columnDataV.setCellValueFactory(new PropertyValueFactory<>("dataVal"));
		columnDose.setCellValueFactory(new PropertyValueFactory<>("dosagem"));
		columnEst.setCellValueFactory(new PropertyValueFactory<>("estoque"));
		columnID.setCellValueFactory(new PropertyValueFactory<>("idProduto"));
		columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComercial"));
		columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("precoUn"));
		columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("TipoUn"));
		columnNomeC.setCellValueFactory(new PropertyValueFactory<>("nomeComecial"));
		columnPrecoUn.setCellValueFactory(new PropertyValueFactory<>("preocoUN"));
		columnTipoUn.setCellValueFactory(new PropertyValueFactory<>("tipoUN"));
		colemnPrincAtivo.setCellValueFactory(new PropertyValueFactory<>("princAtivo"));

		tabela.setItems(ArrayProduto);

	}

	@FXML
	void btAtualizar(ActionEvent event) {
		CarregarInfTable();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CarregarInfTable();
	}

	public void ActionBtImprimirPDF(ActionEvent event, Produto produto, Stage stage) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Salvar Produto em PDF");

		// Define a extensão de arquivo como PDF
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivos PDF", "*.pdf"));

		// Pede ao usuário para escolher o local para salvar o PDF
		File file = fileChooser.showSaveDialog(stage);
		if (file != null) {
			try {
				// Cria um documento PDF
				PDDocument document = new PDDocument();
				PDPage page = new PDPage();
				document.addPage(page);

				// Inicia o fluxo de conteúdo da página
				PDPageContentStream contentStream = new PDPageContentStream(document, page);

// Define a fonte e tamanho do texto
//				contentStream.setFont(, 12);
	
				contentStream.beginText();
				contentStream.setLeading(14.5f); // Espaçamento entre linhas
				contentStream.newLineAtOffset(50, 750); // Posição inicial do texto na página

				contentStream.showText("Nome Comercial: " + produto.getNomeComecial());
				contentStream.newLine();
				contentStream.showText("Nome Genérico: " + produto.getNomeGenerico());
				contentStream.newLine();
				contentStream.showText("Categoria: " + produto.getCategoria());
				contentStream.newLine();
				contentStream.showText("Forma Farmacêutica: " + produto.getFormaFarmaceutica());
				contentStream.newLine();
				contentStream.showText("Concentração: " + produto.getConcentracao());
				contentStream.newLine();
				contentStream.showText("Dosagem: " + produto.getDosagem());
				contentStream.newLine();
				contentStream.showText("Estoque: " + produto.getEstoque());
				contentStream.newLine();
				contentStream.showText("Preço Unitário: " + produto.getPreocoUN());
				contentStream.newLine();
				contentStream.showText("Data de Fabricação: " + produto.getDataFab());
				contentStream.newLine();
				contentStream.showText("Data de Validade: " + produto.getDataVal());
				contentStream.newLine();
				contentStream.showText("Registro ANVISA: " + produto.getRegistroAnvisa());
				contentStream.newLine();
				contentStream.showText("Lote: " + produto.getLote());
				contentStream.newLine();
				contentStream.showText("Localização: " + produto.getEndereco());
				contentStream.newLine();
				contentStream.showText("Principio Ativo: " + produto.getPrincAtivo());
				contentStream.newLine();

				// Finaliza o fluxo de texto
				contentStream.endText();
				contentStream.close();

				// Salva o documento no local selecionado pelo usuário
				document.save(file);
				document.close();

				showAlert("Sucesso", "PDF salvo com sucesso!");
			} catch (IOException e) {
				showAlert("Erro", "Erro ao salvar PDF: " + e.getMessage());
			}
		}
	}

	// Método auxiliar para exibir alertas
	private void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}
}
