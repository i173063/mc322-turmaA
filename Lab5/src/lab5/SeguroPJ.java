package lab5;

import java.util.ArrayList;
import java.util.Date;

public class SeguroPJ extends Seguro{
	private Frota frota;
	private ClientePJ cliente;
	
	//Construtor
	public SeguroPJ(int id, Date dataInicio, Date dataFim, Seguradora seguradora, 
			ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, int valorMensal,
			Frota frota, ClientePJ cliente) {
		super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
		this.frota = frota;
		this.cliente = cliente;
	}
	//Getters e setters
	public Frota getFrota() {
		return frota;
	}
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	public ClientePJ getCliente() {
		return cliente;
	}
	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}
	public boolean gerarSinistro(Sinistro sinistro) {
		return super.getListaSinistros().add(sinistro);
	}
	public boolean autorizarCondutor(Condutor condutor) { 
		return super.getListaCondutores().add(condutor);
	}
	public boolean desautorizarCondutor(Condutor condutor) {
		var i = 0;
		String cpf = condutor.getCpf();
		while(i < super.getListaCondutores().size()) {
			Condutor remover = super.getListaCondutores().get(i);
			if(remover.getCpf().equals(cpf)) {
				super.getListaCondutores().remove(remover);
				return true;
			}
			else
				i++;
		}
		System.out.println("Condutor não está na lista\n");
		return false;
	}
	public int calcularValor() {//completar
		double resultado = 0;
		//( VALOR_BASE * (10 + ( quantidadeFunc ) /10) *
		//(1 + 1/( quantidadeVeiculos +2) ) *
		//(1 + 1/( AnosPosFundacao +2) ) *
		//(2 + quantidadeSinistrosCliente /10) *
		//(5 + quantidadeSinistrosCondutor /10))

		//VALOR_BASE
		double valor_base = 0;
		valor_base = CalcSeguro.VALOR_BASE.getValor();
		//quantidadeFunc
		int quant_Func = this.cliente.getQtdeFuncionarios();
		//quantidadeVeiculos
		int quant_Veiculos = this.frota.getListaVeiculos().size();
		//anos pos fundacao
		Date data_atual = new Date();
		Date data_fund = this.cliente.getDataFundacao();
		int ano_atual = data_atual.getYear();
		int ano_fund = data_fund.getYear();
		int anos_pos_fund = ano_atual - ano_fund;
		//quantidade de Sinistros por Condutor
		int quant_sin_cond = 0;
		ArrayList<Condutor> lista = super.getListaCondutores();
		for (Condutor condutor : lista) {
	        quant_sin_cond += condutor.getListaSinistros().size();
	    }
		//quantidade de Sinistros por Cliente
		int quant_sin_cliente = 0;
		Seguradora seguradora = super.getSeguradora();
		quant_sin_cliente = seguradora.getSinistroPorCliente(this.cliente).size();
		resultado = (valor_base*(10+(quant_Func)/10)*(1+1/(quant_Veiculos+2))*(1+1/(anos_pos_fund+2))*
				(2 +quant_sin_cliente/10)*(5+quant_sin_cond/10));
		int valor = (int)resultado;
		super.setValorMensal(valor);
		return valor;
	}
	public String toString() {
		return "ID: " + super.getId() + ", Data de Início: " + super.getDataInicio() + ", Data do Fim: " 
	+ super.getDataFim() + ", Seguradora: " + super.getSeguradora() + ", Sinistros: " + super.getListaSinistros() + 
	", Condutores: " + super.getListaCondutores() + ", Valor Mensal: " + super.getValorMensal() + ", Frota: " +
	this.frota + ", Cliente: " + this.cliente;
	}
}
