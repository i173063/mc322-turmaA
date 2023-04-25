package lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		Scanner entrada = new Scanner(System.in);
		//ler seguradora
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
		Seguradora seguradora = new Seguradora(nome_seg, telefone_seg, email_seg, endereco_seg);
		//ler pf
		String nome_cpf, endereco_cpf, educacao_cpf, genero_cpf, classe_cpf, cpf;
		String data_nasc;
		String data_lic;
		ArrayList<Veiculo> listaVeiculos1 = null;
		System.out.print("\nInforme os dados do Cliente PF \n");
		System.out.print("nome: ");
		nome_cpf = entrada.next();
		System.out.print("endereco: ");
		endereco_cpf = entrada.next();
		System.out.print("educacao: ");
		educacao_cpf = entrada.next();
		System.out.print("genero: ");
		genero_cpf = entrada.next();
		System.out.print("classe economica: ");
		classe_cpf = entrada.next();
		System.out.print("CPF: ");
		cpf = entrada.next();
		System.out.print("data de nascimento: ");
		data_nasc = entrada.next();
		SimpleDateFormat formatar1 = new SimpleDateFormat("dd/MM/yyyy");
		Date data_Nasc = formatar1.parse(data_nasc);
		System.out.print("data de licenca: ");
		data_lic = entrada.next();
		SimpleDateFormat formatar2 = new SimpleDateFormat("dd/MM/yyyy");
		Date data_Lic = formatar2.parse(data_lic);
		ClientePF cliente1 = new ClientePF(nome_cpf, endereco_cpf, data_Lic,
				educacao_cpf, genero_cpf, classe_cpf, listaVeiculos1, cpf, data_Nasc);
		//ler veiculo e adicionar
		String placa, marca, modelo;
		int ano_fab;
		System.out.print("\nInforme os dados do veiculo \n");
		System.out.print("placa: ");
		placa = entrada.next();
		System.out.print("marca: ");
		marca = entrada.next();
		System.out.print("modelo: ");
		modelo = entrada.next();
		System.out.print("ano de fabricacao: ");
		ano_fab = entrada.nextInt();
		Veiculo veiculo = new Veiculo(placa, marca, modelo, ano_fab);
		System.out.print(veiculo.toString());
		System.out.print("\n");
		boolean adiciona = cliente1.adicionaVeiculo(veiculo);
		//cadastrar pf
		boolean cadastra = seguradora.cadastrarCliente(cliente1);
		//verificar cpf
		boolean verifica_cpf = cliente1.validarCpf(cpf);
		if(verifica_cpf == true) {
			System.out.println("\nCPF válido\n");
		}
		else
			System.out.println("\nCPF inválido\n");
		System.out.print(cliente1.toString());
		System.out.print("\n");
		//ler pj1
		String nome_cpj1, endereco_cpj1, cnpj1;
		String data_fund1;
		ArrayList<Veiculo> listaVeiculos2 = null;
		System.out.print("\nInforme os dados do Cliente PJ 1 \n");
		System.out.print("nome: ");
		nome_cpj1 = entrada.next();
		System.out.print("endereco: ");
		endereco_cpj1 = entrada.next();
		System.out.print("CNPJ: ");
		cnpj1 = entrada.next();
		System.out.print("data de fundacao: ");
		data_fund1 = entrada.next();
		SimpleDateFormat formatar3 = new SimpleDateFormat("dd/MM/yyyy");
		Date data_Fund1 = formatar3.parse(data_fund1);
		ClientePJ cliente2 = new ClientePJ(nome_cpj1, endereco_cpj1, data_Fund1,
				cnpj1, listaVeiculos2);
		//ler veiculo e adicionar
		String placa2, marca2, modelo2;
		int ano_fab2;
		System.out.print("\nInforme os dados do veiculo \n");
		System.out.print("placa: ");
		placa2 = entrada.next();
		System.out.print("marca: ");
		marca2 = entrada.next();
		System.out.print("modelo: ");
		modelo2 = entrada.next();
		System.out.print("ano de fabricacao: ");
		ano_fab2 = entrada.nextInt();
		Veiculo veiculo2 = new Veiculo(placa2, marca2, modelo2, ano_fab2);
		System.out.print(veiculo2.toString());
		System.out.print("\n");
		boolean adiciona2 = cliente2.adicionaVeiculo(veiculo2);
		//cadastrar pj1
		boolean cadastra2 = seguradora.cadastrarCliente(cliente2);
		//verificar cnpj1
		boolean verifica_cnpj = cliente2.validarCnpj(cnpj1);
		if(verifica_cnpj == true) {
			System.out.println("\nCNPJ válido\n");
		}
		else
			System.out.println("\nCNPJ inválido\n");
		System.out.print(cliente2.toString());
		System.out.print("\n");
		//ler pj2
		String nome_cpj2, endereco_cpj2, cnpj2;
		String data_fund2;
		ArrayList<Veiculo> listaVeiculos3 = null;
		System.out.print("\nInforme os dados do Cliente PJ 2 \n");
		System.out.print("nome: ");
		nome_cpj2 = entrada.next();
		System.out.print("endereco: ");
		endereco_cpj2 = entrada.next();
		System.out.print("CNPJ: ");
		cnpj2 = entrada.next();
		System.out.print("data de fundacao: ");
		data_fund2 = entrada.next();
		SimpleDateFormat formatar4 = new SimpleDateFormat("dd/MM/yyyy");
		Date data_Fund2 = formatar4.parse(data_fund2);
		ClientePJ cliente3 = new ClientePJ(nome_cpj2, endereco_cpj2, data_Fund2,
				cnpj2, listaVeiculos3);
		//ler veiculo e adicionar
		String placa3, marca3, modelo3;
		int ano_fab3;
		System.out.print("\nInforme os dados do veiculo \n");
		System.out.print("placa: ");
		placa3 = entrada.next();
		System.out.print("marca: ");
		marca3 = entrada.next();
		System.out.print("modelo: ");
		modelo3 = entrada.next();
		System.out.print("ano de fabricacao: ");
		ano_fab3 = entrada.nextInt();
		Veiculo veiculo3 = new Veiculo(placa3, marca3, modelo3, ano_fab3);
		System.out.print(veiculo3.toString());
		System.out.print("\n");
		boolean adiciona3 = cliente3.adicionaVeiculo(veiculo3);
		//cadastrar pj2
		boolean cadastra3 = seguradora.cadastrarCliente(cliente3);
		//verificar cnpj2
		boolean verifica_cnpj2 = cliente3.validarCnpj(cnpj2);
		if(verifica_cnpj2 == true) {
			System.out.println("\nCNPJ válido\n");
		}
		else
			System.out.println("\nCNPJ inválido\n");
		System.out.print(cliente3.toString());
		System.out.print("\n");
		//listar clientes
		System.out.println("\nClientes da Seguradora:\n");
		seguradora.listarClientes();
		//remover cliente
		System.out.println("\nRemover Ultimo Cliente:");
		seguradora.removerCliente(cliente3.getNome());
		//listar clientes
		System.out.println("\nClientes da Seguradora:\n");
		seguradora.listarClientes();
		//ler sinistro1
		String data1, endereco_sin1;
		System.out.print("\nInforme os dados sinistro \n");
		System.out.print("data: ");
		data1 = entrada.next();
		System.out.print("endereco: ");
		endereco_sin1 = entrada.next();
		Sinistro sinistro1 = new Sinistro(0, data1, endereco_sin1, cliente1, veiculo, seguradora);
		System.out.print(sinistro1.toString());
		System.out.print("\n");
		//gerar sinistro
		boolean gerar1 = seguradora.gerarSinistro(sinistro1);
		//ler sinistro2
		String data2, endereco_sin2;
		System.out.print("\nInforme os dados sinistro \n");
		System.out.print("data: ");
		data2 = entrada.next();
		System.out.print("endereco: ");
		endereco_sin2 = entrada.next();
		Sinistro sinistro2 = new Sinistro(0, data2, endereco_sin2, cliente2, veiculo2, seguradora);
		System.out.print(sinistro2.toString());
		System.out.print("\n");
		//gerar sinistro
		boolean gerar2 = seguradora.gerarSinistro(sinistro2);
		//listar sinistro
		System.out.println("\nLista de Sinistros:\n");
		seguradora.listarSinistros();
		//visualizar sinistro
		System.out.println("\nSinistro do Cliente 1:\n");
		seguradora.visualizarSinistro(cliente1.getNome());
	}
}

