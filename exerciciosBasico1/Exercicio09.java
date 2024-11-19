package exerciciosBasicos1;


/*Crie um programa que leia a altura e largura de uma parede (em metros) 
 * e escreva a área da parede e a quantidade de tinta necessária para pintá-la 
 * (considerando que cada litro de tinta pinta 2m²).*/

import java.util.Scanner;

public class Exercicio09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite a altura da parede: ");
		double altura = sc.nextDouble();
		System.out.print("Digite a largura da parede: ");
		double largura = sc.nextDouble();
		
		double areaParede = altura * largura;
		double qtdeTinta = areaParede / 2.0;
		
		System.out.println("Area da parede: " + areaParede + " metros quadrado");
		System.out.println("Quantidade de tinta para pintar a parede: " + qtdeTinta + " litros");
		
		sc.close();
	}

}
