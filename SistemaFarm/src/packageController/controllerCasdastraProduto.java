package packageController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import packageControle.ProdutoDAO;
import packageModel.Produto;

public class controllerCasdastraProduto implements Initializable {

	@FXML
	private Button btCadastrar;

	@FXML
	private Button btCancelar;

	@FXML
	private TextField textCat;

	@FXML
	private TextField textCodigoBar;

	@FXML
	private TextField textConc;

	@FXML
	private TextField textContraind;

	@FXML
	private TextField textDataComp;

	@FXML
	private DatePicker DtDataFab;

	@FXML
	private DatePicker DtDataVal;;

	@FXML
	private TextField textDose;

	@FXML
	private TextField textEfeitosCol;

	@FXML
	private TextField textFormaF;

	@FXML
	private TextField textInd;

	@FXML
	private TextField textLab;

	@FXML
	private TextField textLote;

	@FXML
	private TextField textNomeC;

	@FXML
	private TextField textNomeG;

	@FXML
	private TextField textPreca;

	@FXML
	private TextField textPrecoUn;

	@FXML
	private TextField textPrincAtivo;

	@FXML
	private TextField textQuant;

	@FXML
	private TextField textTipoUn;

	@FXML
	private TextField textLocalizacao;
	@FXML
	private TextField textRegistroANVISA;

	@FXML
	private TextField textTarja;

	@FXML
	void btCadastrar(ActionEvent event) {
		if (controllerProdutos.produtoEditar == null) {
			Produto produto = new Produto();
			produto.setNomeComecial(textNomeC.getText());
			produto.setNomeGenerico(textNomeG.getText());
			produto.setCategoria(textCat.getText());
			produto.setFormaFarmaceutica(textFormaF.getText());
			produto.setConcentracao(textConc.getText());
			produto.setDosagem(textDose.getText());
			produto.setCodigo(textCodigoBar.getText());
			produto.setEstoque(textQuant.getText());
			produto.setPreocoUN(textPrecoUn.getText());
			produto.setTipoUN(textTipoUn.getText());
			produto.setDataFab(DtDataFab.getValue().toString());
			produto.setDataVal(DtDataVal.getValue().toString());
			produto.setRegistroAnvisa(textRegistroANVISA.getText());
			produto.setLote(textLote.getText());
			produto.setEndereco(textLocalizacao.getText());
			produto.setPrincAtivo(textPrincAtivo.getText());
			produto.setIndicacoes(textInd.getText());
			produto.setContraInd(textContraind.getText());
			produto.setEfeitosColaterais(textEfeitosCol.getText());
			produto.setLaboratorio(textLab.getText());

			ProdutoDAO pro = new ProdutoDAO();
			pro.create(produto);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		} else {
			
			Produto produto = new Produto();
			
			produto.setNomeComecial(textNomeC.getText());
			produto.setNomeGenerico(textNomeG.getText());
			produto.setCategoria(textCat.getText());
			produto.setFormaFarmaceutica(textFormaF.getText());
			produto.setConcentracao(textConc.getText());
			produto.setDosagem(textDose.getText());
			produto.setCodigo(textCodigoBar.getText());
			produto.setEstoque(textQuant.getText());
			produto.setPreocoUN(textPrecoUn.getText());
			produto.setTipoUN(textTipoUn.getText());
			produto.setDataFab(DtDataFab.getValue().toString());
			produto.setDataVal(DtDataVal.getValue().toString());
			produto.setRegistroAnvisa(textRegistroANVISA.getText());
			produto.setLote(textLote.getText());
			produto.setEndereco(textLocalizacao.getText());
			produto.setPrincAtivo(textPrincAtivo.getText());
			produto.setIndicacoes(textInd.getText());
			produto.setContraInd(textContraind.getText());
			produto.setEfeitosColaterais(textEfeitosCol.getText());
			produto.setLaboratorio(textLab.getText());

			ProdutoDAO pro = new ProdutoDAO();
			pro.update(produto);

			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		}
	}

	@FXML
	void btCancelar(ActionEvent event) {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if (controllerProdutos.produtoEditar != null) {
			textNomeC.setText(controllerProdutos.produtoEditar.getNomeComecial());
			textNomeG.setText(controllerProdutos.produtoEditar.getNomeGenerico());
			textCat.setText(controllerProdutos.produtoEditar.getCategoria());
			textFormaF.setText(controllerProdutos.produtoEditar.getFormaFarmaceutica());
			textConc.setText(controllerProdutos.produtoEditar.getConcentracao());
			textDose.setText(controllerProdutos.produtoEditar.getDosagem());
			textCodigoBar.setText(controllerProdutos.produtoEditar.getCodigo());
			textQuant.setText(controllerProdutos.produtoEditar.getEstoque());
			textPrecoUn.setText(controllerProdutos.produtoEditar.getPreocoUN());
			textTipoUn.setText(controllerProdutos.produtoEditar.getTipoUN());
//		DtDataFab.setText(controllerProdutos.produtoEditar.getDataFab());
//		DtDataVal.setText(controllerProdutos.produtoEditar.getDataVal());
			textRegistroANVISA.setText(controllerProdutos.produtoEditar.getRegistroAnvisa());
			textLote.setText(controllerProdutos.produtoEditar.getLote());
			textLocalizacao.setText(controllerProdutos.produtoEditar.getEndereco());
			textPrincAtivo.setText(controllerProdutos.produtoEditar.getPrincAtivo());
			textInd.setText(controllerProdutos.produtoEditar.getIndicacoes());
			textContraind.setText(controllerProdutos.produtoEditar.getContraInd());
			textEfeitosCol.setText(controllerProdutos.produtoEditar.getEfeitosColaterais());
			textLab.setText(controllerProdutos.produtoEditar.getLaboratorio());
		}
	}
}