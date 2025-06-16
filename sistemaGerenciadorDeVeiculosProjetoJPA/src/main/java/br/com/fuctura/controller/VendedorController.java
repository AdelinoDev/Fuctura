package br.com.fuctura.controller;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.TipoDAO;
import br.com.fuctura.dao.VendedorDAO;
import br.com.fuctura.entities.Vendedor;

public class VendedorController {

	Scanner sc = new Scanner(System.in);


	public void menuVendedor() {
		int opcao = 0;
		
		do {
			System.out.println("\n#### GERENCIAMENTO DE VENDEDORES ####");
            System.out.println("1 -> CADASTRAR VENDEDORES");
            System.out.println("2 -> LISTAR TODOS OS VENDEDORES");
            System.out.println("3 -> BUSCAR VENDEDORES");
            System.out.println("4 -> ATUALIZAR DADOS DOS VENDEDORES");
            System.out.println("5 -> REMOVER VENDEDOR");
            System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            
            case 1 -> cadastrarVendedor();
            case 2 -> listarTodosVendedores();
            case 3 -> buscarVendedorPorId();
            case 4 -> atualizarVendedor();
            case 5 -> deletarVendedorPorId();
            case 0 -> System.out.println("Retornando ao menu principal...");
            default -> System.out.println("Opção inválida.");
            
            }
         
		}while(opcao != 0);
	}
	
	
	
	
	
	
	public void cadastrarVendedor() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("############### CADASTRO DE VENDEDOR ###############");
		System.out.print("Informe o nome do vendedor: ");
		String nome = sc.nextLine();
		System.out.print("Informe o cpf: ");
		String cpf = sc.nextLine();
		System.out.print("Informe o celular: ");
		String celular = sc.nextLine();
		System.out.print("Informe o email: ");
		String email = sc.nextLine();
		
		Vendedor vendedor = new Vendedor();
		vendedor.setNome(nome);
		vendedor.setCpf(cpf);
		vendedor.setCelular(celular);
		vendedor.setEmail(email);
		
		VendedorDAO dao = new VendedorDAO();
		dao.salvar(vendedor);
		
		System.out.println("\nVendedor cadastrado com sucesso! ");
	}

	
	public void atualizarVendedor() {
		Scanner sc = new Scanner(System.in);
		
		VendedorDAO dao = new VendedorDAO();
		
		System.out.println("############### CADASTRO DE VENDEDOR ###############");
		System.out.print("Informe o código do vendedor: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Vendedor vendedor = dao.buscarPorId(codigo);
		
		if(vendedor != null) {
			
			System.out.print("Informe o nome do vendedor: ");
			String nome = sc.nextLine();
			System.out.print("Informe o cpf: ");
			String cpf = sc.nextLine();
			System.out.print("Informe o celular: ");
			String celular = sc.nextLine();
			System.out.print("Informe o email: ");
			String email = sc.nextLine();
			
			vendedor.setNome(nome);
			vendedor.setCpf(cpf);
			vendedor.setCelular(celular);
			vendedor.setEmail(email);
			
			dao.atualizar(vendedor);
			
			System.out.println("\nVendedor atualizado com sucesso!");
			
		} else {
			System.out.println("\nVendedor não encontrado!");
		}
		
	}
	
	
	public void listarTodosVendedores() {
		
		VendedorDAO dao = new VendedorDAO();
		
		List<Vendedor> lista = dao.listarTodos();
		
		System.out.println("############### LISTA DE VENDEDORES ###############");
		
		if(lista.isEmpty()) {
			System.out.println("Vendedores não encontrado!");
			
		} else {
			for(Vendedor v : lista) {
				System.out.println("Nome: " + v.getNome());
				System.out.println("CPF: " + v.getCpf());
				System.out.println("Celular: " + v.getCelular());
				System.out.println("E-mail: " + v.getEmail());
				System.out.println("###############################################");
			}
			
		}
		
	}

	
	public void buscarVendedorPorId() {
		Scanner sc = new Scanner(System.in);
		
		VendedorDAO dao = new VendedorDAO();
		
		System.out.println("Informe o código do vendedor: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Vendedor v = dao.buscarPorId(codigo);
		if(v != null) {
			System.out.println("Nome: " + v.getNome());
			System.out.println("CPF: " + v.getCpf());
			System.out.println("Celular: " + v.getCelular());
			System.out.println("E-mail: " + v.getEmail());
			System.out.println("###############################################");
			
		} else {
			System.out.println("Vendedor com código: " + codigo + " não encontrado!");
		}
	}


	public void deletarVendedorPorId() {
		Scanner sc = new Scanner(System.in);

		VendedorDAO dao = new VendedorDAO();

		System.out.println("Informe o código do vendedor: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Vendedor vendedor = dao.buscarPorId(codigo);
		if(vendedor != null) {
			dao.deletar(codigo);
			System.out.println("Vendedor deletado com sucesso!");
		} else {
			System.out.println("Vendedor com código: " + codigo + " não encontrado!");
		}
	}
}
