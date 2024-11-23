package lacoDeRepeticao;
/*Peça ao usuário para inserir um número e imprima a tabuada desse número de 1 a 10*/
import java.util.Scanner;

public class Exercicio04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe um número para gerar a sua tabuada: ");
		int numero = sc.nextInt(); 
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(numero + " x " + i + " = " + (numero * i));
		}
		
		sc.close();
	}

}
