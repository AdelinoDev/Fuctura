package concessionaria;

public class Pessoa {

    private String cpf;
    private String endereco;
    private int idade;

    public Pessoa(){}

    public Pessoa(String cpf, String endereco, int idade) {
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
