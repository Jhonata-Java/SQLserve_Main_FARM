package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import packageConnecting.ConnectionDATABASE;
import packageModel.Produto;


public class ProdutoDAO {

	public void create(Produto p )
	{
		Connection conexão = ConnectionDATABASE.getConnection();
		PreparedStatement comandoSQL = null;
		
		try {
			comandoSQL = conexão.prepareStatement("INSERT INTO Produto VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			comandoSQL.setString(1,p.getNomeComecial());
			comandoSQL.setString(2,p.getNomeGenerico());
			comandoSQL.setString(3,p.getCategoria());
			comandoSQL.setString(4,p.getFormaFarmaceutica());
			comandoSQL.setString(5,p.getConcentracao());
			comandoSQL.setString(6,p.getDosagem());
			comandoSQL.setString(7,p.getCodigo());
			comandoSQL.setString(8,p.getEstoque());
			comandoSQL.setString(9,p.getPreocoUN());
			comandoSQL.setString(10,p.getTipoUN());
			comandoSQL.setString(11,p.getDataFab());
			comandoSQL.setString(12,p.getDataVal());
			comandoSQL.setString(13,p.getRegistroAnvisa());
			comandoSQL.setString(14,p.getLote());
			comandoSQL.setString(15,p.getEndereco());
			comandoSQL.setString(16,p.getPrincAtivo());
			comandoSQL.setString(17,p.getContraInd());
			comandoSQL.setString(18,p.getEfeitosColaterais());
			comandoSQL.setString(19,p.getLaboratorio());
			
			
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
				p.setNomeComecial(rs.getString(2));
				p.setNomeGenerico(rs.getString(3));
				p.setCategoria(rs.getString(4));
				p.setFormaFarmaceutica(rs.getString(5));
				p.setConcentracao(rs.getString(6));		//coloca as informações dentro do array cliente
				p.setDosagem(rs.getString(7));
				p.setCodigo(rs.getString(8));
				p.setEstoque(rs.getString(9));
				p.setPreocoUN(rs.getString(10));
				p.setTipoUN(rs.getString(11));
				p.setDataFab(rs.getString(12));
				p.setDataVal(rs.getString(13));
				p.setRegistroAnvisa(rs.getString(14));
				p.setLote(rs.getString(15));
				p.setEndereco(rs.getString(16));
				p.setPrincAtivo(rs.getString(17));

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
			comandoSQL.setString(1,p.getNomeComecial());
			comandoSQL.setString(2,p.getNomeGenerico());
			comandoSQL.setString(3,p.getCategoria());
			comandoSQL.setString(4,p.getFormaFarmaceutica());
			comandoSQL.setString(5,p.getConcentracao());
			comandoSQL.setString(6,p.getDosagem());
			comandoSQL.setString(7,p.getCodigo());
			comandoSQL.setString(8,p.getEstoque());
			comandoSQL.setString(9,p.getPreocoUN());
			comandoSQL.setString(10,p.getTipoUN());
			comandoSQL.setString(11,p.getDataFab());
			comandoSQL.setString(12,p.getDataVal());
			comandoSQL.setString(13,p.getRegistroAnvisa());
			comandoSQL.setString(14,p.getLote());
			comandoSQL.setString(15,p.getEndereco());
			comandoSQL.setString(16,p.getPrincAtivo());
			comandoSQL.setString(17,p.getContraInd());
			comandoSQL.setString(18,p.getEfeitosColaterais());
			comandoSQL.setString(19,p.getLaboratorio());
			
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
			stmt = con.prepareStatement("SELECT*FROM Produto WHERE nomeComercial like ? OR codigo like ? OR nomeGenerico like ? OR formaFarmaceutica  like ? OR princAtivo  like ? ");
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
				p.setNomeComecial(rs.getString(2));
				p.setNomeGenerico(rs.getString(3));
				p.setCategoria(rs.getString(4));
				p.setFormaFarmaceutica(rs.getString(5));
				p.setConcentracao(rs.getString(6));
				p.setDosagem(rs.getString(7));
				p.setCodigo(rs.getString(8));
				p.setEstoque(rs.getString(9));
				p.setPreocoUN(rs.getString(10));
				p.setTipoUN(rs.getString(11));
				p.setDataFab(rs.getString(12));
				p.setDataVal(rs.getString(13));
				p.setRegistroAnvisa(rs.getString(14));
				p.setLote(rs.getString(15));
				p.setEndereco(rs.getString(16));
				p.setPrincAtivo(rs.getString(17));

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
	
	public ObservableList<String> readNome() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ObservableList<String> produto = FXCollections.observableArrayList();
		try {
			stmt = con.prepareStatement("SELECT nomeComercial FROM Produto");
			rs = stmt.executeQuery();

			while (rs.next()) {
			
				String f = rs.getString(1);
				produto.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return produto;
	}
	
	public ArrayList<Produto> readDadaVal()
	{
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Produto> produto = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT*FROM Produto WHERE dataVal BETWEEN GETDATE() AND DATEADD(MONTH, 4, GETDATE());");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Produto p = new Produto();
				p.setIdProduto(rs.getString(1));
				p.setNomeComecial(rs.getString(2));
				p.setNomeGenerico(rs.getString(3));
				p.setCategoria(rs.getString(4));
				p.setFormaFarmaceutica(rs.getString(5));
				p.setConcentracao(rs.getString(6));
				p.setDosagem(rs.getString(7));
				p.setCodigo(rs.getString(8));
				p.setEstoque(rs.getString(9));
				p.setPreocoUN(rs.getString(10));
				p.setTipoUN(rs.getString(11));
				p.setDataFab(rs.getString(12));
				p.setDataVal(rs.getString(13));
				p.setRegistroAnvisa(rs.getString(14));
				p.setLote(rs.getString(15));
				p.setEndereco(rs.getString(16));
				p.setPrincAtivo(rs.getString(17));

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
	
	public ArrayList<Produto> readEstoqueAcabando()
	{
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList <Produto> produto = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM Produto WHERE estoque <= 100;");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				Produto p = new Produto();
				p.setIdProduto(rs.getString(1));
				p.setNomeComecial(rs.getString(2));
				p.setNomeGenerico(rs.getString(3));
				p.setCategoria(rs.getString(4));
				p.setFormaFarmaceutica(rs.getString(5));
				p.setConcentracao(rs.getString(6));
				p.setDosagem(rs.getString(7));
				p.setCodigo(rs.getString(8));
				p.setEstoque(rs.getString(9));
				p.setPreocoUN(rs.getString(10));
				p.setTipoUN(rs.getString(11));
				p.setDataFab(rs.getString(12));
				p.setDataVal(rs.getString(13));
				p.setRegistroAnvisa(rs.getString(14));
				p.setLote(rs.getString(15));
				p.setEndereco(rs.getString(16));
				p.setPrincAtivo(rs.getString(17));

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
