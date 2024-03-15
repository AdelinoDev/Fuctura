package concessionaria;

import java.util.Scanner;

public class Aplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Carro carro = new Carro();

        int opcao = 0;

        do {
            System.out.println("######## CONCESSIONARIO FUCTURA ########\n");

            System.out.println("######## CAMPO CLIENTES ########\n");
            System.out.println("1 ->  PARA CADASTRAR CLIENTES");
            System.out.println("2 ->  PARA LISTAR CLIENTES");
            System.out.println("3 ->  PARA PESQUISAR CLIENTE POR CPF");
            System.out.println("4 ->  PARA BUSCAR CLIENTE MAIS VELHO\n");

            System.out.println("######## CAMPO CARRO ########\n");

            System.out.println("5 ->  PARA CADASTRAR CARRO");
            System.out.println("6 ->  PARA PESQUISAR POR PLACA");
            System.out.println("7 ->  PARA REMOVER POR PLACA");
            System.out.println("8 ->  PARA LISTAR CARRO");
            System.out.println("9 ->  PARA ATUALIZAR POR PLACA");
            System.out.println("0 -> PARA SAIR DO PROGRAMA");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    cliente.cadastraCliente();
                    break;
                case 2:
                    cliente.listarCliente();
                    break;
                case 3:
                    cliente.pesquisaClientePorCPF();
                    break;
                case 4:
                    cliente.pesquisarPorIdade();
                    break;
                case 5:
                    carro.cadastraCarro();
                    break;
                case 6:
                    carro.pesquisarPorPlaca();
                    break;
                case 7:
                    carro.removerPorPlca();
                    break;
                case 8:
                    carro.listarCarro();
                    break;
                case 9:
                    carro.atualizaPorPlaca();
                    break;
                case 0:
                    System.out.println("FIM PROGRAMA.");
                    break;
                default:
                    System.err.println("OPÇÃO INVÁLIDA!!!!!");
            }


        } while (opcao != 0);



        sc.close();
    }
}
