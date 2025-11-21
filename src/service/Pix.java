package service;

public class Pix {
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
    // falta a lógica do preço da corrida
}
