package ExercicioBasico2;

import java.util.Scanner;

/* Escreva um programa que leia um ano e diga se ele é bissexto ou não. 
   Um ano é bissexto se ele for divisível por 4, exceto se ele for divisível por 100 e não por 400. 

Ex:
2000 é bissexto. 
2100 não é bissexto.*/
public class Exer13 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o ano: ");
		int ano = sc.nextInt();
		
		if ((ano % 4 == 0) && (ano % 100 != 0) || (ano % 400 == 0)) {
			System.out.println("Ano Bissexto");
		} else {
			System.out.println("Ano não Bissexto");
		}
		
		sc.close();
	}

}
