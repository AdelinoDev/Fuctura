package br.com.fuctura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.ClienteEntidade;
import br.com.fuctura.entidade.EnderecoEntidade;

public class ClienteDAO {
	
	public void inserirClienteEndereco(Connection conn, ClienteEntidade clienteEntidade, 
			EnderecoEntidade enderecoEntidade) throws SQLException{
	
		String sqlCliente = "INSERT INTO cliente (nome, cpf, celular, email) values (?, ?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, clienteEntidade.getNome());
		pstm.setString(2, clienteEntidade.getCpf());
		pstm.setString(3, clienteEntidade.getCelular());
		pstm.setString(4, clienteEntidade.getEmail());
		
		int affectedRows = pstm.executeUpdate();
		
		Integer codigoCliente = null;
		
		if(affectedRows > 0) {
			ResultSet rs = pstm.getGeneratedKeys();
			if(rs.next()) {
				codigoCliente = rs.getInt(1);
				 System.out.println("Cliente inserido com sucesso! Código gerado: " + codigoCliente);
			
			} else {
                System.out.println("Nenhuma linha foi inserida.");
            }
		}
		
		pstm.close();
		
		// Endereço -> Insere endereço apenas se o cliente foi inserido com sucesso
		if(codigoCliente != null) {
			
			String sqlEndereco = "INSERT INTO endereco (cliente_id, cep, logradouro, complemento, numero) "
	        		+ "VALUES (?, ?, ?, ?, ?)";
	        
	        PreparedStatement pstm2 = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
	        pstm2.setInt(1, codigoCliente);  
	        pstm2.setString(2, enderecoEntidade.getCep());
	        pstm2.setString(3, enderecoEntidade.getLogradouro());
	        pstm2.setString(4, enderecoEntidade.getComplemento());
	        pstm2.setInt(5, enderecoEntidade.getNumero());
	        
	        int linhasAfetadas = pstm2.executeUpdate();

	        if (linhasAfetadas > 0) {
	            ResultSet rs = pstm2.getGeneratedKeys();
	            if (rs.next()) {
	                int codigoEndereco = rs.getInt(1);
	                enderecoEntidade.setCodigo(codigoEndereco);
	            }
	        }
	        
	        pstm2.close();
		}
	
	}
	
	
	
	//cadastrar cliente
	public void inserir(Connection conn, ClienteEntidade clienteEntidade) throws SQLException {
		
		String sql = "INSERT INTO cliente (nome, cpf, celular, email) values (?, ?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		pstm.setString(1, clienteEntidade.getNome());
		pstm.setString(2, clienteEntidade.getCpf());
		pstm.setString(3, clienteEntidade.getCelular());
		pstm.setString(4, clienteEntidade.getEmail());
		
		int affectedRows = pstm.executeUpdate();
		
		Integer codigoCliente = null;
		
		if(affectedRows > 0) {
			ResultSet rs = pstm.getGeneratedKeys();
			if(rs.next()) {
				codigoCliente = rs.getInt(1);
				 System.out.println("Cliente inserido com sucesso! Código gerado: " + codigoCliente);
			
			} else {
                System.out.println("Nenhuma linha foi inserida.");
            }
		}
		
	}
		
	//consultar todos os clientes
	public List<ClienteEntidade> consultarTodos(Connection conn) {

	    try {
	    	 String comandoSQL = "SELECT * FROM cliente";

	        PreparedStatement pstm = conn.prepareStatement(comandoSQL);

	        ResultSet resultadoConsulta = pstm.executeQuery();

	        List<ClienteEntidade> clientes = new ArrayList<>();

	        while (resultadoConsulta.next()) {

	            // Dados do cliente
	            int codigo = resultadoConsulta.getInt("codigo");
	            String nome = resultadoConsulta.getString("nome");
	            String cpf = resultadoConsulta.getString("cpf");
	            String celular = resultadoConsulta.getString("celular");
	            String email = resultadoConsulta.getString("email");
	            
	            // Cria instâncias
	            ClienteEntidade c = new ClienteEntidade();
	            c.setCodigo(codigo);
	            c.setNome(nome);
	            c.setCpf(cpf);
	            c.setCelular(celular);
	            c.setEmail(email);
	            
	            // Adiciona na lista
	            clientes.add(c);
	            
	        }

	        return clientes;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	
	//consultar todos os clientes por CPF
	public List<ClienteEntidade> consultarPorCpf(Connection conn, String cpfBusca) {
	    
	    try {
	        String comandoSQL = "SELECT * FROM cliente WHERE cpf = ?";
	        
	        PreparedStatement pstm = conn.prepareStatement(comandoSQL);
	        pstm.setString(1, cpfBusca);
	        
	        ResultSet resultadoConsulta = pstm.executeQuery();
	        
	        List<ClienteEntidade> clientes = new ArrayList<>();
	        
	        while (resultadoConsulta.next()) {
	            int codigo = resultadoConsulta.getInt("codigo");
	            String nome = resultadoConsulta.getString("nome");
	            String cpf = resultadoConsulta.getString("cpf");
	            String celular = resultadoConsulta.getString("celular");
				String email = resultadoConsulta.getString("email");
	            
	            ClienteEntidade c = new ClienteEntidade();
	            c.setCodigo(codigo);
	            c.setNome(nome);
	            c.setCpf(cpf);
	            c.setCelular(celular);
	            c.setEmail(email);
	            
	            clientes.add(c);
	       
	        }
	        
	        return clientes;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	
	//excluir clientes por CPF
	public void excluir(Connection conn, ClienteEntidade clienteEntidade) throws SQLException{
		
		String comandoSQLExcluirCliente = "DELETE FROM cliente WHERE cpf = ?";
		
		PreparedStatement pstm = conn.prepareStatement(comandoSQLExcluirCliente);
			
		pstm.setString(1, clienteEntidade.getCpf());
		
		pstm.execute();
		
	}
	
	//atualizar cliente por cpf
	public boolean atualizarClientePorCpf(Connection conn, ClienteEntidade clienteAtualizado) {
	    
	    try {
	        String sql = "UPDATE cliente SET nome = ?, cpf = ?, celular = ?, email = ? WHERE cpf = ?";
	        
	        PreparedStatement pstm = conn.prepareStatement(sql);
	        
	        pstm.setString(1, clienteAtualizado.getNome());
	        pstm.setString(2, clienteAtualizado.getCpf());
	        pstm.setString(3, clienteAtualizado.getCelular());
	        pstm.setString(4, clienteAtualizado.getEmail());
	        pstm.setString(5, clienteAtualizado.getCpf()); // CPF de referência (antigo)
	        
	        int linhasAfetadas = pstm.executeUpdate();
	        
	        return linhasAfetadas > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}


}
