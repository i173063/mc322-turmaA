package lab5;

import java.util.ArrayList;

public abstract class Cliente {

	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	//private double valorSeguro;
	
	//Construtor
	public Cliente(String nome, String endereco, String telefone, String email) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	//Getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String toString() {
		return "Nome: " + this.nome + ", Endereco: "
	+ this.endereco + ", Email: " + this.email + ", Telefone: " + this.telefone;
	}
	public abstract boolean cadastrarVeiculo(Veiculo veiculo);
	public abstract boolean cadastrarFrota(Frota frota);
	public abstract ArrayList<Frota> getListaFrota();
	public abstract  boolean atualizarFrota(int funcao, Frota frota, Veiculo veiculo);
	public abstract ArrayList<Veiculo> getListaVeiculos();
	public abstract boolean removerVeiculo(Veiculo veiculo);
	public abstract boolean getVeiculosPorFrota(String frota);
}


