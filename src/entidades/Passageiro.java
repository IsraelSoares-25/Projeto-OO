package entidades;
import Exceções.EstadoInvalidoDaCorridaException;
import java.util.ArrayList;
import java.util.List;

public class Passageiro extends Usuario{

   private List<String> metodosPagamento;
   private Corrida corridaAtual;


   public Passageiro(String nome, String cpf, String email, String telefone, String senha, String metodosPagamentoInicial) {
       super(nome, cpf, email, telefone, senha);
       this.metodosPagamento = new ArrayList<>();
       if (metodosPagamentoInicial != null && !metodosPagamentoInicial.isEmpty()){
           this.metodosPagamento.add(metodosPagamentoInicial);
       }

   }

   public List<String> getMetodosPagamento() {
      return metodosPagamento;
   }

   public void adicionarMetodoPagamento(String metodo) {
        if (metodo != null && !metodo.isEmpty()) {
            metodosPagamento.add(metodo);
        }
   }

   public Corrida getCorridaAtual() {
      return corridaAtual;
   }

   public void solicitarCorrida(String origem, String destino) {
       this.corridaAtual= new Corrida(this, origem, destino);
       System.out.println("Solicitando viagem de " + origem + " para " + destino + ". Aguarde!");
   }

   public void cancelarCorrida()throws EstadoInvalidoDaCorridaException {
       if(this.corridaAtual != null){
           this.corridaAtual.cancelarCorrida();
       }
       else{
           System.out.println("Nenhuma corrida ativa para cancelar!");
       }
   }
}

