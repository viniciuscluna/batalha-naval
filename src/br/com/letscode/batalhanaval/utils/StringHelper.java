package br.com.letscode.batalhanaval.utils;

import br.com.letscode.batalhanaval.domain.PosicaoTabuleiro;
import br.com.letscode.batalhanaval.enums.Letras;

public class StringHelper {
    public static PosicaoTabuleiro converterTextoParaPosicao(String texto) throws Exception {
        try {
            String linha = texto.split("")[0].toUpperCase();
            int coluna = Integer.parseInt(texto.substring(1));
            return new PosicaoTabuleiro(Letras.valueOf(linha).getPosicao(), coluna);
        }
        catch (Exception ex){
            throw new Exception("Posição inválida");
        }
    }
}
