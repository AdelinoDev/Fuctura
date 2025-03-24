package concessionaria;

import java.util.Scanner;

public class MenuFrenteLoja {
	
	public void frenteLoja() {
		Scanner sc = new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		Veiculo veiculo = new Veiculo();
		Vendedor vendedor = new Vendedor();
		
		int opcao;
		
		do {
			
			System.out.println("######## MENU FRENTE LOJA #########");
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
	                    System.out.println("1. Consultar Veículo por placa.");
	                    System.out.println("2. Voltar ao menu anterior.");
	                    System.out.print("Informe a opção desejada: ");
	                    opcao1 = sc.nextInt();
	
	                    switch (opcao1) {
	                        case 1 -> veiculo.pesquisarVeiculoPorPlaca();
	                        case 2 -> System.out.println("Voltando ao menu principal...");
	                        default -> System.out.println("Opção Inválida!");
	                    }
	                    
	                } while (opcao1 != 2);
	            }
										
				case 2 -> {
					int opcao2;
					
					do {
						
						System.out.println("######## GERENCIAR LOJA #########");
						System.out.println("1. Listar Veiculos disponiveis na Loja.");
						System.out.println("2. Listar Vendedores na Loja.");
						System.out.println("3. Voltar para Menu anterior.");
						
						System.out.print("Informe a opção desejada: ");
	                    opcao2 = sc.nextInt();
	                    
						switch (opcao2) {
					    	case 1 -> veiculo.listarVeiculo();
					    	case 2 -> vendedor.listarVendedor();
					    	case 3-> System.out.println("Voltar para Menu anterior.");
					    	default -> System.out.println("Opção Inválida!");
						}
						
					} while (opcao2 != 3);
				}
					
				case 3-> {
					int opcao3;
					
					do {
						
						System.out.println("######## GERENCIAR VENDEDOR #########");
						System.out.println("1. Consultar Vendedor por nome.");
						System.out.println("2. Voltar para Menu anterior.");
						
						System.out.println("Informe a opção desejada: ");
						opcao3 = sc.nextInt();
						
						switch(opcao3) {
							case 1-> vendedor.pesquisarPorNome();
							case 2-> System.out.println("Voltar para Menu anterior.");
					    	default -> System.out.println("Opção Inválida!");				
						} 			
						
					} while (opcao3 != 2);
				}
				
				case 4-> {
					int opcao4;
					
					do {
						
						System.out.println("######## GERENCIAR CLIENTE #########");
						System.out.println("1. Cadastrar Cliente.");
						System.out.println("2. Consultar Cliente por CPF.");
						System.out.println("3. Voltar para Menu anterior.");
						
						System.out.println("Informe a opção desejada: ");
						opcao4 = sc.nextInt();
						
						switch(opcao4) {
							case 1-> cliente.cadastrarCliente();
							case 2-> cliente.pesquisarClientePorCpf();
							case 3-> System.out.println("Voltar para Menu anterior.");
					    	default -> System.out.println("Opção Inválida!");				
						} 			
						
					} while (opcao4 != 3);
				}
				
				case 5 -> {
				    System.out.println("Voltando para o menu anterior...");
				}
				
			}
						
		} while(opcao != 5);
			
	}

}
