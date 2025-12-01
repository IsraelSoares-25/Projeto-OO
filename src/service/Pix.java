package service;

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
    public boolean processarPagamento(double valor) {
        return true;
    }
}
