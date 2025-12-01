package service;

public class Cartão extends PagamentoService {
    private int numero;
    private String senha;
    public Cartão(int numero, String senha) {
        this.numero = numero;
        this.senha = senha;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public boolean processarPagamento(double valor){
        return true;
    }
}
