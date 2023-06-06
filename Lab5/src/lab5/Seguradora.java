package lab5;

import java.util.ArrayList;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Seguro> listaSeguros;
	
	//Construtor
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco,
			 ArrayList<Cliente> listaClientes,  ArrayList<Seguro> listaSeguros) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new ArrayList<Cliente>();
		this.listaSeguros = new ArrayList<Seguro>();
	}

	//Getters e setters
	public String getCnpj() {
		return cnpj;
	}
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
	public void setClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public ArrayList<Seguro> getListaSeguros(){
		return listaSeguros;
	}
	public void setSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
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
	
	//gerar Seguro
	public boolean gerarSeguro(Seguro seguro) {
		return this.listaSeguros.add(seguro);
	}
	//cancelar Seguro
	public boolean cancelarSeguro(int id) {
		var i = 0;
		while(i < this.listaSeguros.size()) {
			Seguro remover = this.listaSeguros.get(i);
			if(remover.getId() == id) {
				this.listaSeguros.remove(remover);
				return true;
			}
			else
				i++;
		}
		System.out.println("Seguro não está na lista\n");
		return false;
	}
	//get seguros por cliente
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		ArrayList<Seguro> listaSegurosPorCliente = new ArrayList<Seguro>();
		for (Seguro seguro : listaSeguros) {
	        if (seguro.getCliente().equals(cliente)) {
	            listaSegurosPorCliente.add(seguro);
	        }
	    }
		return listaSegurosPorCliente;
	}
	//get sinistros por cliente
	public ArrayList<Sinistro> getSinistroPorCliente(Cliente cliente){
		ArrayList<Sinistro> listaSinistrosPorCliente = new ArrayList<Sinistro>();
		for (Seguro seguro : listaSeguros) {
	        if (seguro.getCliente().equals(cliente)) {
	            listaSinistrosPorCliente.addAll(seguro.getListaSinistros());
	        }
	    }
		return listaSinistrosPorCliente;
	}
	//calcular receita
	public void calcularReceita(){
		int receita = 0;
		for(var i = 0; i < this.listaSeguros.size(); i++) {
			Seguro seguro = this.listaSeguros.get(i);
			receita+=seguro.getValorMensal();
		}
		System.out.printf("O preço da receita é %d\n", receita);
	}
}
