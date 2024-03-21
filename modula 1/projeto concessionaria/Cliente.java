package concessionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {

    private String telefone;
    private String nome;

    private List<Cliente> listaClientes = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String cpf, String endereco, int idade, String telefone, String nome, List<Cliente> listaClientes) {

        super(cpf, endereco, idade);

        this.telefone = telefone;
        this.nome = nome;
        this.listaClientes = listaClientes;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void cadastraCliente() {
        //cpf, endereco, idade
        Scanner sc = new Scanner(System.in);
        Cliente cl = new Cliente();

        System.out.println("Digite o seu nome: ");
        cl.setNome(sc.nextLine());
        System.out.println("Digite o seu telefone: ");
        cl.setTelefone(sc.next());

        System.out.println("Digite o seu CPF: ");
        cl.setCpf(sc.next());
        System.out.println("Digite o seu endereço: ");
        cl.setEndereco(sc.next());
        System.out.println("Digite a sua idade: ");
        cl.setIdade(sc.nextInt());

        listaClientes.add(cl);

    }

    public void listarCliente() {

        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println("#####################################################################################");
            System.out.println("Nome: " + listaClientes.get(i).getNome() + " | "
                    + "Telefone: " + listaClientes.get(i).getTelefone() + " | "
                    + "CPF: " + listaClientes.get(i).getCpf() + " | "
                    + "Endereço: " + listaClientes.get(i).getEndereco() + " | "
                    + "Idade: " + listaClientes.get(i).getIdade());
            System.out.println("#####################################################################################");
            System.out.println("");
        }
    }

    public void pesquisaClientePorCPF() {
        Scanner sc = new Scanner(System.in);

        boolean encontrado = false;

        System.out.print("Digite o número do CPF: ");
        String clienteCpf = sc.next();


        for (int i = 0; i < listaClientes.size(); i++) {

            if (listaClientes.get(i).getCpf().equals(clienteCpf)) {
                System.out.println("#####################################################################################");
                System.out.println("CLIENTE ENCONTRADO");
                System.out.println("Nome: " + listaClientes.get(i).getNome());
                System.out.println("Telefone: " + listaClientes.get(i).getTelefone());
                System.out.println("Endereço: " + listaClientes.get(i).getEndereco());
                System.out.println("Idade: " + listaClientes.get(i).getIdade());
                System.out.println("#####################################################################################");

                encontrado = true;
                break; // Sai do loop assim que o cliente é encontrado
            }
        }

        if (!encontrado) {
            System.err.println("CLIENTE COM O  CPF " + clienteCpf + " NÃO ENCONTRADO.");
        }
    }

    public void pesquisarPorIdade() {
        double idadeMaisVelha = listaClientes.get(0).getIdade();

        for(int i = 0; i < listaClientes.size(); i++) {

            if (listaClientes.get(i).getIdade() > idadeMaisVelha) {
                idadeMaisVelha = listaClientes.get(i).getIdade();

                System.out.println("#####################################################################################");
                System.out.println("Nome: " + listaClientes.get(i).getNome());
                System.out.println("Telefone: " + listaClientes.get(i).getTelefone());
                System.out.println("Endereço: " + listaClientes.get(i).getEndereco());
                System.out.println("Idade: " + listaClientes.get(i).getIdade());
                System.out.println("#####################################################################################");


            }
        }
    }
}

