package packageModel;

public class Compra {
	private String idCompra;
	private String idVendedor;
	private String idProduto;
	private String quantidade;
	private String dataCompra;
	private String valorTotal;
	
	
	public Compra() {
		super();
	}
	public Compra(String idCompra, String idVendedor, String quantidade, String dataCompra,
			String valorTotal, String idProduto) {
		super();
		this.idCompra = idCompra;
		this.idVendedor = idVendedor;
		this.quantidade = quantidade;
		this.dataCompra = dataCompra;
		this.valorTotal = valorTotal;
		this.idProduto = idProduto;
	}
	public String getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}
	public String getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
}
