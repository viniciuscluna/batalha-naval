package br.com.letscode.batalhanaval.controller;

import br.com.letscode.batalhanaval.domain.PosicaoTabuleiro;
import br.com.letscode.batalhanaval.domain.TabuleiroBatalhaNaval;
import br.com.letscode.batalhanaval.utils.StringHelper;
import br.com.letscode.batalhanaval.utils.TabuleiroJogo;
import br.com.letscode.batalhanaval.utils.TabuleiroVazio;

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

        if (!Objects.equals(tabuleiroComputador[lin][col], "N ")) {
            tabuleiroComputador[lin][col] = "N ";
            tabuleiro.setTabuleiroComputador(tabuleiroComputador);
        } else {
            auxPosicionarNaviosComputador();
        }
    }

    public static int getRandomPosition() {
        return new Random().nextInt(10) + 1;
    }

    public void posicionarBombaComputador() throws Exception {
        var posicao = new PosicaoTabuleiro(getRandomPosition(), getRandomPosition());
        var tabuleiroOponente = tabuleiro.getTabuleiroJogador();
        try {
            tabuleiroOponente[posicao.getLinha()][posicao.getColuna()] = getCondicaoBomba(tabuleiroOponente[posicao.getLinha()][posicao.getColuna()]);
        } catch (Exception ex) {
            posicionarBombaComputador();
        }
    }


    public void posicionarSubmarinoJogador(String texto) throws Exception {
        var posicao = StringHelper.converterTextoParaPosicao(texto);
        var tabuleiroJogador = tabuleiro.getTabuleiroJogador();

        if (Objects.equals(tabuleiroJogador[posicao.getLinha()][posicao.getColuna()], "N "))
            throw new Exception("Posição já preenchida!");

        tabuleiroJogador[posicao.getLinha()][posicao.getColuna()] = "N ";
        tabuleiro.setTabuleiroJogador(tabuleiroJogador);
    }

    public void posicionarBombaJogador(String texto) throws Exception {
        var posicao = StringHelper.converterTextoParaPosicao(texto);
        var tabuleiroOponente = tabuleiro.getTabuleiroComputador();
        tabuleiroOponente[posicao.getLinha()][posicao.getColuna()] = getCondicaoBomba(tabuleiroOponente[posicao.getLinha()][posicao.getColuna()]);
    }

    private String getCondicaoBomba(String posicao) throws Exception {
        if (posicao == "N ")
            return "* ";
        else if (posicao == "* ")
            throw new Exception("Posição já escolhida!");
        else return "- ";
    }

    public String getVencedor() {
        return tabuleiro.jogadorVenceu();
    }

    public boolean verificaVenceu() {
        return tabuleiro.verificarSeVenceu();
    }

    public void showTabuleiroJogador(){
        TabuleiroJogo.showTabuleiroJogo(this.tabuleiro.getTabuleiroComputador(), this.tabuleiro.getTabuleiroJogador(), this.tabuleiro.getNomeJogador());
    }

    public void showTabuleiroComputador(){
        TabuleiroJogo.showTabuleiroJogo(this.tabuleiro.getTabuleiroJogador(), this.tabuleiro.getTabuleiroComputador(), "Computador");
    }

}
