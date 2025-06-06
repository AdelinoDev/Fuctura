package br.com.fuctura.dto;

import br.com.fuctura.entities.Endereco;
import br.com.fuctura.entities.Venda;

public class ClienteResponseDTO {
	
	private Integer codigo;
	private String nome;
	private String cpf;
	private String celular;
	private String email;
	private Venda venda;
	private Endereco endereco;
	
	public ClienteResponseDTO( ) {}

	public ClienteResponseDTO(Integer codigo, String nome, String cpf, String celular, 
			String email, Venda venda, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.venda = venda;
		this.endereco = endereco;
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
