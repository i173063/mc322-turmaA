package menu;

import java.util.Scanner;

import menu.enuns.EnumMenuBiblioteca;
import menu.enuns.EnumSubmenuBiblioteca;
import pacote.Biblioteca;

public class MenuBiblioteca extends Menu {
    // Construtor
    public MenuBiblioteca(Scanner scanner) {
        super(scanner);
    }

    // Executa menu da biblioteca (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    public void runMenu(Biblioteca biblioteca) {
        EnumMenuBiblioteca option;
        do {
            showMenu();
            option = readOptionMenu();
            runMenuOption(option, biblioteca);

        } while (option != EnumMenuBiblioteca.VOLTAR);
    }

    // Imprime o menu da biblioteca no terminal
    private void showMenu() {
        EnumMenuBiblioteca menuBiblioteca[] = EnumMenuBiblioteca.values();

        printTituloFormatado("Biblioteca");

        System.out.println("|-------------------------------------------|");
        for (EnumMenuBiblioteca option : menuBiblioteca) {
            // Se a opcao for a ultima (i.e. "VOLTAR"), recebe 0
            int numOption = option.ordinal() == menuBiblioteca.length - 1 ? 0 : option.ordinal() + 1;

            printOpcaoFormatada(numOption, option.getName());
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no menu da biblioteca com o scanner e a retorna
    private EnumMenuBiblioteca readOptionMenu() {
        int option;
        EnumMenuBiblioteca menuBiblioteca[] = EnumMenuBiblioteca.values();

        System.out.print("Digite uma opcao: ");
        option = getScanner().nextInt();
        getScanner().nextLine();
        if (option < 0 || option > menuBiblioteca.length - 1) {
            return null;
        } else if (option == 0) { 
            return EnumMenuBiblioteca.values()[menuBiblioteca.length - 1]; // opcao 0 = "SAIR", i.e. ultima opcao do menu
        } else {
            return EnumMenuBiblioteca.values()[option - 1];
        }
    }

    // Executa a opcao do menu da biblioteca passada
    private void runMenuOption(EnumMenuBiblioteca option, Biblioteca biblioteca) {
        // Caso em que a opcao escolhida e invalida
        if (option == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        switch (option) {
            case MINHA_CONTA:
            case CLIENTES:
            case ITENS:
            case EMPRESTIMOS:
            case RESERVAS:
                runSubmenu(option, biblioteca);
                break;
            case VOLTAR:
                break;
        }
    }

    // Executa submenu da biblioteca (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runSubmenu(EnumMenuBiblioteca option, Biblioteca biblioteca) {
        EnumSubmenuBiblioteca subOption;
        do {
            showSubmenu(option);
            subOption = readOptionSubmenu(option);
            runSubmenuOption(subOption, biblioteca);
        } while (subOption != EnumSubmenuBiblioteca.VOLTAR);
    }

    // Imprime o SubmenuBiblioteca de "suboption" no terminal.
    private void showSubmenu(EnumMenuBiblioteca option) {
        EnumSubmenuBiblioteca submenuBiblioteca[] = option.getSubOptions();

        printTituloFormatado(option.getName());

        System.out.println("|-------------------------------------------|");
        for (int i = 0; i < submenuBiblioteca.length; i++) {
            // Se a opcao for a ultima (i.e. "VOLTAR"), recebe 0
            int numSuboption = i == submenuBiblioteca.length - 1 ? 0 : i + 1;

            printOpcaoFormatada(numSuboption, submenuBiblioteca[i].getName());
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no submenu da biblioteca com o scanner e a retorna
    private EnumSubmenuBiblioteca readOptionSubmenu(EnumMenuBiblioteca option) {
        int subOption;
        EnumSubmenuBiblioteca submenu[] = option.getSubOptions();

        System.out.print("Digite uma opcao: ");
        subOption = getScanner().nextInt();
        getScanner().nextLine();
        if (subOption < 0 || subOption > submenu.length - 1) {
            return null;
        } else if (subOption == 0) {
            return submenu[submenu.length - 1]; // opcao 0 = "VOLTAR", i.e. ultima opcao do submenu
        } else {
            return submenu[subOption - 1];
        }
    }

    // Executa a opcao do submenu da biblioteca passada
    private void runSubmenuOption(EnumSubmenuBiblioteca subOption, Biblioteca biblioteca) {
        // Caso em que a subopcao escolhida e invalida
        if (subOption == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        switch(subOption) {
            // Minha Conta
            case VISUALIZAR_DADOS:
                System.out.println("Visualizar Dados.");
                break;
            case EDITAR_DADOS:
                System.out.println("Editar Dados.");
                break;
            case EXCLUIR_CONTA:
                System.out.println("Excluir Conta.");
                break;

            // Clientes
            case LISTAR_CLIENTES:
                System.out.println("Listar Clientes.");
                break;
            case LISTAR_ESTUDANTES:
                System.out.println("Listar Estudantes.");
                break;
            case LISTAR_PROFESSORES:
                System.out.println("Listar Professores.");
                break;
            case CADASTRAR_CLIENTE:
                System.out.println("Cadastrar Cliente.");
                break;
            case EXCLUIR_CLIENTE:
                System.out.println("Excluir Cliente.");
                break;
            case LISTAR_ASSINATURAS:
                System.out.println("Listar Assinaturas.");
                break;
            case GERAR_ASSINATURA:
                System.out.println("Gerar Assinatura.");
                break;
            case CANCELAR_ASSINATURA:
                System.out.println("Cancelar Assinatura.");
                break;

            // Itens
            case PESQUISAR_ITEM:
                System.out.println("Pesquisar Item.");
                break;
            case LISTAR_ITENS:
                System.out.println("Listar Itens.");
                break;
            case LISTAR_LIVROS:
                System.out.println("Listar Livros.");
                break;
            case LISTAR_APOSTILAS:
                System.out.println("Listar Apostilas.");
                break;
            case LISTAR_ARTIGOS:
                System.out.println("Listar Artigos.");
                break;
            case LISTAR_REVISTAS:
                System.out.println("Listar Revistas.");
                break;
            case CADASTRAR_ITEM:
                System.out.println("Cadastrar Item.");
                break;
            case EXCLUIR_ITEM:
                System.out.println("Excluir Item.");
                break;

            // Emprestimos
            case LISTAR_EMPRESTIMOS:
                System.out.println("Listar Emprestimos.");
                break;
            case LISTAR_EMPRESTIMOS_ATIVOS:
                System.out.println("Listar Emprestimos Ativos.");
                break;
            case LISTAR_EMPRESTIMOS_ATRASADOS:
                System.out.println("Listar Emprestimos Atrasados.");
                break;
            case LISTAR_EMPRESTIMOS_CLIENTE:
                System.out.println("Listar Emprestimos de um Cliente.");
                break;

            // Reservas
            case LISTAR_RESERVAS:
                System.out.println("Listar Reservas.");
                break;
            case LISTAR_RESERVAS_ATIVAS:
                System.out.println("Listar Reservas Ativas.");
                break;
            case LISTAR_RESERVAS_CLIENTE:
                System.out.println("Listar Reservas de um Cliente.");
                break;

            // Comum
            case VOLTAR:
            	break;
        }
    }
}