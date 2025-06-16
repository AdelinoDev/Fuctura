package br.com.fuctura.controller;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.ClienteDAO;
import br.com.fuctura.dao.EnderecoDAO;
import br.com.fuctura.entities.Cliente;
import br.com.fuctura.entities.Endereco;

public class ClienteController {

	Scanner sc = new Scanner(System.in);

	public void menuCliente() {
		int opcao = 0;

		do {
			System.out.println("\n#### GERENCIAMENTO DE CLIENTES ####");
			System.out.println("1 -> CADASTRAR CLIENTE");
			System.out.println("2 -> LISTAR TODOS OS CLIENTES");
			System.out.println("3 -> BUSCAR CLIENTE POR CÓDIGO");
			System.out.println("4 -> ATUALIZAR DADOS DO CLIENTE");
			System.out.println("5 -> REMOVER VEICULO POR CÓDIGO");
			System.out.println("0 -> VOLTAR PARA O MENU PRINCIPAL");
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {

			case 1 -> cadastrarCliente();
			case 2 -> listarTodosClientes();
			case 3 -> buscarClientePorCodigo();
			case 4 -> atualizarCliente();
			case 5 -> deletarClientePorId();
			case 0 -> System.out.println("Retornando ao menu principal...");
			default -> System.out.println("Opção inválida.");

			}

		} while (opcao != 0);
	}

	public void cadastrarCliente() {

		Scanner sc = new Scanner(System.in);

		System.out.println("############### CADASTRO DE CLIENTE ###############");
		System.out.print("Informe o nome do cliente: ");
		String nome = sc.nextLine();
		System.out.print("Informe o cpf: ");
		String cpf = sc.nextLine();
		System.out.print("Informe celular: ");
		String celular = sc.nextLine();
		System.out.print("Informe o email: ");
		String email = sc.nextLine();

		System.out.print("Informe o CEP do cliente: ");
		String cep = sc.nextLine();
		System.out.print("Informe o logradouro do cliente: ");
		String logradouro = sc.nextLine();
		System.out.print("Informe o complemento do cliente: ");
		String complemento = sc.nextLine();
		System.out.print("Informe o número do cliente: ");
		String numero = sc.nextLine();
		

		// ENDEREÇO
		Endereco e = new Endereco();
		e.setCep(cep);
		e.setLogradouro(logradouro);
		e.setComplemento(complemento);
		e.setNumero(numero);

		EnderecoDAO daoEndereco = new EnderecoDAO();
		daoEndereco.salvar(e);
		
		
		// CLIENTE
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setCpf(cpf);
		c.setCelular(celular);
		c.setEmail(email);
		c.setEndereco(e);

		ClienteDAO dao = new ClienteDAO();
		dao.salvar(c);

		System.out.println("\nCliente cadastrado co sucesso!");

	}

	public void atualizarCliente() {
	    ClienteDAO clienteDao = new ClienteDAO();
	    EnderecoDAO enderecoDao = new EnderecoDAO();
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Informe o código do cliente para atualizar: ");
	    int codigo = sc.nextInt();
	    sc.nextLine(); // Consumir quebra de linha

	    Cliente cliente = clienteDao.buscarPorId(codigo);

	    if (cliente != null) {
	        System.out.println("############### ATUALIZAR CLIENTE ###############");

	        // Dados do Cliente
	        System.out.print("Informe o nome do cliente: ");
	        String nome = sc.nextLine();
	        System.out.print("Informe o CPF: ");
	        String cpf = sc.nextLine();
	        System.out.print("Informe o celular: ");
	        String celular = sc.nextLine();
	        System.out.print("Informe o e-mail: ");
	        String email = sc.nextLine();

	        // Atualiza os dados do cliente
	        cliente.setNome(nome);
	        cliente.setCpf(cpf);
	        cliente.setCelular(celular);
	        cliente.setEmail(email);

	        // Dados do Endereço
	        Endereco endereco = cliente.getEndereco(); // Endereço atual do cliente

	        System.out.print("Informe o CEP do cliente: ");
	        String cep = sc.nextLine();
	        System.out.print("Informe o logradouro do cliente: ");
	        String logradouro = sc.nextLine();
	        System.out.print("Informe o complemento do cliente: ");
	        String complemento = sc.nextLine();
	        System.out.print("Informe o número do cliente: ");
	        String numero = sc.nextLine();

	        // Atualiza os dados do endereço
	        endereco.setCep(cep);
	        endereco.setLogradouro(logradouro);
	        endereco.setComplemento(complemento);
	        endereco.setNumero(numero);

	        // Atualiza no banco
	        enderecoDao.atualizar(endereco);
	        clienteDao.atualizar(cliente);

	        System.out.println("\nCliente atualizado com sucesso!");
	    } else {
	        System.out.println("Cliente não encontrado!");
	    }
	}


