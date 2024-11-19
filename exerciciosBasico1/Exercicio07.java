package exerciciosBasicos1;

import java.util.Scanner;

/*
 * Crie um programa que leia o peso de uma encomenda (em kg) e 
 * escreva  o valor do frete (considerando que cada kg custa R$5,00).
 */

public class Exercicio07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o peso de sua encomanda em Kg: ");
		double peso = sc.nextDouble();
		
		double valorFrete = peso * 5.00;
		
		System.out.printf("Valor do frete R$%.2f ", valorFrete);
		
		
		sc.close();
	}

}
