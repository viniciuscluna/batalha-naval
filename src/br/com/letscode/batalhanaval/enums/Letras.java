package br.com.letscode.batalhanaval.enums;

public enum Letras {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8),
    I(9),
    J(10);

    public int posicao;
    public int getPosicao(){
        return posicao;
    }
    Letras(int posicao){
        this.posicao = posicao;
    }
}
