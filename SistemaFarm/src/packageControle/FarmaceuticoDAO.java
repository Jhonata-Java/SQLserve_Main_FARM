package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageConnecting.ConnectionDATABASE;
import packageModel.Farmaceutico;

public class FarmaceuticoDAO {

	public void create(Farmaceutico v) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Vendedor(nome,CPF,email,telefone,dataNasc,dataCont,endereco,) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, v.getNome());
			stmt.setString(2, v.getCPF());
			stmt.setString(3, v.getEmail());
			stmt.setString(4, v.getTelefone());
			stmt.setString(5, v.getDataNasc());
			stmt.setString(6, v.getDataCont());
			stmt.setString(7, v.getEndereco());
			stmt.executeUpdate();
			System.out.println("FOI INSERIDO!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void update(Farmaceutico v){
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE Vendedor SET nome = ?, CPF = ?, email = ?, telefone = ?, dataNasc = ?, dataCont = ?, Endereco = ? WHERE CPF = ?");
			stmt.setString(1, v.getNome());
			stmt.setString(2, v.getCPF());
			stmt.setString(3, v.getEmail());
			stmt.setString(4, v.getTelefone());
			stmt.setString(5, v.getDataNasc());
			stmt.setString(6, v.getDataCont());
			stmt.setString(7, v.getEndereco());

			stmt.setString(8, v.getCPF());

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
			stmt = con.prepareStatement("DELETE FROM Vendedor WHERE CPF = ?");
			stmt.setString(1, CPF);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public Farmaceutico autenticarUser(String user, String password) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Farmaceutico farmaceutico = new Farmaceutico();
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor WHERE senha = ? AND CPF = ? OR email = ? ");
			stmt.setString(1, password);
			stmt.setString(2, user);
			stmt.setString(3, user);
			rs = stmt.executeQuery();
			System.out.println("Teste");
			while (rs.next()) {
				Farmaceutico v = new Farmaceutico();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				v.setPassword(rs.getString(10));
				
				farmaceutico = v;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return farmaceutico;
	}
	public ArrayList<Farmaceutico> read() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Farmaceutico> farmaceutico = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Farmaceutico v = new Farmaceutico();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				farmaceutico.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return farmaceutico;
	}
	public ArrayList<Farmaceutico> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Farmaceutico> farmaceutico = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Vendedor WHERE Nome LIKE ? OR idVendedor LIKE ? ");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Farmaceutico v = new Farmaceutico();
				v.setIdVendedor(rs.getString(1));
				v.setNome(rs.getString(2));
				v.setCPF(rs.getString(3));
				v.setEmail(rs.getString(4));
				v.setTelefone(rs.getString(5));
				v.setDataNasc(rs.getString(6));
				v.setDataCont(rs.getString(7));
				v.setTotalVend(rs.getString(8));
				v.setEndereco(rs.getString(9));
				farmaceutico.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return farmaceutico;
	}
}
