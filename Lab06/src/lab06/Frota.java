package lab06;

import java.util.ArrayList;

public class Frota {
	private String code;
	private ArrayList<Veiculo> listaVeiculos;
	private ArrayList<String> placas;
	
	//Construtor
	public Frota(String code, ArrayList<String> placas, ArrayList<Veiculo> listaVeiculos) {
		this.code = code;
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.placas = placas;
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
	public ArrayList<String> getListaPlacas(){
		return placas;
	}
	public void setPlacas(ArrayList<String> placas) {
		this.placas = placas;
	}
	public boolean addPlaca(String placa) {
		return this.placas.add(placa);
	}
	public boolean removePlaca(String placa) {
		var i = 0;
		while(i < this.placas.size()) {
			String remover = this.placas.get(i);
			if(remover.equals(placa)) {
				this.placas.remove(remover);
				return true;
			}
			else
				i++;
		}
		return false;
	}
	
	public String toString() {
		var i = 0;
		ArrayList<String> p = new ArrayList<String>();
		while(i < this.listaVeiculos.size()) {
			Veiculo veiculo = this.listaVeiculos.get(i);
			String placa = veiculo.getPlaca();
			p.add(placa);
		}
		return this.code + "," + p.get(0) + "," + p.get(1) + "," + p.get(2);
	}
}
