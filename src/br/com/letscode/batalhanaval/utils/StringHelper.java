package br.com.letscode.batalhanaval.utils;

import br.com.letscode.batalhanaval.domain.PosicaoTabuleiro;
import br.com.letscode.batalhanaval.enums.Letras;

public class StringHelper {
    public static PosicaoTabuleiro converterTextoParaPosicao(String texto){
        String linha = texto.split("")[0];
        int coluna = Integer.parseInt(texto.substring(1));
        return new PosicaoTabuleiro(Letras.valueOf(linha).getPosicao(), coluna);
    }
}
