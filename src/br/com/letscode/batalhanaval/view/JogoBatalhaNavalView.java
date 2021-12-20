package br.com.letscode.batalhanaval.view;

import br.com.letscode.batalhanaval.controller.BatalhaNavalController;
import br.com.letscode.batalhanaval.utils.ScreenUtil;

import java.util.Scanner;

public class JogoBatalhaNavalView {
    private BatalhaNavalController controller;
    private Scanner scanner;

    public JogoBatalhaNavalView(Scanner scanner){
        this.scanner = scanner;
        this.controller = new BatalhaNavalController(askNomeJogador());
        escolherPosicoesSubmarino();
    }

    private void escolherPosicoesSubmarino(){
        askPosicoesJogador();
        controller.posicionarNaviosComputador();
    }

    private void askPosicoesJogador(){
        int submarinosRestantes = controller.getQuantidadeSubmarinos();

        //while ()
        ScreenUtil.printTextLine("Coloque a posição:!");
        try {
            controller.posicionarSubmarinoJogador(scanner.next());
        }catch (Exception exception){

        }
    }

    private String askNomeJogador(){
        ScreenUtil.printTextLine("Digite seu nome:!");
        return scanner.next();
    }
}