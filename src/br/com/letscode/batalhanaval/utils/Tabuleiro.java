package br.com.letscode.batalhanaval.utils;

import java.util.Arrays;

public class Tabuleiro {

    private void getHeaderTabuleiro(String nomeJogador) {
        System.out.println("-------------------------------------------------------");
        System.out.println("|                       "+nomeJogador+"                       |");
        System.out.println("-------------------------------------------------------");
    }
    public void gerarTabuleiroVazio(String[][] tabuleiro, String nomeJogador){
        getHeaderTabuleiro(nomeJogador);
        for (String[] coluna : tabuleiro) {
            System.out.print("| ");
            for (String row : coluna) {
                System.out.print(row + " | ");
            }
            System.out.println("\n-------------------------------------------------------");
        }
    }

    public void preencherTabuleiroVazio(String[][] tabuleiro){
        char[] headColuna = new char[] { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };

        for (String[] row : tabuleiro)
            Arrays.fill(row, "  ");

        for (int i = 0; i < 11; i++) {
            String header = i == 0 ? " " : Integer.toString(i);
            header = header.length() < 2 && header != " " ? "0" + header : header == " " ? " " : header;
            tabuleiro[0][i] = header;
        }

        for (int i = 1; i < 11; i++)
            tabuleiro[i][0] = Character.toString(headColuna[i]);
    }


}
