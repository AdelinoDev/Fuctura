package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.fuctura.dao.ClienteDAO;
import br.com.fuctura.entidade.ClienteEntidade;

public class Aula4TesteDAO {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/concessionaria";
		String user = "postgres";
		String password = "14011982";
		
		try {
					
			Connection conn = DriverManager.getConnection(url, user, password);
			
			ClienteDAO clienteDAO = new ClienteDAO();
			
			ClienteEntidade entidade = new ClienteEntidade();
			entidade.setNome("Adelino");
			entidade.setCpf("0945054979");
			
			clienteDAO.inserir(conn, entidade);
			
			
			List<ClienteEntidade> lista = clienteDAO.consultarTodos(conn);
			for(ClienteEntidade e: lista) {
				System.out.println("Codigo: " + e.getCodigo());
				System.out.println("Nome: " + e.getNome());
				System.out.println("CPF: " + e.getCpf());
				System.out.println("Celular: " + e.getCelular());
				System.out.println("Email: " + e.getEmail());
				System.out.println("--------------------------------");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
