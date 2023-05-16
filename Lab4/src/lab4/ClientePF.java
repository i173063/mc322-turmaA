package lab4;

import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
	private final String cpf;
	private Date dataNascimento;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	
	public ClientePF(String nome, String endereco, Date dataLicenca,
			String educacao, String genero, String classeEconomica,
			ArrayList<Veiculo> listaVeiculos, String cpf, Date dataNascimento, double valorSeguro) {
		super(nome, endereco, listaVeiculos, valorSeguro);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
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
		public Date getDataLicenca() {
			return dataLicenca;
		}
		public void setDataLicenca(Date dataLicenca) {
			this.dataLicenca = dataLicenca;
		}
		public String getClasseEconomica() {
			return classeEconomica;
		}
		public void setClasseEconomica(String classeEconomica) {
			this.classeEconomica = classeEconomica;
		}

		
		public double calculaScore() {
			//VALOR_BASE * FATOR_IDADE * quantidadeCarros
			double resultado = 0;
			//VALOR_BASE
			double valor_base = 0;
			valor_base = CalcSeguro.VALOR_BASE.getValor();
			//quantidadeCarros
			int qtdeCarros = 0;
			for(int i = 0; i < super.getListaVeiculos().size(); i++) {
				qtdeCarros++;
			}
			//FATOR_IDADE
			Date data_atual = new Date();
			int ano_atual = data_atual.getYear();
			int ano_nasc = this.dataNascimento.getYear();
			int idade = ano_atual - ano_nasc;
			double fator = 0;
			if(idade > 18 && idade < 30) {
				fator = CalcSeguro.FATOR_18_30.getValor();
			} else if(idade > 30 && idade < 60) {
				fator = CalcSeguro.FATOR_30_60.getValor();
			} else if(idade > 60 && idade < 90) {
				fator = CalcSeguro.FATOR_60_90.getValor();
			}
			resultado = valor_base*qtdeCarros*fator;
			return resultado;
		}
		
		public String toString() {
			return "CPF: " + this.cpf + ", Genero: "
		+ this.genero + ", Data Licenca: " + this.dataLicenca + ", Educacao: " + this.educacao + 
		", Data Nascimento: " + this.dataNascimento + ", Classe Economica: " + this.classeEconomica +
		", Nome: " + super.getNome() + ", Endereco: " + super.getEndereco() + ", Veiculos: " 
		+ super.getListaVeiculos() + ", Valor do Seguro: " + super.getValorSeguro(); 
		}
}


