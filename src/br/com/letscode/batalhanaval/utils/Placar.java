package br.com.letscode.batalhanaval.utils;

import br.com.letscode.batalhanaval.domain.TabuleiroBatalhaNaval;

public class Placar {

    public static void showPlacar(long naviosRestantesComputador, long naviosRestantesJogador,String nome){
        ScreenUtil.printTextLine("------------------ Navios restantes -------------------");
        ScreenUtil.printTextLine(nome+": "+naviosRestantesJogador);
        ScreenUtil.printTextLine("Computador: "+naviosRestantesComputador);
        ScreenUtil.printTextLine("-------------------------------------------------------");
    }
}
