 package menu.enuns;

public enum EnumSubmenuPadrao {
    // Admin
    LISTAR_BIBLIOTECAS("Listar Bibliotecas"),
    CADASTRAR_BIBLIOTECA("Cadastrar Biblioteca"),
    EXCLUIR_BIBLIOTECA("Excluir Biblioteca"),
    AVANCAR_TEMPO("Avancar Tempo"),
    // Biblioteca
    MINHA_CONTA_BIBLIOTECA("Minha Conta"),
    CLIENTES("Clientes"),
    ITENS_BIBLIOTECA("Itens"),
    EMPRESTIMOS_BIBLIOTECA("Emprestimos"),
    RESERVAS_BIBLIOTECA("Reservas"),
    // Cliente
    MINHA_CONTA_CLIENTE("Minha Conta"),
    ITENS_CLIENTE("Itens"),
    EMPRESTIMOS_CLIENTE("Emprestimos"),
    RESERVAS_CLIENTE("Reservas"),
    // Comum
	VOLTAR("Voltar");
	
    // Atributo
	private final String name;
	
    // Construtor
	EnumSubmenuPadrao(String name){
		this.name = name;
	}
	
    // Getter
	public String getName() {
		return name;
	}
}
