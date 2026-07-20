package repository;

import entities.Banco;

import java.util.ArrayList;
import java.util.List;

public class BancoRepository {
    private static final List<Banco> bancos = new ArrayList<>();

    static {
        bancos.add(new Banco("Itaú"));
        bancos.add(new Banco("Santander"));
        bancos.add(new Banco("Bradesco"));
        bancos.add(new Banco("Caixa"));
    }

    public static List<Banco> getBancos(){
        return bancos;
    }
}
