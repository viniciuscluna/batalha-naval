package br.com.letscode.batalhanaval.controller;

import br.com.letscode.batalhanaval.domain.TabuleiroBatalhaNaval;
import br.com.letscode.batalhanaval.utils.StringHelper;
import br.com.letscode.batalhanaval.utils.TabuleiroVazio;

import java.util.Random;

public class BatalhaNavalController {
    private TabuleiroBatalhaNaval tabuleiro;
    public BatalhaNavalController(String nomeJogador){
        tabuleiro = new TabuleiroBatalhaNaval(nomeJogador);
    }

    public int getQuantidadeSubmarinos(){
        return tabuleiro.getQuantidadeSubmarino();
    }

    public void posicionarNaviosComputador(){
        int quantSubmarino = tabuleiro.getQuantidadeSubmarino();
        while(quantSubmarino > 0){
            auxPosicionarNaviosComputador();
            quantSubmarino--;
        }
    }
    private void auxPosicionarNaviosComputador(){
        var tabuleiroComputador = tabuleiro.getTabuleiroComputador();
        int lin = getRandomPosition();
        int col = getRandomPosition();

        if(tabuleiroComputador[lin][col] != "N"){
            tabuleiroComputador[lin][col] = "N";
            tabuleiro.setTabuleiroComputador(tabuleiroComputador);
        }else{
            auxPosicionarNaviosComputador();
        }
    }
    public static int getRandomPosition() {
        return new Random().nextInt(10+1)+1;
    }

    public void posicionarSubmarinoJogador(String texto) throws Exception {
        var posicao = StringHelper.converterTextoParaPosicao(texto);
        var tabuleiroJogador = tabuleiro.getTabuleiroJogador();

        if(tabuleiroJogador[posicao.getLinha()][posicao.getColuna()] == "N")
            throw new Exception("Posição já preenchida!");

        tabuleiroJogador[posicao.getLinha()][posicao.getColuna()] = "N";
        tabuleiro.setTabuleiroJogador(tabuleiroJogador);
    }





}
