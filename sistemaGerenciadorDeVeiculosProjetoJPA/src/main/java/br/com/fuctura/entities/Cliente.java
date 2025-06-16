package br.com.fuctura.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String nome;
	private String cpf;
	private String celular;
	private String email;
	
	@OneToMany(mappedBy = "cliente")
    private List<Venda> vendas;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "endereco_id", referencedColumnName = "codigo")
	private Endereco endereco;
	
	public Cliente() {}

	public Cliente(Integer codigo, String nome, String cpf, String celular, String email, List<Venda> vendas,
			Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.email = email;
		this.vendas = vendas;
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


	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
	

}
