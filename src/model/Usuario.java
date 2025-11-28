package model;

public class Usuario {
    private String nome;
    private String cpf;
    private int telefone;
    private String senha;

    public Usuario(String nome, String cpf, int telefone, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
