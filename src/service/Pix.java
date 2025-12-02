package service;

import Exceções.PagamentoRecusadoException;
import entidades.Corrida;

public class Pix extends PagamentoService {
    private String chave;
    private Corrida corrida;
    public Pix(String chave) {
        this.chave = chave;
    }
    public String getChave() {
        return chave;
    }
    public void setChave(String chave) {
        this.chave = chave;
    }
    public boolean processarPagamento(double valor) throws PagamentoRecusadoException {
        double corridaPreco=this.corrida.getPreco();
        if (valor < this.corrida.getPreco()) {
            throw new PagamentoRecusadoException("Saldo insuficiente");
        }
        System.out.println("Valor da corrida: " + corridaPreco);
        return true;
    }
}
