package service;

public class Cartão {
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
    public void processarPagamento(double valor){
        //saldo do cartão pensado em débito
    }
}
