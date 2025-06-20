package br.com.fuctura.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loja")
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String nome;
	private String endereco;
	private String cnpj;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "codigo")
    private Endereco end;

    @OneToMany(mappedBy = "loja", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Veiculo> veiculos;

    @OneToMany(mappedBy = "loja", cascade = CascadeType.ALL)
    private List<Venda> vendas;
		
	
	public Loja() {
	}

	public Loja(Integer codigo, String nome, String endereco, String cnpj, List<Veiculo> veiculos, List<Venda> vendas,
			Endereco end) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.veiculos = veiculos;
		this.vendas = vendas;
		this.end = end;
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

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<Venda> getVenda() {
		return vendas;
	}

	public void setVenda(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	
	
	

}
