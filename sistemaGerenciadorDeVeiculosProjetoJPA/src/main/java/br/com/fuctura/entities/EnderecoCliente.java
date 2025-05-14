package br.com.fuctura.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco_cliente")
public class EnderecoCliente {
	
	private Integer codigo_cliente;
	private Integer codigo_endereco;
	
	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	public Integer getCodigo_endereco() {
		return codigo_endereco;
	}
	public void setCodigo_endereco(Integer codigo_endereco) {
		this.codigo_endereco = codigo_endereco;
	}

}
