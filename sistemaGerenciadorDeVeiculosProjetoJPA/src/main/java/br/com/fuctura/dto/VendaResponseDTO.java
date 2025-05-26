package br.com.fuctura.dto;

import br.com.fuctura.entities.Cliente;
import br.com.fuctura.entities.Loja;
import br.com.fuctura.entities.Veiculo;
import br.com.fuctura.entities.Vendedor;

public class VendaResponseDTO {

	private Integer codigo;
	private Double valor;
	private Loja loja;
	private Vendedor vendedor;
	private Cliente cliente;
	private Veiculo veiculo;

	public VendaResponseDTO() {
	}

	public VendaResponseDTO(Integer codigo, Double valor, Loja loja, Vendedor vendedor, Cliente cliente,
			Veiculo veiculo) {
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
