package entidades;
import java.util.ArrayList;
import java.util.List;

public class Passageiro extends Usuario{

   private List<String> metodosPagamento;
   private Corrida corridaAtual;

   public Passageiro(String cpf, String email, String nome, String senha, String telefone, String metodosPagamento) {
      super(cpf, email, nome, senha, telefone);
       this.metodosPagamento = new ArrayList<>();
       this.metodosPagamento.add(metodosPagamento);
   }

   public List<String> getMetodosPagamento() {
      return metodosPagamento;
   }

   public void setMetodosPagamento(List<String> metodosPagamento) {
      this.metodosPagamento = metodosPagamento;
   }

   public Corrida getCorridaAtual() {
      return corridaAtual;
   }

   public void solicitarCorrida(String origem, String destino){

      Corrida novaCorrida = new Corrida(this, origem, destino);

      this.corridaAtual= novaCorrida;
      System.out.println("Solicitando viagem de " + origem + " para " + destino + ". Aguarde!");
   }
}

