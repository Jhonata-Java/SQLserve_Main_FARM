package packageModel;

public class Produto {
	
	private String idProduto;
	private String idFornecedor;
	private String nomeComecial;
	private String nomeGenerico;
	private String categoria;
	private String formaFarmaceutica;
	private String concentracao;
	private String dosagem;
	private String codigo;
	private String estoque;
	private String preocoUN;
	private String tipoUN;
	private String dataFab;
	private String dataVal;
	private String registroAnvisa;
	private String lote;
	private String endereco;
	
	public Produto() {
		super();
	}

	public Produto(String idProduto, String idFornecedor, String nomeComecial, String nomeGenerico, String categoria,
			String formaFarmaceutica, String concentracao, String dosagem, String codigo, String estoque,
			String preocoUN, String tipoUN, String dataFab, String dataVal, String registroAnvisa, String lote,
			String endereco) {
		super();
		this.idProduto = idProduto;
		this.idFornecedor = idFornecedor;
		this.nomeComecial = nomeComecial;
		this.nomeGenerico = nomeGenerico;
		this.categoria = categoria;
		this.formaFarmaceutica = formaFarmaceutica;
		this.concentracao = concentracao;
		this.dosagem = dosagem;
		this.codigo = codigo;
		this.estoque = estoque;
		this.preocoUN = preocoUN;
		this.tipoUN = tipoUN;
		this.dataFab = dataFab;
		this.dataVal = dataVal;
		this.registroAnvisa = registroAnvisa;
		this.lote = lote;
		this.endereco = endereco;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNomeComecial() {
		return nomeComecial;
	}

	public void setNomeComecial(String nomeComecial) {
		this.nomeComecial = nomeComecial;
	}

	public String getNomeGenerico() {
		return nomeGenerico;
	}

	public void setNomeGenerico(String nomeGenerico) {
		this.nomeGenerico = nomeGenerico;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFormaFarmaceutica() {
		return formaFarmaceutica;
	}

	public void setFormaFarmaceutica(String formaFarmaceutica) {
		this.formaFarmaceutica = formaFarmaceutica;
	}

	public String getConcentracao() {
		return concentracao;
	}

	public void setConcentracao(String concentracao) {
		this.concentracao = concentracao;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstoque() {
		return estoque;
	}

	public void setEstoque(String estoque) {
		this.estoque = estoque;
	}

	public String getPreocoUN() {
		return preocoUN;
	}

	public void setPreocoUN(String preocoUN) {
		this.preocoUN = preocoUN;
	}

	public String getTipoUN() {
		return tipoUN;
	}

	public void setTipoUN(String tipoUN) {
		this.tipoUN = tipoUN;
	}

	public String getDataFab() {
		return dataFab;
	}

	public void setDataFab(String dataFab) {
		this.dataFab = dataFab;
	}

	public String getDataVal() {
		return dataVal;
	}

	public void setDataVal(String dataVal) {
		this.dataVal = dataVal;
	}

	public String getRegistroAnvisa() {
		return registroAnvisa;
	}

	public void setRegistroAnvisa(String registroAnvisa) {
		this.registroAnvisa = registroAnvisa;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
