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
}
