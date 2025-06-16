package br.com.fuctura.controller;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entities.Veiculo;

public class VeiculoController {
	
	Scanner sc = new Scanner(System.in);


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
            case 5 -> deletarVeiculo();
            case 0 -> System.out.println("Retornando ao menu principal...");
            default -> System.out.println("Opção inválida.");
            
            }
         
		}while(opcao != 0);
	}
	
	
	
	public void cadastrarVeiculo() {
		
	    Scanner sc = new Scanner(System.in);
	   
	    System.out.println("############### CADASTRO DE VEÍCULO ###############");
	    
	    System.out.print("Informe a placa do veículo: ");
	    String placa = sc.nextLine();
	    System.out.print("Informe o modelo do veículo: ");
	    String modelo = sc.nextLine();
	    System.out.print("Informe o ano do veículo: ");
	    int ano = sc.nextInt();
	    sc.nextLine(); 
	    System.out.print("Informe o valor do veículo: ");
	    double valor = sc.nextDouble();
	    sc.nextLine(); 
 
	    // Criando o objeto Veiculo
	    Veiculo veiculo = new Veiculo();
	    veiculo.setPlaca(placa);
	    veiculo.setModelo(modelo);
	    veiculo.setAno(ano);
	    veiculo.setValor(valor);

	    VeiculoDAO dao = new VeiculoDAO();
	    // Salvando no banco de dados
	    dao.salvarVeiculo(veiculo);

	    System.out.println("\nVeículo cadastrado com sucesso!");
	}


	
	public void listaTodosVeiculos() {
	    VeiculoDAO dao = new VeiculoDAO();
	    List<Veiculo> lista = dao.listarTodos();  // busca todos os veículos
	    
	    System.out.println("\n### Lista de Veículos ###");
	    if (lista.isEmpty()) {
	        System.out.println("Nenhum veículo cadastrado.");
	    } else {
	        for (Veiculo v : lista) {
	            System.out.println("Placa: " + v.getPlaca());
	            System.out.println("Modelo: " + v.getModelo());
	            System.out.println("Ano: " + v.getAno());
	            System.out.println("Valor: " + v.getValor());
	            System.out.println("----------------------------");
	        }
	    }
	}

	
	
	public void buscarVeiculoPorCodigo() {
	    VeiculoDAO dao = new VeiculoDAO();
	    System.out.println("Informe o código do veículo:");
	    int codigo = sc.nextInt();
	    sc.nextLine();  // limpar buffer

	    Veiculo veiculo = dao.buscarPorId(codigo);
	    if (veiculo != null) {
	        System.out.println("Veículo encontrado:");
	        System.out.println("Placa: " + veiculo.getPlaca());
	        System.out.println("Modelo: " + veiculo.getModelo());
	        System.out.println("Ano: " + veiculo.getAno());
	        System.out.println("Valor: " + veiculo.getValor());
	    } else {
	        System.out.println("Veículo com código " + codigo + " não encontrado.");
	    }
	}


	
	public void atualizarVeiculo() {
		
	    VeiculoDAO dao = new VeiculoDAO();
	    
	    System.out.println("############### CADASTRO DE LOJA ###############");
	    
	    System.out.println("Informe o código do veículo para atualizar:");
	    int codigo = sc.nextInt();
	    sc.nextLine();  // limpar buffer
	    
	    Veiculo veiculo = dao.buscarPorId(codigo);
	    
	    if (veiculo == null) {
	        System.out.println("Veículo com código " + codigo + " não encontrado.");
	        return;
	    }
	    
	    System.out.println("Informe a nova placa do veículo (atual: " + veiculo.getPlaca() + "):");
	    String placa = sc.nextLine();
	    
	    System.out.println("Informe o novo modelo do veículo (atual: " + veiculo.getModelo() + "):");
	    String modelo = sc.nextLine();
	    
	    System.out.println("Informe o novo ano do veículo (atual: " + veiculo.getAno() + "):");
	    int ano = sc.nextInt();
	    sc.nextLine();  // limpar buffer
	    
	    System.out.println("Informe o novo valor do veículo (atual: " + veiculo.getValor() + "):");
	    double valor = sc.nextDouble();
	    sc.nextLine();  // limpar buffer
	    
	    // Atualiza os dados no objeto
	    veiculo.setPlaca(placa);
	    veiculo.setModelo(modelo);
	    veiculo.setAno(ano);
	    veiculo.setValor(valor);
	    
	    // Persiste a atualização
	    dao.atualizar(veiculo);
	    
	    System.out.println("Veículo atualizado com sucesso!");
	}


	
	public void deletarVeiculo() {
	    VeiculoDAO dao = new VeiculoDAO();

	    System.out.println("Informe o código do veículo para deletar:");
	    int codigo = sc.nextInt();
	    sc.nextLine(); // limpar buffer

	    Veiculo veiculo = dao.buscarPorId(codigo);

	    if (veiculo == null) {
	        System.out.println("Veículo com código " + codigo + " não encontrado.");
	        return;
	    }

	    dao.deletarVeiculo(codigo);
	    System.out.println("Veículo deletado com sucesso!");
	}

	
}
