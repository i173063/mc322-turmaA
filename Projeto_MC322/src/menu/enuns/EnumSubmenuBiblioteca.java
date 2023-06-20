package menu.enuns;

/* enum para os Submenus
 * Cada constante e uma opcao de todos os submenus
 */
public enum EnumSubmenuBiblioteca {
    // Minha Conta
    VISUALIZAR_DADOS("Visualizar Dados"),
    EDITAR_DADOS("Editar Dados"),
    EXCLUIR_CONTA("Excluir Conta"),
    // Clientes
    LISTAR_CLIENTES("Listar Todos os Clientes"),
    LISTAR_ESTUDANTES("Listar Estudantes"),
    LISTAR_PROFESSORES("Listar Professores"),
    CADASTRAR_CLIENTE("Cadastrar Cliente"),
    EXCLUIR_CLIENTE("Excluir Cliente"),
    LISTAR_ASSINATURAS("Listar Assinaturas"),
    GERAR_ASSINATURA("Gerar Assinatura"),
    CANCELAR_ASSINATURA("Cancelar Assinatura"),
    // Itens
    PESQUISAR_ITEM("Pesquisar Item"),
    LISTAR_ITENS("Listar Todos os Itens"),
    LISTAR_LIVROS("Listar Livros"),
    LISTAR_APOSTILAS("Listar Apostilas"),
    LISTAR_ARTIGOS("Listar Artigos"),
    LISTAR_REVISTAS("Listar Revistas"),
    CADASTRAR_ITEM("Cadastrar Item"),
    EXCLUIR_ITEM("Excluir Item"),
    // Emprestimos
    LISTAR_EMPRESTIMOS("Listar Todos os Emprestimos"),
    LISTAR_EMPRESTIMOS_ATIVOS("Listar Emprestimos Ativos"),
    LISTAR_EMPRESTIMOS_ATRASADOS("Listar Emprestimos Atrasados"),
    LISTAR_EMPRESTIMOS_CLIENTE("Listar Emprestimos por Cliente"),
    // Reservas
    LISTAR_RESERVAS("Listar Todas as Reservas"),
    LISTAR_RESERVAS_ATIVAS("Listar Reservas Ativas"),
    LISTAR_RESERVAS_CLIENTE("Listar Reservas por Cliente"),
    // Comum
	VOLTAR("Voltar");
	
    // Atributo
	private final String name;
	
    // Construtor
	EnumSubmenuBiblioteca(String name){
		this.name = name;
	}
	
    // Getter
	public String getName() {
		return name;
	}
}