package br.com.letscode.batalhanaval;

import br.com.letscode.batalhanaval.view.JogoBatalhaNavalView;
import br.com.letscode.batalhanaval.view.MenuView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuView menuJogo = new MenuView(scanner);
        menuJogo.Iniciar();
    }
}
