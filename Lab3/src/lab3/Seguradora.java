package lab3;

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
	
	//remover Cliente --> rever
	public void removerCliente(String cliente) {
		var i = 0;
		while(i < this.listaClientes.size()) {
			Cliente remover = this.listaClientes.get(i);
			if(remover.getNome() == cliente) {
				this.listaClientes.remove(remover);
			}
			else
				i++;
		}
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
	
	//visualizar Sinistro --> rever
	public void visualizarSinistro(String cliente) {
		var i = 0;
		for(i = 0; i < this.listaSinistros.size(); i++) {
			Sinistro visualizar = this.listaSinistros.get(i);
			Cliente cliente_v = visualizar.getCliente();
			if(cliente_v.getNome() == cliente) {
				System.out.printf("Sinistro %d: %s\n", i, visualizar.toString());;
			}
		}
	}
	
	//listar Sinistros
	public void listarSinistros() {
		for(var i = 0; i < this.listaSinistros.size(); i++) {
			Sinistro sinistro = this.listaSinistros.get(i);
			System.out.printf("Sinistro %d: %s\n", i, sinistro.toString());
		}
	}
}

