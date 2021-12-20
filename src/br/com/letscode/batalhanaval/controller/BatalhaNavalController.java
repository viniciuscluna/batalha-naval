package br.com.letscode.batalhanaval.controller;

import br.com.letscode.batalhanaval.domain.TabuleiroBatalhaNaval;
import br.com.letscode.batalhanaval.utils.StringHelper;
import br.com.letscode.batalhanaval.utils.TabuleiroVazio;

public class BatalhaNavalController {
    private TabuleiroBatalhaNaval tabuleiro;
    public BatalhaNavalController(String nomeJogador){
        tabuleiro = new TabuleiroBatalhaNaval(nomeJogador);
    }

    public int getQuantidadeSubmarinos(){
        return tabuleiro.getQuantidadeSubmarino();
    }

    public void posicionarNaviosComputador(){

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
