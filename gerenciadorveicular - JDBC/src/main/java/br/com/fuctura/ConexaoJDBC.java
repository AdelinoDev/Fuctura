package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/agenda";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "14011982";
	
	public static Connection iniciarConexao() {
		
		try {
			Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Banco conectado com sucesso!");
			return conn;
		}
		catch (SQLException e) {
			System.out.println("Falha na conexão!");
			System.out.println(e.getMessage());
			return null;
		}
	}
	

	public static void fecharConexao(Connection conn) {
		
		try {
			if(conn != null) {
				conn.close();
				System.out.println("Conexão com o banco de dados fechado com sucesso!");
			}
		}
		catch(SQLException e) {
			System.out.println("Falha indeterminada!");
			System.out.println(e.getMessage());
		}
	}
}
