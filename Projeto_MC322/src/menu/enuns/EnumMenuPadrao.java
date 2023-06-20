package menu.enuns;

/* enum para o Menu
 * Cada constante e uma opcao do menu, que tem um nome e uma lista de submenus
 */
public enum EnumMenuPadrao {
    ADMIN("Admin", new EnumSubmenuPadrao[] {
        EnumSubmenuPadrao.LISTAR_BIBLIOTECAS,
        EnumSubmenuPadrao.CADASTRAR_BIBLIOTECA,
        EnumSubmenuPadrao.EXCLUIR_BIBLIOTECA,
        EnumSubmenuPadrao.AVANCAR_TEMPO,
        EnumSubmenuPadrao.VOLTAR
    }),
    BIBLIOTECA("Area Biblioteca", new EnumSubmenuPadrao[] {
        EnumSubmenuPadrao.MINHA_CONTA_BIBLIOTECA,
        EnumSubmenuPadrao.CLIENTES,
        EnumSubmenuPadrao.ITENS_BIBLIOTECA,
        EnumSubmenuPadrao.EMPRESTIMOS_BIBLIOTECA,
        EnumSubmenuPadrao.RESERVAS_BIBLIOTECA,
        EnumSubmenuPadrao.VOLTAR
    }),
    CLIENTE("Area Cliente", new EnumSubmenuPadrao[] {
        EnumSubmenuPadrao.MINHA_CONTA_CLIENTE,
        EnumSubmenuPadrao.ITENS_CLIENTE,
        EnumSubmenuPadrao.EMPRESTIMOS_CLIENTE,
        EnumSubmenuPadrao.RESERVAS_CLIENTE,
        EnumSubmenuPadrao.VOLTAR
    }),
    SAIR("Sair");

    // Atributos
    private final String name;
    private final EnumSubmenuPadrao[] subOptions;

    // Construtor
    EnumMenuPadrao(String name, EnumSubmenuPadrao ... subOptions) {
        this.name = name;
        this.subOptions = subOptions;
    }

    // Getters
    public String getName() {
        return name;
    }

    public EnumSubmenuPadrao[] getSubOptions() {
        return subOptions;
    }
}