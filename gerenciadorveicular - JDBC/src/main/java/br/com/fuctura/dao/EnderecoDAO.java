package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import br.com.fuctura.entidade.EnderecoEntidade;
import br.com.fuctura.entidade.VeiculoEntidade;

public class EnderecoDAO {

	// inserir endereço
    public void inserirEndereco(Connection conn, EnderecoEntidade endereco) throws SQLException {
        String sql = "INSERT INTO endereco (codigo_cliente, cep, logradouro, complemento, numero) "
        		+ "VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pstm.setInt(1, endereco.getCodigo_cliente());
        pstm.setString(2, endereco.getCep());
        pstm.setString(3, endereco.getLogradouro());
        pstm.setString(4, endereco.getComplemento());
        pstm.setInt(5, endereco.getNumero());
        
        int linhasAfetadas = pstm.executeUpdate();

        if (linhasAfetadas > 0) {
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                int codigoEndereco = rs.getInt(1);
                endereco.setCodigo(codigoEndereco);
            }
        }
        
        pstm.close(); // Sempre bom fechar recursos
    }
    
    // consultar todos os endereços
    public List<EnderecoEntidade> consultarTodosEndereco(Connection conn) {
    	
    	try {
    		String sql = "SELECT * FROM endereco";
    		
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		ResultSet rs = pstm.executeQuery();
    		
    		List<EnderecoEntidade> enderecos = new ArrayList<>();
 
    		while(rs.next()) {
    			int codigo = rs.getInt("codigo");
    			int codigo_cliente = rs.getInt("codigo_cliente");
    			String cep = rs.getString("cep");
    			String logradouro = rs.getString("logradouro");
    			String complemento = rs.getString("complemento");
    			int numero = rs.getInt("numero");
    			
    			EnderecoEntidade endereco = new EnderecoEntidade();
    			endereco.setCodigo(codigo);
    			endereco.setCodigo_cliente(codigo_cliente);
    			endereco.setCep(cep);
    			endereco.setLogradouro(logradouro);
    			endereco.setComplemento(complemento);
    			endereco.setNumero(numero);
    			
    			enderecos.add(endereco);		
    		}
    		return enderecos;
    				
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    	
    	return null;
    }
 
    // consultar endereço por CODIGO
    public List<EnderecoEntidade> consultarEnderecoID(Connection conn, int codigoBusca) {
    	
    	try {
    		String sql = "SELECT * FROM endereco WHERE codigo = ?";
    		
    		PreparedStatement pstm = conn.prepareStatement(sql);
    		pstm.setInt(1, codigoBusca);
    		
    		ResultSet rs = pstm.executeQuery();
    		
    		List<EnderecoEntidade> enderecos = new ArrayList<>();
    		
    		while(rs.next()) {
    			int codigo = rs.getInt("codigo");
    			int codigo_cliente = rs.getInt("codigo_cliente");
    			String cep = rs.getString("cep");
    			String logradouro = rs.getString("logradouro");
    			String complemento = rs.getString("complemento");
    			int numero = rs.getInt("numero");
    			
    			EnderecoEntidade e = new EnderecoEntidade();
    			e.setCodigo(codigo);
    			e.setCodigo_cliente(codigo_cliente);
    			e.setCep(cep);
    			e.setLogradouro(logradouro);
    			e.setComplemento(complemento);
    			e.setNumero(numero);
    			
    			enderecos.add(e);
    		}
    		return enderecos;
    		
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    }

    //excluir endereço por CODIGO
    public void excluirEndereco(Connection conn, EnderecoEntidade enderecoEntidade) throws SQLException{
		
		String sql = "DELETE FROM endereco WHERE codigo = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, enderecoEntidade.getCodigo());
		
		pstm.execute();		
		
	}

    //atualizar dados endereço 
    public boolean atualizarDadosEndereco(Connection conn, EnderecoEntidade enderecoEntidade) {
	    String sql = "UPDATE endereco SET cep = ?, logradouro = ?, complemento = ?, numero = ? WHERE codigo = ?";

	    try {
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        pstm.setString(1, enderecoEntidade.getCep());
	        pstm.setString(2, enderecoEntidade.getLogradouro());
	        pstm.setString(3, enderecoEntidade.getComplemento());
	        pstm.setInt(4, enderecoEntidade.getNumero());

	        int linhasAfetadas = pstm.executeUpdate();

	        return linhasAfetadas > 0; // Retorna true se atualizou com sucesso

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return false;
	}
}

