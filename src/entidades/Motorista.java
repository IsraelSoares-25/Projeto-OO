package entidades;

public class Motorista extends Usuario{

    private boolean disponibilidade;
    private Veiculo veiculo;
    private CNH carteiraDeHabilitacao ;
    private Corrida corridaAtual;

    public Motorista(String cpf, String email, String nome, String senha, String telefone, CNH carteiraDeHabilitacao, Veiculo veiculo) {
        super(cpf, email, nome, senha, telefone);
        this.carteiraDeHabilitacao = carteiraDeHabilitacao;
        this.veiculo = veiculo;
        this.disponibilidade = true;
    }

    public void aceitarCorrida(Corrida novaCorrida) {
        if (this.disponibilidade) {
            this.corridaAtual = novaCorrida;
            this.disponibilidade = false;
            novaCorrida.setStatus(Corrida.StatusCorrida.ACEITA);
            System.out.println("O motorista " + getNome() + " aceitou sua corrida!"); //so pra validar msm
        }
        else {
            System.out.println("Motorista " + getNome() + " está ocupado!");
        }
    }

    public void finalizarCorrida() {
        disponibilidade = true;
        System.out.println("Motorista disponivel novamente!");
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
