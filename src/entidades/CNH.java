package entidades;

public class CNH {
    private String numero;
    private String categoria;
    private int anoValidade;
    private int anoEmissao;

    public CNH(int anoEmissao, int anoValidade, String categoria, String numero) {
        this.anoEmissao = anoEmissao;
        this.anoValidade = anoValidade;
        this.categoria = categoria;
        this.numero = numero;
    }

    public boolean isValida(){
        int anoAtual = java.time.Year.now().getValue();
        return this.anoValidade >= anoAtual;
    }

    public boolean categoriaValidaParaCarro() {
        return this.categoria.equalsIgnoreCase("B") || this.categoria.equalsIgnoreCase("AB");
    }



    public int getAnoEmissao() {
        return anoEmissao;
    }

    public void setAnoEmissao(int anoEmissao) {
        this.anoEmissao = anoEmissao;
    }

    public int getAnoValidade() {
        return anoValidade;
    }

    public void setAnoValidade(int anoValidade) {
        this.anoValidade = anoValidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
