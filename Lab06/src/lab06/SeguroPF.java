package lab06;

import java.util.ArrayList;
import java.util.Date;

public class SeguroPF extends Seguro{
	private Veiculo veiculo;
	private ClientePF cliente;
	
	//Construtor
	public SeguroPF(int id, Date dataInicio, Date dataFim, Seguradora seguradora, 
			ArrayList<Sinistro> listaSinistros, ArrayList<Condutor> listaCondutores, int valorMensal,
			Veiculo veiculo, ClientePF cliente) {
		super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
		this.veiculo = veiculo;
		this.cliente = cliente;
	}
	//Getters e setters
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public ClientePF getCliente() {
		return cliente;
	}
	public void setCliente(ClientePF cliente) {
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
	public int calcularValor() {
		double resultado = 0;
		//( VALOR_BASE * FATOR_IDADE * (1 + 1/( quantidadeVeiculos +2) ) *
		//2 (2 + quantidadeSinistrosCliente /10) *
		//3 (5 + quantidadeSinistrosCondutor /10) )
		//VALOR_BASE
		double valor_base = 0;
		valor_base = CalcSeguro.VALOR_BASE.getValor();
		//FATOR_IDADE
		Date data_atual = new Date();
		Date data_nasc = this.cliente.getDataNascimento();
		int ano_atual = data_atual.getYear();
		int ano_nasc = data_nasc.getYear();
		int idade = ano_atual - ano_nasc;
		double fator = 0;
		if(idade < 30) {
			fator = CalcSeguro.FATOR_30.getValor();
		} else if(idade >= 30 && idade < 60) {
			fator = CalcSeguro.FATOR_30_60.getValor();
		} else if(idade >= 60 && idade < 90) {
			fator = CalcSeguro.FATOR_60.getValor();
		}
		//quantidadeVeiculos
		int quant_Veiculos = this.cliente.getListaVeiculos().size();
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
		resultado = (valor_base*fator*(1+1/(quant_Veiculos+2))*2*(2+quant_sin_cliente/10)*3*(5+quant_sin_cond/10));
		int valor = (int)resultado;
		super.setValorMensal(valor);
		return valor;
	}
	
	public String toString() {
		return "ID: " + super.getId() + ", Data de Início: " + super.getDataInicio() + ", Data do Fim: " 
	+ super.getDataFim() + ", Seguradora: " + super.getSeguradora() + ", Sinistros: " + super.getListaSinistros() + 
	", Condutores: " + super.getListaCondutores() + ", Valor Mensal: " + super.getValorMensal() + ", Veiculo: " +
	this.veiculo + ", Cliente: " + this.cliente;
	}
}
