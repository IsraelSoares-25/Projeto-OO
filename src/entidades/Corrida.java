package entidades;
import Exceções.EstadoInvalidoDaCorridaException;
import entidades.Veiculo.Categoria;

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

    public double calcularPreco(double distanciaKm){
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
        System.out.println("Valor da corrida: " + this.preco);
        return preco;
    }
    public void iniciarCorrida() throws EstadoInvalidoDaCorridaException {
        if (this.status != StatusCorrida.ACEITA){
            throw new EstadoInvalidoDaCorridaException("Não é Possível iniciar a viagem.",this.status);
        }
        this.status = StatusCorrida.EM_ANDAMENTO;
        System.out.println("Corrida iniciada com sucesso.");
    }

    public void cancelarCorrida()throws EstadoInvalidoDaCorridaException{
        if(this.status == StatusCorrida.EM_ANDAMENTO){
            throw new EstadoInvalidoDaCorridaException("Não é possível cancelar a corrida:",this.status);
        }
        this.status = StatusCorrida.CANCELADA;
        System.out.println("Corrida cancelada");
    }

    public void finalizarViagem(){
        this.status = StatusCorrida.FINALIZADA;
        if (motorista != null){
            motorista.finalizarCorrida();
        }
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
