package util;

import java.util.Scanner;

import static util.Cores.*;


public interface UtilidadesTexto{

    public default String centralizarTitulo(String titulo, int largura){
        //centraliza o titulo na largura desejada
        int espacos = (largura - titulo.length()) / 2;
        String padding = " ".repeat(espacos);
        return(
                GREEN+BLACK_BG+ "===============================\n"
                + padding + titulo+
                "\n==============================="+RESET);
    }
    //interface principal de escolhas do Menu
    public default void menuInterface(){
        System.out.println(centralizarTitulo("MENU",31));
        System.out.println("[1] DEPOSITAR");
        System.out.println("[2] SACAR");
        System.out.println("[3] TRANSFERIR");
        System.out.println("[4] MOSTRAR EXTRATO");
        System.out.println("[5] SAIR"+RESET);
    }
    default void menuInicio(){
        System.out.println(centralizarTitulo("INICIO",31));
        System.out.println("[1] CRIAR CONTA");
        System.out.println("[2] Entrar em uma conta");
        System.out.println("[3] Sair");
    }

     static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }


}
