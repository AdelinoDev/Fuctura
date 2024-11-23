package exerciciosEstruturaDeControle;

import java.util.Scanner;

/*Criar um programa que receba um número e verifique se ele está entre 0 e 10 e é par;*/
public class Exercicio1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Por favor digite um número entre 0 e 10: ");
		int numero = sc.nextInt();
		
		if(numero >= 0 && numero <= 10) {
			
			if(numero % 2 == 0 ) {
				System.out.println("PAR");
			} else {
				System.out.println("ÍMPAR");
			}
			
		} else {
			System.out.println("Número invalido, não consta entre 0 e 10!");
		}
		
		
		sc.close();
	}

}
