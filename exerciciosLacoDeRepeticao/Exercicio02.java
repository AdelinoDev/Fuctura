package lacoDeRepeticao;

import java.util.Random;
import java.util.Scanner;

/*Implemente um jogo em que o computador escolhe um número aleatório entre 1 e 100, 
 e o jogador tenta adivinhar. O jogo continua até que o jogador acerte o número.*/
public class Exercicio02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		int numeroUsuario = 0;
		
		// Número inteiro aleatório entre 0 e 100
	    int numeroAleatorio = random.nextInt(100) + 1;
		
		do {
		    
		    System.out.print("Digite um numero entre 0 e 100: ");
		    numeroUsuario = sc.nextInt();
		    
		    if (numeroUsuario > numeroAleatorio) {
		    	System.out.println("O número é menor");
		    } else if(numeroUsuario < numeroAleatorio) {
		    	System.out.println("O número é maior");
		    } else {
		    	System.out.println("Parabens voce acertou!"); 
			    System.out.println("Número do computador: " + numeroAleatorio);
			    System.out.println("Número digitado: " + numeroUsuario);
		    }
		   
		    
		} while(numeroAleatorio != numeroUsuario);
	
	        
	    sc.close();    
	}

}
