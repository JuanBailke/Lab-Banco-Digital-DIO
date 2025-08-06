import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Conta implements ContaInterface {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes;

    public Conta (Cliente cliente){
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque deve ser positivo.");
            return;
        }
        if (saldo < valor) {
            System.out.println("Saldo insuficiente para saque na conta " + this.numero + ".");
            return;
        }
        saldo -= valor;
        this.transacoes.add(new Transacao(TipoTransacao.SAQUE, valor, "Saque em terminal"));
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito deve ser positivo.");
            return;
        }
        saldo += valor;
        this.transacoes.add(new Transacao(TipoTransacao.DEPOSITO, valor, "Depósito em conta"));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor <= 0) {
            System.out.println("Valor de transferência deve ser positivo.");
            return;
        }
        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para transferência na conta " + this.numero + ".");
            return;
        }
        if (this == contaDestino) {
            System.out.println("Não é possível transferir para a mesma conta.");
            return;
        }

        this.saldo -= valor;
        this.transacoes.add(new Transacao(TipoTransacao.TRANSFERENCIA_ENVIADA, valor, "Para conta " + contaDestino.getNumero()));

        contaDestino.receberTransferencia(valor, this);
    }

    protected void receberTransferencia(double valor, Conta contaOrigem) {
        this.saldo += valor;
        this.transacoes.add(new Transacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor, "Da conta " + contaOrigem.getNumero()));
    }

    protected void imprimirInfosComuns() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("CPF: " + this.cliente.getCpf());
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.println("--- Histórico de Transações ---");
        if (this.transacoes.isEmpty()) {
            System.out.println("Não foram realizadas movimentações.");
        } else {
            this.transacoes.forEach(System.out::println);
        }
        System.out.printf("Saldo Atual: R$ %.2f%n%n", this.saldo);
    }
}
