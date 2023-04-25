package lab3;

import java.util.Random;


public class Sinistro {
	private final int id; //rever
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	//Construtor
	public Sinistro(int id, String data, String endereco, 
			Cliente cliente, Veiculo veiculo, Seguradora seguradora) {
		Random aleatorio = new Random();
		this.id = aleatorio.nextInt();
		this.data = data;
		this.endereco = endereco;
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.seguradora = seguradora;
	}
	//Getters e setters
	public int getId() { //randomico
		return id;
	}
	/*public void setId(int id) {
		this.id = id;
	}*/
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	public Seguradora getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(Seguradora seguradora){
		this.seguradora = seguradora;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo){
		this.veiculo = veiculo;
	}

	public String toString() {
		return "Id: " + this.id + ", Data: "
	+ this.data + ", Endereco: " + this.endereco + "\nCliente: " + this.cliente
	+ "\nSeguradora: " + this.seguradora.getNome() + "\nVeiculo: " + this.veiculo;
	}
}

