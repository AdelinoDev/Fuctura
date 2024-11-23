package exerciciosDeCondiconal;
/*Implemente um sistema de semáforo usando switch case. 
 Receba um estado (vermelho, amarelo ou verde) e determine a ação apropriada.*/
import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Informe estado do semafaro (vermelho, amarelo ou verde): ");
		String estado = sc.next().toUpperCase();
		
		
		switch(estado) {
		case "VERMELHO": System.out.println("PARE!");break;
		case "VERDE": System.out.println("PODE SEGUIR!");break;
		case "AMARELO": System.out.println("ATEÇÃO!");break;
		default: System.out.println("Opção Invalida!");
		}
		
		System.out.println("\nFIM!");
		
		sc.close();

	}

}
