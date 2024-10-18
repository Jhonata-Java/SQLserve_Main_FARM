package packageModel;

public class Venda {
	
	private String idVenda;
	private String idVendedor;
	private String idProduto;
	private String quantidade;
	private String dataVenda;
	private String procoTotal;
	
	public Venda() {
		super();
	}

	public Venda(String idVenda, String idVendedor, String idProduto, String quantidade, String dataVenda,
			String procoTotal) {
		super();
		this.idVenda = idVenda;
		this.idVendedor = idVendedor;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.dataVenda = dataVenda;
		this.procoTotal = procoTotal;
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getProcoTotal() {
		return procoTotal;
	}

	public void setProcoTotal(String procoTotal) {
		this.procoTotal = procoTotal;
	}
}
