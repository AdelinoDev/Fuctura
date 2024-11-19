package exerciciosBasico2;

/*Escreva um programa que leia a temperatura em graus Celsius e 
 * converta para graus Fahrenheit ou Kelvin, de acordo com a escolha do usuário. 

A fórmula para converter Celsius para Fahrenheit é: 
F = (C * 9/5) + 32. 

A fórmula para converter Celsius para Kelvin é 
K = C + 273.15.
*/

import java.util.Scanner;

public class Exercicio09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a temperatura em graus Celsiu: ");
		double temperatura = sc.nextDouble();
		
		System.out.println("Informa a opção a qual você deseja converter: \n"
				+ " 1 - Celsius para Fahrenheit \n"
				+ " 2 - Celsius para Kelvin ");
		int opcao = sc.nextInt();
		
		switch(opcao) {
		case 1: 
			double F = (temperatura * 9/5) + 32;
			System.out.println("Temperatura em Fahrenheit: " + F); break;
		case 2: 
			double K = temperatura + 273.15;
			System.out.println("Temperatura em Fahrenheit: " + K); break;
		default: System.out.println("Opção Invalida!!");
		}
		
		sc.close();

	}

}
