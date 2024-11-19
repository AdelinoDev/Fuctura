package ExercicioBasico2;

import java.util.Scanner;

/* Escreva um programa que leia um número inteiro entre 1 e 7 e mostre o dia da semana correspondente. 
 * Se o número não estiver nesse intervalo, mostre uma mensagem de erro.*/
public class Exer12 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe um dia da semana de 1 á 7\n"
				+ " 1 -> DOMINGO\n"
				+ " 2 -> SEGUNDA\n"
				+ " 3 -> TERÇA\n"
				+ " 4 -> QUARTA\n"
				+ " 5 -> QUINTA\n"
				+ " 6 -> SEXTA\n"
				+ " 7 -> SABADO");
		String diaSemana = sc.next();
		
		switch(diaSemana) {
		case "1": System.out.println("DOMINGO."); break;
		case "2": System.out.println("SEGUNDA."); break;
		case "3": System.out.println("TERÇA."); break;
		case "4": System.out.println("QUARTA."); break;
		case "5": System.out.println("QUINTA."); break;
		case "6": System.out.println("SEXTA."); break;
		case "7": System.out.println("SABADO."); break;
		default : System.out.println("Opção Invalida!");
		}
				
		sc.close();
	}
	
}
