package exerciciosBasicos1;

import java.util.Scanner;

/*Crie um programa que leia a distância percorrida por um carro (em km) 

e o tempo gasto (em horas) e escreva a velocidade média do carro. 

A fórmula de velocidade média é: 

vm = distancia(em metros) / tempo(em segundos)

*/

public class Exercicio03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe a distancia percorrida em Km: ");
		double distanciakm = sc.nextDouble();
		System.out.print("Informe o tempo gasto em horas: ");
		double tempoGastoHoras = sc.nextDouble();
		
		double velocidadeMedia = (distanciakm * 1000) / (tempoGastoHoras * 3600);
		
		System.out.printf("Velocidade media do carro eh: %.3f m/s %n" , velocidadeMedia);
		

		sc.close();
	}

}
