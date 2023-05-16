package lab4;

import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private int qtdeFuncionarios;
	
	public ClientePJ(String nome, String endereco, Date dataFundacao,
			String cnpj, ArrayList<Veiculo> listaVeiculos, double valorSeguro, int qtdeFuncionarios) {
		super(nome, endereco, listaVeiculos, valorSeguro);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;//rever
	}
	//Getters e setters
		public String getCnpj() {
			return cnpj;
		}
		public Date getDataFundacao() {
			return dataFundacao;
		}
		public void setDataFundacao(Date dataFundacao) {
			this.dataFundacao = dataFundacao;
		}
		public int getQtdeFuncionarios() {
			return qtdeFuncionarios;
		}
		public void setQtdeFuncionarios(int qtdeFuncionarios) {
			this.qtdeFuncionarios = qtdeFuncionarios;
		}

		
		public double calculaScore() {
			//VALOR_BASE * (1 + ( quantidadeFunc ) /100) * quantidadeCarros
			double resultado = 0;
			//VALOR_BASE
			double valor_base = 0;
			valor_base = CalcSeguro.VALOR_BASE.getValor();
			//quantidadeCarros
			int qtdeCarros = 0;
			for(int i = 0; i < super.getListaVeiculos().size(); i++) {
				qtdeCarros++;
			}
			//(1 + ( quantidadeFunc ) /100)
			int qtdeFunc = 1+(this.qtdeFuncionarios)/100;
			resultado = valor_base*qtdeCarros*qtdeFunc;
			return resultado;
		}
		
		
		public String toString() {
			return "CNPJ: " + this.cnpj + ", Data Fundacao: "
		+ this.dataFundacao + ", Nome: " + super.getNome() + ", Endereco: " + super.getEndereco() + 
		", Veiculos: " + super.getListaVeiculos() + ", Valor do Seguro: " + super.getValorSeguro() +
		", Quantidade de Funcionarios: " + this.qtdeFuncionarios; 
		}
}
//


