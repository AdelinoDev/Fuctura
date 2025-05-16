package br.com.fuctura.dto;

public class LojaResponseDTO {
	
private Integer codigo;
	
	private String nome;
	private String endereco;
	private String cnpj;
	
	public LojaResponseDTO() {}

	public LojaResponseDTO(Integer codigo, String nome, String endereco, String cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
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
		return "LojaResponseDTO [codigo=" + codigo + ""
				+ ", nome=" + nome + ""
				+ ", endereco=" + endereco + 
				", cnpj=" + cnpj
				+ "]";
	}
	
	

}
