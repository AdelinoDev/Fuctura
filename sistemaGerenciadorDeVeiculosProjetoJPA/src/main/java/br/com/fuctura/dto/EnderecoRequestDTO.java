package br.com.fuctura.dto;

import br.com.fuctura.entities.Cliente;
import br.com.fuctura.entities.Loja;

public class EnderecoRequestDTO {

	private String cep;
	private String logradouro;
	private String complemento;
	private String numero;
	private Loja loja;
	private Cliente cliente;
	
	
	public EnderecoRequestDTO() {}

	public EnderecoRequestDTO(String cep, String logradouro, String complemento, 
			String numero, Loja loja, Cliente cliente) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.loja = loja;
		this.cliente = cliente;
	}

	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
