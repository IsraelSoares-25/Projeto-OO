package service;

import Exceções.PagamentoRecusadoException;

public class Cartão extends PagamentoService {
    private String numero;
    private String senha;
    private double valor;

    public Cartão(String numero, String senha) {
        this.numero = numero;
        this.senha = senha;
    }

    @Override
    public boolean processarPagamento(double valor)throws PagamentoRecusadoException {
        this.valor = valor;
        if (numero == null || numero.length() != 16){
            throw new PagamentoRecusadoException("o número do cartão requer 16 digitos: ");
        }
        System.out.println("Pagamento iniciado com sucesso.");
        return true;
    }


    public String getNumero() {
        return numero;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
