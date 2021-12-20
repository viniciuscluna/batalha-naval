package br.com.letscode.batalhanaval.domain;

import br.com.letscode.batalhanaval.utils.TabuleiroVazio;

public class TabuleiroBatalhaNaval {
    public String[][] getTabuleiroJogador() {
        return tabuleiroJogador;
    }

    public void setTabuleiroJogador(String[][] tabuleiroJogador) {
        this.tabuleiroJogador = tabuleiroJogador;
    }

    public String[][] getTabuleiroComputador() {
        return tabuleiroComputador;
    }

    public void setTabuleiroComputador(String[][] tabuleiroComputador) {
        this.tabuleiroComputador = tabuleiroComputador;
    }

    private String[][] tabuleiroJogador = new String[11][11];
    private String[][] tabuleiroComputador = new String[11][11];
    private String nomeJogador;

    public int getQuantidadeSubmarino() {
        return QUANTIDADE_SUBMARINO;
    }

    private final int QUANTIDADE_SUBMARINO = 10;
    public TabuleiroBatalhaNaval(String nomeJogador){
        this.tabuleiroJogador = TabuleiroVazio.setTabuleiroVazio(this.tabuleiroJogador);
        this.tabuleiroComputador = TabuleiroVazio.setTabuleiroVazio(this.tabuleiroComputador);
        this.nomeJogador = nomeJogador;
    }
}
