package model;

public class Motorista {
    private String nome;
    private int cpf;
    private int telefone;
    private int senha;
    private String placaCarro;

    public Motorista(String nome, int cpf, int telefone, int senha, String placaCarro) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
        this.placaCarro = placaCarro;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public int getCpf () {
        return cpf;
    }

    public void setCpf (int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone () {
        return telefone;
    }

    public void setTelefone (int telefone) {
        this.telefone = telefone;
    }

    public int getSenha () {
        return senha;
    }

    public void setSenha (int senha) {
        this.senha = senha;
    }

    public String getPlacaCarro () {
        return placaCarro;
    }

    public void setPlacaCarro (String placaCarro) {
        this.placaCarro= placaCarro;
    }


}
