package br.com.fuctura.dto;

public class LojaRequestDTO {
	
	private String nome;
	private String endereco;
	private String cnpj;
	
	public LojaRequestDTO() {}

	public LojaRequestDTO(String nome, String endereco, String cnpj) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "LojaRequestDTO [nome=" + nome + ", endereco=" + endereco + ", cnpj=" + cnpj + "]";
	}

	
}
