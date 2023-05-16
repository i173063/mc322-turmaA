package lab4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppMain {
	private static ArrayList<Seguradora> seguradoras = new ArrayList<Seguradora>();
	//exibir menu externo
		private static void exibirMenuExterno() {
			MenuOperacoes menuOperacoes[] = MenuOperacoes.values();
			System.out.println("Menu principal");
			for(MenuOperacoes op: menuOperacoes) {
				System.out.println(op.ordinal() + " - " + op.getDescricao());
			}
		}
		
		// exibir submenus
		private static void exibirSubmenu(MenuOperacoes op) {
			SubmenuOpcoes[] submenu = op.getSubmenu();
			System.out.println(op.getDescricao());
			for(int i=0; i<submenu.length; i++) {
				System.out.println(i +" - " + submenu[i].getDescricao());
			}
		}
		
		//ler opções do menu externo
		private static MenuOperacoes lerOpcaoMenuExterno() {
			Scanner scanner = new Scanner(System.in);
			int opUsuario;
			MenuOperacoes opUsuarioConst;
			do {
				System.out.println("Digite uma opcao: ");
				opUsuario = scanner.nextInt();
			}while(opUsuario < 0 || opUsuario > MenuOperacoes.values().length - 1);
			opUsuarioConst = MenuOperacoes.values()[opUsuario];
			return opUsuarioConst;
		}
		
		//ler opção dos submenus
		private static SubmenuOpcoes lerOpcaoSubmenu(MenuOperacoes op) {
			Scanner scanner = new Scanner(System.in);
			int opUsuario;
			SubmenuOpcoes opUsuarioConst;
			do {
				System.out.println("Digite uma opcao: ");
				opUsuario = scanner.nextInt();
			}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
			opUsuarioConst = op.getSubmenu()[opUsuario];
			return opUsuarioConst;
		}
		
		//executar opções do menu externo
		private static void executarOpcaoMenuExterno(MenuOperacoes op) throws ParseException {
			ArrayList<Seguradora> seguradoras2 = new ArrayList<Seguradora>();
			seguradoras2 = seguradoras; 
			Scanner entrada = new Scanner(System.in);
			switch(op) {
				case CADASTROS:
				case LISTAR:
				case EXCLUIR:
					executarSubmenu(op);
					break;
				case GERAR_SINISTRO:
					//System.out.println("Executar metodo gerar Sinistro");
					String data, endereco_sin, nome_seguradora, nome_cliente, placa_veiculo;
					System.out.print("\nInforme os dados do sinistro \n");
					System.out.print("data: ");
					data = entrada.next();
					SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
					Date data_s = formatar.parse(data);
					System.out.print("endereco: ");
					endereco_sin = entrada.next();
					System.out.print("nome da seguradora: ");
					nome_seguradora = entrada.next();
					System.out.print("nome do cliente: ");
					nome_cliente = entrada.next();
					System.out.print("placa do veiculo: ");
					placa_veiculo = entrada.next();
					for(var i = 0; i < seguradoras.size(); i++) {
						Seguradora seguradora = seguradoras.get(i);
						if (seguradora.getNome().equals(nome_seguradora)) {
							//encontrar cliente
							ArrayList<Cliente> clientes = seguradora.getListaClientes();
							for(var j = 0; j < clientes.size(); j++) {
								Cliente cliente = clientes.get(j);
								if (cliente.getNome().equals(nome_cliente)) {
									//listar veiculos
									ArrayList<Veiculo> veiculos = cliente.getListaVeiculos();
									for(var w = 0; w < veiculos.size(); w++) {
										Veiculo veiculo = veiculos.get(w);
										if (veiculo.getPlaca().equals(placa_veiculo)) {
											Sinistro sinistro = new Sinistro(0, data_s, endereco_sin, cliente, veiculo, seguradora);
											//gerar sinistro
											boolean gerar = seguradora.gerarSinistro(sinistro);
											System.out.println("Sinistro gerado!");
											//calcula seguro e armazena
											seguradora.calcularPrecoSeguroCliente(nome_cliente);
										}
									}
								}
							}
						}
					}
					break;
				case TRANSFERIR_SEGURO:
					//System.out.println("Executar metodo tranferir seguro");
					String nome_seg, nome_cliente1, nome_cliente2, veiculo_placa;
					System.out.print("\nInforme os dados da tranferência \n");
					System.out.print("nome da seguradora: ");
					nome_seg = entrada.next();
					System.out.print("nome do cliente que irá transferir: ");
					nome_cliente1 = entrada.next();
					System.out.print("nome do cliente que irá receber: ");
					nome_cliente2 = entrada.next();
					System.out.print("placa do veiculo de transferência: ");
					veiculo_placa = entrada.next();
					Veiculo veiculo_add = (null);
					Sinistro sinistro_add = (null);
					for(var i = 0; i < seguradoras.size(); i++) {
						Seguradora seguradora = seguradoras.get(i);
						if (seguradora.getNome().equals(nome_seg)) {
							//encontrar clientes
							ArrayList<Sinistro> sinistros = seguradora.getListaSinistros();
							for(var j = 0; j < sinistros.size(); j++) {
								Sinistro sinistro1 = sinistros.get(j);
								Cliente cliente1 = sinistro1.getCliente();
								if (cliente1.getNome().equals(nome_cliente1)) {
									//remover veiculo
									ArrayList<Veiculo> veiculos = cliente1.getListaVeiculos();
									for(var w = 0; w < veiculos.size(); w++) {
										Veiculo veiculo = veiculos.get(w);
										if (veiculo.getPlaca().equals(veiculo_placa)) {
											veiculo_add = veiculo;
											sinistro_add = sinistro1;
											veiculos.remove(veiculo_add);
											sinistros.remove(sinistro_add);
											seguradora.calcularPrecoSeguroCliente(nome_cliente1);
										}
									}
								} 
							}
							ArrayList<Cliente> clientes = seguradora.getListaClientes();
							for(var w = 0; w < clientes.size(); w++) {
								Cliente cliente2 = clientes.get(w);
								if (cliente2.getNome().equals(nome_cliente2)) {
									//adiciona veiculo
									boolean adiciona = cliente2.adicionaVeiculo(veiculo_add);
									//gera sinistro
									Sinistro sinistro2 = new Sinistro(sinistro_add.getId(), sinistro_add.getData(), sinistro_add.getEndereco(), 
											cliente2, veiculo_add, seguradora);
									boolean gerar = seguradora.gerarSinistro(sinistro2);
									seguradora.calcularPrecoSeguroCliente(nome_cliente2);
									System.out.println("Transferência concluída!");
								}
							}
						}
					}
					break;
				case CALCULAR_RECEITA:
					//System.out.println("Executar metodo calcular receita");
					String nome_seguradora3;
					System.out.print("nome da seguradora: ");
					nome_seguradora3 = entrada.next();
					for(var i = 0; i < seguradoras.size(); i++) {
						Seguradora seguradora3 = seguradoras.get(i);
						if (seguradora3.getNome().equals(nome_seguradora3)) {
							//calcular receita
							seguradora3.calcularReceita();
						}
					}
					break;
			}
		}
		
		public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) throws ParseException {
			ArrayList<Seguradora> seguradoras3 = new ArrayList<Seguradora>();
			seguradoras3 = seguradoras; 
			Scanner entrada = new Scanner(System.in);
			switch(opSubmenu) {
			case CADASTRAR_CLIENTE:
				//System.out.println("Chamar metodo cadastrar cliente");
				int tipo_cliente;
				System.out.println("Cliente PJ(1) ou Cliente PF(2)?");
				tipo_cliente = entrada.nextInt();
				if(tipo_cliente == 2) {
					String nome_cpf, endereco_cpf, educacao_cpf, genero_cpf, classe_cpf, cpf;
					String data_nasc;
					String data_lic;
					double valor_seg = 0; //rever
					ArrayList<Veiculo> listaVeiculos = null;
					System.out.print("\nInforme os dados do Cliente PF \n");
					System.out.print("nome: ");
					nome_cpf = entrada.next();
					Validacao.validarNome(nome_cpf);//rever
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
					Validacao.validarCpf(cpf);
					System.out.print("data de nascimento: ");
					data_nasc = entrada.next();
					SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
					Date data_Nasc = formatar.parse(data_nasc);
					System.out.print("data de licenca: ");
					data_lic = entrada.next();
					SimpleDateFormat formatar2 = new SimpleDateFormat("dd/MM/yyyy");
					Date data_Lic = formatar2.parse(data_lic);
					ClientePF cliente = new ClientePF(nome_cpf, endereco_cpf, data_Lic,
							educacao_cpf, genero_cpf, classe_cpf, listaVeiculos, cpf, data_Nasc, valor_seg);
					//encontrar a seguradora
					String nome_seguradora;
					System.out.print("nome da seguradora: ");
					nome_seguradora = entrada.next();
					for(Seguradora seguradora : seguradoras) {
						if (seguradora.getNome().equals(nome_seguradora)) {
							//cadastra cliente
							boolean cadastra = seguradora.cadastrarCliente(cliente);
							System.out.println("Cliente cadastrado!");
						}
					}
				} else if (tipo_cliente == 1) {
					String nome_cpj, endereco_cpj, cnpj;
					String data_fund;
					int qtde_func;
					double valor_seg = 0; //rever
					ArrayList<Veiculo> listaVeiculos2 = null;
					System.out.print("\nInforme os dados do Cliente PJ\n");
					System.out.print("nome: ");
					nome_cpj = entrada.next();
					Validacao.validarNome(nome_cpj);//rever
					System.out.print("endereco: ");
					endereco_cpj = entrada.next();
					System.out.print("CNPJ: ");
					cnpj = entrada.next();
					Validacao.validarCnpj(cnpj);
					System.out.print("quantidade de funcionários: ");
					qtde_func = entrada.nextInt();
					System.out.print("data de fundacao: ");
					data_fund = entrada.next();
					SimpleDateFormat formatar3 = new SimpleDateFormat("dd/MM/yyyy");
					Date data_Fund = formatar3.parse(data_fund);
					ClientePJ cliente = new ClientePJ(nome_cpj, endereco_cpj, data_Fund,
							cnpj, listaVeiculos2, valor_seg, qtde_func);
					//encontrar a seguradora
					String nome_seguradora;
					System.out.print("nome da seguradora: ");
					nome_seguradora = entrada.next();
					for(var i = 0; i < seguradoras.size(); i++) {
						Seguradora seguradora = seguradoras.get(i);
						if (seguradora.getNome().equals(nome_seguradora)) {
							//cadastra cliente
							boolean cadastra = seguradora.cadastrarCliente(cliente);
							System.out.println("Cliente cadastrado!");
						}
					}
				}
				break;
			case CADASTRAR_VEICULO:
				//System.out.println("Chamar metodo cadastrar veiculo");
				String placa, marca, modelo, nome_cliente, nome_seguradora;
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
				//System.out.print(veiculo.toString());
				//encontrar a seguradora
				System.out.print("nome da seguradora: ");
				nome_seguradora = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					//System.out.println("Entrei");
					Seguradora seguradora = seguradoras.get(i);
					if (seguradora.getNome().equals(nome_seguradora)) {
						//encontrar cliente
						System.out.print("nome do cliente: ");
						nome_cliente = entrada.next();
						ArrayList<Cliente> clientes = seguradora.getListaClientes();
						for(var j = 0; j < clientes.size(); j++) {
							Cliente cliente = clientes.get(j);
							if (cliente.getNome().equals(nome_cliente)) {
								//adiciona veiculo
								boolean adiciona = cliente.adicionaVeiculo(veiculo);
								System.out.println("Veiculo cadastrado!");
							}
						}
					}
				}
				break;
			case CADASTRAR_SEGURADORA:
				//System.out.println("Chamar metodo cadastrar seguradora");
				String nome_seg, telefone_seg, email_seg, endereco_seg;
				System.out.print("\nInforme os dados da seguradora \n");
				System.out.print("nome: ");
				nome_seg = entrada.next();
				Validacao.validarNome(nome_seg);//rever
				System.out.print("telefone: ");
				telefone_seg = entrada.next();
				System.out.print("email: ");
				email_seg = entrada.next();
				System.out.print("endereco: ");
				endereco_seg = entrada.next();
				Seguradora seguradora = new Seguradora(nome_seg, telefone_seg, email_seg, endereco_seg);
				seguradoras.add(seguradora);
				System.out.println("Seguradora cadastrada");
				break;
			case LISTAR_CLIENTES:
				//System.out.println("Chamar metodo listar clientes");
				String nome;
				System.out.print("nome da seguradora: ");
				nome = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora1 = seguradoras.get(i);
					if (seguradora1.getNome().equals(nome)) {
						//listar clientes
						System.out.println("\nClientes da Seguradora:\n");
						seguradora1.listarClientes();
					}
				}
				break;
			case LISTAR_SINISTROS_SEG:
				//System.out.println("Chamar metodo listar sinistros por seguradora");
				String nome2;
				System.out.print("nome da seguradora: ");
				nome2 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora2 = seguradoras.get(i);
					if (seguradora2.getNome().equals(nome2)) {
						//listar sinistro
						System.out.println("\nLista de Sinistros:\n");
						seguradora2.listarSinistros();
					}
				}
				break;
			case LISTAR_SINISTRO_CLIENTE:
				//System.out.println("Chamar metodo listar sinistros por cliente");
				String nome3;
				System.out.print("nome da seguradora: ");
				nome3 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora3 = seguradoras.get(i);
					if (seguradora3.getNome().equals(nome3)) {
						//encontrar cliente
						String nome_cliente2;
						System.out.print("nome do cliente: ");
						nome_cliente2 = entrada.next();
						ArrayList<Cliente> clientes2 = seguradora3.getListaClientes();
						for(var j = 0; j < clientes2.size(); j++) {
							Cliente cliente2 = clientes2.get(j);
							if (cliente2.getNome().equals(nome_cliente2)) {
								//visualizar sinistro
								System.out.println("\nSinistro do Cliente:\n");
								seguradora3.visualizarSinistro(cliente2.getNome());
							}
						}
					}
				}
				break;
			case LISTAR_VEICULOS_CLIENTE:
				//System.out.println("Chamar metodo listar veiculos por cliente");
				String nome4;
				System.out.print("nome da seguradora: ");
				nome4 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora4 = seguradoras.get(i);
					if (seguradora4.getNome().equals(nome4)) {
						//encontrar cliente
						String nome_cliente3;
						System.out.print("nome do cliente: ");
						nome_cliente3 = entrada.next();
						ArrayList<Cliente> clientes3 = seguradora4.getListaClientes();
						for(var j = 0; j < clientes3.size(); j++) {
							Cliente cliente3 = clientes3.get(j);
							if (cliente3.getNome().equals(nome_cliente3)) {
								//listar veiculos
								ArrayList<Veiculo> veiculos2 = cliente3.getListaVeiculos();
								System.out.println("\nVeiculos do Cliente:\n");
								for(var w = 0; w < veiculos2.size(); w++) {
									Veiculo veiculo_c = veiculos2.get(w);
									System.out.printf("Veiculo %d: %s\n", w, veiculo_c.toString());
								}
							}
						}
					}
				}
				break;
			case LISTAR_VEICULOS_SEG:
				//System.out.println("Chamar metodo listar veiculos por seguradora");
				String nome5;
				System.out.print("nome da seguradora: ");
				nome5 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora5 = seguradoras.get(i);
					if (seguradora5.getNome().equals(nome5)) {
						//encontrar cliente
						ArrayList<Cliente> clientes4 = seguradora5.getListaClientes();
						for(var j = 0; j < clientes4.size(); j++) {
							Cliente cliente4 = clientes4.get(j);
							//listar veiculos
							ArrayList<Veiculo> veiculos3 = cliente4.getListaVeiculos();
							for(var w = 0; w < veiculos3.size(); w++) {
								Veiculo veiculo_s = veiculos3.get(w);
								System.out.printf("Veiculo %d.%d: %s\n", j, w, veiculo_s.toString());
							}
						}
					}
				}
				break;
			case EXCLUIR_CLIENTE:
				//System.out.println("Chamar metodo excluir cliente");
				String nome6;
				System.out.print("nome da seguradora: ");
				nome6 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora6 = seguradoras.get(i);
					if (seguradora6.getNome().equals(nome6)) {
						//encontrar cliente
						String nome_cliente5;
						System.out.print("nome do cliente: ");
						nome_cliente5 = entrada.next();
						seguradora6.removerCliente(nome_cliente5);
					}
				}
				break;
			case EXCLUIR_VEICULO:
				//System.out.println("Chamar metodo excluir veiculo");
				String nome7;
				System.out.print("nome da seguradora: ");
				nome7 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora7 = seguradoras.get(i);
					if (seguradora7.getNome().equals(nome7)) {
						//encontrar cliente
						String nome_cliente6;
						System.out.print("nome do cliente: ");
						nome_cliente6 = entrada.next();
						ArrayList<Cliente> clientes6 = seguradora7.getListaClientes();
						for(var j = 0; j < clientes6.size(); j++) {
							Cliente cliente6 = clientes6.get(j);
							if (cliente6.getNome().equals(nome_cliente6)) {
								//listar veiculos
								String placa_veiculo;
								System.out.print("placa do veiculo: ");
								placa_veiculo = entrada.next();
								ArrayList<Veiculo> veiculos4 = cliente6.getListaVeiculos();
								for(var w = 0; w < veiculos4.size(); w++) {
									Veiculo veiculo_c = veiculos4.get(w);
									if (veiculo_c.getPlaca().equals(placa_veiculo)) {
										veiculos4.remove(veiculo_c);
									}
								}
							}
						}
					}
				}
				break;
			case EXCLUIR_SINISTRO:
				//System.out.println("Chamar metodo excluir sinistro");
				String nome8;
				System.out.print("nome da seguradora: ");
				nome8 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora8 = seguradoras.get(i);
					if (seguradora8.getNome().equals(nome8)) {
						//encontrar cliente
						int id_sinistro;
						System.out.print("ID do sinistro: ");
						id_sinistro = entrada.nextInt();
						ArrayList<Sinistro> sinistros = seguradora8.getListaSinistros();
						for(var w = 0; w < sinistros.size(); w++) {
							Sinistro sinistro_r = sinistros.get(w);
							if (sinistro_r.getId() == id_sinistro) {
								sinistros.remove(sinistro_r);
							}
						}
					}
				}
				break;
			}
		}
		
		//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
		private static void executarSubmenu(MenuOperacoes op) throws ParseException {
			SubmenuOpcoes opSubmenu;
			do {
				exibirSubmenu(op);
				opSubmenu = lerOpcaoSubmenu(op);
				executarOpcaoSubMenu(opSubmenu);
			}while(opSubmenu != SubmenuOpcoes.VOLTAR);
		}
		
		//executa o menu externo: exibição do menu, leitura da opção e execução da opção
		public static void main(String[] args) throws ParseException {
			MenuOperacoes op;
			do {
				exibirMenuExterno();
				op = lerOpcaoMenuExterno();
				executarOpcaoMenuExterno(op);
			}while(op != MenuOperacoes.SAIR);
			System.out.println("Saiu do sistema");
		}
}
