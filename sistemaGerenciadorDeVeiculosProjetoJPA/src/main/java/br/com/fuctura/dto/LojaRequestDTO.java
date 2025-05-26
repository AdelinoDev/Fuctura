package br.com.fuctura.dto;

import java.util.List;

import br.com.fuctura.entities.Endereco;
import br.com.fuctura.entities.Veiculo;
import br.com.fuctura.entities.Venda;

public class LojaRequestDTO {
	
	private String nome;
	private String endereco;
	private String cnpj;
	private List<Veiculo> veiculos;
	private List<Venda> venda;
	private Endereco end;
	
	public LojaRequestDTO() {}

	public LojaRequestDTO(String nome, String endereco, String cnpj, List<Veiculo> veiculos, 
			List<Venda> venda, Endereco end) {
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		this.veiculos = veiculos;
		this.venda = venda;
		this.end = end;
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
		return venda;
	}

	public void setVenda(List<Venda> venda) {
		this.venda = venda;
	}

	public Endereco getEnd() {
		return end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	
	
}
