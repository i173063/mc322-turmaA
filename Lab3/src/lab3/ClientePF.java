package lab3;

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
			ArrayList<Veiculo> listaVeiculos, String cpf, Date dataNascimento) {
		super(nome, endereco, listaVeiculos);
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
	/*	public void setCpf(String cpf) {
			this.cpf = cpf;
		}*/
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
		
		//validar cpf
		public boolean validarCpf(String cpf) {
			if(cpf == null) {
				return false;
			}
			cpf = cpf.replaceAll("[^0-9]+", "");//remover caract nao num
			int n = cpf.length();
			if(n != 11) { //verifica se tem 11 digitos
				return false;
			}
			//verifica digitos iguais
			int i = 0;
			while (i < n) {
				if(cpf.charAt(i) != cpf.charAt(n-1))
					break;
				i++;
			}
			if (i == n)
				return false;
			//calcular digito verificador
			int sm = 0;
			int peso = 10;
			int r, num;
			int digito1, digito2;
			//calculo do digito1
			for (int j = 0; j < 9; j++) {
				num = (int)(cpf.charAt(j)-48);
				sm = sm +(num*peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if((r == 10)||(r == 11))
				digito1 = '0';
			else digito1 = (char)(r+48);
			//calculo do digito2
			sm = 0;
			peso = 11;
			for (int w = 0; w < 10; w++) {
				num = (int)(cpf.charAt(w)-48);
				sm = sm +(num*peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if((r == 10)||(r == 11))
				digito2 = '0';
			else digito2 = (char)(r+48);
			//verificar os digitos calculados com os dados
			if((digito1 != cpf.charAt(9)||(digito2 != cpf.charAt(10))))
				return false;
			return true;
		}
		public String toString() {
			return "CPF: " + this.cpf + ", Genero: "
		+ this.genero + ", Data Licenca: " + this.dataLicenca + ", Educacao: " + this.educacao + 
		", Data Nascimento: " + this.dataNascimento + ", Classe Economica: " + this.classeEconomica +
		", Nome: " + super.getNome() + ", Endereco: " + super.getEndereco() + ", Veiculos: " 
		+ super.getListaVeiculos(); 
		}
}

