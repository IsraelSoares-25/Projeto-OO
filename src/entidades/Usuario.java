package entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String senha;

    private boolean possuiPendencias;
    private List<Integer> avaliacoes = new ArrayList<>();
    private double mediaAvaliacoes;

    public Usuario(String nome, String cpf, String email, String telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.possuiPendencias = false;
        this.mediaAvaliacoes = 0.0;
    }

    public void adicionarAvaliacao(int nota){
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 1 e 5 estrelas! .");
        }

        avaliacoes.add(nota);
        atualizarMedia();
    }

    private void atualizarMedia(){
        double soma = 0;

        if (avaliacoes.isEmpty()){
            this.mediaAvaliacoes = 0.0;
            return;
        }

        for (int n : avaliacoes){
            soma += n;
        }

        this.mediaAvaliacoes = soma/avaliacoes.size();
    }

    public double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }

    public int getNumAvaliacoes (){
        return avaliacoes.size();
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public boolean isPossuiPendencias() {
        return possuiPendencias;
    }

    public void setPossuiPendencias(boolean possuiPendencias) {
        this.possuiPendencias = possuiPendencias;
    }

    public List<Integer> getAvaliacoes() {
        return List.copyOf(avaliacoes);
    }
}
