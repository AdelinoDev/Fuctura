package br.com.fuctura.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String placa;
	private String modelo;
	private Integer ano;
	private Double valor;
	
	@ManyToOne
    @JoinColumn(name = "loja_id")
    private Loja loja;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    @OneToMany(mappedBy = "veiculo")
    private List<Venda> vendas;
	
	
	public Veiculo() {
	}

	public Veiculo(Integer codigo, String placa, String modelo, Integer ano, 
			Double valor, Loja loja, Tipo tipo, List<Venda> vendas) {
		this.codigo = codigo;
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.loja = loja;
		this.tipo = tipo;
		this.vendas = vendas;
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
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

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
}



