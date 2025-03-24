package concessionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vendedor extends Pessoa{
	
	private static List<Vendedor> listaVendedor = new ArrayList<>();
	private Loja loja; // Associação com a Loja
	
	public Vendedor() {
		super();
	}

	public Vendedor(String nome, String cpf, String telefone, String endereco, List<Vendedor> listaVendedors) {
		super(nome, cpf, telefone, endereco);
		this.listaVendedor = listaVendedor;
	}
	
	public void cadastrarVendedor() {
		Scanner sc = new Scanner(System.in);
		Vendedor vendedor = new Vendedor();
		
		System.out.print("Digite o nome do vendedor: ");
		vendedor.setNome(sc.nextLine());
		System.out.print("Digite o CPF: ");
		vendedor.setCpf(sc.nextLine());
		System.out.print("Digite o telefone: ");
		vendedor.setTelefone(sc.nextLine());
		System.out.print("Digite o endereço: ");
		vendedor.setEndereco(sc.nextLine());
		
		listaVendedor.add(vendedor);
		System.out.println("Vendedor cadastrado com sucesso!");
	}
	
	public void listarVendedor() {
		
		for(Vendedor v : listaVendedor) {
			System.out.println("###############################################");
			System.out.println("Nome: " + v.getNome());
			System.out.println("CPF: " + v.getCpf());
			System.out.println("Telefone: " + v.getTelefone());
			System.out.println("Endereço: " + v.getEndereco());
			System.out.println("###############################################");
		}
	}
	
	public void pesquisarPorNome() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome do vendedor: ");
		String nomeVendedor = sc.nextLine();
		
		for(Vendedor v : listaVendedor) {
			
			if(v.getNome().equals(nomeVendedor)) {
				System.out.println("###############################################");
				System.out.println("Vendedor encontrado!");
				System.out.println("Nome: " + v.getNome());
				System.out.println("CPF: " + v.getCpf());
				System.out.println("Telefone: " + v.getTelefone());
				System.out.println("Endereço: " + v.getEndereco());
				System.out.println("###############################################");
				return;
			}
		}
		
		System.err.println("Vendedor com o nome: " + nomeVendedor + " não encontrado!");
	}
	
	public void atualizarPorNome() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o nome do vendedor: ");
		String atualizarVendedor = sc.nextLine();

		for(Vendedor v : listaVendedor) {
			
			if(v.getNome().equals(atualizarVendedor)) {
				System.out.println("###############################################");
				System.out.println("Vendedor encontrado!");
				System.out.println("Nome: " + v.getNome());
				System.out.println("CPF: " + v.getCpf());
				System.out.println("Telefone: " + v.getTelefone());
				System.out.println("Endereço: " + v.getEndereco());
				System.out.println("###############################################");

			}
		}

	        System.err.println("Vendedor com o nome: " + atualizarVendedor + " não encontrado!");
	}
	
	
	public void excluirVendedor() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o CPF do vendedor: ");
		String excluirPorCpf = sc.nextLine();
		
		for(Vendedor v : listaVendedor) {
			System.out.println(v.getCpf());
			
			if(v.getCpf().equals(excluirPorCpf)) {
				listaVendedor.remove(v);
				System.out.println("Vendedor removido com sucesso!");
				return;
			}
		}
		System.err.println("Vendedor não encontrado!");
	}

}
