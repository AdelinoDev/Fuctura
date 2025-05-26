package br.com.fuctura.controller;

import java.util.Scanner;

import br.com.fuctura.dto.VeiculoRequestDTO;
import br.com.fuctura.dto.VeiculoResponseDTO;
import br.com.fuctura.service.VeiculoService;

public class VeiculoController {
	
	private VeiculoService service;
	
	Scanner sc = new Scanner(System.in);

	public VeiculoController(VeiculoService service) {
		this.service = service;
	}



	public void menuVeiculo() {
		int opcao = 0;
		
		do {
			System.out.println("\n#### GERENCIAMENTO DE VEÍCULOS ####");
            System.out.println("1 -> CADASTRAR VEICULOS");
            System.out.println("2 -> LISTAR TODOS OS VEICULOS");
            System.out.println("3 -> BUSCAR VEICULO POR PLACA");
            System.out.println("4 -> ATUALIZAR DADOS DO VEICULO");
            System.out.println("5 -> REMOVER VEICULO");
            System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            
            case 1 -> cadastrarVeiculo();
            case 2 -> listaTodosVeiculos();
            case 3 -> buscarVeiculoPorCodigo();
            case 4 -> atualizarVeiculo();
            case 5 -> removerVeiculo();
            case 0 -> System.out.println("Retornando ao menu principal...");
            default -> System.out.println("Opção inválida.");
            
            }
         
		}while(opcao != 0);
	}
	
	
	
	public void cadastrarVeiculo() {
		
		VeiculoRequestDTO dto = new VeiculoRequestDTO();
		
		System.out.println("Informe a placa do veículo: ");
		dto.setPlaca(sc.nextLine());
		System.out.println("Informe o modelo do veículo: ");
		dto.setModelo(sc.nextLine());
		System.out.println("Informe o ano do veículo: ");
		dto.setAno(sc.nextInt());
		sc.nextLine();
		System.out.println("Informe o valor do veículo: ");
		dto.setValor(sc.nextDouble());
		sc.nextLine();
		
		service.criarVeiculo(dto);
		
	}

	
	public void listaTodosVeiculos() {
		
		var lista = service.listarTodosVeiculos();
		
		System.out.println("\n### Lista de Veículos ###");
        for (VeiculoResponseDTO v : lista) {
            System.out.println("Código: " + v.getCodigo());
            System.out.println("Placa: " + v.getPlaca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Ano: " + v.getAno());
            System.out.println("Valor: " + v.getValor());
            System.out.println("----------------------------");
        }
	}
	
	
	public void buscarVeiculoPorCodigo() {
    
	    System.out.print("Informe o codigo do veículo: ");
	    int codigo = sc.nextInt();	    
	    sc.nextLine(); // Consome a quebra de linha pendente após nextInt()

	    VeiculoResponseDTO v = service.buscarVeiculoPorCodigo(codigo);

	    if (v != null) {
	        System.out.println("Código: " + v.getCodigo());
	        System.out.println("Placa: " + v.getPlaca());
	        System.out.println("Modelo: " + v.getModelo());
	        System.out.println("Ano: " + v.getAno());
	        System.out.println("Valor: " + v.getValor());
	        System.out.println("----------------------------");
	    } else {
	        System.out.println("Veículo com o código '" + codigo + "' não encontrado.");
	    }
	}

	
	public void atualizarVeiculo() {
		
		System.out.println("Informe o código do veículo: ");
		int codigo = sc.nextInt();
		sc.nextLine();
		
		VeiculoRequestDTO dto = new VeiculoRequestDTO();
		
		System.out.println("Informe a nova placa do veículo: ");
		dto.setPlaca(sc.nextLine());
		System.out.println("Informe o novo modelo do veículo: ");
		dto.setModelo(sc.nextLine());
		System.out.println("Informe o novo ano do veículo: ");
		dto.setAno(sc.nextInt());sc.nextLine();
		System.out.println("Informe o novo valor do veículo: ");
		dto.setValor(sc.nextDouble());sc.nextLine();
		
		service.atualizar(codigo, dto);
	}

	
	public void removerVeiculo() {
		
		System.out.println("Informe o código do veículo para ser removido: ");
		int codigo = sc.nextInt();
		sc.nextLine();
	}
	
}
