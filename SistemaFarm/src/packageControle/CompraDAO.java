package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnecting.ConnectionDATABASE;
import packageModel.Compra;

public class CompraDAO {
	
	static String faturamento;
	
	/*
	 * 
	 * 
	- funcionario que ma
	SELECT 
    v.nome, 
    COUNT(*) AS totalVend,          -- Conta o número de vendas
    SUM(va.precoTotal) AS totalValor -- Soma o valor das vendas
FROM Vendedor v
JOIN Venda va ON va.idVendedor = v.idVendedor  
GROUP BY v.nome;
	
	
	-Todal vendido no mes 
SELECT SUM(precoTotal) AS totalVendas
FROM Venda;


	-Quantidade de Produtos cadastrados
	SELECT COUNT(*) AS total_medicamentos
FROM Produto;
	
	*/
	
	
	
	public void create(Compra c) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Venda VALUES(?, ?, ? , GETDATE(),?)");
			stmt.setString(1, c.getIdVendedor());
			stmt.setString(2, c.getIdProduto());
			stmt.setString(3, c.getQuantidade());
			stmt.setString(4, c.getValorTotal());

			stmt.executeUpdate();
			System.out.println("FOI INSERIDO!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void update(Compra v){
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE Venda SET idVendedor = ?, quantidade = ?,dataVenda = ?,precoTotal = ? WHERE idVenda = ?");
			stmt.setString(1, v.getIdVendedor());
			stmt.setString(2, v.getQuantidade());
			stmt.setString(3, v.getDataCompra());
			stmt.setString(4, v.getValorTotal());
			stmt.setString(5, v.getIdCompra());

			stmt.executeUpdate();
			System.out.println("FOI ATUALIZADO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void delete(String CPF) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Venda WHERE idVenda = ?");
			stmt.setString(1, CPF);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	
	}
	public ArrayList<Compra> read() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Compra> compra = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Vw_ReloatorioVenda");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Compra c = new Compra();
				c.setIdCompra(rs.getString(1));
				c.setIdVendedor(rs.getString(2));
				c.setIdProduto(rs.getString(3));
				c.setQuantidade(rs.getString(4));
				c.setDataCompra(rs.getString(5));
				c.setValorTotal(rs.getString(6));
			
				compra.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return compra;
	}
	public ArrayList<Compra> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Compra> compra = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Vw_RelatorioVenda WHERE idVenda LIKE ? OR dataVenda LIKE ? OR idVendedor LIKE ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			stmt.setString(3, search);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Compra c = new Compra();
				c.setIdCompra(rs.getString(1));
				c.setIdVendedor(rs.getString(2));
				c.setQuantidade(rs.getString(3));
				c.setDataCompra(rs.getString(4));
				c.setValorTotal(rs.getString(5));
				compra.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return compra;
	}
	
	public static String Faturamento() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;		
		
		try {
			stmt = con.prepareStatement("SELECT SUM(precoTotal) AS totalVendas\r\n"
					+ "FROM Venda;");
			rs = stmt.executeQuery();

			while (rs.next()) {
				faturamento = (rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return faturamento;
	}

	
}
