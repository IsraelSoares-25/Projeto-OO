package service;

import Exceções.PagamentoRecusadoException;
import entidades.Corrida;

public class Pix extends PagamentoService {
    private String chave;

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

        if (valor <= 0) {
            throw new PagamentoRecusadoException("Valor inválido para pagamentos via PIX!");
        }
        if (chave == null){
            throw new PagamentoRecusadoException("Necessário informar a chave Pix!");
        }

        System.out.println("Pagamento via PIX realizado com sucesso.");

        return true;
    }
}
