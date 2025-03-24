package concessionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loja {
	
	private String nome;
	private String endereco;
	private String telefone;
	
	private Veiculo veiculo;
	
	private static List<Loja> listaLoja = new ArrayList<>();
	
	private List<Vendedor> vendedores;
	private List<Veiculo> veiculosDisponiveis;
	
	public Loja() {}

	 public Loja(String nome, String endereco, String telefone, List<Loja> listaLoja) {
	        this.nome = nome;
	        this.endereco = endereco;
	        this.telefone = telefone;
	        this.listaLoja = listaLoja;
	        this.veiculosDisponiveis = new ArrayList<>();
	        this.vendedores = new ArrayList<>();
	 }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public List<Veiculo> getVeiculosDisponiveis() {
		return veiculosDisponiveis;
	}

	public void setVeiculosDisponiveis(List<Veiculo> veiculosDisponiveis) {
		this.veiculosDisponiveis = veiculosDisponiveis;
	}
	
	public static List<Loja> getListaLoja() {
		return listaLoja;
	}

	public static void setListaLoja(List<Loja> listaLoja) {
		Loja.listaLoja = listaLoja;
	}

	public void cadastrarLoja() {
		Scanner sc = new Scanner(System.in);
		Loja loja = new Loja();
		
		System.out.print("Digite o nome da loja: ");
		loja.setNome(sc.nextLine());
		System.out.print("Digite o endereço: ");
		loja.setEndereco(sc.nextLine());
		System.out.print("Digite o telefone: ");
		loja.setTelefone(sc.nextLine());
		
		listaLoja.add(loja);
		System.out.println("Loja cadastrada com sucesso!");
	}
	
	public void atualizarLoja() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o  nome da loja a qual queres atualizar");
		String atualizarPorNome = sc.nextLine();
		
		boolean encontrado = false;
		
		for (Loja loja : listaLoja) {
	    	
	        if (loja.getNome().equals(atualizarPorNome)) {
	            System.out.print("Novo nome: ");
	            loja.setNome(sc.nextLine());

	            System.out.print("Novo telefone: ");
	            loja.setTelefone(sc.nextLine());

	            System.out.print("Novo endereço: ");
	            loja.setEndereco(sc.nextLine());

	            System.out.println("Cliente atualizado com sucesso!");
	            return;
	        }
	    }
		
		if(!encontrado) {
			System.err.println("Loja nome: " + atualizarPorNome + " não encontrada!");
		}
	}
	
	public void adicionarVeiculo(Veiculo veiculo) {
		
	    if (veiculo != null) {
	        this.veiculosDisponiveis.add(veiculo);
	        System.out.println("Veículo adicionado à loja " + this.nome + " com sucesso!");
	    } else {
	        System.err.println("Veículo inválido. Não foi possível adicioná-lo à loja.");
	    }
	}

	public String toString() {
		String dados = """
				Nome: %s
				Endereço: %s
				Telefone: %s
				Veiculo associado: %s
				""";
				return String.format(dados, nome, endereco, telefone, veiculo);
	}

}
