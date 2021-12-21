package br.com.letscode.batalhanaval.view;

import br.com.letscode.batalhanaval.utils.ScreenUtil;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;
    public MenuView(Scanner scanner){
        this.scanner = scanner;
    }
    private void showHeader() {
        ScreenUtil.printTextLine("\n\n==================================================================================", 84);
        System.out.println("\n ");
        ScreenUtil.printTextLine("##   ## #### #   # #### #      #### #### ##### ##### #    ####", 80, true, ' ');
        ScreenUtil.printTextLine("### ##  #  # #   # #  # #      #  # #  #   #     #   #    #   ", 80, true, ' ');
        ScreenUtil.printTextLine("#  ##   ####  # #  #### #      ###  ####   #     #   #    ### ", 80, true, ' ');
        ScreenUtil.printTextLine("#       #  #  # #  #  # #      #  # #  #   #     #   #    #   ", 80, true, ' ');
        ScreenUtil.printTextLine("#       #  #  ###  #  # ####   #### #  #   #     #   #### ####", 80, true, ' ');

    }
    public void Iniciar() {
        showHeader();
        showMenu();
    }

    private void showMenu() {
        System.out.println("\n ");
        ScreenUtil.printTextLine("==================================================================================", 82);
        ScreenUtil.printTextLine("I: Iniciar Logo", 80, true);
        ScreenUtil.printTextLine("S: Sair", 80, true);
        ScreenUtil.printTextLine("==================================================================================", 82);
        ScreenUtil.printTextLine("\n# Digite a opção desejada: ", 80);
        String option;

        option = scanner.next();
        switch (option.toUpperCase()) {
            case "I":
                IniciarJogo();
                break;
            case "S":
                System.out.print("\nAté logo!");
                break;
            default:
                ScreenUtil.printTextLine("Opção inválida", 80);
                ScreenUtil.printTextLine("#: ", 80);
        }
    }

    private void IniciarJogo(){
        JogoBatalhaNavalView jogo = new JogoBatalhaNavalView(scanner);

    }
}
