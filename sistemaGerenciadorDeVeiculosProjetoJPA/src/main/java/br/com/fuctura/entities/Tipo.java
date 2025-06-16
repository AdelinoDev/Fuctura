package br.com.fuctura.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo")
public class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	private String descricao;
	
	@OneToMany(mappedBy = "tipo")
    private List<Veiculo> veiculos;
	
	public Tipo() {}
	
	public Tipo(Integer codigo, String descricao, List<Veiculo> veiculos) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.veiculos = veiculos;
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

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
