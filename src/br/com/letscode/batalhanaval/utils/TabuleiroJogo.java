package br.com.letscode.batalhanaval.utils;

import br.com.letscode.batalhanaval.consts.ValoresTabuleiro;

public class TabuleiroJogo {

    public static void showTabuleiroJogo(String[][] tabuleiroPrincipal, String[][] tabuleiroSecundario, String nome) {
        TabuleiroVazio.getHeaderTabuleiro(nome);
        percorrerTabuleiro(tabuleiroPrincipal, tabuleiroSecundario);
    }

    private static void percorrerTabuleiro(String[][] tabuleiroPrincipal, String[][] tabuleiroSecundario) {
        for (int colunaPosicao = 0; colunaPosicao < tabuleiroPrincipal.length; colunaPosicao++) {
            var coluna = tabuleiroPrincipal[colunaPosicao];
            System.out.print("| ");
            for (int linhaPosicao = 0; linhaPosicao < coluna.length; linhaPosicao++) {
                var linha = coluna[linhaPosicao];
                var valorMostrar = linha;
                if (colunaPosicao > 0 && linhaPosicao > 0) {
                    var valorSecundario = tabuleiroSecundario[colunaPosicao][linhaPosicao];
                    valorMostrar = getTextoNavio(valorMostrar, valorSecundario);
                }
                System.out.print(valorMostrar + " | ");
            }
            ScreenUtil.printTextLine("\n-------------------------------------------------------");
        }
    }

    private static String getTextoNavio(String tabuleiroPrincipal, String tabuleiroSecundario) {

        String textoConsiderar = ValoresTabuleiro.Vazio;

        if(tabuleiroPrincipal == ValoresTabuleiro.Vazio && tabuleiroSecundario == ValoresTabuleiro.Navio)
            textoConsiderar = ValoresTabuleiro.Navio;
        else if(tabuleiroPrincipal == ValoresTabuleiro.Navio && tabuleiroSecundario == ValoresTabuleiro.Navio)
            textoConsiderar = ValoresTabuleiro.Navio;
        else if(tabuleiroPrincipal == ValoresTabuleiro.TiroAgua && tabuleiroSecundario == ValoresTabuleiro.Navio)
            textoConsiderar = ValoresTabuleiro.TiroAguaNavioPosicionado;
        else if(tabuleiroPrincipal == ValoresTabuleiro.TiroCerteiro && tabuleiroSecundario == ValoresTabuleiro.Navio)
            textoConsiderar = ValoresTabuleiro.TiroCerteiroNavioPosicionado;
        else if(tabuleiroPrincipal == ValoresTabuleiro.TiroAgua && tabuleiroSecundario == ValoresTabuleiro.Vazio)
            textoConsiderar = ValoresTabuleiro.TiroAgua;
        else if(tabuleiroPrincipal == ValoresTabuleiro.TiroAgua && tabuleiroSecundario == ValoresTabuleiro.TiroAgua)
            textoConsiderar = ValoresTabuleiro.TiroAgua;
        else if(tabuleiroPrincipal == ValoresTabuleiro.TiroCerteiro && tabuleiroSecundario == ValoresTabuleiro.Vazio)
            textoConsiderar = ValoresTabuleiro.TiroCerteiro;
        else if(tabuleiroPrincipal == ValoresTabuleiro.TiroCerteiro && tabuleiroSecundario == ValoresTabuleiro.TiroAgua)
            textoConsiderar = ValoresTabuleiro.TiroCerteiro;
        else if(tabuleiroPrincipal == ValoresTabuleiro.Vazio && tabuleiroSecundario == ValoresTabuleiro.TiroCerteiro)
            textoConsiderar = ValoresTabuleiro.Vazio;
        else textoConsiderar = ValoresTabuleiro.Vazio;

        return textoConsiderar;
    }
}
