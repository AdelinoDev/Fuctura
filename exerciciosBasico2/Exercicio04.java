package exerciciosBasico2;

import java.util.Scanner;

/*Escreva um programa que leia a idade de uma pessoa e diga se ela pode votar ou não nas eleições. 

No Brasil, o voto é obrigatório para pessoas entre 18 e 70 anos, 
e facultativo para pessoas entre 16 e 18 anos ou maiores de 70 anos.*/

public class Exercicio04 {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("Informe a idade do eleitor: ");
		 int idade = sc.nextInt();
		 
		 if(idade >= 18 && idade <= 70) {
			 System.out.println("Voto obrigatório!");
		 } else {
			 System.out.println("Voto facultativo!");
		 }
		 
		 sc.close();
	}

}
