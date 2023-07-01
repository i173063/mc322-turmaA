package lab06;

import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private String dataFundacao;
	private ArrayList<Frota> listaFrota;
	private String code;

	public ClientePJ(String cnpj, String nome, String telefone, String endereco, String email,
			String dataFundacao, String code, ArrayList<Frota> listaFrota) {
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.listaFrota = new ArrayList<Frota>();
		this.code = code;
	}
	//Getters e setters
		public String getCnpj() {
			return cnpj;
		}
		public String getDataFundacao() {
			return dataFundacao;
		}
		public void setDataFundacao(String dataFundacao) {
			this.dataFundacao = dataFundacao;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
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
			var i = 0;
			ArrayList<String> codes = new ArrayList<String>();
			while(i < this.listaFrota.size()) {
				Frota frota = this.listaFrota.get(i);
				String code = frota.getCode();
				codes.add(code);
			}
			return this.cnpj + "," + super.getNome() + "," + super.getTelefone() + "," + 
			super.getEndereco() + "," + super.getEmail() + "," + this.dataFundacao + "," 
			+ codes; 
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


