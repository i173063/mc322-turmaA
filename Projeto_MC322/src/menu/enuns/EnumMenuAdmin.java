package menu.enuns;

public enum EnumMenuAdmin {
    LISTAR_BIBLIOTECAS("Listar Bibliotecas"),
    CADASTRAR_BIBLIOTECA("Cadastrar Biblioteca"),
    EXCLUIR_BIBLIOTECA("Excluir Biblioteca"),
    AVANCAR_TEMPO("Avancar Tempo"),
    VOLTAR("Voltar");

    // Atributo
    private final String name;

    // Construtor
    EnumMenuAdmin(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }
}