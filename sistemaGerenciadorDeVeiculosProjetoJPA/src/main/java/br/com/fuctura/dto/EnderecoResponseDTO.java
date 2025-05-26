package br.com.fuctura.dto;

import br.com.fuctura.entities.Cliente;
import br.com.fuctura.entities.Loja;

public class EnderecoResponseDTO {

	private Integer codigo;
	private String cep;
	private String logradouro;
	private String complemento;
	private String numero;
	private Loja loja;
	private Cliente cliente;
	
	
	public EnderecoResponseDTO() {}

	public EnderecoResponseDTO(Integer codigo, String cep, String logradouro, String complemento, 
			String numero, Loja loja, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.cep = cep;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.loja = loja;
		this.cliente = cliente;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
