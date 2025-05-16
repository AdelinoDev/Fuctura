package br.com.fuctura.dto;

public class VeiculoRequestDTO {
	
	private String placa;
	private String modelo;
	private Integer ano;
	private Double valor;
	
	public VeiculoRequestDTO() {
	}

	public VeiculoRequestDTO(String placa, String modelo, Integer ano, Double valor) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
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

	@Override
	public String toString() {
		return "VeiculoRequestDTO [placa=" + placa 
				+ ", modelo=" + modelo 
				+ ", ano=" + ano 
				+ ", valor=" + valor + "]";
	}
	
	
	
	

}
