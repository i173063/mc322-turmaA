package lab4;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	private double valorSeguro;
	
	//Construtor
	public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, double valorSeguro) {
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.valorSeguro = valorSeguro;//rever
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
	public double getValorSeguro() {
		return valorSeguro;
	}
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	public boolean adicionaVeiculo(Veiculo veiculo) {
		return this.listaVeiculos.add(veiculo);
	}

	public double calculaScore() {
		double resultado = 0;
		return resultado;
	}
	
	public String toString() {
		return "Nome: " + this.nome + ", Endereco: "
	+ this.endereco + ", Veiculos: " + this.listaVeiculos + ", Valor do Seguro: " + this.valorSeguro;
	}
}

