package lab4;

import java.util.Date;
import java.util.Random;


public class Sinistro {
	private final int id; 
	private Date data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	//Construtor
	public Sinistro(int id, Date data, String endereco, 
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
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
//

