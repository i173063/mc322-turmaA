package lab5;

import java.util.ArrayList;

public class Frota {
	private String code;
	private ArrayList<Veiculo> listaVeiculos;
	
	//Construtor
	public Frota(String code, ArrayList<Veiculo> listaVeiculos) {
		this.code = code;
		this.listaVeiculos = new ArrayList<Veiculo>();
	}
	//Getters e setters
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	public void setVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	public boolean addVeiculo(Veiculo veiculo) {
		return this.listaVeiculos.add(veiculo);
	}
	public boolean removeVeiculo(Veiculo veiculo) {
		var i = 0;
		String placa = veiculo.getPlaca();
		while(i < this.listaVeiculos.size()) {
			Veiculo remover = this.listaVeiculos.get(i);
			if(remover.getPlaca().equals(placa)) {
				this.listaVeiculos.remove(remover);
				return true;
			}
			else
				i++;
		}
		System.out.println("Veiculo não está na lista\n");
		return false;
	}
	
	public String toString() {
		return "Code: " + this.code + ", Veiculos: " + this.listaVeiculos;
	}
}
