package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import packageConnecting.ConnectionDATABASE;
import packageModel.Compra;

public class CompraDAO {
	public void create(Compra c) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Venda (idVendedor, quantidade,dataVenda,precoTotal) VALUES(?, ?, ?, ?)");
			stmt.setString(1, c.getIdVendedor());
			stmt.setString(2, c.getQuantidade());
			stmt.setString(3, c.getDataCompra());
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
			stmt = con.prepareStatement("SELECT*FROM Venda");
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
	public ArrayList<Compra> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Compra> compra = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Venda WHERE idVenda LIKE ? OR dataVenda LIKE ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
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

}
