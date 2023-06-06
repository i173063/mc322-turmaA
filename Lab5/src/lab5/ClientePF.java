package lab5;

import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
	private final String cpf;
	private Date dataNascimento;
	private String educacao;
	private String genero;
	private ArrayList<Veiculo> listaVeiculos;
	
	public ClientePF(String nome, String endereco, String telefone, String email,
			String cpf, Date dataNascimento, String educacao, String genero,
			ArrayList<Veiculo> listaVeiculos) {
		super(nome, endereco, telefone, email);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.educacao = educacao;
		this.genero = genero;
		this.listaVeiculos = new ArrayList<Veiculo>();
	}
	//Getters e setters
		public String getCpf() {
			return cpf;
		}
		public Date getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Date dataNascimento) {
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
			return "CPF: " + this.cpf + ", Genero: " + this.genero + ", Educacao: " + this.educacao + 
					", Data Nascimento: " + this.dataNascimento + ", Nome: " + super.getNome() + 
					", Endereco: " + super.getEndereco() + ", Telefone: " + super.getTelefone() + 
					", Email: " + super.getEmail() + ", Veiculos: " + this.listaVeiculos; 
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


