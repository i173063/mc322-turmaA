package lab5;

import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private int qtdeFuncionarios;
	private ArrayList<Frota> listaFrota;

	public ClientePJ(String nome, String endereco, String telefone, String email,
			String cnpj, Date dataFundacao, int qtdeFuncionarios, ArrayList<Frota> listaFrota) {
		super(nome, endereco, telefone, email);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
		this.listaFrota = new ArrayList<Frota>();
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
		public ArrayList<Frota> getListaFrota(){
			return listaFrota;
		}
		public void setFrota(ArrayList<Frota> listaFrota) {
			this.listaFrota = listaFrota;
		}
		public boolean cadastrarFrota(Frota frota) {
			return this.listaFrota.add(frota);
		}
		public boolean atualizarFrota(int funcao, Frota frota, Veiculo veiculo) { //rever
			//funcao 1: adicionar veiculo na frota
			if(funcao == 1) {
				frota.addVeiculo(veiculo);
				return true;
			}
			//funcao 2: remover veiculo da frota
			else if(funcao == 2) {
				frota.removeVeiculo(veiculo);
				return true;
			}
			//funcao 3: remover frota
			else if(funcao == 3) {
				var i = 0;
				String code = frota.getCode();
				while(i < this.listaFrota.size()) {
					Frota remover = this.listaFrota.get(i);
					if(remover.getCode().equals(code)) {
						this.listaFrota.remove(remover);
						return true;
					}
					else
						i++;
				}
				System.out.println("Frota não está na lista\n");
				return false;
			}
			System.out.println("Função inválida!\n");
			return false;
		}
		public boolean getVeiculosPorFrota(String frota) { //rever
			var i = 0;
			while(i < this.listaFrota.size()) {
				Frota nova_frota = this.listaFrota.get(i);
				if(nova_frota.getCode().equals(frota)) {
					ArrayList<Veiculo> listaVeiculos = nova_frota.getListaVeiculos();
					var j = 0;
					while(j < listaVeiculos.size()) {
						Veiculo novo_veiculo = listaVeiculos.get(j);
						System.out.printf("\nVeiculo %d: ", j);
						novo_veiculo.toString();
						j++;
					}
					return true;
				}
				else
					i++;
			}
			System.out.println("Frota não está na lista\n");
			return false;
		}
		
		public String toString() {
			return "CNPJ: " + this.cnpj + ", Data Fundacao: "
		+ this.dataFundacao + ", Nome: " + super.getNome() + ", Endereco: " + super.getEndereco() + 
		", Telefone: " + super.getTelefone() + ", Email: " + super.getEmail() + ", Frota: " + 
		this.getListaFrota() + ", Quantidade de Funcionarios: " + this.qtdeFuncionarios; 
		}
		public boolean cadastrarVeiculo(Veiculo veiculo) {
			return false;
		}
		public ArrayList<Veiculo> getListaVeiculos(){
			return null;
		}
		public boolean removerVeiculo(Veiculo veiculo) {
			return false;
		}
}


