package entidades;
import Exceções.EstadoInvalidoDaCorridaException;
import Exceções.NenhumMotoristaException;
import java.util.ArrayList;
import java.util.List;

public class Passageiro extends Usuario{

   private List<String> metodosPagamento;
   private Corrida corridaAtual;
   private Motorista motorista;

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

   public void solicitarCorrida(String origem, String destino) throws NenhumMotoristaException {
       if(!motorista.isDisponibilidade()){
           throw new NenhumMotoristaException("Nenhum motorista disponível");
       }
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

