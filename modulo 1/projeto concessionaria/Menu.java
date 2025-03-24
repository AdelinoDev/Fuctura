package concessionaria;

import java.util.Scanner;

public class Menu {
	
	public void MenuPrincipal() {
		Scanner sc = new Scanner(System.in);
		
		Cliente cliente = new Cliente();
		Loja loja = new Loja();
		Pessoa pessoa = new Pessoa();
		Veiculo veiculo = new Veiculo();
		Vendedor vendedor = new Vendedor();
		
		MenuFrenteLoja fL = new MenuFrenteLoja();
		MenuAdministracao aC = new MenuAdministracao();
		
		int opcao;
		
		do {
			System.out.println("######## CONCESSIONARIO FUCTURA #########");
			System.out.println("1. Frente de Loja");
			System.out.println("2. Administração de Cadastro");
			System.out.println("3. Sair");
			
			System.out.print("Digite a opção desejada: ");
			opcao = sc.nextInt();
			
			switch(opcao) {
				case 1-> fL.frenteLoja();
				case 2-> aC.administracaoDeCadastro();
				case 3 -> System.out.println("Voltando para o menu anterior...");				
			}
			
		} while(opcao != 3);
				
	}

}
