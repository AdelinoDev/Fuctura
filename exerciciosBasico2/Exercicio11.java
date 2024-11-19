package ExercicioBasico2;

import java.util.Scanner;

/* Escreva um programa que leia o peso e a altura de uma pessoa e 
   calcule o seu índice de massa corporal (IMC). 

Fórmula do IMC: peso / (altura * altura). 

De acordo com o IMC, mostre a classificação da pessoa: 

IMC:Abaixo de 18,5  Classificação:Abaixo do peso

IMC:Entre 18,5 e 24,9 Classificação:Peso normal

IMC:Entre 25 e 29,9 Classificação:Sobrepeso

IMC:Entre 30 e 34,9 Classificação:Obesidade grau I

IMC:Entre 35 e 39,9 Classificação:Obesidade grau II

IMC:Acima de 40 Classificação:Obesidade grau III*/
public class Exe11 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe o peso em (Kg): ");
		double peso = sc.nextDouble();
		System.out.print("Informe a altura em (metros): ");
		double altura = sc.nextDouble();
		
		double imc = peso / Math.pow(altura, 2);
		
		System.out.printf("Valor do IMC: %.2f%n", imc);
		
		if (imc > 40.0) {
			System.out.println("Obesidade grau III!");
		} else if (imc > 35.0) {
			System.out.println("Obesidade grau II!");
		} else if (imc > 30.0) {
			System.out.println("Obesidade grau I!");
		} else if (imc > 25.0) {
			System.out.println("Sobrepeso!");
		} else if (imc > 18.5) {
			System.out.println("Normal!");
		} else {
			System.out.println("Abaixo do peso!");
		}
		
		sc.close();

	}

}
