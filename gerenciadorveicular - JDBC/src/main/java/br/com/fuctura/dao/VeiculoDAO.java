package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.VeiculoEntidade;

public class VeiculoDAO {

	public void inserirVeiculo(Connection conn, VeiculoEntidade veiculo) throws SQLException {
		
		String sql = "INSERT INTO veiculo(placa, modelo, ano, valor) values(?, ?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, veiculo.getPlaca());
		pstm.setString(2, veiculo.getModelo());
		pstm.setInt(3, veiculo.getAno());
		pstm.setDouble(4, veiculo.getValor());
		
		int affectedRows = pstm.executeUpdate();
		
		Integer codigoVeiculo = null;
		
		if(affectedRows > 0) {
			ResultSet rs = pstm.getGeneratedKeys();
			
			if(rs.next()) {
				codigoVeiculo = rs.getInt(1);
			}
		}
		
	}

	public List<VeiculoEntidade> consultarTodosVeiculos(Connection conn) {
		 
		try {
			
			String sql = "SELECT * FROM veiculo";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			List<VeiculoEntidade> veiculos = new ArrayList<>();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String placa = rs.getString("placa");
				String modelo = rs.getString("modelo");
				int ano = rs.getInt("ano");
				double valor = rs.getDouble("valor");
				
				VeiculoEntidade veiculo = new VeiculoEntidade();
				veiculo.setCodigo(codigo);
				veiculo.setPlaca(placa);
				veiculo.setModelo(modelo);
				veiculo.setAno(ano);
				veiculo.setValor(valor);
				
				veiculos.add(veiculo);
			}
			
			
			return veiculos;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<VeiculoEntidade> consultarVeiculosPorPlaca(Connection conn, String placaBusca) {
		
		try {
			
			String sql = "SELECT * FROM veiculo WHERE placa = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, placaBusca);
			
			ResultSet rs = pstm.executeQuery();
			
			List<VeiculoEntidade> veiculos = new ArrayList<>();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String placa = rs.getString("placa");
				String modelo = rs.getString("modelo");
				int ano = rs.getInt("ano");
				double valor = rs.getDouble("valor");
				
				VeiculoEntidade veiculo = new VeiculoEntidade();
				veiculo.setCodigo(codigo);
				veiculo.setPlaca(placa);
				veiculo.setModelo(modelo);
				veiculo.setAno(ano);
				veiculo.setValor(valor);
				
				veiculos.add(veiculo);
			}
			
			return veiculos;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void excluirVeiculo(Connection conn, VeiculoEntidade veiculoEntidade) throws SQLException{
		
		String sql = "DELETE FROM veiculo WHERE placa = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, veiculoEntidade.getCodigo());
		
		pstm.execute();		
		
	}

	public boolean atualizarDadosVeiculo(Connection conn, VeiculoEntidade veiculo) {
	    String sql = "UPDATE veiculo SET modelo = ?, ano = ?, valor = ? WHERE placa = ?";

	    try {
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, veiculo.getModelo());
	        pstm.setInt(2, veiculo.getAno());
	        pstm.setDouble(3, veiculo.getValor());
	        pstm.setString(4, veiculo.getPlaca());

	        int linhasAfetadas = pstm.executeUpdate();

	        return linhasAfetadas > 0; // Retorna true se atualizou com sucesso

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}

}
