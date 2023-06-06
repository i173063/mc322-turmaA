package lab5;

public enum MenuOperacoes {
	SAIR("Sair", new SubmenuOpcoes[] {}),
	CADASTROS("Cadastros", new SubmenuOpcoes[] {
			SubmenuOpcoes.CADASTRAR_CLIENTE,
			SubmenuOpcoes.CADASTRAR_VEICULO,
			SubmenuOpcoes.CADASTRAR_SEGURADORA,
			SubmenuOpcoes.CADASTRAR_CONDUTOR,
			SubmenuOpcoes.CADASTRAR_FROTA,
			SubmenuOpcoes.VOLTAR
	}),
	LISTAR("Listar", new SubmenuOpcoes[] { //rever
			SubmenuOpcoes.LISTAR_CLIENTES,
			SubmenuOpcoes.LISTAR_SINISTRO_CLIENTE,
			SubmenuOpcoes.LISTAR_VEICULOS_CLIENTE,
			SubmenuOpcoes.LISTAR_SEGUROS_CLIENTE,
			SubmenuOpcoes.LISTAR_SEGUROS_SEG,
			SubmenuOpcoes.VOLTAR
	}),
	EXCLUIR("Excluir", new SubmenuOpcoes[] {
			SubmenuOpcoes.EXCLUIR_CLIENTE,
			SubmenuOpcoes.EXCLUIR_VEICULO,
			SubmenuOpcoes.EXCLUIR_SINISTRO,
			SubmenuOpcoes.EXCLUIR_FROTA,
			SubmenuOpcoes.EXCLUIR_CONDUTOR,
			SubmenuOpcoes.EXCLUIR_SEGURO,
			SubmenuOpcoes.VOLTAR}),
	GERAR_SINISTRO("Gerar Sinistro", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	GERAR_SEGURO("Gerar Seguro", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	CALCULAR_RECEITA("Calcular Receita Seguradora", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR});
	
	//atributos
	private final String descricao;
	private final SubmenuOpcoes[] submenu;
	
	//Construtor
	MenuOperacoes(String descricao, SubmenuOpcoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}
	
	//getters
	public String getDescricao() {
		return descricao;
	}
	
	public SubmenuOpcoes[] getSubmenu() {
		return submenu;
	}

}
