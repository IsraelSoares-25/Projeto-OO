package service;

import Exceções.PagamentoRecusadoException;

public class PagamentoCartao extends PagamentoService {
    private String numero;
    private String senha;

    public PagamentoCartao(String numero, String senha) {
        this.numero = numero;
        this.senha = senha;
    }

    @Override
    public boolean processarPagamento(double valor)throws PagamentoRecusadoException {
        if(valor <= 0){
            throw new PagamentoRecusadoException("Valor inválido para pagamentos!");
        }

        if (numero == null || numero.length() != 16){
            throw new PagamentoRecusadoException("O número do cartão requer 16 digitos!");
        }

        if (senha ==  null || senha.length()<4){
            throw new PagamentoRecusadoException("Senha Invalida");
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
