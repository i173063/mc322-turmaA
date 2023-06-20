package menu.enuns;

public enum EnumMenuBiblioteca {
    MINHA_CONTA("Minha Conta", new EnumSubmenuBiblioteca[] {
        EnumSubmenuBiblioteca.VISUALIZAR_DADOS,
        EnumSubmenuBiblioteca.EDITAR_DADOS,
        EnumSubmenuBiblioteca.EXCLUIR_CONTA,
        EnumSubmenuBiblioteca.VOLTAR
    }),
    CLIENTES("Clientes", new EnumSubmenuBiblioteca[] {
        EnumSubmenuBiblioteca.LISTAR_CLIENTES,
        EnumSubmenuBiblioteca.LISTAR_ESTUDANTES,
        EnumSubmenuBiblioteca.LISTAR_PROFESSORES,
        EnumSubmenuBiblioteca.CADASTRAR_CLIENTE,
        EnumSubmenuBiblioteca.EXCLUIR_CLIENTE,
        EnumSubmenuBiblioteca.LISTAR_ASSINATURAS,
        EnumSubmenuBiblioteca.GERAR_ASSINATURA,
        EnumSubmenuBiblioteca.CANCELAR_ASSINATURA,
        EnumSubmenuBiblioteca.VOLTAR
    }),
    ITENS("Itens", new EnumSubmenuBiblioteca[] {
        EnumSubmenuBiblioteca.PESQUISAR_ITEM,
        EnumSubmenuBiblioteca.LISTAR_ITENS,
        EnumSubmenuBiblioteca.LISTAR_LIVROS,
        EnumSubmenuBiblioteca.LISTAR_APOSTILAS,
        EnumSubmenuBiblioteca.LISTAR_ARTIGOS,
        EnumSubmenuBiblioteca.LISTAR_REVISTAS,
        EnumSubmenuBiblioteca.CADASTRAR_ITEM,
        EnumSubmenuBiblioteca.EXCLUIR_ITEM,
        EnumSubmenuBiblioteca.VOLTAR
    }),
    EMPRESTIMOS("Emprestimos", new EnumSubmenuBiblioteca[] {
        EnumSubmenuBiblioteca.LISTAR_EMPRESTIMOS,
        EnumSubmenuBiblioteca.LISTAR_EMPRESTIMOS_ATIVOS,
        EnumSubmenuBiblioteca.LISTAR_EMPRESTIMOS_ATRASADOS,
        EnumSubmenuBiblioteca.LISTAR_EMPRESTIMOS_CLIENTE,
        EnumSubmenuBiblioteca.VOLTAR
    }),
    RESERVAS("Reservas", new EnumSubmenuBiblioteca[] {
        EnumSubmenuBiblioteca.LISTAR_RESERVAS,
        EnumSubmenuBiblioteca.LISTAR_RESERVAS_ATIVAS,
        EnumSubmenuBiblioteca.LISTAR_RESERVAS_CLIENTE,
        EnumSubmenuBiblioteca.VOLTAR
    }),
    VOLTAR("Voltar");

    // Atributos
    private final String name;
    private final EnumSubmenuBiblioteca[] subOptions;

    // Construtor
    EnumMenuBiblioteca(String name, EnumSubmenuBiblioteca ... subOptions) {
        this.name = name;
        this.subOptions = subOptions;
    }

    // Getters
    public String getName() {
        return name;
    }

    public EnumSubmenuBiblioteca[] getSubOptions() {
        return subOptions;
    }
}
