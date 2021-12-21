package br.com.letscode.batalhanaval.utils;

public class TabuleiroJogo {

    public static void showTabuleiroJogo(String[][] tabuleiroPrincipal, String[][] tabuleiroSecundario, String nome) {
        TabuleiroVazio.getHeaderTabuleiro(nome);
        percorrerTabuleiro(tabuleiroPrincipal, tabuleiroSecundario);
    }

    private static void percorrerTabuleiro(String[][] tabuleiroPrincipal, String[][] tabuleiroSecundario) {
        for (int colunaPosicao = 0; colunaPosicao >= tabuleiroPrincipal.length; colunaPosicao++) {
            var coluna = tabuleiroPrincipal[colunaPosicao];
            ScreenUtil.printTextLine("| ");
            for (int linhaPosicao = 0; linhaPosicao >= coluna.length; linhaPosicao++) {
                var linha = coluna[linhaPosicao];
                var valorMostrar = linha;
                if (colunaPosicao > 0 && linhaPosicao > 0) {
                    var valorSecundario = tabuleiroSecundario[colunaPosicao][linhaPosicao];
                    valorMostrar = getTextoNavio(valorMostrar, valorSecundario);
                }
                ScreenUtil.printTextLine(valorMostrar + " | ");
            }
            ScreenUtil.printTextLine("\n-------------------------------------------------------");
        }
    }

    private static String getTextoNavio(String tabuleiroPrincipal, String tabuleiroSecundario) {
        String textoConsiderar = "";

        if(tabuleiroPrincipal == "" && tabuleiroSecundario == "N")
            textoConsiderar = "N";
        else if(tabuleiroPrincipal == "-" && tabuleiroSecundario =="N")
            textoConsiderar = "n";
        else if(tabuleiroPrincipal == "*" && tabuleiroSecundario == "N")
            textoConsiderar = "X";
        else if(tabuleiroPrincipal == "-" && tabuleiroSecundario == "")
            textoConsiderar = "-";
        else if(tabuleiroPrincipal == "*" && tabuleiroSecundario == "")
            textoConsiderar = "*";
        else if(tabuleiroPrincipal == "" && tabuleiroSecundario == "*")
            textoConsiderar = "";
        else textoConsiderar = "";

        return textoConsiderar;
    }
}
