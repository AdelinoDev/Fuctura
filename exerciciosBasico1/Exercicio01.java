/*Crie um programa que leia o nome do usuário e escreva uma saudação personalizada: 
 "Olá, [nome do usuário]! Bem-vindo ao nosso programa!".*/

package exerciciosBasicos1;

import java.util.Scanner;

public class Exercicio01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String nome;
		
		System.out.print("Digite o nome: ");
		nome = sc.next();
		
		System.out.println("Olá, " + nome + "!, Bem-vindo ao nosso programa!");
		
		sc.close();
	}

}
