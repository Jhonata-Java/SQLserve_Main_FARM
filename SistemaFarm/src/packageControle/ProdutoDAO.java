package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnecting.ConnectionDATABASE;
import packageModel.Produto;


public class ProdutoDAO {

	public void create(Produto p )
	{
		Connection conexão = ConnectionDATABASE.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("INSERT INTO Produto VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			comandoSQL.setString(1,p.getIdFornecedor());
			comandoSQL.setString(2,p.getNomeComecial());
			comandoSQL.setString(3,p.getNomeGenerico());
			comandoSQL.setString(4,p.getCategoria());
			comandoSQL.setString(5,p.getFormaFarmaceutica());
			comandoSQL.setString(6,p.getConcentracao());
			comandoSQL.setString(7,p.getDosagem());
			comandoSQL.setString(8,p.getCodigo());
			comandoSQL.setString(9,p.getEstoque());
			comandoSQL.setString(10,p.getPreocoUN());
			comandoSQL.setString(11,p.getTipoUN());
			comandoSQL.setString(12,p.getDataFab());
			comandoSQL.setString(13,p.getDataVal());
			comandoSQL.setString(14,p.getRegistroAnvisa());
			comandoSQL.setString(15,p.getLote());
			comandoSQL.setString(16,p.getEndereco());
			
			
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Executado independente que o try catch for acionado ou não
		}finally {
			ConnectionDATABASE.closeConnection(conexão, comandoSQL);		}
	}
     //ResultSet retorna a informação do Banco de Dados(necessario quando se utiliza um select
	public ArrayList<Produto> read()
	{
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Produto> produto = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Produto ");
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Produto p = new Produto();
				p.setIdProduto(rs.getString(1));
				p.setIdFornecedor(rs.getString(2));
				p.setNomeComecial(rs.getString(3));
				p.setNomeGenerico(rs.getString(4));
				p.setCategoria(rs.getString(5));
				p.setFormaFarmaceutica(rs.getString(6));
				p.setConcentracao(rs.getString(7));		//coloca as informações dentro do array cliente
				p.setDosagem(rs.getString(8));
				p.setCodigo(rs.getString(9));
				p.setEstoque(rs.getString(10));
				p.setPreocoUN(rs.getString(11));
				p.setTipoUN(rs.getString(12));
				p.setDataFab(rs.getString(13));
				p.setDataVal(rs.getString(14));
				p.setRegistroAnvisa(rs.getString(15));
				p.setLote(rs.getString(16));
				p.setEndereco(rs.getString(17));

				produto.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		
		return produto;
	}
	public void update(Produto p )
	{
		Connection conexão = ConnectionDATABASE.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("UPDATE Produto SET idFornecedor = ?,  nomeComercial = ?, nomeGenerico = ?, categoria = ?, formaFarmaceutica = ?, concentracao = ?,dosagem = ?, codigo = ?, estoque = ?, precoUn = ?, tipoUn = ?,dataFab = ?,dataVal = ?, registroAnvisa = ?, lote = ?, endereco = ?  WHERE codigo = ?");
			comandoSQL.setString(1,p.getIdFornecedor());
			comandoSQL.setString(2,p.getNomeComecial());
			comandoSQL.setString(3,p.getNomeGenerico());
			comandoSQL.setString(4,p.getCategoria());
			comandoSQL.setString(5,p.getFormaFarmaceutica());
			comandoSQL.setString(6,p.getConcentracao());
			comandoSQL.setString(7,p.getDosagem());
			comandoSQL.setString(8,p.getCodigo());
			comandoSQL.setString(9,p.getEstoque());
			comandoSQL.setString(10,p.getPreocoUN());
			comandoSQL.setString(11,p.getTipoUN());
			comandoSQL.setString(12,p.getDataFab());
			comandoSQL.setString(13,p.getDataVal());
			comandoSQL.setString(14,p.getRegistroAnvisa());
			comandoSQL.setString(15,p.getLote());
			comandoSQL.setString(16,p.getEndereco());
			comandoSQL.setString(17,p.getCodigo());
			
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Executado independente que o try catch for acionado ou não
		}finally {
			ConnectionDATABASE.closeConnection(conexão, comandoSQL);
		}
	}
	
	public void delete(String codigo)
	{
		Connection conexão = ConnectionDATABASE.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("DELETE FROM Produto  WHERE codigo = ?");
			comandoSQL.setString(1, codigo);
			comandoSQL.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERRO ao apagar! Produto possui registro de compra!!!",e);
		}finally {
			ConnectionDATABASE.closeConnection(conexão, comandoSQL);
		}
	}
	
	public ArrayList<Produto> search(String search)
	{
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Produto> produto = new ArrayList<>();
		
		try {//like significa "se parece com" ?
			stmt = con.prepareStatement("SELECT*FROM Produto WHERE nomeComercial like ? OR codigo like ? OR nomeGenerico like ? OR formaFarmaceutica = like ? OR princAtivo = like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			stmt.setString(3, search);
			stmt.setString(4, search);
			stmt.setString(5, search);
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Produto p = new Produto();
				p.setIdProduto(rs.getString(1));
				p.setIdFornecedor(rs.getString(2));
				p.setNomeComecial(rs.getString(3));
				p.setNomeGenerico(rs.getString(4));
				p.setCategoria(rs.getString(5));
				p.setFormaFarmaceutica(rs.getString(6));
				p.setConcentracao(rs.getString(7));		//coloca as informações dentro do array cliente
				p.setDosagem(rs.getString(8));
				p.setCodigo(rs.getString(9));
				p.setEstoque(rs.getString(10));
				p.setPreocoUN(rs.getString(11));
				p.setTipoUN(rs.getString(12));
				p.setDataFab(rs.getString(13));
				p.setDataVal(rs.getString(14));
				p.setRegistroAnvisa(rs.getString(15));
				p.setLote(rs.getString(16));
				p.setEndereco(rs.getString(17));
				p.setPrincAtivo(rs.getString(18));
				produto.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return produto;
	}
}
