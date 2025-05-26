package br.com.fuctura.dto;

import br.com.fuctura.entities.Loja;
import br.com.fuctura.entities.Tipo;
import br.com.fuctura.entities.Venda;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class VeiculoRequestDTO {

	private String placa;
	private String modelo;
	private Integer ano;
	private Double valor;
	private Loja loja;
	private Tipo tipo;
	private Venda venda;
	
	public VeiculoRequestDTO() {}

	public VeiculoRequestDTO(String placa, String modelo, Integer ano, Double valor, 
			Loja loja, Tipo tipo, Venda venda) {
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.loja = loja;
		this.tipo = tipo;
		this.venda = venda;
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

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
