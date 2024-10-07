package packageControle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import packageConnecting.ConnectionDATABASE;
import packageModel.Fornecedor;

public class FornecedorDAO {
	public void create(Fornecedor f) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO Fornecedor VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getCNPJ());
			stmt.setString(3, f.getInscricaoEstadual());
			stmt.setString(4, f.getNomeResponsavel());
			stmt.setString(5, f.getRamoAtuacao());
			stmt.setString(6, f.getEmail());
			stmt.setString(7, f.getTelefone());
			stmt.setString(8, f.getEnderco());

			stmt.executeUpdate();
			System.out.println("FOI INSERIDO!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void update(Fornecedor f){
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement(
					"UPDATE Fornecedor SET nome = ?, CNPJ = ?, inscricaoEstadual = ?, nomeResponsavel = ?, ramoAtuacao = ?, email = ?, telefone = ?, endereco = ? WHERE CNPJ = ?");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getCNPJ());
			stmt.setString(3, f.getInscricaoEstadual());
			stmt.setString(4, f.getNomeResponsavel());
			stmt.setString(5, f.getRamoAtuacao());
			stmt.setString(6, f.getEmail());
			stmt.setString(7, f.getTelefone());
			stmt.setString(8, f.getEnderco());
			stmt.setString(9, f.getCNPJ());

			stmt.executeUpdate();
			System.out.println("FOI ATUALIZADO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public void delete(String CNPJ) {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM Fornecedor WHERE codigo = ?");
			stmt.setString(1, CNPJ);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt);
		}
	}
	public ArrayList<Fornecedor> read() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Fornecedor");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setIdFornecedor(rs.getString(1));
				f.setNome(rs.getString(2));
				f.setCNPJ(rs.getString(3));
				f.setInscricaoEstadual(rs.getString(4));
				f.setNomeResponsavel(rs.getString(5));
				f.setRamoAtuacao(rs.getString(6));
				f.setEmail(rs.getString(7));
				f.setTelefone(rs.getString(8));
				f.setEnderco(rs.getString(9));
				fornecedor.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return fornecedor;
	}
	
	
	public ArrayList<Fornecedor> search(String search) {
		search = "%"+search+"%";
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT*FROM Fornecedor WHERE Nome LIKE ? OR CNPJ LIKE ?");
			stmt.setString(1, search);
			stmt.setString(2, search);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setIdFornecedor(rs.getString(1));
				f.setNome(rs.getString(2));
				f.setCNPJ(rs.getString(3));
				f.setInscricaoEstadual(rs.getString(4));
				f.setNomeResponsavel(rs.getString(5));
				f.setRamoAtuacao(rs.getString(6));
				f.setEmail(rs.getString(7));
				f.setTelefone(rs.getString(8));
				f.setEnderco(rs.getString(9));
				fornecedor.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return fornecedor;
	}
	// Usar na Tela Registra Venda
	public ArrayList<Fornecedor> readNome() {
		Connection con = ConnectionDATABASE.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();
		try {
			stmt = con.prepareStatement("SELECT nome FROM Fornecedor");
			rs = stmt.executeQuery();

			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setNome(rs.getString(1));
				fornecedor.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionDATABASE.closeConnection(con, stmt, rs);
		}
		return fornecedor;
	}
}
