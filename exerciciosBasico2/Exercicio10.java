package ExercicioBasico2;

import java.util.Scanner;

/* Escreva um programa que leia o salário de um funcionário e 
aplique um aumento de acordo com a seguinte tabela: 

Faixa salarial: Até R$ 1.500,00 
Percentual de Aumento: 15% 

Faixa Salarial: De R$ 1.500,01 até R$ 2.500,00 Percentual de Aumento: 10% 

Faixa Salarial: Acima de R$ 2.500,00 
Percentual de Aumento: 5%*/
public class Exe10 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a salario do funcionario: ");
		double salario = sc.nextDouble();

		if (salario > 2500.00) {
			salario = salario + (salario * 0.05);
			System.out.println("Salario com aumento: " + salario);
		} else if (salario > 1500.00) {
			salario = salario + (salario * 0.10);
			System.out.println("Salario com aumento: " + salario);
		} else {
			salario = salario + (salario * 0.15);
			System.out.println("Salario com aumento: " + salario);
		}
		
		sc.close();
		
	}

}
