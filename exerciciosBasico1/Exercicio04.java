package exerciciosBasicos1;

import java.util.Scanner;

/*CCrie um programa que leia o número de horas trabalhadas por um funcionário e o valor da hora de trabalho 
 * e escreva o salário bruto desse funcionário.*/
public class Exercicio04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o nome do funcionario: ");
		String nome = sc.nextLine();
		System.out.print("Informe a quantidade de horas trabalhada: ");
		double quantidadeHoras = sc.nextDouble();
		System.out.print("Informe o valor da hora de trabalho: ");
		double valorHora = sc.nextDouble();
		
		double salarioBruto = quantidadeHoras * valorHora;
		
		System.out.println("Salario bruto do funcionario: " + salarioBruto);
		
		sc.close();
	}

}
