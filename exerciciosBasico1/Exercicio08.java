package exerciciosBasicos1;

/*Crie um programa que leia a cotação do dólar e um valor em reais e escreva o valor convertido em dólares.*/

import java.util.Scanner;

public class Exercicio08 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o valor em reais: ");
		double valorReais = sc.nextDouble();
		
		double valorConvertido = valorReais * 5.89;
		
		System.out.println("O valor convertido: R$" + valorConvertido);
		
		sc.close();
	}

}
