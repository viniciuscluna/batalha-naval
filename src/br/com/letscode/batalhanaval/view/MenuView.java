package br.com.letscode.batalhanaval.view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    public MenuView(Scanner scanner){
        this.scanner = scanner;
    }

    public void Iniciar() {
        IniciarJogo();
    }

    public void IniciarJogo(){
        JogoBatalhaNavalView jogo = new JogoBatalhaNavalView(scanner);

    }
}
