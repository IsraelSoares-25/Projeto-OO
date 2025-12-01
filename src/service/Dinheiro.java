package service;

public class Dinheiro extends PagamentoService {
    private int valor;
    public Dinheiro(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public boolean processarPagamento(double valor) {
        return true;
    }
}
