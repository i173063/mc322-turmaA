package lab06;

import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
	private final String cpf;
	private String dataNascimento;
	private String educacao;
	private String genero;
	private ArrayList<Veiculo> listaVeiculos;
	private String placa;
	
	public ClientePF(String cpf, String nome, String telefone, String endereco,
			String email, String sexo, String ensino, String dataNasc,
			String placa, ArrayList<Veiculo> listaVeiculos) {
		super(nome, telefone, endereco, email);
		this.cpf = cpf;
		this.dataNascimento = dataNasc;
		this.educacao = ensino;
		this.genero = sexo;
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.placa = placa;
	}
	//Getters e setters
		public String getCpf() {
			return cpf;
		}
		public String getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public String getEducacao() {
			return educacao;
		}
		public void setEducacao(String educacao) {
			this.educacao = educacao;
		}
		public String getPlaca() {
			return placa;
		}
		public void setPlaca(String placa) {
			this.placa = placa;
		}
		public ArrayList<Veiculo> getListaVeiculos(){
			return listaVeiculos;
		}
		public void setVeiculos(ArrayList<Veiculo> listaVeiculos) {
			this.listaVeiculos = listaVeiculos;
		}
		public boolean cadastrarVeiculo(Veiculo veiculo) {
			return this.listaVeiculos.add(veiculo);
		}
		public boolean removerVeiculo(Veiculo veiculo) {
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
			var i = 0;
			ArrayList<String> placas = new ArrayList<String>();
			while(i < this.listaVeiculos.size()) {
				Veiculo veiculo = this.listaVeiculos.get(i);
				String placa = veiculo.getPlaca();
				placas.add(placa);
			}
			return this.cpf + "," + super.getNome() + "," + super.getTelefone() + 
					"," + super.getEndereco() + "," + super.getEmail() + 
					"," + this.genero + "," + this.educacao + 
					"," + this.dataNascimento + "," + placas; 
		}
		public boolean cadastrarFrota(Frota frota) {
			return false;
		}
		public ArrayList<Frota> getListaFrota(){
			return null;
		}
		public  boolean atualizarFrota(int funcao, Frota frota, Veiculo veiculo) {
			return false;
		}
		public boolean getVeiculosPorFrota(String frota) {
			return false;
		}
}


