package concessionaria;

import java.util.ArrayList;
import java.util.List;

public class Loja {

    private List<Carro> carrosCadastrados = new ArrayList<>();

    private int quantidade;

    public Loja() {}

    public Loja(List<Carro> carrosCadastrados,  int quantidade) {
        this.carrosCadastrados = carrosCadastrados;
        this.quantidade = quantidade;
    }

    public List<Carro> getCarrosCadastrados() {
        return carrosCadastrados;
    }
    public void setCarrosCadastrados(List<Carro> carrosCadastrados) {
        this.carrosCadastrados = carrosCadastrados;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
