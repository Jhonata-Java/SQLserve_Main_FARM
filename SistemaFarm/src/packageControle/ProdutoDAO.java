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
//			comandoSQL.setString(1,p.getidFornecedor());
//			comandoSQL.setString(2,p.getnomeComercial());
//			comandoSQL.setString(3,p.getnomeGenerico());
//			comandoSQL.setString(4,p.getcategoria());
//			comandoSQL.setString(5,p.getformaFarmaceutica());
//			comandoSQL.setString(6,p.getconcentracao());
//			comandoSQL.setString(7,p.getdosagem());
//			comandoSQL.setString(8,p.getcodigo());
//			comandoSQL.setString(9,p.getestoque());
//			comandoSQL.setString(10,p.getprecoUn());
//			comandoSQL.setString(11,p.gettipoUn());
//			comandoSQL.setString(12,p.getdataFab());
//			comandoSQL.setString(13,p.getdataVal());
//			comandoSQL.setString(14,p.getregistroAnvisa());
//			comandoSQL.setString(15,p.getlote());
//			comandoSQL.setString(16,p.getendereco());
//			
			comandoSQL.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Executado independente que o try catch for acionado ou não
		}finally {
		//	ConnectionDATABASEe.closeConnection(conexão, comandoSQL);
		}
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
//				p.setidProduto(rs.getString(1));
//				p.setidFornecedor(rs.getString(2));
//				p.setnomeComercial(rs.getString(3));
//				p.setnomeGenerico(rs.getString(4));
//				p.setcategoria(rs.getString(5));
//				p.setformaFarmaceutica(rs.getString(6));
//				p.setconcentracao(rs.getString(7));		//coloca as informações dentro do array cliente
//				p.setdosagem(rs.getString(8));
//				p.setcodigo(rs.getString(9));
//				p.setestoque(rs.getString(10));
//				p.setprecoUn(rs.getString(11));
//				p.settipoUn(rs.getString(12));
//				p.setdataFab(rs.getString(13));
//				p.setdataVal(rs.getString(14));
//				p.setregistroAnvisa(rs.getString(15));
//				p.setlote(rs.getString(16));
//				p.setendereco(rs.getString(17));
//				produto.add(p);
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
			comandoSQL = conexão.prepareStatement("UPDATE Produto SET idFornecedor = ?,  nomeComercial = ?, nomeGenerico = ?, categoria = ?, formaFarmaceutica = ?, concentracao = ?,dosagem = ?, codigo = ?, estoque = ?, precoUn = ?, tipoUn = ?,dataFab = ?,dataVal = ?, registroAnvisa = ?, lote = ?, endereco = ? WHERE codigo = ?");
//			comandoSQL.setString(1,p.getidFornecedor());
//			comandoSQL.setString(2,p.getnomeComercial());
//			comandoSQL.setString(3,p.getnomeGenerico());
//			comandoSQL.setString(4,p.getcategoria());
//			comandoSQL.setString(5,p.getformaFarmaceutica());
//			comandoSQL.setString(6,p.getconcentracao());
//			comandoSQL.setString(7,p.getdosagem());
//			comandoSQL.setString(8,p.getcodigo());
//			comandoSQL.setString(9,p.getestoque());
//			comandoSQL.setString(10,p.getprecoUn());
//			comandoSQL.setString(11,p.gettipoUn());
//			comandoSQL.setString(12,p.getdataFab());
//			comandoSQL.setString(13,p.getdataVal());
//			comandoSQL.setString(14,p.getregistroAnvisa());
//			comandoSQL.setString(15,p.getlote());
//			comandoSQL.setString(16,p.getendereco());
//			
//			comandoSQL.setString(17,p.getcodigo());
			
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
			stmt = con.prepareStatement("SELECT*FROM Produto WHERE nomeComercial like ? OR codigo like ? OR nomeGenerico like ? OR formaFarmaceutica = like ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			stmt.setString(3, search);
			stmt.setString(4, search);
			rs = stmt.executeQuery();
			//percorre a tabela
			while(rs.next())
			{
				Produto p = new Produto();
//				p.setidProduto(rs.getString(1));
//				p.setidFornecedor(rs.getString(2));
//				p.setnomeComercial(rs.getString(3));
//				p.setnomeGenerico(rs.getString(4));
//				p.setcategoria(rs.getString(5));
//				p.setformaFarmaceutica(rs.getString(6));
//				p.setconcentracao(rs.getString(7));		//coloca as informações dentro do array cliente
//				p.setdosagem(rs.getString(8));
//				p.setcodigo(rs.getString(9));
//				p.setestoque(rs.getString(10));
//				p.setprecoUn(rs.getString(11));
//				p.settipoUn(rs.getString(12));
//				p.setdataFab(rs.getString(13));
//				p.setdataVal(rs.getString(14));
//				p.setregistroAnvisa(rs.getString(15));
//				p.setlote(rs.getString(16));
//				p.setendereco(rs.getString(17));
//				produto.add(p);
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
