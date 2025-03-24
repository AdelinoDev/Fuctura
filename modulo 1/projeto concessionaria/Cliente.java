package concessionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa{
	
	private static List<Cliente> listaCliente = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf, String telefone, String endereco, List<Cliente> listaCliente) {
		super(nome, cpf, telefone, endereco);
	}
	

	public static List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public static void setListaCliente(List<Cliente> listaCliente) {
		Cliente.listaCliente = listaCliente;
	}

	public void cadastrarCliente() {
		
		Scanner sc = new Scanner(System.in);
		Cliente c = new Cliente();
		
		System.out.print("Digite o nome: ");
		c.setNome(sc.nextLine());
		System.out.print("Digite o CPF: ");
		c.setCpf(sc.nextLine());
		System.out.print("Digite o telefone: ");
		c.setTelefone(sc.nextLine());
		System.out.print("Digite o endereço: ");
		c.setEndereco(sc.nextLine());
		
		listaCliente.add(c);
		System.out.println("Cliente cadastrado com sucesso!");
	}
	
	public void pesquisarClientePorCpf() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o CPF: ");
		String cpfCliente = sc.nextLine();
		
		for(Cliente c : listaCliente) {
			
			if(c.getCpf().equals(cpfCliente)) {
				System.out.println("###############################################");
				System.out.println("Cliente encontrado com sucesso!");
				System.out.println("Nome: " + c.getNome());
				System.out.println("CPF: " + c.getCpf());
				System.out.println("Telefone: " + c.getTelefone());
				System.out.println("Endereço: " + c.getEndereco());
				System.out.println("###############################################");
				return;
			}
		}
		
		System.err.println("Cliente CPF: " + cpfCliente + " não encontrado!");
	}
	
	public void excluirCliente() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o CPF: ");
		String excluirPorCpf = sc.nextLine();
		
		for(int i = 0; i < listaCliente.size(); i++) {
			Cliente cliente = listaCliente.get(i);
			
			if(cliente.getCpf().equalsIgnoreCase(excluirPorCpf)) {
				listaCliente.remove(cliente);
				System.out.println("Cliente removido com sucesso!");
				return;
			}
		}
		System.err.println("Cliente não encontrado!");
	}
	
	public void atualizarCliente() {
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Digite o CPF do cliente que deseja atualizar: ");
	    String atualizarCliente = sc.nextLine();

	    for (Cliente c : listaCliente) {
	    	
	        if (c.getCpf().equals(atualizarCliente)) {
	            System.out.print("Novo nome: ");
	            c.setNome(sc.nextLine());

	            System.out.print("Novo telefone: ");
	            c.setTelefone(sc.nextLine());

	            System.out.print("Novo endereço: ");
	            c.setEndereco(sc.nextLine());

	            System.out.println("Cliente atualizado com sucesso!");
	            return;
	        }
	    }

	    System.err.println("Cliente não encontrado!");
	}

}
