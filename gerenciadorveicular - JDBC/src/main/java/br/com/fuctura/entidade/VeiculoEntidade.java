package br.com.fuctura.entidade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class VeiculoEntidade {
	
	private int codigo;
	
	private String placa;
	private String modelo;
	private int ano;
	private double valor;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

	public static void cadastrarVeiculo() {
		
		String url = "jdbc:postgresql://localhost:5432/ concessionaria";
		String user = "postgres";
		String password = "1401982";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Sistema conectado com sucesso!");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Informe a placa do veiculo: ");
			String placa = sc.nextLine();
			System.out.print("Informe o modelo do veiculo: ");
			String modelo = sc.nextLine();
			System.out.print("Informe o ano do veiculo: ");
			int ano = sc.nextInt();
			System.out.print("Informe o valor do veiculo: ");
			double valor = sc.nextDouble();
			
			String sql = "insert into veiculo (placa, modelo, ano,valor) values (?, ?, ?, ?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, placa);
			pstm.setString(2, modelo);
			pstm.setInt(3, ano);
			pstm.setDouble(4, valor);
			
			pstm.executeUpdate();
			
			System.out.println("Cadastro do veiculo realizado com sucesso!");
			
			pstm.close();
			conn.close();
			//sc.close();
					
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			
		}
		
		System.out.println("Sistema encerrado com sucesso!");
		
	}
	
	
	
}
