package lab06;

import java.util.Date;
import java.util.Random;


public class Sinistro {
	private final int id; 
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
	//Construtor
	public Sinistro(int id, Date data, String endereco, 
			Condutor condutor, Seguro seguro) {
		Random aleatorio = new Random();
		this.id = aleatorio.nextInt();
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}
	//Getters e setters
	public int getId() { //randomico
		return id;
	}
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
	public Condutor getCondutor() {
		return condutor;
	}
	public void setCondutor(Condutor condutor){
		this.condutor = condutor;
	}
	public Seguro getSeguro() {
		return seguro;
	}
	public void setSeguro(Seguro seguro){
		this.seguro = seguro;
	}

	public String toString() {
		return "Id: " + this.id + ", Data: "
	+ this.data + ", Endereco: " + this.endereco + "\nCondutor: " + this.condutor
	+ "\nSeguro: " + this.seguro;
	}
}
