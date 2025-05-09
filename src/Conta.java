public class Conta {

    protected double saldo;
    protected Cliente cliente;
    protected Banco banco;

    public Conta(Cliente cliente, Banco banco){
        this.banco = banco;
        this.cliente = cliente;
    }

    public void sacar(double saldo){
        this.saldo -= saldo;
    }

    public void depositar(double saldo){
        this.saldo += saldo;
    }

    protected void imprimirInfos(){
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Banco: " + banco.getNomeBanco());
        System.out.println("Agência: " + banco.getAgencia());
        System.out.println("Número: " + banco.getNumero());
        System.out.println("Saldo: " + saldo);
    }
}
