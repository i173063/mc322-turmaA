package lab5;

import java.util.ArrayList;
import java.util.Date;

public class Condutor {
	private final String cpf;
	private String nome;
	private String telefone;
	private Date dataNascimento;
	private String endereco;
	private String email;
	private ArrayList<Sinistro> listaSinistros;
	
	public Condutor(String nome, String endereco, String telefone, String email,
			String cpf, Date dataNascimento, ArrayList<Sinistro> listaSinistros) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.email = email;
		this.listaSinistros = new ArrayList<Sinistro>();
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
		public ArrayList<Sinistro> getListaSinistros(){
			return listaSinistros;
		}
		public void setSinistros(ArrayList<Sinistro> listaSinistros) {
			this.listaSinistros = listaSinistros;
		}
		public boolean adicionarSinistro(Sinistro sinistro) {
			return this.listaSinistros.add(sinistro);
		}
		public String toString() {
			return "CPF: " + this.cpf + ", Data Nascimento: " + this.dataNascimento + 
					", Nome: " + this.nome + ", Endereco: " + this.endereco + ", Telefone: " 
					+ this.telefone + ", Email: " + this.email + ", Sinistros: " + this.listaSinistros; 
		}
}
