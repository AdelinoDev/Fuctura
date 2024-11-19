package exerciciosBasico2;
/*Escreva um programa que leia dois números inteiros e um operador aritmético (+, -, *, /) 
 * 
 * e realize a operação correspondente. Se o operador não for válido, mostre uma mensagem de erro.
 */

import java.util.Scanner;

public class Exercicio07 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite um número inteiro: ");
		int numero1 = sc.nextInt();
		System.out.print("Digite outro número inteiro: ");
		int numero2 = sc.nextInt();
		System.out.println("Digite agora o tipo de operação que deseja realizar");
		System.out.print("(+ -> para soma"
							+ ", - -> para subtração"
							+ ", * -> para multiplicação, "
							+ "/ -> divisão)");
		String operacao = sc.next();
				
		switch(operacao) {
		
		case "+" -> System.out.println(numero1 + numero2);
		case "*" -> System.out.println(numero1 * numero2);
		case "-" -> System.out.println(numero1 - numero2);
		case "/" -> System.out.println(numero1 / numero2);
		
		default -> System.out.println("Operação Invalida!");
		}
				
		
		sc.close();
	}

}
