package exerciciosBasicos1;

import java.util.Scanner;

/*Crie um programa que leia a quantidade de litros de água consumidos por uma residência em um mês 
e escreva o valor da conta de água (considerando que cada litro de água custa R$0,02).*/

public class Exercicio06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe a quantidade de litros de agua gasto por mes: ");
		double qtdeLitrosAgua = sc.nextDouble();
		
		double valorContaAgua = qtdeLitrosAgua * 0.02;
		
		System.out.println("Valor da conta de água: " + valorContaAgua);
		
		sc.close();
	}

}
