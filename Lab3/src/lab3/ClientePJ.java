package lab3;

import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	
	public ClientePJ(String nome, String endereco, Date dataFundacao,
			String cnpj, ArrayList<Veiculo> listaVeiculos) {
		super(nome, endereco, listaVeiculos);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}
	//Getters e setters
		public String getCnpj() {
			return cnpj;
		}
	/*	public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}*/
		public Date getDataFundacao() {
			return dataFundacao;
		}
		public void setDataFundacao(Date dataFundacao) {
			this.dataFundacao = dataFundacao;
		}
		
		//validar cnpj
		public boolean validarCnpj(String cnpj) {
			if(cnpj == null) {
				return false;
			}
			cnpj = cnpj.replaceAll("[^0-9]+", "");//remover caract nao num
			int n = cnpj.length();
			if(n != 14) { //verifica se tem 14 digitos
				return false;
			}
			//verifica digitos iguais
			int i = 0;
			while (i < n) {
				if(cnpj.charAt(i) != cnpj.charAt(n-1))
					break;
				i++;
			}
			if (i == n)
				return false;
			//calcular digito verificador
			int sm = 0;
			int p1 = 5;
			int p2 = 13;
			int r, num;
			int digito1, digito2;
			//calculo do digito1
			for (var j = 0; j < 12; j++, p1--, p2--) {
				if(p1 >=2) {
					num = (int)(cnpj.charAt(j)-48);
					sm = sm +(num*p1);	
				}
				else {
					num = (int)(cnpj.charAt(j)-48);
					sm = sm +(num*p2);
				}
			}
			r = sm % 11;
			if(r < 2)
				digito1 = '0';
			else digito1 = (char)(48+(11-r));
			//calculo do digito2
			sm = 0;
			int p3 = 6;
			int p4 = 14;
			for (var j = 0; j < 13; j++, p3--, p4--) {
				if(p3 >=2) {
					num = (int)(cnpj.charAt(j)-48);
					sm = sm +(num*p3);	
				}
				else {
					num = (int)(cnpj.charAt(j)-48);
					sm = sm +(num*p4);
				}
			}
			r = sm % 11;
			if(r < 2)
				digito2 = '0';
			else digito2 = (char)(48+(11-r));
			//verificar os digitos calculados com os dados
			if((digito1 != cnpj.charAt(12)||(digito2 != cnpj.charAt(13))))
				return false;
			return true;
		}
		public String toString() {
			return "CNPJ: " + this.cnpj + ", Data Fundacao: "
		+ this.dataFundacao + ", Nome: " + super.getNome() + ", Endereco: " + super.getEndereco() + 
		", Veiculos: " + super.getListaVeiculos(); 
		}
}


