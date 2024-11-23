package exerciciosDeCondiconal;
/*Desenvolva um conversor que recebe uma unidade de medida (metro, centímetro, quilômetro) e 
 para outra unidade com base na entrada.*/
import java.util.Scanner;

public class Exercicio03 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a unidade de medida deseja \n"
				+ "1 -> metro\n"
				+ "2 -> centímetro\n"
				+ "3 -> quilômetro");
		int unidade = sc.nextInt();
		System.out.println("Informe o valor da unidade da medida. Por exe.: 100");
		double valor = sc.nextDouble();
		
		switch(unidade) {
		case 1: 
			System.out.println("Valor convertido de metros para centimetros: " + (valor*100.0));
			System.out.println("Valor convertido de metros para quilometros: " + (valor/100.0));
			break;
		case 2: 
			System.out.println("Valor convertido de centimetros para metros: " + (valor/100.0));
			System.out.println("Valor convertido de centimetros para quilometros: " + (valor/100000.0));
			break;
		case 3: 
			System.out.println("Valor convertido de quilometros para metros: " + (valor/1000.0));
			System.out.println("Valor convertido de quilometros para centimentros: " + (valor/100000.0));
			break;
		default: System.out.println("Opção Inválida!!");
		}
		
		System.out.println("FIM!");
		
		sc.close();
	}

}
