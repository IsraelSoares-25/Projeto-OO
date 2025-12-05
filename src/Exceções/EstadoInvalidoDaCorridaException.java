package Exceções;

import entidades.Corrida.StatusCorrida;

public class EstadoInvalidoDaCorridaException extends Exception {

    private StatusCorrida estadoAtual;

    public EstadoInvalidoDaCorridaException(String mensagem) {
        super(mensagem);
        this.estadoAtual = estadoAtual;
    }

    public StatusCorrida getEstadoAtual() {
        return estadoAtual;
    }
}
