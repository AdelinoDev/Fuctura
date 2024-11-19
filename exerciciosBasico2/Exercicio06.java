package exerciciosBasico2;
/*Escreva um programa que leia uma letra do alfabeto e diga se ela é uma vogal ou uma consoante.
 *  
 * Lembre-se que, na comparação de Strings, usa-se o método .equals() ou o .equalsIgnoreCase().*/

import java.util.Scanner;

public class Exercicio06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe uma letra do alfabeto: ");
		String letra = sc.next();sc.next();
		
		if( letra.equalsIgnoreCase("a") ||
			letra.equalsIgnoreCase("e") ||
			letra.equalsIgnoreCase("i") ||
			letra.equalsIgnoreCase("o") ||
			letra.equalsIgnoreCase("u") ) {
			System.out.println("Letra digita eh uma vogal: " + letra);
		} else {
			System.out.println("Letra digita eh uma consoante: " + letra);
		}
		
		sc.close();
	}

}
