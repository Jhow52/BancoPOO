import java.util.Scanner;

public class Main {

    private static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Banco banco = new Banco();
        ContaCorrente contaCorrente = new ContaCorrente(cliente, banco);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente, banco);
        Conta conta = new Conta(cliente, banco);
        int opcao = -1;

        do{
            System.out.println("1 - Ver dados");
            System.out.println("2 - Ver saldo");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Inserir dados");
            System.out.println("0 - Sair");
            opcao = entrada.nextInt();

            System.out.println("---------------------------");
            switch (opcao){
                case 1 -> {
                    System.out.println("-----Conta Corrente-----");
                    contaCorrente.imprimirInfos();
                    System.out.println("-----Conta Poupança-----");
                    contaPoupanca.imprimirInfos();
                }
                case 2 -> {
                    System.out.println("Saldo atual Conta Corrente: R$ " + contaCorrente.saldo);
                    System.out.println("Saldo atual Conta Poupança: R$ " + contaPoupanca.saldo);
                    double saldoTotal = contaCorrente.saldo + contaPoupanca.saldo;
                    System.out.println("Saldo atual Total:  R$ " + saldoTotal);
                }
                case 3 -> {
                    depositarConta(contaCorrente);
                    depositarConta(contaPoupanca);
                }
                case 4 -> {
                    sacarDinheiro(contaCorrente);
                    sacarDinheiro(contaPoupanca);
                }
                case 5 -> {
                    inserirNome(cliente);
                    nomeDoBanco(banco);
                    inserirNumeroConta(banco);
                    inserirAgencia(banco);
                }
            }
            System.out.println("---------------------------");
        }while(opcao != 0);
    }
    public static void inserirNome(Cliente cliente){
        System.out.println("Insira o nome do cliente: ");
        String nome = entrada.next();
        cliente.setNome(nome);
    }
    public static void nomeDoBanco(Banco banco){
        System.out.println("Insira o nome do seu banco: ");
        String nomeBanco = entrada.next();
        banco.setNomeBanco(nomeBanco);
    }
    public static void inserirAgencia(Banco banco){
        System.out.println("Insira a sua agencia: ");
        int agencia = entrada.nextInt();
        banco.setAgencia(agencia);
    }
    public static void inserirNumeroConta(Banco banco){
        System.out.println("Insira o numero da sua conta: ");
        int numero = entrada.nextInt();
        banco.setNumero(numero);
    }
    public static void depositarConta(Conta conta) {
        System.out.print("Você quer fazer um depósito na " + conta.getClass().getCanonicalName() + "? 1=Sim, 2=Não: ");
        int opcao = entrada.nextInt();
        if (opcao == 1) {
            System.out.print("Insira o valor que você quer depositar: ");
            double valor = entrada.nextDouble();
            if (valor <= 0) {
                System.out.println("Não é possível depositar R$ 0,00 ou menos.");
            } else {
                conta.depositar(valor);
            }
        } else {
            System.out.println("Nenhum depósito realizado.");
        }
    }

    public static void sacarDinheiro(Conta conta){
        System.out.println("Você quer fazer um saque na " + conta.getClass().getCanonicalName() + "? 1=Sim, 2= Não: ");
        int opcao = entrada.nextInt();
        if(opcao == 1){
            System.out.print("Insira o valor que você quer sacar: ");
            double valor = entrada.nextDouble();
            if(valor <= conta.saldo){
                conta.sacar(valor);
                System.out.println("Saque de: " + valor);
            }else {
                System.out.println("Saldo insuficiente");
            }
        }
    }
}