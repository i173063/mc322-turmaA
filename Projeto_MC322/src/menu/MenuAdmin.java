package menu;

import java.util.Scanner;

import menu.enuns.EnumMenuAdmin;

public class MenuAdmin extends Menu {
    // Construtor
    public MenuAdmin(Scanner scanner) {
        super(scanner);
    }

    // Executa menu do admin (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    public void runMenu() {
        EnumMenuAdmin option;
        do {
            showMenu();
            option = readOptionMenu();
            runMenuOption(option);

        } while (option != EnumMenuAdmin.VOLTAR);
    }

    // Imprime o menu do admin no terminal
    private void showMenu() {
        EnumMenuAdmin menuAdmin[] = EnumMenuAdmin.values();

        printTituloFormatado("Admin");

        System.out.println("|-------------------------------------------|");
        for (int i = 0; i < menuAdmin.length; i++) {
            // Se a opcao for a ultima (i.e. "VOLTAR"), recebe 0
            int numOption = i == menuAdmin.length - 1 ? 0 : i + 1;

            printOpcaoFormatada(numOption, menuAdmin[i].getName());
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no menu do admin com o scanner e a retorna
    private EnumMenuAdmin readOptionMenu() {
        int option;
        EnumMenuAdmin menuAdmin[] = EnumMenuAdmin.values();

        System.out.print("Digite uma opcao: ");
        option = getScanner().nextInt();
        getScanner().nextLine();
        if (option < 0 || option > menuAdmin.length - 1) {
            return null;
        } else if (option == 0) { 
            return EnumMenuAdmin.values()[menuAdmin.length - 1]; // opcao 0 = "SAIR", i.e. ultima opcao do menu
        } else {
            return EnumMenuAdmin.values()[option - 1];
        }
    }

    // Executa a opcao do menu do admin passada
    private void runMenuOption(EnumMenuAdmin option) {
        // Caso em que a opcao escolhida e invalida
        if (option == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        switch (option) {
            case LISTAR_BIBLIOTECAS:
                System.out.println("Listar Bibliotecas.");
                break;
            case CADASTRAR_BIBLIOTECA:
                System.out.println("Cadastrar Biblioteca.");
                break;
            case EXCLUIR_BIBLIOTECA:
                System.out.println("Excluir Biblioteca.");
                break;
            case AVANCAR_TEMPO:
                System.out.println("Avancar Tempo.");
                break;
            case VOLTAR:
                break;
        }
    }
}