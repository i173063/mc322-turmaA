package lab4;

import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Sinistro> listaSinistros;
	
	//Construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSinistros = new ArrayList<Sinistro>();
	}

	//Getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	} 
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public ArrayList<Cliente> getListaClientes(){
		return listaClientes;
	}
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	
	//cadastrar Cliente
	public boolean cadastrarCliente(Cliente cliente) {
		return this.listaClientes.add(cliente);
	}
	
	//remover Cliente
	public boolean removerCliente(String cliente) {
		var i = 0;
		while(i < this.listaClientes.size()) {
			Cliente remover = this.listaClientes.get(i);
			if(remover.getNome().equals(cliente)) {
				this.listaClientes.remove(remover);
				return true;
			}
			else
				i++;
		}
		System.out.println("Cliente não está na lista\n");
		return false;
	}
	
	//listar Clientes
	public void listarClientes() {
		for(var i = 0; i < this.listaClientes.size(); i++) {
			Cliente cliente = this.listaClientes.get(i);
			System.out.printf("Cliente %d: %s\n", i, cliente.toString());
		}
	}
	
	//gerar Sinistro
	public boolean gerarSinistro(Sinistro sinistro) {
		return this.listaSinistros.add(sinistro);
	}
	
	//visualizar Sinistro
	public boolean visualizarSinistro(String cliente) {
		boolean sinistro_encontrado = false;
		for(var i = 0; i < this.listaSinistros.size(); i++) {
			Sinistro visualizar = this.listaSinistros.get(i);
			Cliente cliente_v = visualizar.getCliente();
			if(cliente_v.getNome().equals(cliente)) {
				System.out.printf("Sinistro %d: %s\n", i, visualizar.toString());
				sinistro_encontrado = true;
			}
		}
		if (sinistro_encontrado) {
			return true;
		} else {
			System.out.println("Sinistro não está na lista\n");
			return false;
		}
	}
	
	//listar Sinistros
	public void listarSinistros() {
		for(var i = 0; i < this.listaSinistros.size(); i++) {
			Sinistro sinistro = this.listaSinistros.get(i);
			System.out.printf("Sinistro %d: %s\n", i, sinistro.toString());
		}
	}
	
	public void calcularPrecoSeguroCliente(String cliente) {
		//calculaScore () * (1 + quantidade_de_sinistros )
		double resultado = 0;
		//quantidade_de_sinistros
		int qtdeSinistros = 0;
		double score = 0;
		for(int i = 0; i < this.listaSinistros.size(); i++) {
			Sinistro achar = this.listaSinistros.get(i);
			Cliente cliente_a = achar.getCliente();
			if(cliente_a.getNome().equals(cliente)) {
				qtdeSinistros++;
			}
		}
		//calcula score
		for(var j = 0; j < this.listaClientes.size(); j++) {
			Cliente achar_2 = this.listaClientes.get(j);
			if(achar_2.getNome().equals(cliente)) {
				score = achar_2.calculaScore();
				resultado = score*(1+qtdeSinistros);
				achar_2.setValorSeguro(resultado);
			}
		}
	}
	
	public void calcularReceita(){
		double receita = 0;
		for(var i = 0; i < this.listaClientes.size(); i++) {
			Cliente cliente = this.listaClientes.get(i);
			receita+=cliente.getValorSeguro();
		}
		System.out.printf("O preço da receita é %.1f\n", receita);
	}
}


