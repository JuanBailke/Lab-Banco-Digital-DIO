public class Main {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan", "12345678900");
        Cliente cliente2 = new Cliente("Felipe", "09876543211");

        Conta cc1 = new ContaCorrente(cliente1);
        Conta poupanca1 = new ContaPoupanca(cliente1);
        Conta cc2 = new ContaCorrente(cliente2);
        Conta poupanca2 = new ContaPoupanca(cliente2);

        System.out.println("--- Realizando Operações ---");
        cc1.depositar(100);
        poupanca1.depositar(200);
        cc1.transferir(50, cc2);
        cc2.transferir(20, poupanca2);
        poupanca2.sacar(10);
        cc2.sacar(5);
        cc2.transferir(30, poupanca1);
        poupanca1.transferir(15, cc1);
        System.out.println("--- Operações Finalizadas ---\n");

        cc1.imprimirExtrato();
        poupanca1.imprimirExtrato();
        cc2.imprimirExtrato();
        poupanca2.imprimirExtrato();
    }
}
