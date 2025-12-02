package service;

import Exceções.PagamentoRecusadoException;
import entidades.Corrida;

public class Dinheiro extends PagamentoService {
    private int valor;
    private Corrida corrida;
    public Dinheiro(Corrida corrida, int valor) {
        this.valor = valor;
        this.corrida = corrida;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public boolean processarPagamento(double valor)throws PagamentoRecusadoException {
        double corridaPreco=this.corrida.getPreco();
        if (valor < this.corrida.getPreco()) {
            throw new PagamentoRecusadoException("Saldo insuficiente");
        }
        System.out.println("Valor total de corrida: " + corridaPreco);
        return true;
    }
}
