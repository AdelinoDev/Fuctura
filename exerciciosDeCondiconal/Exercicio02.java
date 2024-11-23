package exerciciosDeCondiconal;

import java.util.Scanner;

/* Crie um programa que recebe uma nota musical (A, B, C, D, E ou F) e 
 * fornece informações sobre ela, como a frequência.*/
public class Exercicio02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escolha uma letra referente a nota musical \n"
				+ "A -> Dó \n"
				+ "B -> Ré \n"
				+ "C -> Mi \n"
				+ "D -> Fá \n"
				+ "E -> Sol \n"
				+ "F -> Lá ");
		char letra = sc.next().charAt(0);
		
		switch(Character.toUpperCase(letra)) {
		case 'A': System.out.println("Nota musical correspodente a Dó"); break;
		case 'B': System.out.println("Nota musical correspodente a Ré"); break;
		case 'C': System.out.println("Nota musical correspodente a Mi"); break;
		case 'D': System.out.println("Nota musical correspodente a Fá"); break;
		case 'E': System.out.println("Nota musical correspodente a Sol"); break;
		case 'F': System.out.println("Nota musical correspodente a Lá"); break;
		default: System.out.println("Opção Invalida!");
		}
		
		sc.close();
	}

}
