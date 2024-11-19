package exerciciosBasico2;

/*Escreva um programa que leia dois números inteiros do usuário 
 *e diga qual é o maior, o menor ou se são iguais.*/

import java.util.Scanner;

public class Exercicio02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("informe o primeiro numero: ");
		double num1 = sc.nextDouble();
		System.out.print("informe o segundo numero: ");
		double num2 = sc.nextDouble();
		
		if(num1 > num2) {
			System.out.println("O primeiro número é maior");
		} else if(num1 < num2) {
			System.out.println("O segundo número é maior");
		} else {
			System.out.println("O dois números são iguais");
		}
		
		sc.close();
	}

}
