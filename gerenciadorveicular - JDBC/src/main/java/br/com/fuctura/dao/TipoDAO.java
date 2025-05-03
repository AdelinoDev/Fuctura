package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.TipoEntidade;
import br.com.fuctura.entidade.VeiculoEntidade;

public class TipoDAO {
	
	public void inserirTipo(Connection conn, TipoEntidade tipo) throws SQLException{
		
		String sql = "INSERT INTO tipo(descricao) values(?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, tipo.getDescricao());
		
		int affectedRows = pstm.executeUpdate();
		
		Integer codigoTipo = null;
		
		if(affectedRows > 0) {
			ResultSet rs = pstm.getGeneratedKeys();
			
			if(rs.next()) {
				codigoTipo = rs.getInt(1);
			}
		}
	}

	public List<TipoEntidade> consultarTodosTipos(Connection conn) {
		
		try {
			
			String sql = "SELECT * FROM tipo";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			List<TipoEntidade> tipos = new ArrayList<>();
		
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String descricao = rs.getString("descricao");
				
				TipoEntidade tipo = new TipoEntidade();
				tipo.setCodigo(codigo);
				tipo.setDescricao(descricao);
				
				tipos.add(tipo);
			}
			
			
			return tipos;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<TipoEntidade> consultarTipoPorCodigo(Connection conn, int codigoBusca) {
		
		try {
			String sql = "SELECT * FROM tipo WHERE codigo = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigoBusca);
			
			ResultSet rs = pstm.executeQuery();
			
			List<TipoEntidade> tipos = new ArrayList<>();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String descricao = rs.getString("descricao");
				
				TipoEntidade tipo = new TipoEntidade();
				tipo.setCodigo(codigo);
				tipo.setDescricao(descricao);
				
				tipos.add(tipo);
			}
			
			return tipos;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

    public void excluirTipo(Connection conn, TipoEntidade tipoEntidade) throws SQLException{
		
		String sql = "DELETE FROM tipo WHERE codigo = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, tipoEntidade.getCodigo());
		
		pstm.execute();		
		
	}

    public boolean atualizarDadosTipo(Connection conn, TipoEntidade tipoEntidade) {
	    String sql = "UPDATE tipo SET descricao = ? WHERE codigo = ?";

	    try {
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, tipoEntidade.getDescricao());

	        int linhasAfetadas = pstm.executeUpdate();

	        return linhasAfetadas > 0; // Retorna true se atualizou com sucesso

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
}
