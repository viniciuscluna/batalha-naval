package br.com.letscode.batalhanaval;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoBatalhaNaval jogoBatalhaNaval = new JogoBatalhaNaval();
        jogoBatalhaNaval.Iniciar(scanner);
    }
}
