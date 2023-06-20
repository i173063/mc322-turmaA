import java.util.Scanner;

import menu.MenuPadrao;

public class Main {
    public static void main(String[] args) throws Exception {
        /******************************* MENU INTERATIVO *******************************/

        Scanner scanner = new Scanner(System.in);        
        MenuPadrao menu = new MenuPadrao(scanner);
        menu.runMenu();
    }
}