package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.entidade.LojaEntidade;

public class LojaDAO {
	
	//inserir loja
	public void inserirLoja(Connection conn, LojaEntidade loja) throws SQLException{
		
		String sql = "INSERT INTO loja(nome, cnpj, endereco) values(?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, loja.getNome());
		pstm.setString(2, loja.getCnpj());
		pstm.setString(3, loja.getEndereco());
		
		int affectdRows = pstm.executeUpdate();
		
		Integer codigoLoja = null;
		
		if(affectdRows > 0) {
			ResultSet rs = pstm.getGeneratedKeys();
			
			if(rs.next()) {
				codigoLoja = rs.getInt(1);
			}
		}
	}

	//consultar todas as lojas
	public List<LojaEntidade> consultarTodasLoja(Connection conn){
		
		try {
			
			String sql = "SELECT * FROM loja";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			List<LojaEntidade> lojas = new ArrayList<>();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String cnpj = rs.getString("cnpj");
				String endereco = rs.getString("endereco");
				
				LojaEntidade loja = new LojaEntidade();
				loja.setCodigo(codigo);
				loja.setNome(nome);
				loja.setCnpj(cnpj);
				loja.setEndereco(endereco);
				
				lojas.add(loja);
			}		
			
			return lojas;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	//consultar lojas por ID
	public List<LojaEntidade> consultarLojasPorCodigo(Connection conn, int codigoBusca) {
		
		try {
			
			String sql = "SELECT * FROM loja WHERE codigo = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigoBusca);
			
			ResultSet rs = pstm.executeQuery();
			
			List<LojaEntidade> lojas = new ArrayList<>();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String cnpj = rs.getString("cnpj");
				String endereco = rs.getString("endereco");
				
				LojaEntidade loja = new LojaEntidade();
				loja.setCodigo(codigo);
				loja.setNome(nome);
				loja.setCnpj(cnpj);
				loja.setEndereco(endereco);
				
				lojas.add(loja);
			}
			return lojas;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	//excluir loja por codigo
	public void excluirLoja(Connection conn, LojaEntidade lojaEntidade) throws SQLException {
		
		String sql = "DELETE FROM loja WHERE codigo = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, lojaEntidade.getCodigo());
		
		pstm.execute();
	}

	public boolean atualizarDadosLojaPorCodigo(Connection conn, LojaEntidade lojaAtualizado) {
		
		try {
			String sql = "UPDATE loja SET codigo = ?, nome = ?, cnpj = ?, endereco = ? WHERE codigo = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, lojaAtualizado.getNome());
			pstm.setString(2, lojaAtualizado.getCnpj());
			pstm.setString(3, lojaAtualizado.getEndereco());
			pstm.setInt(4, lojaAtualizado.getCodigo());
			
			int linhasAfetadas = pstm.executeUpdate();
			
			return linhasAfetadas > 0;
						
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
