package model;

public class Passageiro extends Usuario{

   private String metodosPagamento ;

   public Passageiro(String cpf, String email, String nome, String senha, String telefone, String metodosPagamento) {
      super(cpf, email, nome, senha, telefone);
       this.metodosPagamento = metodosPagamento;
   }

   public String getMetodosPagamento() {
      return metodosPagamento;
   }

   public void setMetodosPagamento(String metodosPagamento) {
      this.metodosPagamento = metodosPagamento;
   }
}

