package service;

import Exceções.PagamentoRecusadoException;

public class PagamentoPix extends PagamentoService {
    private String chave;

    public PagamentoPix(String chave) {
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
            throw new PagamentoRecusadoException("Valor invalido para pagamentos via Pix!");
        }
        if (chave == null){
            throw new PagamentoRecusadoException("Necessário informar a chave Pix!");
        }

        System.out.println("Pagamento via PIX realizado com sucesso.");

        return true;
    }
}
