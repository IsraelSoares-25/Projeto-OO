package model;

public class Motorista {
    private boolean disponibilidade;
    private Veiculo veiculo;

    public Motorista ( Veiculo veiculo) {
        this.disponibilidade = true; 
        this.veiculo = veiculo;
    }
     public boolean aceitarCorrida() {
        if (disponibilidade) {
            disponibilidade = false;
            return true;
        }
        return false;
    }

    public void finalizarCorrida() {
        disponibilidade = true;
    }

   
}
