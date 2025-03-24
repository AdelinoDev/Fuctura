package concessionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAdministracao {
	
public void administracaoDeCadastro() {
		
		Scanner sc = new Scanner(System.in);
		
		Veiculo veiculo = new Veiculo();
		Vendedor vendedor = new Vendedor();
		Loja loja = new Loja();
		Cliente cliente = new Cliente();
		
		List<Veiculo> listaVeiculos = new ArrayList<>();
		List<Vendedor> listaVendedores = new ArrayList<>();
		List<Cliente> listaClientes = new ArrayList<>();

		
		int opcao;
		
		do {

			System.out.println("######## MENU ADMINISTRAÇÃO DE CADASTRO #########");
			System.out.println("1. Gerenciar Veículo.");
			System.out.println("2. Gerenciar Loja.");
			System.out.println("3. Gerenciar Vendedor.");
			System.out.println("4. Gerenciar Cliente.");
			System.out.println("5. Voltar para Menu anterior.");
			
			System.out.println("Informe a opção desejada: ");
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1 -> {
					int opcao1;
					
					do {
						System.out.println("\n######## GERENCIAR VEÍCULO #########");
	                    System.out.println("1. Cadastrar Veiculo.");
	                    System.out.println("2. Excluir Veiculo.");
	                    System.out.println("3. Alterar dados do Veiculo.");
	                    System.out.println("4. Voltar para Menu anterior.");
	                    
	                    System.out.print("Informe a opção desejada: ");
	                    opcao1 = sc.nextInt();
	                    
	                    switch(opcao1) {
	                    	case 1 -> veiculo.cadastrarVeiculo();
	                    	case 2 -> veiculo.excluirVeiculo();
	                    	case 3 -> veiculo.atualizarVeiculo();
	                    	case 4 -> System.out.println("Voltar para Menu anterior.");
	                    	default -> System.out.println("Opção Invalida!");
	                    }
	                    
					} while(opcao1 != 4);
				}
				
				case 2 -> {
					int opcao2;
						
					do {
						System.out.println("\n######## GERENCIAR LOJA #########");
	                    System.out.println("1. Alterar dados da Loja.");
	                    System.out.println("2. Voltar para Menu anterior.");
	                    
	                    System.out.print("Informe a opção desejada: ");
	                    opcao2 = sc.nextInt();
	                    
	                    switch(opcao2) {
	                    	case 1 -> loja.atualizarLoja();
	                    	case 2 -> System.out.println("Voltar para Menu anterior.");
	                    	default -> System.out.println("Opção Invalida!");
	                    }
	                    
					} while(opcao2 != 2);
				}
				
				case 3 -> {
					int opcao3;
					
					do {
						System.out.println("\n######## GERENCIAR VENDEDOR #########");
	                    System.out.println("1. Cadastrar Vendedor.");
	                    System.out.println("2. Excluir Vendedor.");
	                    System.out.println("3. Alterar Dados do Vendedor.");
	                    System.out.println("4. Voltar para Menu anterior");
	                    
	                    System.out.print("Informe a opção desejada: ");
	                    opcao3 = sc.nextInt();
	                    
	                    switch(opcao3) {
	                    	case 1 -> vendedor.cadastrarVendedor();
	                    	case 2 -> vendedor.excluirVendedor();
	                    	case 3 -> vendedor.atualizarPorNome();
	                    	case 4 -> System.out.println("Voltar para Menu anterior.");
	                    	default -> System.out.println("Opção Invalida!");
	                    }
					} while(opcao3 != 4);
				}
				
				case 4 -> {
					int opcao4;
					
					do {
						System.out.println("\n######## GERENCIAR CLIENTE #########");
	                    System.out.println("1. Cadastrar Cliente.");
	                    System.out.println("2. Excluir Cliente.");
	                    System.out.println("3. Alterar Dados do Cliente.");
	                    System.out.println("4. Voltar para Menu anterior");
	                    
	                    System.out.print("Informe a opção desejada: ");
	                    opcao4 = sc.nextInt();
	                    
	                    switch(opcao4) {
	                    	case 1 -> cliente.cadastrarCliente();
	                    	case 2 -> cliente.excluirCliente();
	                    	case 3 -> cliente.atualizarCliente();
	                    	case 4 -> System.out.println("Voltar para Menu anterior");
	                    	default -> System.out.println("OPção Inválida!");
	                    }
	                    
					} while(opcao4 != 4);
				}
				
				case 5 -> {
				    System.out.println("Voltando para o menu anterior...");
				}
			}
		
		} while(opcao != 5);
	}

}
