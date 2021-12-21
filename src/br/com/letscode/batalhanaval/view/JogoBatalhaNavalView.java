package br.com.letscode.batalhanaval.view;

import br.com.letscode.batalhanaval.controller.BatalhaNavalController;
import br.com.letscode.batalhanaval.utils.ScreenUtil;

import java.util.Scanner;

public class JogoBatalhaNavalView {
    private BatalhaNavalController controller;
    private Scanner scanner;

    public JogoBatalhaNavalView(Scanner scanner) {
        this.scanner = scanner;
        this.controller = new BatalhaNavalController(askNomeJogador());
        escolherPosicoesSubmarino();
        comecarJogo();
    }

    private void comecarJogo(){
        boolean vezJogador = true;
        executarRodada(vezJogador);

        controller.showTabuleiroComputador();
        controller.showTabuleiroJogador();
        ScreenUtil.printTextLine(controller.getVencedor() + " VENCEU!!!!");
    }
    private void executarRodada(boolean vezJogador){
        while (!controller.verificaVenceu()){
            try {
                if(vezJogador) {
                    ScreenUtil.printTextLine("Posicione sua bomba: ");
                    controller.posicionarBombaJogador(scanner.next());
                    controller.showTabuleiroJogador();
                    vezJogador = false;
                }
                else{
                    controller.posicionarBombaComputador();
                    vezJogador = true;
                }
                executarRodada(vezJogador);
            }
            catch (Exception ex){
                ScreenUtil.printTextLine(ex.getMessage());
                executarRodada(vezJogador);
            }
        }
    }

    private void escolherPosicoesSubmarino() {
        askPosicoesJogador();
        controller.posicionarNaviosComputador();
    }

    private void askPosicoesJogador() {
        int submarinosRestantes = controller.getQuantidadeSubmarinos();
        while (submarinosRestantes > 0) {
            try {
                ScreenUtil.printTextLine("Insira uma posição:");
                controller.posicionarSubmarinoJogador(scanner.next());
                controller.showTabuleiroJogador();
                submarinosRestantes--;
            } catch (Exception exception) {
                ScreenUtil.printTextLine(exception.getMessage());
            }
        }
    }

    private String askNomeJogador() {
        ScreenUtil.printTextLine("Digite seu nome:");
        return scanner.next();
    }
}
