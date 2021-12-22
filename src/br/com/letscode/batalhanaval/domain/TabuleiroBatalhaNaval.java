package br.com.letscode.batalhanaval.domain;

import br.com.letscode.batalhanaval.consts.ValoresTabuleiro;
import br.com.letscode.batalhanaval.utils.TabuleiroVazio;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    public String getNomeJogador() {
        return nomeJogador;
    }

    private String nomeJogador;

    public int getQuantidadeSubmarino() {
        return QUANTIDADE_SUBMARINO;
    }

    private final int QUANTIDADE_SUBMARINO = 10;
    public long naviosRestantesJogador(){
        return Arrays.stream(tabuleiroJogador).flatMap(Arrays::stream).collect(Collectors.toList()).stream().filter(f -> f.equals(ValoresTabuleiro.Navio)).count();
    }
    public long naviosRestantesComputador(){
        return Arrays.stream(tabuleiroComputador).flatMap(Arrays::stream).collect(Collectors.toList()).stream().filter(f -> f.equals(ValoresTabuleiro.Navio)).count();
    }
    public boolean verificarSeVenceu(){
       return (naviosRestantesComputador() == 0 || naviosRestantesJogador() == 0);
    }
    public String jogadorVenceu(){
        if(naviosRestantesComputador() == 0)
            return nomeJogador;
        else return "Computador";
    }

    public TabuleiroBatalhaNaval(String nomeJogador){
        TabuleiroVazio.setTabuleiroVazio(this.tabuleiroJogador);
        TabuleiroVazio.setTabuleiroVazio(this.tabuleiroComputador);
        this.nomeJogador = nomeJogador;
    }
}
