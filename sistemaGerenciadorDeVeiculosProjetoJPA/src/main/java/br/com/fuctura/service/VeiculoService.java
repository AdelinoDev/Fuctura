package br.com.fuctura.service;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fuctura.dto.VeiculoRequestDTO;
import br.com.fuctura.dto.VeiculoResponseDTO;
import br.com.fuctura.entities.Veiculo;
import br.com.fuctura.repository.VeiculoRepository;

public class VeiculoService {
		
	private VeiculoRepository repository;

	public VeiculoService(VeiculoRepository repository) {
		this.repository = repository;
	}
	
	//Metodo para criar um novo veidulo
	public void criarVeiculo(VeiculoRequestDTO dto) {
		
		Veiculo v = new Veiculo();
		v.setPlaca(dto.getPlaca());
		v.setModelo(dto.getModelo());
		v.setAno(dto.getAno());
		v.setValor(dto.getValor());
		
		repository.salvarVeiculo(v);
	}
	
	//Metodo para listar todos os veiculos
	public List<VeiculoResponseDTO> listarTodosVeiculos() {
		
		return  repository.listarTodos().stream()
				.map(this::toResponseDTO)
				.collect(Collectors.toList());
	}
	
	//Metodo para buscar um veiculo por ID
	public VeiculoResponseDTO buscarVeiculoPorCodigo(Integer codigo) {
		
		Veiculo v = repository.buscarPorId(codigo);
		return v != null ? toResponseDTO(v) : null;
	}
	
	//Metodo para atualizar veiculo
	public void atualizar(Integer codigo, VeiculoRequestDTO dto) {
		
		Veiculo v = repository.buscarPorId(codigo);
		
		if(v != null) {
			v.setPlaca(dto.getPlaca());
			v.setModelo(dto.getPlaca());
			v.setModelo(dto.getModelo());
			v.setAno(dto.getAno());
			v.setValor(dto.getValor());
			
			repository.atualizar(v);
		}
	}
	
	
	//Metodo para deletar
	public void deletar(Integer codigo) {
		repository.deletarVeiculo(codigo);
	}
	
	
	
	//Metodo auxiliar para converter a entidade Veiculo para VeiculoResponesDTO
	private VeiculoResponseDTO toResponseDTO (Veiculo v) {
		
		VeiculoResponseDTO dto = new VeiculoResponseDTO();
		dto.setCodigo(v.getCodigo());
		dto.setPlaca(v.getPlaca());
		dto.setModelo(v.getModelo());
		dto.setAno(v.getAno());
		dto.setValor(v.getValor());
		
		return dto;
	}

}
