package br.com.fuctura.controller;

import java.util.Scanner;

import java.util.List;

import br.com.fuctura.dao.TipoDAO;
import br.com.fuctura.dao.VendaDAO;
import br.com.fuctura.entities.Venda;

public class VendaController {

	
	Scanner sc = new Scanner(System.in);


	public void menuVenda() {
		int opcao = 0;
		
		do {
			System.out.println("\n#### GERENCIAMENTO DE VENDAS ####");
            System.out.println("1 -> CADASTRAR VENDA");
            System.out.println("2 -> LISTAR TODAS AS VENDAS");
            System.out.println("3 -> BUSCAR VENDA");
            System.out.println("4 -> ATUALIZAR DADOS DA VENDA");
            System.out.println("5 -> REMOVER VENDA");
            System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            
            case 1 -> cadastrarVenda();
            case 2 -> listarTodasVendas();
            case 3 -> buscarVendaPorId();
            case 4 -> atualizarVenda();
            case 5 -> deletarVendaPorId();
            case 0 -> System.out.println("Retornando ao menu principal...");
            default -> System.out.println("Opção inválida.");
            
            }
         
		}while(opcao != 0);
	}
	
	
	
	
	
	public void cadastrarVenda() {

		Scanner sc = new Scanner(System.in);

		System.out.println("############### CADASTRO DE VENDA ###############");
		System.out.print("Informe o valor da venda: ");
		double valor = sc.nextDouble();

		Venda venda = new Venda();
		venda.setValor(valor);

		VendaDAO dao = new VendaDAO();
		dao.salvarVenda(venda);

	}

	
	public void atualizarVenda() {

		Scanner sc = new Scanner(System.in);

		VendaDAO dao = new VendaDAO();
		
		System.out.println("############### ATUALIZAR VENDA ###############");
		System.out.print("Informe o código da venda: ");
		int codigo = sc.nextInt();
		
		Venda venda = dao.buscarPorId(codigo);
		
		if(venda != null) {
			
			System.out.print("Informe o valor da venda: ");
			double valor = sc.nextDouble();
			
			venda.setValor(valor);
			
			dao.atualizar(venda);
			
			System.out.println("\nVenda atualizada com sucesso!");
		
		} else {
			System.out.println("Venda não encontrada!");
		}

	}
	
	
	public void listarTodasVendas() {
		
		VendaDAO dao = new VendaDAO();
		
		List<Venda> lista = dao.listarTodos();
		
		System.out.println("############### LISTAR VENDA ###############");
		
		if(lista.isEmpty()) {
			System.out.println("Vendas não encontrada!");
			
		} else {
			
			for(Venda v : lista) {
				System.out.println("Valor: " + v.getValor());
				System.out.println("##############################################");
			}
		}
	}


	public void buscarVendaPorId() {
		Scanner sc = new Scanner(System.in);
		
		VendaDAO dao = new VendaDAO();
		
		System.out.println("Informe o código da venda: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Venda v = dao.buscarPorId(codigo);
		if(v != null) {
			System.out.println("Valor: " + v.getValor());
			System.out.println("##############################################");
			
		} else {
			System.out.println("Venda com código: " + codigo + " não encontrado!");
		}
	}


	public void deletarVendaPorId() {
		Scanner sc = new Scanner(System.in);

		VendaDAO dao = new VendaDAO();

		System.out.println("Informe o código da venda: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Venda v = dao.buscarPorId(codigo);
		if(v != null) {
			
			dao.deletar(codigo);
			System.out.println("Venda deletada com sucesso!");
			
		} else {
			System.out.println("Venda com código: " + codigo + " não encontrada!");
		}
	}
}
