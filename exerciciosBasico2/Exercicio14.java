package ExercicioBasico2;
/*Escreva um programa que leia a hora atual em formato 24 horas (0 a 23) e 
 mostre uma saudação de acordo com o período do dia. 

Se a hora não estiver nesse intervalo, o programa deve mostrar “Hora inválida”.

Por exemplo, se a hora for 8, o programa deve mostrar “Bom dia”.*/
import java.util.Scanner;

public class Exe14 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a hora atual: ");
		int hora = sc.nextInt();
		
		if (hora > 23 || hora < 0) {
			System.out.println("Hora inválida!");
		} else if (hora >= 6 && hora <= 12) {
			System.out.println("Bom dia!");
		} else if (hora >12  && hora <= 18) {
			System.out.println("Boa tarde!");
		} else {
			System.out.println("Boa noite!");
		}
		
		sc.close();
	}

}
