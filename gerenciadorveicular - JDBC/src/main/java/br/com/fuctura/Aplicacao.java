package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fuctura.entidade.VeiculoEntidade;

public class Aplicacao {
	public static void main(String[] args) {
		

		String url = "jdbc:postgresql://localhost:5432/concessionaria";
		String user = "postgres";
		String password = "14011982";
			
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado com sucesso!");
			
			Scanner sc = new Scanner(System.in);
			
			//cadastrar veiculo
			System.out.println("Placa: ");
			String placa = sc.nextLine();
			System.out.println("Modelo: ");
			String modelo = sc.nextLine();
			System.out.println("Ano: ");
			int ano= sc.nextInt();
			System.out.println("Valor: ");
			double valor = sc.nextDouble();	
			
			String comandoSQL = "INSERT INTO veiculo (placa, modelo, ano, valor) values (?, ?, ?, ?)";
			
			PreparedStatement pstm = conn.prepareStatement(comandoSQL);
			
			pstm.setString(1, placa);
			pstm.setString(2, modelo);
			pstm.setInt(3, ano);
			pstm.setDouble(4, valor);
			
			pstm.execute();
			
			System.out.println("Registro cadastrado com sucesso!");
			
			//liberar recursos
			pstm.close();
			conn.close();
			sc.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		System.out.println("Aplicação encerrada!");
		
		
		
	}
}
