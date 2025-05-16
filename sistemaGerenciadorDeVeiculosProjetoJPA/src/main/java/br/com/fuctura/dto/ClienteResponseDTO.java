package br.com.fuctura.dto;

public class ClienteResponseDTO {

	private Integer codigo;
	
	private String nome;
	private String cpf;
	private String celular;
	private String email;
	
	public ClienteResponseDTO() {}

	public ClienteResponseDTO(Integer codigo, String nome, String cpf, String celular, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
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

	@Override
	public String toString() {
		return "ClienteResponseDTO [codigo=" + codigo + ""
				+ ", nome=" + nome + ""
				+ ", cpf=" + cpf + ""
				+ ", celular=" + celular
				+ ", email=" + email + "]";
	}
	
	
}
