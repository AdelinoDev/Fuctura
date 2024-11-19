package exerciciosBasico2;

import java.util.Scanner;

/*Escreva um programa que leia o preço de um produto e a 
 forma de pagamento escolhida pelo cliente: 

→ 1 - em espécie
→ 2 - cartão de crédito
→ 3 - cartão de débito 

Mostre o valor final da compra. 

Considere que o produto tem 10% de desconto se for pago em espécie ou
no cartão de débito e não tem desconto se for pago no cartão de crédito.*/

public class Exercicio08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o nome do produto: ");
		String nomeProduto = sc.nextLine();
		
		System.out.print("Digite o preço do produto: ");
		double preco = sc.nextDouble();
		
		System.out.print("Digite a forma de pagamento: ");
		System.out.print("1 - em espécie "
				+ "2 - cartão de crédito "
				+ "3 - cartão de débito ");
		int formaPagamento = sc.nextInt();
		
		switch(formaPagamento) {
		case 1,2: 
			double precoFinal = preco - (preco * 0.1);
		
			System.out.println("Valor do produto: " + precoFinal); 
			break;
		case 3:
			System.out.println("Valor do produto: " + preco); 
			break;
		default: 
			System.out.println("Opção Invalida!!"); 
		}
		sc.close();
	}

}
