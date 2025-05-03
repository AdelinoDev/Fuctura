package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Aula4 {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/concessionaria";
		String user = "postgres";
		String password = "14011982";
		
		//BUSCAR
		try {
			
			Connection conn = DriverManager.getConnection(url, user, password);

			String comandoSQL = "SELECT * FROM cliente";
			
			PreparedStatement pstm = conn.prepareStatement(comandoSQL);
			
			ResultSet resultadoConsulta = pstm.executeQuery();
			
			while(resultadoConsulta.next()) {
				
				int codigo = resultadoConsulta.getInt("codigo");
				String nome = resultadoConsulta.getString("nome");
				String cpf = resultadoConsulta.getString("cpf");
				
				System.out.println("Codigo: " + codigo);
				System.out.println("Nome: " + nome);
				System.out.println("CPF: " + cpf);
				System.out.println("-------------------------");
			
			}
					
		} catch(SQLException e) {
				e.printStackTrace();
		}
		finally {
			
		}
		
		
		
		
		
	}

}
