package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.VendedorEntidade;

public class VendedorDAO {
	
	public void inserirVendedor(Connection conn, VendedorEntidade vendedor) throws SQLException {
		
		String sql = "INSERT INTO vendedor(nome, cpf, telefone, endereco) values(?, ?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, vendedor.getNome());
		pstm.setString(2, vendedor.getCpf());
		pstm.setString(3, vendedor.getTelefone());
		pstm.setString(4, vendedor.getEndereco());
		
		int linhasAfetadas = pstm.executeUpdate();
		
		Integer codigoVendedor = null;
		
		if(linhasAfetadas > 0) {
			ResultSet rs = pstm.getGeneratedKeys();
			
			if(rs.next()) {
				codigoVendedor = rs.getInt(1);
			}
		}
	}

	public List<VendedorEntidade> consultarTodosVendedor(Connection conn) {
		
		try {
			
			String sql = "SELECT * FROM vendedor";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			List<VendedorEntidade> vendedores = new ArrayList<>();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				
				VendedorEntidade vendedor = new VendedorEntidade();
				vendedor.setCodigo(codigo);
				vendedor.setNome(nome);
				vendedor.setCpf(cpf);
				vendedor.setTelefone(telefone);
				vendedor.setEndereco(endereco);
				
				vendedores.add(vendedor);
			}
			
			return vendedores;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<VendedorEntidade> consultarVendedorPorCpf(Connection conn, String cpfBusca) {
		
		try {
			
			String sql = "SELECT * FROM vendedor WHERE cpf = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpfBusca);
			
			ResultSet rs = pstm.executeQuery();
			
			List<VendedorEntidade> vendedores = new ArrayList<>();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String telefone = rs.getString("telefone");
				String endereco = rs.getString("endereco");
				
				VendedorEntidade v = new VendedorEntidade();
				v.setCodigo(codigo);
				v.setNome(nome);
				v.setCpf(cpf);
				v.setTelefone(telefone);
				v.setEndereco(endereco);
				
				vendedores.add(v);
				
			}
			
			return vendedores;
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	public void excluirVendedorPorCpf(Connection conn, VendedorEntidade vendedorEntidade) throws SQLException {
		
		String sql = "DELETE FROM vendedor WHERE cpf = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, vendedorEntidade.getCpf());
		
		pstm.execute();
	}

	public boolean atualizarVendedorPorCodigo(Connection conn, VendedorEntidade clienteAtualizado) {
		
		try {
			String sql = "UPDATE vendedor SET nome = ?, cpf = , telefone = ?, endereco = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, clienteAtualizado.getCodigo());
			pstm.setString(2, clienteAtualizado.getNome());
			pstm.setString(3, clienteAtualizado.getCpf());
			pstm.setString(4, clienteAtualizado.getTelefone());
			pstm.setString(5, clienteAtualizado.getEndereco());
			pstm.setInt(6, clienteAtualizado.getCodigo());
			
			int linhasAfetadas = pstm.executeUpdate();
			
			return linhasAfetadas > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
