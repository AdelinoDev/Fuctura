package br.com.fuctura.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer codigo;
	private Double valor;
	
	@OneToOne(mappedBy = "venda")
	private Loja loja;
	
	@OneToOne(mappedBy = "venda")
	private Vendedor vendedor;
	
	@OneToOne(mappedBy = "venda")
	private Cliente cliente;

	@OneToOne(mappedBy = "venda")
	private Veiculo veiculo;
	
	public Venda() {}

	public Venda(Integer codigo, Double valor, Loja loja, Vendedor vendedor, 
			Cliente cliente, Veiculo veiculo) {
		this.codigo = codigo;
		this.valor = valor;
		this.loja = loja;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
