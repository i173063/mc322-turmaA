package lab5;

public enum SubmenuOpcoes {
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	CADASTRAR_FROTA("Cadastrar frota"),
	CADASTRAR_CONDUTOR("Cadastrar condutor"),
	LISTAR_CLIENTES("Listar cliente por seguradora"),
	LISTAR_SINISTRO_CLIENTE("Listar sinistro por cliente"),
	LISTAR_VEICULOS_CLIENTE("Listar veículo por cliente"),
	LISTAR_SEGUROS_CLIENTE("Listar seguros por cliente"),
	LISTAR_SEGUROS_SEG("Listar seguros por seguradora"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	EXCLUIR_SINISTRO("Excluir sinistro"),
	EXCLUIR_FROTA("Excluir frota"),
	EXCLUIR_CONDUTOR("Excluir condutor"),
	EXCLUIR_SEGURO("Excluir seguro"),
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
