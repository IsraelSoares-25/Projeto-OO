package service;

public class Cartão extends PagamentoService {
    private String numero;
    private String senha;
    private double valor;

    public Cartão(String numero, String senha) {
        this.numero = numero;
        this.senha = senha;
    }

    @Override
    public boolean processarPagamento(double valor){
        this.valor = valor;
        if (numero != null && numero.length() == 16){
            System.out.println("Processando pagamento no cartão");
            return true;
        } else {
            System.out.println("Falha no pagamento"); //add exceptions
            return false;
        }
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
