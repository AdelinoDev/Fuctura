package concessionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Veiculo {
	
	private String marca;
	private String modelo;
	private Integer ano;
	private String placa;
	private Double preco;
	
	private static List<Veiculo> listaVeiculo = new ArrayList<>();
	
	public Veiculo() {}

	public Veiculo(String marca, String modelo, Integer ano, String placa, Double preco, List<Veiculo> listaVeiculo) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.placa = placa;
		this.preco = preco;
		this.listaVeiculo = listaVeiculo; 
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Veiculo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(List<Veiculo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

	public void cadastrarVeiculo() {
		Scanner sc = new Scanner(System.in);
		Veiculo veiculo = new Veiculo();
		
		System.out.print("Digite a marca do veiculo: ");
		veiculo.setMarca(sc.nextLine());
		System.out.print("Digite modelo: ");
		veiculo.setModelo(sc.nextLine());
		System.out.print("Digite o ano: ");
		veiculo.setAno(sc.nextInt());
		System.out.print("Digite a placa: ");
		veiculo.setPlaca(sc.nextLine());
		System.out.print("Digite o preço: ");
		veiculo.setPreco(sc.nextDouble());
		
		listaVeiculo.add(veiculo);
		System.out.println("Veiculo cadastrado com sucesso!");
	}
	
	public void listarVeiculo() {
		
		for(Veiculo v : listaVeiculo) {
			System.out.println("###############################################");
			System.out.println("Marca: " + v.getMarca());
			System.out.println("Modelo: " + v.getModelo());
			System.out.println("Ano: " + v.getAno());
			System.out.println("Placa: " + v.getPlaca());
			System.out.println("Preço: " + v.getPreco());
			System.out.println("###############################################");
		}
	}
	
	public void pesquisarVeiculoPorPlaca() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a placa do veículo: ");
		String placaVeiculo = sc.nextLine();
		
		for(Veiculo v : listaVeiculo) {
			
			if(v.getPlaca().equals(placaVeiculo)) {
				System.out.println("###############################################");
				System.out.println("Veiculo encontrado!");
				System.out.println("Marca: " + v.getMarca());
				System.out.println("Modelo: " + v.getModelo());
				System.out.println("Ano: " + v.getAno());
				System.out.println("Placa: " + v.getPlaca());
				System.out.println("Preço: " + v.getPreco());
				System.out.println("###############################################");
				return;
			}
		}
		
		System.err.println("Veiculo da placa " + placaVeiculo + " não encontrado!");
	}
	
	public void excluirVeiculo() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a placa do veículo: ");
		String placaVeiculo = sc.nextLine();
		
		for(int i = 0; i < listaVeiculo.size(); i++) {
			Veiculo v = listaVeiculo.get(i);
			
			if(v.getPlaca().equalsIgnoreCase(placaVeiculo)) {
				listaVeiculo.remove(v);
				System.out.println("Veiculo removido com sucesso!");
				return;
			}
		}
		
		System.out.println("Veiculo placa: " + placaVeiculo + " não encontrado!");
	}
	
	public void atualizarVeiculo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a placa do veiculo ao qual queres atualizar: ");
		String atualizarPorPlaca = sc.nextLine().trim();
		
		for (Veiculo v : listaVeiculo) {
	    	
	        if (v.getPlaca().equalsIgnoreCase(atualizarPorPlaca)) {
	        	System.out.println("###############################################");
	            System.out.print("Novo modelo: ");
	            v.setModelo(sc.nextLine());

	            System.out.print("Marca: ");
	            v.setMarca(sc.nextLine());

	            System.out.print("Ano: ");
	            v.setAno(sc.nextInt());
	            
	            System.out.println("Placa: ");
	            v.setPlaca(sc.nextLine());
	            
	            System.out.println("Preço: ");
	            v.setPreco(sc.nextDouble());

	            System.out.println("Cliente atualizado com sucesso!");
	            return;
	        }
	    }
		
			System.err.println("Carro da placa " + atualizarPorPlaca + " não encontrado");
	}

}
