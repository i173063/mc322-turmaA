package lab4;

public enum SubmenuOpcoes {
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	LISTAR_CLIENTES("Listar cliente por seguradora"),
	LISTAR_SINISTROS_SEG("Listar sinistros por seguradora"),
	LISTAR_SINISTRO_CLIENTE("Listar sinistro por cliente"),
	LISTAR_VEICULOS_CLIENTE("Listar veículo por cliente"),
	LISTAR_VEICULOS_SEG("Listar veículo por seguradora"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	EXCLUIR_SINISTRO("Excluir sinistro"),
	VOLTAR("Voltar");
	
	//atributo
	private final String descricao;
	
	//Construtor
	SubmenuOpcoes(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}
}
//
