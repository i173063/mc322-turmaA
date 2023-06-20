package menu;

import java.util.Scanner;

import menu.enuns.EnumMenuCliente;
import menu.enuns.EnumSubmenuCliente;
import pacote.Cliente;

public class MenuCliente extends Menu{
    // Construtor
    public MenuCliente(Scanner scanner) {
        super(scanner);
    }

    // Executa menu do cliente (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    public void runMenu(Cliente cliente) {
        EnumMenuCliente option;
        do {
            showMenu();
            option = readOptionMenu();
            runMenuOption(option, cliente);

        } while (option != EnumMenuCliente.VOLTAR);
    }

    // Imprime o menu do cliente no terminal
    private void showMenu() {
        EnumMenuCliente menuCliente[] = EnumMenuCliente.values();

        printTituloFormatado("Cliente");

        System.out.println("|-------------------------------------------|");
        for (EnumMenuCliente option : menuCliente) {
            // Se a opcao for a ultima (i.e. "VOLTAR"), recebe 0
            int numOption = option.ordinal() == menuCliente.length - 1 ? 0 : option.ordinal() + 1;

            printOpcaoFormatada(numOption, option.getName());
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no menu do cliente com o scanner e a retorna
    private EnumMenuCliente readOptionMenu() {
        int option;
        EnumMenuCliente menuCliente[] = EnumMenuCliente.values();

        System.out.print("Digite uma opcao: ");
        option = getScanner().nextInt();
        getScanner().nextLine();
        if (option < 0 || option > menuCliente.length - 1) {
            return null;
        } else if (option == 0) { 
            return EnumMenuCliente.values()[menuCliente.length - 1]; // opcao 0 = "SAIR", i.e. ultima opcao do menu
        } else {
            return EnumMenuCliente.values()[option - 1];
        }
    }

    // Executa a opcao do menu do cliente passada
    private void runMenuOption(EnumMenuCliente option, Cliente cliente) {
        // Caso em que a opcao escolhida e invalida
        if (option == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        switch (option) {
            case MINHA_CONTA:
            case ITENS:
            case EMPRESTIMOS:
            case RESERVAS:
                runSubmenu(option, cliente);
                break;
            case VOLTAR:
                break;
        }
    }

    // Executa submenu do cliente (imprime, recebe a opcao e executa a opcao) de acordo com a opcao passada
    private void runSubmenu(EnumMenuCliente option, Cliente cliente) {
        EnumSubmenuCliente subOption;
        do {
            showSubmenu(option);
            subOption = readOptionSubmenu(option);
            runSubmenuOption(subOption, cliente);
        } while (subOption != EnumSubmenuCliente.VOLTAR);
    }

    // Imprime o SubmenuCliente de "suboption" no terminal.
    private void showSubmenu(EnumMenuCliente option) {
        EnumSubmenuCliente submenuBiblioteca[] = option.getSubOptions();

        printTituloFormatado(option.getName());

        System.out.println("|-------------------------------------------|");
        for (int i = 0; i < submenuBiblioteca.length; i++) {
            // Se a opcao for a ultima (i.e. "VOLTAR"), recebe 0
            int numSuboption = i == submenuBiblioteca.length - 1 ? 0 : i + 1;

            printOpcaoFormatada(numSuboption, submenuBiblioteca[i].getName());
        }
        System.out.println("|-------------------------------------------|");
    }

    // Le a opcao escolhida no submenu do cliente com o scanner e a retorna
    private EnumSubmenuCliente readOptionSubmenu(EnumMenuCliente option) {
        int subOption;
        EnumSubmenuCliente submenu[] = option.getSubOptions();

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

    // Executa a opcao do submenu do cliente passada
    private void runSubmenuOption(EnumSubmenuCliente subOption, Cliente cliente) {
        // Caso em que a subopcao escolhida e invalida
        if (subOption == null) {
            System.out.println("Opcao Invalida.");
            return;
        }

        switch(subOption) {
            // Minha Conta
            case VISUALIZAR_DADOS:
                System.out.println("Visualizar dados.");
                break;
            case EDITAR_DADOS:
                System.out.println("Editar dados.");
                break;
            case EXCLUIR_CONTA:
                System.out.println("Excluir conta.");
                break;

            // Itens
            case PESQUISAR_ITEM:
                System.out.println("Pesquisar item.");
                break;
            case ULTIMAS_AQUISICOES:
                System.out.println("Ultimas aquisicoes.");
                break;
            
            // Emprestimos
            case MEUS_EMPRESTIMOS:
                System.out.println("Meus emprestimos.");
                break;
            case EMPRESTIMOS_ATRASADOS:
                System.out.println("Emprestimos atrasados.");
                break;
            case SOLICITAR_EMPRESTIMO:
                System.out.println("Solicitar emprestimo.");
                break;
            case DEVOLVER_EMPRESTIMO:
                System.out.println("Devolver emprestimo.");
                break;
            case RENOVAR_EMPRESTIMO:
                System.out.println("Renovar emprestimo.");
                break;

            // Reservas
            case MINHAS_RESERVAS:
                System.out.println("Minhas reservas.");
                break;
            case RESERVAR_ITEM:
                System.out.println("Reservar item.");
                break;
            case CANCELAR_RESERVA:
                System.out.println("Cancelar reserva.");
                break;

            // Comum
            case VOLTAR:
            	break;
        }
    
    }
}