package packageModel;

public class Fornecedor {
	
	private String idFornecedor;
	private String nome;
	private String CNPJ;
	private String inscricaoEstadual;
	private String nomeResponsavel;
	private String ramoAtuacao;
	private String email;
	private String telefone;
	private String enderco;
	
	public Fornecedor() {
		super();
	}

	public Fornecedor(String idFornecedor, String nome, String cNPJ, String inscricaoEstadual, String nomeResponsavel,
			String ramoAtuacao, String email, String telefone, String enderco) {
		this.idFornecedor = idFornecedor;
		this.nome = nome;
		CNPJ = cNPJ;
		this.inscricaoEstadual = inscricaoEstadual;
		this.nomeResponsavel = nomeResponsavel;
		this.ramoAtuacao = ramoAtuacao;
		this.email = email;
		this.telefone = telefone;
		this.enderco = enderco;
	}
	
	public String getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getRamoAtuacao() {
		return ramoAtuacao;
	}

	public void setRamoAtuacao(String ramoAtuacao) {
		this.ramoAtuacao = ramoAtuacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEnderco() {
		return enderco;
	}

	public void setEnderco(String enderco) {
		this.enderco = enderco;
	}
}
