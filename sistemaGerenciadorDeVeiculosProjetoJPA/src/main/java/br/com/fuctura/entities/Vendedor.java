package br.com.fuctura.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vendedor")
public class Vendedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String nome;
	private String cpf;
	private String celular;
	private String email;
	
	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<Venda> vendas;
	
	public Vendedor() {}

	public Vendedor(Integer codigo, String nome, String cpf, String celular, String email, List<Venda> vendas) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.vendas = vendas;
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

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

}
