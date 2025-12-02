package service;

public abstract class PagamentoService {
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento...");
        return true;
    }
}
