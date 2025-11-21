package model;
//inicio do codigo da classe passageiro
public class Passageiro {

   private String nome; 
   private int cpf;
   private int telefone;
   private int senha;
   private int formasPagamento;

   public Passageiro(String nome, int cpf, int telefone, int senha, int formasPagamento) {
      this.nome = nome;
      this.cpf = cpf;
      this.telefone = telefone;
      this.senha = senha;
      this.formasPagamento = formasPagamento;
   }
   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public int getCpf() {
      return cpf;
   }
   public void setCpf( int cpf) {
      this.cpf = cpf;
   }

   public int getTelefone() {
      return telefone;
   }

   public void setTelefone(int telefone) {
      this.telefone = telefone;
   }

   public int getSenha() {
      return senha;
   }
   
   public void setSenha( int senha) {
      this.senha = senha;
   }

   public int getFormasPagamento() {
      return formasPagamento;
   }

   public void setFormasPagamento(int formasPagamento) {
      this.formasPagamento = formasPagamento;
   }

   
   







}
