package exerciciosBasicos1;

import java.util.Scanner;

/*Crie um programa que leia o preço de dois produtos e escreva o valor total da compra. 
 * Lembre-se que valores são números fracionados, ou seja, declare-os com o tipo double.*/

public class Exercicio02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		double produto1 = 0.0, produto2 = 0.0;
		
		System.out.print("Informe o valor do primeiro produto: ");
		produto1 = sc.nextDouble();
		System.out.print("Informe o valor do segundo produto: ");
		produto2 = sc.nextDouble();
		
		double valorTotal = produto1 + produto2;
		
		System.out.printf("Valor total da compra é: R$ %.2f%n" , valorTotal);
		
		sc.close();
	}

}
