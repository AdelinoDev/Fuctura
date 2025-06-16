package br.com.fuctura.controller;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.EnderecoDAO;
import br.com.fuctura.dao.TipoDAO;
import br.com.fuctura.entities.Tipo;

public class TipoController {

	
	Scanner sc = new Scanner(System.in);


	public void menuTipo() {
		int opcao = 0;
		
		do {
			System.out.println("\n#### GERENCIAMENTO DE TIPOS ####");
            System.out.println("1 -> CADASTRAR TIPO");
            System.out.println("2 -> LISTAR TODOS OS TIPOS");
            System.out.println("3 -> BUSCAR TIPO");
            System.out.println("4 -> ATUALIZAR DADOS DO TIPO");
            System.out.println("5 -> REMOVER TIPO");
            System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            
            case 1 -> CadastrarTipo();
            case 2 -> listarTodosTipos();
            case 3 -> buscarTipoPorId();
            case 4 -> atualizarTipo();
            case 5 -> deletarTipoPorId();
            case 0 -> System.out.println("Retornando ao menu principal...");
            default -> System.out.println("Opção inválida.");
            
            }
         
		}while(opcao != 0);
	}
	
	
	
	
	
	public void CadastrarTipo() {

		Scanner sc = new Scanner(System.in);

		System.out.println("############### CADASTRO DE TIPO ###############");
		System.out.print("Informe a descrição do tipo: ");
		String descricao = sc.nextLine();

		Tipo tipo = new Tipo();
		tipo.setDescricao(descricao);

		TipoDAO dao = new TipoDAO();
		dao.salvar(tipo);

		System.out.println("\nTipo cadastrado com sucesso!");
	}

	public void atualizarTipo() {

		Scanner sc = new Scanner(System.in);

		TipoDAO dao = new TipoDAO();

		System.out.println("############### ATUALIZAR TIPO ###############");
		System.out.print("Informe o codigo do tipo para atualização: ");
		int codigo = sc.nextInt();
		sc.nextLine();

		Tipo tipo = dao.buscarPorId(codigo);

		if (tipo != null) {

			System.out.print("Informe a descrição: ");
			String descricao = sc.nextLine();

			tipo.setDescricao(descricao);

			dao.atualizar(tipo);

			System.out.println("\nTipo atualizado comsucesso!");

		} else {
			System.out.println("Tipo não encontrado!");

		}

	}

	public void listarTodosTipos() {

		TipoDAO dao = new TipoDAO();

		List<Tipo> lista = dao.buscarTodos();

		System.out.println("############### LISTAR TIPO ###############");

		if (lista.isEmpty()) {
			System.out.println("Nenhum tipo encontrado!");

		} else {

			for (Tipo t : lista) {
				System.out.println("Descrição: ");
				System.out.println("#########################################");
			}
		}
	}

	public void buscarTipoPorId() {
		Scanner sc = new Scanner(System.in);

		TipoDAO dao = new TipoDAO();

		System.out.println("Informe o codigo do tipo: ");
		int codigo = sc.nextInt();
		sc.nextLine();

		Tipo t = dao.buscarPorId(codigo);
		if (t != null) {
			System.out.println("Descrição: ");
			System.out.println("#########################################");

		} else {
			System.out.println("Tipo com o código: " + codigo + " não encontrado!");

		}
	}

	public void deletarTipoPorId() {
		Scanner sc = new Scanner(System.in);

		TipoDAO dao = new TipoDAO();

		System.out.println("Informe o código do tipo: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Tipo t = dao.buscarPorId(codigo);
		if(t != null) {
			
			dao.deletar(codigo);
			System.out.println("Tipo deletado com sucesso!");
		} else {
			System.out.println("Tipo com código: " + codigo + " não encontrado!");
		}
	}
}