	public void listarTodosClientes() {
		
	    ClienteDAO dao = new ClienteDAO();
	    
	    List<Cliente> lista = dao.listarTodos();

	    System.out.println("############### LISTA DE CLIENTES ###############");

	    if (lista.isEmpty()) {
	        System.out.println("Nenhum cliente encontrado!");
	    } else {
	        for (Cliente c : lista) {
	            System.out.println("Nome: " + c.getNome());
	            System.out.println("CPF: " + c.getCpf());
	            System.out.println("Celular: " + c.getCelular());
	            System.out.println("E-mail: " + c.getEmail());

	            Endereco e = c.getEndereco(); // acessa o endereço diretamente
	            if (e != null) {
	                System.out.println("CEP: " + e.getCep());
	                System.out.println("Logradouro: " + e.getLogradouro());
	                System.out.println("Complemento: " + e.getComplemento());
	                System.out.println("Número: " + e.getNumero());
	            } else {
	                System.out.println("Endereço não cadastrado.");
	            }

	            System.out.println("--------------------------------------------------");
	        }
	    }
	}


	public void buscarClientePorCodigo() {
	    Scanner sc = new Scanner(System.in);
	    ClienteDAO dao = new ClienteDAO();

	    System.out.println("############### BUSCAR CLIENTE POR CÓDIGO ###############");
	    System.out.print("Informe o código do cliente: ");
	    int codigo = sc.nextInt();
	    sc.nextLine(); // Consumir quebra de linha

	    Cliente c = dao.buscarPorId(codigo);

	    if (c != null) {
	        System.out.println("\nCliente encontrado com sucesso!");
	        System.out.println("Nome: " + c.getNome());
	        System.out.println("CPF: " + c.getCpf());
	        System.out.println("Celular: " + c.getCelular());
	        System.out.println("E-mail: " + c.getEmail());

	        Endereco e = c.getEndereco();
	        if (e != null) {
	            System.out.println("CEP: " + e.getCep());
	            System.out.println("Logradouro: " + e.getLogradouro());
	            System.out.println("Complemento: " + e.getComplemento());
	            System.out.println("Número: " + e.getNumero());
	        } else {
	            System.out.println("Endereço não cadastrado.");
	        }

	        System.out.println("#####################################################");

	    } else {
	        System.out.println("Cliente com código " + codigo + " não encontrado!");
	    }
	}


	public void deletarClientePorId() {
	    Scanner sc = new Scanner(System.in);
	    ClienteDAO dao = new ClienteDAO();

	    System.out.println("############### DELETAR CLIENTE ###############");
	    System.out.print("Informe o código do cliente: ");
	    int codigo = sc.nextInt();
	    sc.nextLine(); // Consumir quebra de linha

	    Cliente c = dao.buscarPorId(codigo);

	    if (c != null) {
	        System.out.println("\nCliente localizado:");
	        System.out.println("Nome: " + c.getNome());
	        System.out.println("CPF: " + c.getCpf());
	        System.out.println("Celular: " + c.getCelular());
	        System.out.println("E-mail: " + c.getEmail());

	        Endereco e = c.getEndereco();
	        if (e != null) {
	            System.out.println("CEP: " + e.getCep());
	            System.out.println("Logradouro: " + e.getLogradouro());
	            System.out.println("Complemento: " + e.getComplemento());
	            System.out.println("Número: " + e.getNumero());
	        } else {
	            System.out.println("Endereço não cadastrado.");
	        }

	        System.out.print("\nDeseja realmente deletar este cliente? (s/n): ");
	        String confirmacao = sc.nextLine();

	        if (confirmacao.equalsIgnoreCase("s")) {
	            dao.delete(codigo);
	            System.out.println("Cliente deletado com sucesso!");
	        } else {
	            System.out.println("Operação cancelada.");
	        }

	    } else {
	        System.out.println("Cliente com código " + codigo + " não encontrado!");
	    }
	}


}