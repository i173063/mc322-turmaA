package menu.enuns;

public enum EnumMenuCliente {
    MINHA_CONTA("Minha Conta", new EnumSubmenuCliente[] {
        EnumSubmenuCliente.VISUALIZAR_DADOS,
        EnumSubmenuCliente.EDITAR_DADOS,
        EnumSubmenuCliente.EXCLUIR_CONTA,
        EnumSubmenuCliente.VOLTAR
    }),
    ITENS("Itens", new EnumSubmenuCliente[] {
        EnumSubmenuCliente.PESQUISAR_ITEM,
        EnumSubmenuCliente.ULTIMAS_AQUISICOES,
        EnumSubmenuCliente.VOLTAR
    }),
    EMPRESTIMOS("Emprestimos", new EnumSubmenuCliente[] {
        EnumSubmenuCliente.MEUS_EMPRESTIMOS,
        EnumSubmenuCliente.EMPRESTIMOS_ATRASADOS,
        EnumSubmenuCliente.SOLICITAR_EMPRESTIMO,
        EnumSubmenuCliente.DEVOLVER_EMPRESTIMO,
        EnumSubmenuCliente.RENOVAR_EMPRESTIMO,
        EnumSubmenuCliente.VOLTAR
    }),
    RESERVAS("Reservas", new EnumSubmenuCliente[] {
        EnumSubmenuCliente.MINHAS_RESERVAS,
        EnumSubmenuCliente.RESERVAR_ITEM,
        EnumSubmenuCliente.CANCELAR_RESERVA,
        EnumSubmenuCliente.VOLTAR
    }),
    VOLTAR("Voltar");

    // Atributos
    private final String name;
    private final EnumSubmenuCliente[] subOptions;

    // Construtor
    EnumMenuCliente(String name, EnumSubmenuCliente ... subOptions) {
        this.name = name;
        this.subOptions = subOptions;
    }

    // Getters
    public String getName() {
        return name;
    }

    public EnumSubmenuCliente[] getSubOptions() {
        return subOptions;
    }
}
