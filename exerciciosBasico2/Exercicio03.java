package exerciciosBasico2;

import java.util.Scanner;

/*Faça um programa que leia três notas de um aluno e calcule a média. 

Se a média for maior ou igual a 7, o aluno está aprovado. 
Se a média for menor que 4, o aluno está reprovado. 
Se a média estiver entre 4 e 7, o aluno precisa fazer uma prova final.*/

public class Exercicio03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a primeira nota: ");
		double nota1 = sc.nextDouble();
		System.out.print("Digite a segunda nota: ");
		double nota2 = sc.nextDouble();
		System.out.print("Digite a terceira nota: ");
		double nota3 = sc.nextDouble();
		
		double media = (nota1 + nota2 + nota3) / 3; 
		
		System.out.println("Média do Aluno: " + media);
		
		if(media >= 7) {
			System.out.println("Aluno Aprovado!");
		} else if(media < 4) {
			System.out.println("Aluno Reprovado!");
		} else {
			System.out.println("Aluno precisa fazer uma prova final!");
		}
		
		sc.close();
	}

}
