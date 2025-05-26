package br.com.fuctura.dto;

import br.com.fuctura.entities.Venda;
import jakarta.persistence.OneToMany;

public class VendedorRequestDTO {
	
	private String nome;
	private String cpf;
	private String celular;
	private String email;
	private Venda venda;
	
	public VendedorRequestDTO() {}

	public VendedorRequestDTO(String nome, String cpf, String celular, String email, Venda venda) {
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.venda = venda;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	} 
	
	
	
}
