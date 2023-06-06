package lab5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class Seguro {
	private final int id;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Condutor> listaCondutores;
	private int valorMensal;
	
	//Construtor
	public Seguro(int id, Date dataInicio, Date dataFim, Seguradora seguradora, 
			ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, int valorMensal) {
		Random aleatorio = new Random();
		this.id = aleatorio.nextInt();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaCondutores = new ArrayList<Condutor>();
		this.valorMensal = valorMensal;
	}
	//Getters e setters
	public int getId() {
		return id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Seguradora getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	public void setSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	public ArrayList<Condutor> getListaCondutores(){
		return listaCondutores;
	}
	public void setCondutores(ArrayList<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}
	public int getValorMensal() {
		return valorMensal;
	}
	public void setValorMensal(int valorMensal) {
		this.valorMensal = valorMensal;
	}
	public boolean gerarSinistro(Sinistro sinistro) { //rever
		return this.listaSinistros.add(sinistro);
	}
	public boolean autorizarCondutor(Condutor condutor) { //rever
		return this.listaCondutores.add(condutor);
	}
	public boolean desautorizarCondutor(Condutor condutor) { //rever
		var i = 0;
		String cpf = condutor.getCpf();
		while(i < this.listaCondutores.size()) {
			Condutor remover = this.listaCondutores.get(i);
			if(remover.getCpf().equals(cpf)) {
				this.listaCondutores.remove(remover);
				return true;
			}
			else
				i++;
		}
		System.out.println("Condutor não está na lista\n");
		return false;
	}
	public int calcularValor() {
		int resultado = 0;
		return resultado;
	}
	
	public String toString() {
		return "ID: " + this.id + ", Data de Início: " + this.dataInicio + ", Data do Fim: " 
	+ this.dataFim + ", Seguradora: " + this.seguradora + ", Sinistros: " + this.listaSinistros + 
	", Condutores: " + this.listaCondutores + ", Valor Mensal: " + this.valorMensal;
	}
	
	public abstract Cliente getCliente();
}
