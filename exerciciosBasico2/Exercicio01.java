package exerciciosBasico2;

/*Escreva um programa que leia um número inteiro do usuário e diga se ele é par ou ímpar.*/

import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o valor de um número interio: ");
		int numero = sc.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("Esse número inteiro é PAR");
		} else {
			System.out.println("Esse número inteiro é ÍMPAR");
		}
		
		sc.close();
	}

}
