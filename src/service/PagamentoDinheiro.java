package service;

import Exceções.PagamentoRecusadoException;
import Exceções.SaldoInsuficienteException;
import entidades.Corrida;

public class PagamentoDinheiro extends PagamentoService {

    private double valorEmDinheiro;
    private Corrida corrida;

    public PagamentoDinheiro(Corrida corrida, double valorEmDinheiro) {
        this.valorEmDinheiro = valorEmDinheiro;
        this.corrida = corrida;
    }

    public double getvalorEmDinheiro() {
        return valorEmDinheiro;
    }

    public void setvalorEmDinheiro(double valor) {
        this.valorEmDinheiro = valor;
    }

    public boolean processarPagamento(double valor) throws SaldoInsuficienteException {
        double preco = corrida.getPreco();

        if (valorEmDinheiro < preco) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        System.out.println("Pagamento em dinheiro realizado.");
        System.out.println("Valor da corrida: " + preco);
        System.out.println("Valor entregue: " + valorEmDinheiro);
        System.out.println("Troco: " + (valorEmDinheiro - preco));

        return true;
    }
}
