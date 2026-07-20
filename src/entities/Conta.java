package entities;

public class Conta {
    private Cliente titular;
    private Banco banco;
    private long numero; //ID
    private double saldo;
    private static long proximoNum = 1;
    //---------------------------------------------------------------

    public Conta(Cliente titular) {
        this.titular = titular;
        this.numero = proximoNum;
        proximoNum++;
    }
    //---------------------------------------------------------------

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo>0){
            this.saldo = saldo;
        }
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    //---------------------------------------------------------------

    @Override
    public String toString() {
        return "Conta{" +
                "titular=" + titular.getNome()+'-'+titular.getCpf()+
                ", nomeBanco='" + banco + '\'' +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
//--------------------------METHODS------------------------------

}