package menu;

import java.util.Scanner;

import menu.enuns.EnumMenuPadrao;
import pacote.Biblioteca;
import pacote.Cliente;

public class MenuPadrao extends Menu{
    MenuBiblioteca menuBiblioteca;
    MenuCliente menuCliente;
    MenuAdmin menuAdmin;

    // Construtor
    public MenuPadrao(Scanner scanner) {
        super(scanner);
        this.menuBiblioteca = new MenuBiblioteca(scanner);
        this.menuCliente = new MenuCliente(scanner);
        this.menuAdmin = new MenuAdmin(scanner);
    }

    // Executa menu padrao (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    public void runMenu() {
        EnumMenuPadrao option;
        do {
            showMenu();
            option = readOptionMenu();
            runMenuOption(option);

        } while (option != EnumMenuPadrao.SAIR);
    }

    // Imprime Menu Padrao no terminal
    private void showMenu() {
        EnumMenuPadrao menu[] = EnumMenuPadrao.values();

        printTituloFormatado("Menu");

        System.out.println("|-------------------------------------------|");
        for (EnumMenuPadrao option : menu) {
            // Se a opcao for a ultima (i.e. "SAIR"), recebe 0
            int numOption = option.ordinal() == menu.length - 1 ? 0 : option.ordinal() + 1;

            printOpcaoFormatada(numOption, option.getName());
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no menu padrao com o scanner e a retorna
    private EnumMenuPadrao readOptionMenu() {
        int option;
        EnumMenuPadrao menu[] = EnumMenuPadrao.values();

        System.out.print("Digite uma opcao: ");
        option = getScanner().nextInt();
        getScanner().nextLine();
        if (option < 0 || option > menu.length - 1) {
            return null;
        } else if (option == 0) { 
            return EnumMenuPadrao.values()[menu.length - 1]; // opcao 0 = "SAIR", i.e. ultima opcao do menu
        } else {
            return EnumMenuPadrao.values()[option - 1];
        }
    }

    // Executa a opcao do menu padrao passada
    private void runMenuOption(EnumMenuPadrao option) {
        // Caso em que a opcao escolhida e invalida
        if (option == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        Biblioteca biblioteca;
        Cliente cliente;

        switch (option) {
            case ADMIN:
                menuAdmin.runMenu();
                break;
            case BIBLIOTECA:
                System.out.println("Login da Biblioteca:");
                biblioteca = loginbiblioteca();
                if (biblioteca == null) {return;}
                System.out.println("Login realizado com sucesso!");
                System.out.printf("Bem vindo(a) %s!\n", "Nome Biblioteca");
                menuBiblioteca.runMenu(biblioteca);
                break;
            case CLIENTE:
                System.out.println("Login do Cliente:");
                cliente = loginCliente();
                if (cliente == null) {return;}
                System.out.println("Login realizado com sucesso!");
                System.out.printf("Bem vindo(a) %s!\n", "Nome Cliente");
                menuCliente.runMenu(cliente);
                break;
            case SAIR:
                System.out.println("Programa encerrado.");
                break;
        }
    }


    /******************************* METODOS AUXILIARES *******************************/

    // Login da Biblioteca
    private Biblioteca loginbiblioteca() {
        return null;
    }

    // Login do Cliente
    private Cliente loginCliente() {
        return null;
    }
}