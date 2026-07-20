package entities;

import java.util.ArrayList;

public class Banco {
    private String nome;
    private ArrayList<Conta> contas = new ArrayList<>();
    //---------------------------------------------------------------

    public Banco(String nome) {
        this.nome = nome;
    }
    //---------------------------------------------------------------

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(Conta conta) {
        this.contas.add(conta);
    }
    //---------------------------------------------------------------


    public Banco(String nome, ArrayList<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "Banco:" + nome;
    }
}
