package br.com.fuctura.views;

import java.util.Scanner;

import br.com.fuctura.controller.ClienteController;
import br.com.fuctura.controller.LojaController;
import br.com.fuctura.controller.VeiculoController;
import br.com.fuctura.controller.VendedorController;

public class MenuPrincipal {
	
	VeiculoController veiculo= new VeiculoController();
	ClienteController cliente = new ClienteController();
	VendedorController vendedor = new VendedorController();
	LojaController loja = new LojaController();
	
	
	Scanner sc = new Scanner(System.in);


	public void menuPrincipal() {
				
		int opcao = 0;
		
		do {
			System.out.println("\n#### CONCESSIONÁRIO FUCTURA ####");
            System.out.println("1 -> GERENCIAMENTO DE VEICULOS");
            System.out.println("2 -> GERENCIAMENTO DE CLIENTES");
            System.out.println("3 -> GERENCIAMENTO DE VENDEDOR");
            System.out.println("4 -> GERENCIAMENTO DE LOJA");
            System.out.println("0 -> SAIR DO PROGRAMA");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            
            case 1 -> veiculo.menuVeiculo();
            case 2 -> cliente.menuCliente();
            case 3 -> vendedor.menuVendedor();
            case 4 -> loja.menuLoja();
            case 0 -> System.out.println("Programa finalizado com sucesso!");
            default -> System.out.println("Opção inválida.");
            
            }
         
		}while(opcao != 0);
	}

}
