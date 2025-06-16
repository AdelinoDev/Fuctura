package br.com.fuctura.controller;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.LojaDAO;
import br.com.fuctura.entities.Loja;

public class LojaController {
	
	Scanner sc = new Scanner(System.in);


	public void menuLoja() {
		int opcao = 0;
		
		do {
			System.out.println("\n#### GERENCIAMENTO DE LOJAS ####");
            System.out.println("1 -> CADASTRAR LOJA");
            System.out.println("2 -> LISTAR TODAS AS LOJAS");
            System.out.println("3 -> BUSCAR LOJA");
            System.out.println("4 -> ATUALIZAR LOJA");
            System.out.println("5 -> REMOVER LOJA");
            System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            
            case 1 -> cadastrarLoja();
            case 2 -> listarTodasLojas();
            case 3 -> buscarLojaPorId();
            case 4 -> atualizarLoja();
            case 5 -> deletarLojaPorId();
            case 0 -> System.out.println("Retornando ao menu principal...");
            default -> System.out.println("Opção inválida.");
            
            }
         
		}while(opcao != 0);
	}
	
	
	
	
	
	
	public void cadastrarLoja() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("############### CADASTRO DE LOJA ###############");
		System.out.print("Informe o nome da loja: ");
		String nome = sc.nextLine();
		System.out.print("Informe o endereço: ");
		String endereco = sc.nextLine();
		System.out.print("Informe o CNPJ: ");
		String cnpj = sc.nextLine();
		
		Loja loja = new Loja();
		loja.setNome(nome);
		loja.setEndereco(endereco);
		loja.setCnpj(cnpj);
		
		LojaDAO dao = new LojaDAO();
		dao.salvarLoja(loja);
		
		System.out.println("\nLoja salva com sucesso!");
	}
	
	
	public void atualizarLoja() {
		
		Scanner sc = new Scanner(System.in);
		
		LojaDAO dao = new LojaDAO();
		
		System.out.println("############### ATUALIZAR DE LOJA ###############");
		System.out.print("Informe o codigo da loja: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Loja loja = dao.buscarPorId(codigo);
		
		if(loja != null) {
			
			System.out.print("Informe o nome da loja: ");
			String nome = sc.nextLine();
			System.out.print("Informe o endereço: ");
			String endereco = sc.nextLine();
			System.out.print("Informe o CNPJ: ");
			String cnpj = sc.nextLine();
			
			loja.setNome(nome);
			loja.setEndereco(endereco);
			loja.setCnpj(cnpj);
			
			dao.atualizar(loja);
			
			System.out.println("\nLoja atualizada com sucesso!");
			
		} else {
			System.out.println("Loja não encontrada com sucesso!");
		}
		
	}
	
	
	public void listarTodasLojas() {
		
		LojaDAO dao = new LojaDAO();
		
		List<Loja> lista = dao.listarTodos();
		
		System.out.println("############### LISTA DAS LOJAS ###############");
		
		if(lista.isEmpty()) {
			System.out.println("Loja não encontrada!");
		
		} else {
			
			for( Loja l : lista) {
				System.out.println("Nome: " + l.getNome());
				System.out.println("Endereço: " + l.getEndereco());
				System.out.println("CNPJ: " + l.getCnpj());
				System.out.println("################################################");
			}
		}
	}

	
	public void buscarLojaPorId() {
		
		Scanner sc = new Scanner(System.in);
		
		LojaDAO dao = new LojaDAO();
		
		System.out.println("Informe o código da loja: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Loja l = dao.buscarPorId(codigo);
		
		if(l != null) {
			System.out.println("Nome: " + l.getNome());
			System.out.println("Endereço: " + l.getEndereco());
			System.out.println("CNPJ: " + l.getCnpj());
			System.out.println("################################################");
			
		} else {
			System.out.println("Loja com o código: " + codigo + " não encontrado!");
		}
	}


	public void deletarLojaPorId() {
Scanner sc = new Scanner(System.in);
		
		LojaDAO dao = new LojaDAO();
		
		System.out.println("Informe o código da loja: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Loja l = dao.buscarPorId(codigo);
		if(l != null) {
			dao.deletar(codigo);
			System.out.println("Loja deletada com sucesso!");
			
		} else {
			System.out.println("Loja com código: " + codigo + " não encontrada!");
		}
	}
}
