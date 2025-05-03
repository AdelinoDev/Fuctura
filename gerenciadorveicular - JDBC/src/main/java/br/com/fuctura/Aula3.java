package br.com.fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aula3 {

	public static void main(String[] args) {
		
		//inserir cliente
		//inserir endereco
		
		String url = "jdbc:postgresql://localhost:5432/concessionaria";
		String user = "postgres";
		String password = "14011982";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado com sucesso!");
			
			Scanner sc = new Scanner(System.in);
			
			//inserir cliente
			String comandoSQLInserirCliente = "INSERT INTO cliente (nome, cpf) values (?, ?)";
			
			PreparedStatement pstm = conn.prepareStatement(comandoSQLInserirCliente, Statement.RETURN_GENERATED_KEYS);
			
			//Scanner
			sc.nextLine(); // limpar o buffer antes de nextLine()
			System.out.print("Informe o nome do cliente: ");
			String nome = sc.nextLine();
			System.out.print("Infome o cpf do cliente: ");
			String cpf = sc.next();
			
			pstm.setString(1, nome);
			pstm.setString(2, cpf);
			
			int affectedRows = pstm.executeUpdate();
			
			Integer codigoCliente = null;
			
			if(affectedRows > 0) {
				ResultSet rs = pstm.getGeneratedKeys();
				if(rs.next()) {
					codigoCliente = rs.getInt(1);
				}
			}
			
			System.out.println("Cliente cadastrado com sucesso! ID: " + codigoCliente);
			
			String comandoSQLInserirEndereco = "INSERT INTO endereco (cliente_id, logradouro) values (?, ?)";
			
			//scanner
			System.out.print("Informe o endereço: ");
			String logradouro = sc.next();
			
			PreparedStatement pstmEndereco = conn.prepareStatement(comandoSQLInserirEndereco, Statement.RETURN_GENERATED_KEYS);
			
			pstmEndereco.setInt(1, codigoCliente);
			pstmEndereco.setString(2, logradouro);
			
			pstmEndereco.executeUpdate();
			
			Integer codigoEndereco = null;
			
			if(affectedRows > 0) {
				ResultSet rs = pstmEndereco.getGeneratedKeys();
				if(rs.next()) {
					codigoEndereco = rs.getInt(1);
				}
			}
			
			
			// INSERIR NA TABELA CLIENTE ENDEREÇO(CODIGO_CLIENTE, CODIGO_ENDERECO)
			String comandoInserirCliente = "insert into enderco_cliente(endereco_id, cliente_id) values(?, ?)";
			
			PreparedStatement pstmEnderecoCliente = conn.prepareStatement(comandoInserirCliente);
			
			pstmEnderecoCliente.setInt(1, codigoEndereco);
			pstmEnderecoCliente.setInt(2, codigoCliente);
			
			pstmEnderecoCliente.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		
		
		
		
	}

}
