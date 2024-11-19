package exerciciosBasico2;

/*Escreva um programa que leia o mês do ano em número (1 a 12) 
 e diga quantos dias ele tem. Considere que o ano não é bissexto.*/

import java.util.Scanner;

public class Exercicio05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe mês do ano em número (1 á 12): ");
		int mes = sc.nextInt();
		
		// switch case mais atualizado
		switch (mes) {
			case 1 -> System.out.println("Janeiro");
			case 2 -> System.out.println("Fevereiro"); 
			case 3 -> System.out.println("Março"); 
			case 4 -> System.out.println("Abril"); 
			case 5 -> System.out.println("Maio"); 
			case 6 -> System.out.println("Junho");
			case 7 -> System.out.println("Julho"); 
			case 8 -> System.out.println("Agosto"); 
			case 9 -> System.out.println("Setembro"); 
			case 10 -> System.out.println("Outubro");
			case 11 -> System.out.println("Novembro"); 
			case 12 -> System.out.println("Dezembro");
			default -> System.out.println("Número inválido!"); 	
		}
			
		sc.close();
	}

}
