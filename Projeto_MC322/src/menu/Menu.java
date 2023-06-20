package menu;

import java.util.Scanner;

public abstract class Menu {
    private Scanner scanner;

    // Construtor
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    // Retorna o titulo do menu (ou submenu) no formato '#################### Menu ###################'
    protected void printTituloFormatado(String titulo) {
        int width = 43; // Tamanho total do titulo menos 2 (espacos em branco)
        int padding = width - titulo.length();

        if (padding <= 0) { // padding <= 0 indica que o titulo e maior ou igual ao tamanho total
            System.out.println(titulo);; // Se esse for o caso, nao tem espaco para colocar o #. Logo, imprime o proprio titulo
        } else {
            int right = padding / 2;
            int left = padding - right; // O esquerdo e sempre igual ao direito ou igual ao direito + 1
            String leftPadding = "#".repeat(left);
            String rightPadding = "#".repeat(right);
            System.out.printf("\n%s %s %s\n", leftPadding, titulo, rightPadding);
        }
    }

    // Imprime a opcao no formato '| Opcao X - NomeOpcao                       |'
    protected void printOpcaoFormatada(int numOpcao, String nomeOpcao) {
        String titulo = String.format("Opcao %d - %s", numOpcao, nomeOpcao);
        int width = 41; // Tamanho total do titulo menos 4 (caracteres '|' e espacos em branco)
        int padding = width - titulo.length();

        System.out.printf("| %s%s |\n", titulo, " ".repeat(padding));
    }


    public Scanner getScanner() {
        return this.scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}