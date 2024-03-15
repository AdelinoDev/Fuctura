package concessionaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carro extends Cliente{

    private String placa;
    private String marca;
    private String modelo;
    private int ano;
    private float valorAproximado;
    private Cliente dono;

    private List<Carro> listaCarros = new ArrayList<>();

    public Carro(){
        super();
    }

    public Carro(Cliente dono, String placa, String marca, String modelo,
     int ano, float valorAproximado, List<Carro> listaCarros) {
        super();

        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorAproximado = valorAproximado;
        this.listaCarros = listaCarros;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getValorAproximado() {
        return valorAproximado;
    }

    public void setValorAproximado(float valorAproximado) {
        this.valorAproximado = valorAproximado;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public List<Carro> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(List<Carro> listaCarros) {
        this.listaCarros = listaCarros;
    }

    public void cadastraCarro() {
        Scanner sc = new Scanner(System.in);
        Carro carro = new Carro();

        System.out.println("Digite a placa do carro: ");
        carro.setPlaca(sc.next());
        System.out.println("Digite a marca do carro: ");
        carro.setMarca(sc.next());
        System.out.println("Digite o modelo do carro: ");
        carro.setModelo(sc.next());
        System.out.println("Digite o ano do carro: ");
        carro.setAno(sc.nextInt());
        System.out.println("Digite o preço do carro: ");
        carro.setValorAproximado(sc.nextFloat());

        listaCarros.add(carro);

    }

    public void pesquisarPorPlaca() {
        Scanner sc = new Scanner(System.in);

        boolean encontrado = false;

        System.out.println("Digite o número da placa do carro: ");
        String placaCarro = sc.next();

        for (int i = 0; i < listaCarros.size(); i++) {
            if (listaCarros.get(i).getPlaca().equals(placaCarro)) {
                System.out.println("#####################################################################################");
                System.out.println("Placa do carro encontrado com SUCESSO!!");
                System.out.println("Placa: " + listaCarros.get(i).getPlaca() + " | "
                        + "Marca: " + listaCarros.get(i).getMarca() + " | "
                        + " Modelo: " + listaCarros.get(i).getModelo() + " | "
                        + "Ano: " + listaCarros.get(i).getAno() + " | "
                        + "Preço: " + listaCarros.get(i).getValorAproximado());
                System.out.println("#####################################################################################");
                System.out.println("");

                encontrado = true;
                break;
            }

            if (!encontrado) {
                System.err.println("CARRO COM A PLACA " + placaCarro + " NÃO ENCONTRADO.");
            }
        }
    }

    public void removerPorPlca() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a placa do carro ao qual será removido: ");
        String removerPlaca = sc.next();

        for (int i = 0; i < listaCarros.size(); i++) {
            System.out.println(listaCarros.get(i).getPlaca());

            if (listaCarros.get(i).getPlaca().equals(removerPlaca)) {
                System.out.println("Carro removido com sucesso!");
                break;
            } else {
                System.err.println("Carro não encontrado!");
            }
        }
    }

    public void listarCarro() {
        for (int i = 0; i < listaCarros.size(); i++) {
            System.out.println("#####################################################################################");
            System.out.println("Placa: " + listaCarros.get(i).getPlaca() + " | "
                                + "Marca: " + listaCarros.get(i).getMarca() + " | "
                                + " Modelo: " + listaCarros.get(i).getModelo() + " | "
                                + "Ano: " + listaCarros.get(i).getAno() + " | "
                                + "Preço: " + listaCarros.get(i).getValorAproximado());
            System.out.println("#####################################################################################");
            System.out.println("");
        }
    }

    public void atualizaPorPlaca() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a placa do carro ao qual queres atualizar: ");
        String atualizarPlaca = sc.next();

        for (int i = 0; i < listaCarros.size(); i++) {

            if (listaCarros.get(i).getPlaca().equals(atualizarPlaca)) {
                System.out.println("#####################################################################################");
                System.out.println("Digite a placa do carro: ");
                listaCarros.get(i).setPlaca(sc.next());
                System.out.println("Digite a marca do carro: ");
                listaCarros.get(i).setMarca(sc.next());
                System.out.println("Digite o modelo do carro: ");
                listaCarros.get(i).setModelo(sc.next());
                System.out.println("Digite o ano do carro: ");
                listaCarros.get(i).setAno(sc.nextInt());
                System.out.println("Digite o preço do carro: ");
                listaCarros.get(i).setValorAproximado(sc.nextFloat());
                System.out.println("#####################################################################################");

                break;
            } else {
                System.err.println("Placa não encontrada!");
            }
        }
    }
}
