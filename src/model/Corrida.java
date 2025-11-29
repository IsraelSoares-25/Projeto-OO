package model;
import model.Veiculo.Categoria;

public class Corrida {
    public enum StatusCorrida {
        SOLICITADA,    // Passageiro solcitou, esperando motorista
        ACEITA,        // Motorista pegou a corrida
        EM_ANDAMENTO,  // Estão a camminho
        FINALIZADA,    // Chegou no local
        CANCELADA      // Deu ruim
    }
    private Passageiro passageiro;
    private Motorista motorista;

    private String origem;
    private String destino;
    private double preco;
    private StatusCorrida status;

    public Corrida(Passageiro passageiro, String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        this.passageiro = passageiro;

        this.status = StatusCorrida.SOLICITADA;
    }

    public void atribuirMotorista(Motorista motorista){
        this.motorista = motorista;
        this.status = StatusCorrida.ACEITA;
    }

    public void calcularPreco(){
        Categoria categoriaVeiculo = this.motorista.getVeiculo().getCategoria();

        double tarifaBase = 0;
        double valorPorKm = 0;

        if (categoriaVeiculo == Categoria.COMUM){
            tarifaBase = 5.00;
            valorPorKm = 1.00;
        } else {
            tarifaBase = 9.00;
            valorPorKm = 2.20;
        }

        this.preco = tarifaBase + (distanciaKm * valorPorKm);
    }




}
