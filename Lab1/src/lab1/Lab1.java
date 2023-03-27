package lab1;

import java.util.Scanner;
import java.util.Random;

public class Lab1 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in); //ler as entradas
		//Ler dados da seguradora
		String nome_seg, telefone_seg, email_seg, endereco_seg;
		System.out.print("\nInforme os dados da seguradora \n");
		System.out.print("nome: ");
		nome_seg = entrada.next();
		System.out.print("telefone: ");
		telefone_seg = entrada.next();
		System.out.print("email: ");
		email_seg = entrada.next();
		System.out.print("endereco: ");
		endereco_seg = entrada.next();
		//Armazenar dados
		Seguradora seguradora = new Seguradora(nome_seg, telefone_seg, email_seg, endereco_seg);
		//Ler dados do veiculo
		String placa, marca, modelo;
		System.out.print("\nInforme os dados do veiculo \n");
		System.out.print("placa: ");
		placa = entrada.next();
		System.out.print("marca: ");
		marca = entrada.next();
		System.out.print("modelo: ");
		modelo = entrada.next();
		//Armazenar dados
		Veiculo veiculo = new Veiculo(placa, marca, modelo);
		//Ler dados do sinistro
		Random aleatorio = new Random(); //numero aleatorio para o id
		String data, endereco_sin;
		int id = aleatorio.nextInt();
		System.out.print("\nInforme os dados sinistro \n");
		System.out.print("data: ");
		data = entrada.next();
		System.out.print("endereco: ");
		endereco_sin = entrada.next();
		//Armazenar dados
		Sinistro sinistro = new Sinistro(id, data, endereco_sin);
		//Ler dados do cliente
		String nome_cli, cpf_cli, dataNascimento, endereco_cli;
		int idade_cli;
		System.out.print("\nInforme os dados do cliente \n");
		System.out.print("nome: ");
		nome_cli = entrada.next();
		System.out.print("cpf: ");
		cpf_cli = entrada.next();
		System.out.print("data de nascimento: ");
		dataNascimento = entrada.next();
		System.out.print("idade: ");
		idade_cli = entrada.nextInt();
		System.out.print("endereco: ");
		endereco_cli = entrada.next();
		//Armazenar dados
		Cliente cliente = new Cliente(nome_cli, cpf_cli, dataNascimento, endereco_cli, idade_cli);
		//Imprime info seguradora 
		System.out.println("\nSeguradora: ");
		System.out.println(seguradora.getNome());
		System.out.println(seguradora.getTelefone());
		System.out.println(seguradora.getEmail());
		System.out.println(seguradora.getEndereco());
		//Imprime info veiculo 
		System.out.println("\nVeiculo: ");
		System.out.println(veiculo.getPlaca());
		System.out.println(veiculo.getMarca());
		System.out.println(veiculo.getModelo());
		//Imprime info sinistro 
		System.out.println("\nSinistro: ");
		System.out.println(sinistro.getId());
		System.out.println(sinistro.getData());
		System.out.println(sinistro.getEndereco());
		//Imprime info sinistro 
		System.out.println("\nCliente: ");
		System.out.println(cliente.getNome());
		boolean resposta = cliente.validarCpf(cpf_cli);
		//System.out.println(resposta);
		if(resposta == true) {
			System.out.println(cliente.getCpf());
		}
		else 
			System.out.println("CPF inválido");
		System.out.println(cliente.getDataNascimento());
		System.out.println(cliente.getIdade());
		System.out.println(cliente.getEndereco());
	}

}
