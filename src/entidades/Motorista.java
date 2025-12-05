package entidades;

import Exceções.EstadoInvalidoDaCorridaException;

public class Motorista extends Usuario{

    private boolean disponibilidade;
    private Veiculo veiculo;
    private CNH carteiraDeHabilitacao ;
    private Corrida corridaAtual;

    public Motorista(String nome, String cpf, String email, String telefone, String senha, CNH carteiraDeHabilitacao, Veiculo veiculo) {
        super(nome, cpf, email, telefone, senha);
        this.carteiraDeHabilitacao = carteiraDeHabilitacao;
        this.veiculo = veiculo;
        this.disponibilidade = true;
    }

    public void aceitarCorrida(Corrida novaCorrida) throws EstadoInvalidoDaCorridaException {
        if (novaCorrida == null){
            throw new EstadoInvalidoDaCorridaException("Não existe corridas para aceitar!");
        }
        if (!this.disponibilidade){
            throw new EstadoInvalidoDaCorridaException("Motorista indisponível para aceitar corridas.");
        }
        if (novaCorrida.getStatus() != Corrida.StatusCorrida.SOLICITADA) {
            throw new EstadoInvalidoDaCorridaException("A corrida não está disponível para ser aceita.");
        }

        this.corridaAtual = novaCorrida;
        this.disponibilidade = false;
        novaCorrida.setStatus(Corrida.StatusCorrida.ACEITA);
        System.out.println("O motorista " + getNome() + " aceitou sua corrida!");


    }

    public void finalizarCorrida() throws EstadoInvalidoDaCorridaException{
        if (this.corridaAtual == null) {
            throw new EstadoInvalidoDaCorridaException("Não há corrida ativa para finalizar.");
        }

        if (this.corridaAtual.getStatus() != Corrida.StatusCorrida.ACEITA &&
                this.corridaAtual.getStatus() != Corrida.StatusCorrida.EM_ANDAMENTO) {
            throw new EstadoInvalidoDaCorridaException("Essa corrida não pode ser finalizada! Estado Inválido!");
        }

        this.corridaAtual.setStatus(Corrida.StatusCorrida.FINALIZADA);

        if (this.corridaAtual.getPassageiro() != null) {
            this.corridaAtual.getPassageiro().setCorridaAtual(null);
        }


        this.corridaAtual = null;
        disponibilidade = true;

        System.out.println("Motorista disponivel novamente!");
    }

    public void corridaCancelada() throws EstadoInvalidoDaCorridaException {
        if (this.corridaAtual != null) {
            System.out.println("A corrida foi cancelada pelo passageiro.");
            this.corridaAtual = null;
            this.disponibilidade = true;
        } else {
            throw new EstadoInvalidoDaCorridaException("Nenhuma corrida para cancelar.");
        }
    }


    public CNH getCarteiraDeHabilitacao() {
        return carteiraDeHabilitacao;
    }

    public void setCarteiraDeHabilitacao(CNH carteiraDeHabilitacao) {
        this.carteiraDeHabilitacao = carteiraDeHabilitacao;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Corrida getCorridaAtual() {
        return corridaAtual;
    }
}
