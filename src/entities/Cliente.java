package entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private long id;
    private String nome;
    private String cpf;
    private int idade;
    private ArrayList<Conta> contas = new ArrayList<>();

    private static long proximoId = 1;
    //---------------------------------------------------------------

    public Cliente(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.id = proximoId;
        proximoId++;
    }
    //---------------------------------------------------------------

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    //---------------------------------------------------------------

    @Override
    public String toString() {
        return  "nome='" + nome + "'|" +
                "cpf='" + cpf + "'|";
    }
}
