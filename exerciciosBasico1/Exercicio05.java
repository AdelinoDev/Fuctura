package exerciciosBasicos1;

import java.util.Scanner;

/* Crie um programa que leia o valor de um empréstimo, a taxa de juros mensal 
 e o número de meses e escreva o valor da parcela mensal do empréstimo.*/

public class Exercicio05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o valor do emprestimo: ");
		double valorEmprestimo = sc.nextDouble();
		System.out.print("Informe a taxa de juros mensal em (%): ");
		double taxaJurosMensal = sc.nextDouble() / 100;
		System.out.print("Informe o numero de meses: ");
		int numeroMeses = sc.nextInt();
		
		double valorParcelaMensal = (valorEmprestimo * taxaJurosMensal) / 
				                    (1 - Math.pow(1 + taxaJurosMensal, -numeroMeses));
		
		System.out.printf("Valor da parcela mensal do emprestimo: %.3f", valorParcelaMensal);
		
		sc.close();
	}

}
