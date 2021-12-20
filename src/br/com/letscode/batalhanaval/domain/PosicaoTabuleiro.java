package br.com.letscode.batalhanaval.domain;

public class PosicaoTabuleiro {
    public PosicaoTabuleiro(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }


    private int linha;
    private int coluna;

}
