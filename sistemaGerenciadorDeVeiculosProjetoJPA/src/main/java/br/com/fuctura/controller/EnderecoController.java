package br.com.fuctura.controller;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.EnderecoDAO;
import br.com.fuctura.entities.Endereco;

public class EnderecoController {
	
	Scanner sc = new Scanner(System.in);


	public void menuEndereco() {
		int opcao = 0;
		
		do {
			System.out.println("\n#### GERENCIAMENTO DE ENDEREÇO ####");
            System.out.println("1 -> CADASTRAR ENDEREÇO");
            System.out.println("2 -> LISTAR TODOS OS ENDEREÇOS");
            System.out.println("3 -> BUSCAR VEICULO POR CODIGO");
            System.out.println("4 -> ATUALIZAR DADOS DO ENDEREÇO");
            System.out.println("5 -> REMOVER ENDEREÇO");
            System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            
            case 1 -> cadastrarEndereco();
            case 2 -> listarTodosEnderecos();
            case 3 -> buscarEnderecoPorId();
            case 4 -> atualizarEndereco();
            case 5 -> deletarEnderecoPorID();
            case 0 -> System.out.println("Retornando ao menu principal...");
            default -> System.out.println("Opção inválida.");
            
            }
         
		}while(opcao != 0);
	}
	
	
	
	
	
	
	
	public void cadastrarEndereco() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("############### CADASTRO DE ENDEREÇO ###############");
		System.out.print("Informe o cep do endereço: ");
		String cep = sc.nextLine();
		System.out.print("Informe o logradouro: ");
		String logradouro = sc.nextLine();
		System.out.print("Informe o completo: ");
		String complemento = sc.nextLine();
		System.out.print("Informe o número do endereço: ");
		String numero = sc.nextLine();
		
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setLogradouro(logradouro);
		endereco.setComplemento(complemento);
		endereco.setNumero(numero);
		
		EnderecoDAO dao = new EnderecoDAO();
		dao.salvar(endereco);
		
		System.out.println("\nEndereço salvo com sucesso!");
		
	}
	
	
	public void atualizarEndereco() {
		
		EnderecoDAO dao = new EnderecoDAO();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o código do endereço para atualização: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Endereco endereco = dao.buscarPorId(codigo);
		
		if(endereco != null) {
			
			System.out.print("Informe o cep: ");
			String cep = sc.nextLine();
			System.out.print("Informe o logradouro: ");
			String logradouro = sc.nextLine();
			System.out.print("Informe o complemento: ");
			String complemento = sc.nextLine();
			System.out.print("Informe o numero: ");
			String numero = sc.nextLine();
			
			endereco.setCep(cep);
			endereco.setLogradouro(logradouro);
			endereco.setComplemento(complemento);
			endereco.setNumero(numero);
			
			dao.atualizar(endereco);
			
			System.out.println("\nEndereço atualizado com sucesso!");
			
		} else {
			
			System.out.println("Endereço não encontrado!");
		}
		
	}
	

	public void listarTodosEnderecos() {
		
		EnderecoDAO dao = new EnderecoDAO();
		
		List<Endereco> lista = dao.listaTodos();
		
		System.out.println("############### LISTA DE ENDEREÇO ###############");
		
		if(lista.isEmpty()) {
			System.out.println("Nenhum endereço encontrado!");
			
		} else {
			
			for(Endereco e : lista) {
				System.out.println("Cep: " + e.getCep());
				System.out.println("Logradouro: " + e.getLogradouro());
				System.out.println("Complemento: " + e.getComplemento());
				System.out.println("Número: " + e.getNumero());
				System.out.println("#################################################");
			}
			
		}
	}
	
	
	public void buscarEnderecoPorId() {
		
		Scanner sc = new Scanner(System.in);
		
		EnderecoDAO dao = new EnderecoDAO();
		
		System.out.println("Informe o código do endereço: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Endereco e = dao.buscarPorId(codigo);
		
		if(e != null) {
			System.out.println("Endereço encontrado com sucesso!");
			System.out.println("Cep: " + e.getCep());
			System.out.println("Logradouro: " + e.getLogradouro());
			System.out.println("Complemento: " + e.getComplemento());
			System.out.println("Número: " + e.getNumero());
			System.out.println("#################################################");
			
		} else {
			System.out.println("Endereço com o codigo: " + codigo + " não foi encontrado!");
		}
	}
	
	
	public void deletarEnderecoPorID() {
		Scanner sc = new Scanner(System.in);
		
		EnderecoDAO dao = new EnderecoDAO();
		
		System.out.println("Informe o código do endereço: ");
		int codigo = sc.nextInt(); sc.nextLine();
		
		Endereco e = dao.buscarPorId(codigo);
		if(e != null) {
			dao.deletar(codigo);
			System.out.println("Endereço deletado com sucesso!");
			
		} else {
			System.out.println("Endereço com código: " + codigo + " não encontrado!");
		}
	}
	
}
