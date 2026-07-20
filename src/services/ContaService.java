package services;

import entities.Banco;
import entities.Cliente;
import entities.Conta;
import repository.BancoRepository;
import util.Cores;
import util.UtilidadesTexto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContaService extends Cores implements UtilidadesTexto  {
    private static Scanner sc = new Scanner(System.in);
    private final List<Banco> bancos = BancoRepository.getBancos();

    public String validarNome(String nome) {
        while(nome.length() < 3){
            System.out.println(RED+"Nome deve ter no minimo 3 caracteres"+RESET);
            System.out.println("Nome: ");
            nome = sc.nextLine();
        }
        return nome;
    }
    public String validarCPF(String cpf) {
        while(cpf.length() < 11){
            System.out.println(RED+"CPF deve ter no minimo 11 caracteres"+RESET);
            System.out.println("CPF: ");
            cpf = sc.nextLine();
        }
        return cpf;
    }
    public int validarIdade(int idade) {
        while(idade < 0 || idade > 130){
            System.out.println(RED+"Idade inválida"+RESET);
            System.out.println("Idade: ");
            idade = sc.nextInt(); sc.nextLine();
        }
        return idade;
    }
    //-----------------------------------------------------------------

    public Cliente criarCliente() {
        System.out.print("Digite seu nome:");
        String nome = sc.nextLine().trim().toLowerCase();
        nome = validarNome(nome);

        System.out.print("Digite seu cpf:");
        String cpf = sc.nextLine().trim().toLowerCase();
        cpf = validarCPF(cpf);

        System.out.print("Digite sua idade:");
        int idade = sc.nextInt();
        sc.nextLine();
        idade = validarIdade(idade);

        Cliente cliente = new Cliente(nome,cpf,idade);
        return cliente;
    }
    public void escolherBanco(Conta conta) {

        System.out.println(GREEN + "Em qual banco deseja criar a conta?" + RESET);
        for(int  i = 0; i < bancos.size(); i++){
            System.out.println("[" + (i + 1) + "] " + bancos.get(i).getNome());
        }

        int opcao;

        while (true) {

            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());

                if (opcao >= 1 && opcao <= bancos.size()) {
                    break;
                }

                System.out.println(RED + "Banco inválido!" + RESET);

            } catch (NumberFormatException e) {
                System.out.println(RED + "Digite apenas números!" + RESET);
            }
        }

        Banco banco = bancos.get(opcao - 1);

        conta.setBanco(banco);
        banco.setContas(conta);
    }

    public void criarConta(){
        System.out.println(centralizarTitulo("CADASTRO",31));

        Cliente cliente = criarCliente();
        Conta conta = new Conta(cliente);

        escolherBanco(conta);

        cliente.getContas().add(conta);

        System.out.println("Conta criada com sucesso!");

    }

    public Conta localizarConta(){
        System.out.print("Digite o nome de usuário: ");
        String nome = sc.nextLine().trim().toLowerCase();
        System.out.print("Digite o CPF da conta: ");
        String cpf = sc.nextLine().trim().toLowerCase();

        List<Conta> contasEncontradas = new ArrayList<>();
        for(Banco banco: bancos){
            for(Conta conta: banco.getContas()){
                if(nome.equals(conta.getTitular().getNome()) && cpf.equals(conta.getTitular().getCpf())){
                    contasEncontradas.add(conta);
                }
            }
        }

        if(contasEncontradas.isEmpty()){
            System.out.println("Nenhuma conta encontrada!");
            return null;
        }
        if(contasEncontradas.size()==1){
            return contasEncontradas.get(0);
        }
        int i = 1;
        centralizarTitulo("CONTAS ENCONTRADAS",31);
        for(Conta conta: contasEncontradas){
            System.out.println("[" +i+ "]"+conta.getTitular() +" | "+ conta.getBanco().getNome());
            i++;
        }
        System.out.print("Escolha: ");

        int opcao = sc.nextInt();
        sc.nextLine();

        return contasEncontradas.get(opcao-1);
    }

    public void buscarConta(){

        Conta conta = localizarConta();

        if(conta != null){
            utilizarConta(conta);
        }
    }

    public void utilizarConta(Conta conta){
        boolean logado = true;
        while(logado){
            System.out.println("Seja bem vindo, "+UtilidadesTexto.capitalizeFirstLetter(conta.getTitular().getNome()) +" ao banco "+conta.getBanco().getNome()+"!");

            menuInterface();

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1: depositar(conta); break;
                case 2: sacar(conta); break;
                case 3: transferir(conta); break;
                case 4: mostrarExtrato(conta); break;
                case 5: logado = false; break;
            }
        }
    }

    public void depositar(Conta conta){
        System.out.print("Quanto deseja depositar? ");
        double qtd = sc.nextInt();
        sc.nextLine();
        conta.setSaldo(conta.getSaldo()+qtd);
    }
    public void sacar(Conta conta){
        System.out.print("Quanto deseja sacar? ");
        double qtd = sc.nextInt();
        sc.nextLine();
        conta.setSaldo(conta.getSaldo()-qtd);
    }
    public void transferir(Conta suaConta){

        Conta conta = localizarConta();

        System.out.print("Quanto deseja transferir? ");
        double qtd = sc.nextDouble();
        sc.nextLine();

        conta.setSaldo(conta.getSaldo()+qtd);
        suaConta.setSaldo(suaConta.getSaldo()-qtd);

    }
    public void mostrarExtrato(Conta conta){
        centralizarTitulo("EXTRATO",31);
        System.out.println("Nome: "+conta.getTitular().getNome());
        System.out.println("CPF: "+conta.getTitular().getCpf());
        System.out.println("Saldo: "+conta.getSaldo());
        System.out.println("Número: "+conta.getNumero());
        System.out.println("Banco: "+conta.getBanco());
    }

}
