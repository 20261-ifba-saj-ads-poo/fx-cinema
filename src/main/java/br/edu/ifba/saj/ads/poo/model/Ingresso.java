package br.edu.ifba.saj.ads.poo.model;

public class Ingresso {
    private Sessao sessao;
    private float valor;
    private Cliente cliente;
    private TipoIngresso tipoIngresso;
    public Ingresso(Sessao sessao) {
        this.sessao = sessao;
    }    

    public Ingresso(Sessao sessao, float valorIngresso) {
        this.sessao = sessao;
        this.valor = valorIngresso;
    }

    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ingresso [sessao=" + sessao + ", valor=" + valor + ", cliente=" + cliente + ", tipoIngresso="
                + tipoIngresso + "]";
    }

    

}
