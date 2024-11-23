package lacoDeRepeticao;

import java.util.Scanner;

/*Desenvolva um programa que use um loop while para gerar uma sequência de números pares a 
  partir de 2 e imprima cada número na tela até que o número gerado seja maior do que 20.*/
public class Exercicio05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 int numero = 2; 

	        while (numero <= 20) { // Condição para gerar números até 20
	            System.out.println(numero);
	            numero += 2; // Incrementa de 2 em 2 para gerar apenas números pares
	        }
				
		sc.close();
	}

}
