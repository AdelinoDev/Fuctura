package br.com.fuctura.dto;

import br.com.fuctura.entities.Veiculo;

public class TipoResquestDTO {

	private String descricao;
	private Veiculo veiculo;
	
	public TipoResquestDTO() {}

	public TipoResquestDTO(String descricao, Veiculo veiculo) {
		this.descricao = descricao;
		this.veiculo = veiculo;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
}
