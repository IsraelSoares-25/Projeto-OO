package entidades;
import Exceções.EstadoInvalidoDaCorridaException;
import entidades.Veiculo.Categoria;
import utils.CalculadoraDistancia;

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

        if (this.passageiro != null) {
            this.passageiro.setCorridaAtual(this);
        }
    }

    public void atribuirMotorista(Motorista motorista){
        if (motorista == null) {
            throw new EstadoInvalidoDaCorridaException("Motorista inválido.");
        }

        if (!motorista.isDisponibilidade()) {
            throw new EstadoInvalidoDaCorridaException("Motorista não está disponível.");
        }

        this.motorista = motorista;
        this.status = StatusCorrida.ACEITA;

        motorista.setCorridaAtual(this);
        motorista.setDisponibilidade(false);
    }

    public double calcularPreco(){
        if (this.motorista == null || this.motorista.getVeiculo() == null) {
            throw new EstadoInvalidoDaCorridaException("Não é possível calcular o preço sem um motorista ou um veículo atribuído.");
        }

        double distanciaKm = CalculadoraDistancia.calcular(this.origem,this.destino);

        Veiculo.Categoria categoriaVeiculo = this.motorista.getVeiculo().getCategoria();

        double tarifaBase = 0;
        double valorPorKm = 0;

        if (categoriaVeiculo == Veiculo.Categoria.COMUM){
            tarifaBase = 5.00;
            valorPorKm = 1.00;
        } else {
            tarifaBase = 9.00;
            valorPorKm = 2.20;
        }

        this.preco = tarifaBase + (distanciaKm * valorPorKm);
        System.out.println("Valor da corrida: " + this.preco);
        return this.preco;
    }
    public void iniciarCorrida() throws EstadoInvalidoDaCorridaException {
        if (this.status != StatusCorrida.ACEITA){
            throw new EstadoInvalidoDaCorridaException("Não é Possível iniciar a viagem. Estado atual: " + this.status);
        }
        if (this.motorista == null || this.passageiro == null) {
            throw new EstadoInvalidoDaCorridaException("Motorista ou passageiro não configurados.");
        }

        this.status = StatusCorrida.EM_ANDAMENTO;
        System.out.println("Corrida iniciada com sucesso.");
    }

    public void cancelarCorrida() throws EstadoInvalidoDaCorridaException{
        if (this.status == StatusCorrida.EM_ANDAMENTO ||
            this.status == StatusCorrida.FINALIZADA ||
            this.status == StatusCorrida.CANCELADA){

            throw new EstadoInvalidoDaCorridaException("Não é possível cancelar a corrida pois já está " + this.status);
        }

        this.status = StatusCorrida.CANCELADA;
        System.out.println("Corrida cancelada");

        if (motorista != null) {
            motorista.corridaCancelada();
            motorista = null;
        }
        if (this.passageiro != null) {
            this.passageiro.setCorridaAtual(null);
        }
    }

    public void finalizarViagem(){
        this.status = StatusCorrida.FINALIZADA;
        calcularPreco();

        if (this.passageiro != null) {
            this.passageiro.setCorridaAtual(null);
        }

        if (motorista != null){
            this.motorista.setCorridaAtual(null);
            this.motorista.setDisponibilidade(true);
            this.motorista = null;
        }

        System.out.println("Corrida finalizada com sucesso! O valor da corrida foi de: " + this.preco);
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public StatusCorrida getStatus() {
        return status;
    }

    public void setStatus(StatusCorrida status) {
        this.status = status;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
}
