package view;

import services.ContaService;
import util.Cores;
import util.UtilidadesTexto;

import java.util.Scanner;

public class Menu extends Cores implements UtilidadesTexto {

    public void iniciar(){
        Scanner sc = new Scanner(System.in);
        ContaService cs = new ContaService();

        boolean terminar = false;

        while (!terminar){
            System.out.println(centralizarTitulo("BANCO JAVA",31));
            menuInicio();
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1: cs.criarConta(); break;
                case 2: cs.buscarConta(); break;
                case 3: terminar = true; break;
                default:
                    System.out.println(RED+"Opção inválida! Tente novamente!"+RESET);
            }

        }
    }

}
