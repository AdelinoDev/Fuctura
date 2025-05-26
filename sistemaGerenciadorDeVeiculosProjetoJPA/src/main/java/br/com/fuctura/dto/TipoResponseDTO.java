package br.com.fuctura.dto;

import br.com.fuctura.entities.Veiculo;

public class TipoResponseDTO {

	private Integer codigo;
	private String descricao;
	private Veiculo veiculo;
	
	public TipoResponseDTO() {}

	public TipoResponseDTO(Integer codigo, String descricao, Veiculo veiculo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.veiculo = veiculo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
