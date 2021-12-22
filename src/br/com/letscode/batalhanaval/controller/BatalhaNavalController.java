package br.com.letscode.batalhanaval.controller;

import br.com.letscode.batalhanaval.consts.ValoresTabuleiro;
import br.com.letscode.batalhanaval.domain.PosicaoTabuleiro;
import br.com.letscode.batalhanaval.domain.ResultadoBomba;
import br.com.letscode.batalhanaval.domain.TabuleiroBatalhaNaval;
import br.com.letscode.batalhanaval.utils.*;

import java.util.Objects;
import java.util.Random;

public class BatalhaNavalController {
    private TabuleiroBatalhaNaval tabuleiro;

    public BatalhaNavalController(String nomeJogador) {
        tabuleiro = new TabuleiroBatalhaNaval(nomeJogador);
    }

    public int getQuantidadeSubmarinos() {
        return tabuleiro.getQuantidadeSubmarino();
    }

    public void posicionarNaviosComputador() {
        int quantSubmarino = tabuleiro.getQuantidadeSubmarino();
        while (quantSubmarino > 0) {
            auxPosicionarNaviosComputador();
            quantSubmarino--;
        }
    }

    private void auxPosicionarNaviosComputador() {
        var tabuleiroComputador = tabuleiro.getTabuleiroComputador();
        int lin = getRandomPosition();
        int col = getRandomPosition();

        if (!Objects.equals(tabuleiroComputador[lin][col], ValoresTabuleiro.Navio)) {
            tabuleiroComputador[lin][col] = ValoresTabuleiro.Navio;
            tabuleiro.setTabuleiroComputador(tabuleiroComputador);
        } else {
            auxPosicionarNaviosComputador();
        }
    }

    public static int getRandomPosition() {
        return new Random().nextInt(10) + 1;
    }

    public void posicionarBombaComputador() {
        var posicao = new PosicaoTabuleiro(getRandomPosition(), getRandomPosition());
        var tabuleiroOponente = tabuleiro.getTabuleiroJogador();
        try {
            tabuleiroOponente[posicao.getLinha()][posicao.getColuna()] = getCondicaoBomba(tabuleiroOponente[posicao.getLinha()][posicao.getColuna()]).getResultado();
        } catch (Exception ex) {
            posicionarBombaComputador();
        }
    }


    public void posicionarSubmarinoJogador(String texto) throws Exception {
        var posicao = StringHelper.converterTextoParaPosicao(texto);
        var tabuleiroJogador = tabuleiro.getTabuleiroJogador();

        if (Objects.equals(tabuleiroJogador[posicao.getLinha()][posicao.getColuna()], ValoresTabuleiro.Navio))
            throw new Exception("Posição já preenchida!");

        tabuleiroJogador[posicao.getLinha()][posicao.getColuna()] = ValoresTabuleiro.Navio;
        tabuleiro.setTabuleiroJogador(tabuleiroJogador);
    }

    public String posicionarBombaJogador(String texto) throws Exception {
        var posicao = StringHelper.converterTextoParaPosicao(texto);
        var tabuleiroOponente = tabuleiro.getTabuleiroComputador();
        var condicaoBomba= getCondicaoBomba(tabuleiroOponente[posicao.getLinha()][posicao.getColuna()]);
        tabuleiroOponente[posicao.getLinha()][posicao.getColuna()] = condicaoBomba.getResultado();

        return  StringHelper.concatenaString(condicaoBomba.getMensagem());
    }

    private ResultadoBomba getCondicaoBomba(String posicao) throws Exception {
        if (posicao.equals(ValoresTabuleiro.Navio))
            return new ResultadoBomba("Tiro Certeiro", ValoresTabuleiro.TiroCerteiro);
        else if (posicao.equals(ValoresTabuleiro.TiroCerteiro) || posicao.equals(ValoresTabuleiro.TiroAgua))
            throw new Exception("Posição já escolhida!");
        else return new ResultadoBomba("Tiro na água", ValoresTabuleiro.TiroAgua);
    }

    public String getVencedor() {
        return tabuleiro.jogadorVenceu();
    }

    public boolean verificaVenceu() {
        return tabuleiro.verificarSeVenceu();
    }

    public void showTabuleiroJogador(boolean mostrarPlacar){
        TabuleiroJogo.showTabuleiroJogo(this.tabuleiro.getTabuleiroComputador(), this.tabuleiro.getTabuleiroJogador(), this.tabuleiro.getNomeJogador());
        if(mostrarPlacar){
            Placar.showPlacar(this.tabuleiro.naviosRestantesComputador(), this.tabuleiro.naviosRestantesJogador(), this.tabuleiro.getNomeJogador());
        }
    }

    public void showTabuleirosCompletos(){
        showTabuleiroJogador(false);
        TabuleiroJogo.showTabuleiroJogo(this.tabuleiro.getTabuleiroJogador(), this.tabuleiro.getTabuleiroComputador(), "Computador");
    }

}
