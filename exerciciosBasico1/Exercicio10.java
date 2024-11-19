package exerciciosBasicos1;

/*Crie um programa que leia o preço à vista de um produto e o número de parcelas
 *e escreva  o valor de cada parcela (considerando juros simples de 2% ao mês).*/

import java.util.Scanner;

public class Exercicio10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o valor do produto á vista: ");
		double valorProduto = sc.nextDouble();
		System.out.print("Informe a quantidade de parcelas: ");
		int parcela = sc.nextInt();
		System.out.print("Informe a taxa mensal: ");
		double taxa = sc.nextDouble() / 100;
		
		double valorFinal = valorProduto * (1 + (taxa * parcela));
		double valorParcela = valorFinal / parcela;
		
		System.out.printf("\nValor das parcelas: %.2f\n", valorParcela);
        System.out.printf("Valor final do produto: %.2f\n", valorFinal);
		
		sc.close();
	}

}
