package lab5;

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
					String data, endereco_sin, nome_seguradora, cpf_c;
					int id_seguro;
					System.out.print("\nInforme os dados do sinistro \n");
					System.out.print("data: ");
					data = entrada.next();
					SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
					Date data_s = formatar.parse(data);
					System.out.print("endereco: ");
					endereco_sin = entrada.next();
					System.out.print("nome da seguradora: ");
					nome_seguradora = entrada.next();
					System.out.print("ID do seguro: ");
					id_seguro = entrada.nextInt();
					System.out.print("CPF do condutor: ");
					cpf_c = entrada.next();
					for(var i = 0; i < seguradoras.size(); i++) {
						Seguradora seguradora = seguradoras.get(i);
						if (seguradora.getNome().equals(nome_seguradora)) {
							//encontrar seguro
							ArrayList<Seguro> seguros = seguradora.getListaSeguros();
							for(var j = 0; j < seguros.size(); j++) {
								Seguro seguro = seguros.get(j);
								if (seguro.getId() == id_seguro) {
									//listar condutores
									ArrayList<Condutor> condutores = seguro.getListaCondutores();
									for(var w = 0; w < condutores.size(); w++) {
										Condutor condutor = condutores.get(w);
										if (condutor.getCpf().equals(cpf_c)) {
											Sinistro sinistro = new Sinistro(0, data_s, endereco_sin, condutor, seguro);
											//gerar sinistro
											boolean gerar = seguro.gerarSinistro(sinistro);
											System.out.println("Sinistro gerado!");
										}
									}
								}
							}
						}
					}
					break;
				case GERAR_SEGURO:
					//System.out.println("Executar metodo gerar seguro");
					String nome_seguradora1;
					System.out.print("nome da seguradora: ");
					nome_seguradora1 = entrada.next();
					for(Seguradora seguradora : seguradoras) {
						if (seguradora.getNome().equals(nome_seguradora1)) {
							String nome_cliente6;
							System.out.print("nome do cliente: ");
							nome_cliente6 = entrada.next();
							ArrayList<Cliente> clientes6 = seguradora.getListaClientes();
							for(var j = 0; j < clientes6.size(); j++) {
									Cliente cliente6 = clientes6.get(j);
									if (cliente6.getNome().equals(nome_cliente6)) {
										if(cliente6 instanceof ClientePF) {
											//adicionar veiculo
											String placa_veiculo1;
											System.out.print("placa do veiculo: ");
											placa_veiculo1 = entrada.next();
											ArrayList<Veiculo> veiculos4 = cliente6.getListaVeiculos();
											for(var w = 0; w < veiculos4.size(); w++) {
												Veiculo veiculo_c = veiculos4.get(w);
												if (veiculo_c.getPlaca().equals(placa_veiculo1)) {
													int valorMensal;
													String dataInicio, dataFim;
													ArrayList<Sinistro> listaSinistros = null;
													ArrayList<Condutor> listaCondutores = null;
													System.out.print("\nInforme os dados do Seguro PF \n");
													valorMensal = 0;
													System.out.print("data de inicio: ");
													dataInicio = entrada.next();
													SimpleDateFormat formatar1 = new SimpleDateFormat("dd/MM/yyyy");
													Date data_in = formatar1.parse(dataInicio);
													System.out.print("data de fim: ");
													dataFim = entrada.next();
													SimpleDateFormat formatar2 = new SimpleDateFormat("dd/MM/yyyy");
													Date data_fim = formatar2.parse(dataFim);
													SeguroPF seguro = new SeguroPF(0, data_in, data_fim, seguradora, 
															listaSinistros, listaCondutores, valorMensal, veiculo_c, (ClientePF) cliente6);
													seguro.calcularValor();
													boolean cadastra = seguradora.gerarSeguro(seguro);
													System.out.println("Seguro gerado!");
												}
											}
										}
										if(cliente6 instanceof ClientePJ) {
											//adicionar frota
											String code_frota1;
											System.out.print("code da frota: ");
											code_frota1 = entrada.next();
											ArrayList<Frota> frotas4 = cliente6.getListaFrota();
											for(var w = 0; w < frotas4.size(); w++) {
												Frota frota_c = frotas4.get(w);
												if (frota_c.getCode().equals(code_frota1)) {
													int valorMensal;
													String dataInicio, dataFim;
													ArrayList<Sinistro> listaSinistros = null;
													ArrayList<Condutor> listaCondutores = null;
													System.out.print("\nInforme os dados do Seguro PF \n");
													valorMensal = 0;
													System.out.print("data de inicio: ");
													dataInicio = entrada.next();
													SimpleDateFormat formatar1 = new SimpleDateFormat("dd/MM/yyyy");
													Date data_in = formatar1.parse(dataInicio);
													System.out.print("data de fim: ");
													dataFim = entrada.next();
													SimpleDateFormat formatar2 = new SimpleDateFormat("dd/MM/yyyy");
													Date data_fim = formatar2.parse(dataFim);
													SeguroPJ seguro = new SeguroPJ(0, data_in, data_fim, seguradora, 
															listaSinistros, listaCondutores, valorMensal, frota_c, (ClientePJ) cliente6);
													seguro.calcularValor();
													boolean cadastra = seguradora.gerarSeguro(seguro);
													System.out.println("Seguro gerado!");
												}
											}
										}
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
				System.out.println("Pessoa Jurídica(1) ou Pessoa Física(2)?");
				tipo_cliente = entrada.nextInt();
				if(tipo_cliente == 2) {
					String nome_cpf, endereco_cpf, telefone_cpf, email_cpf, educacao_cpf, genero_cpf, cpf;
					String data_nasc;
					ArrayList<Veiculo> listaVeiculos = null;
					System.out.print("\nInforme os dados do Cliente PF \n");
					System.out.print("nome: ");
					nome_cpf = entrada.next();
					Validacao.validarNome(nome_cpf);//rever
					System.out.print("endereco: ");
					endereco_cpf = entrada.next();
					System.out.print("educacao: ");
					educacao_cpf = entrada.next();
					System.out.print("telefone: ");
					telefone_cpf = entrada.next();
					System.out.print("email: ");
					email_cpf = entrada.next();
					System.out.print("genero: ");
					genero_cpf = entrada.next();
					System.out.print("CPF: ");
					cpf = entrada.next();
					Validacao.validarCpf(cpf);
					System.out.print("data de nascimento: ");
					data_nasc = entrada.next();
					SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
					Date data_Nasc = formatar.parse(data_nasc);
					ClientePF cliente = new ClientePF(nome_cpf, endereco_cpf, telefone_cpf, email_cpf, 
							cpf, data_Nasc, educacao_cpf, genero_cpf, listaVeiculos);
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
					String nome_cpj, endereco_cpj, telefone_cpj, email_cpj, cnpj;
					String data_fund;
					int qtde_func;
					ArrayList<Frota> listaFrota = null;
					System.out.print("\nInforme os dados do Cliente PJ\n");
					System.out.print("nome: ");
					nome_cpj = entrada.next();
					Validacao.validarNome(nome_cpj);//rever
					System.out.print("endereco: ");
					endereco_cpj = entrada.next();
					System.out.print("telefone: ");
					telefone_cpj = entrada.next();
					System.out.print("email: ");
					email_cpj = entrada.next();
					System.out.print("CNPJ: ");
					cnpj = entrada.next();
					Validacao.validarCnpj(cnpj);
					System.out.print("quantidade de funcionários: ");
					qtde_func = entrada.nextInt();
					System.out.print("data de fundacao: ");
					data_fund = entrada.next();
					SimpleDateFormat formatar3 = new SimpleDateFormat("dd/MM/yyyy");
					Date data_Fund = formatar3.parse(data_fund);
					ClientePJ cliente = new ClientePJ(nome_cpj, endereco_cpj, telefone_cpj,
							email_cpj, cnpj, data_Fund, qtde_func, listaFrota);
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
				String placa, marca, modelo, nome_cliente, nome_seguradora, code_frota;
				int ano_fab, tipo_adc;
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
						System.out.print("Adicionar a uma frota? Sim(1) Não(2)");
						tipo_adc = entrada.nextInt();
						//encontrar cliente
						System.out.print("nome do cliente: ");
						nome_cliente = entrada.next();
						ArrayList<Cliente> clientes = seguradora.getListaClientes();
						for(var j = 0; j < clientes.size(); j++) {
							Cliente cliente = clientes.get(j);
							if (cliente.getNome().equals(nome_cliente)) {
								//adiciona veiculo
								if(tipo_adc == 2) {
									//adicionar direto no cliente
									boolean adiciona = cliente.cadastrarVeiculo(veiculo);
									System.out.println("Veiculo cadastrado!");
								} else if(tipo_adc == 1) {
									//adicionar na frota
									System.out.print("code da frota: ");
									code_frota = entrada.next();
									ArrayList<Frota> frotas = cliente.getListaFrota();
									for(var w = 0; w < frotas.size(); w++) {
										Frota frota = frotas.get(w);
										if (frota.getCode().equals(code_frota)) {
											boolean adiciona2 = cliente.atualizarFrota(1, frota, veiculo);
											System.out.println("Veiculo cadastrado!");
										}
									}
								}
							}
						}
					}
				}
				break;
			case CADASTRAR_FROTA:
				//System.out.println("Chamar metodo cadastrar frota");
				String code;
				ArrayList<Veiculo> listaVeiculos = null;
				System.out.print("\nInforme os dados da frota \n");
				System.out.print("code: ");
				code = entrada.next();
				Frota frota = new Frota(code, listaVeiculos);
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
								boolean adiciona = cliente.cadastrarFrota(frota);
								System.out.println("Frota cadastrada!");
							}
						}
					}
				}
				break;
			case CADASTRAR_CONDUTOR:
				//System.out.println("Chamar metodo cadastrar condutor");
				String cpf_cond, nome_cond, telefone_cond, email_cond, endereco_cond;
				String data_cond;
				int id_seguro;
				ArrayList<Sinistro> listaSinistros = null;
				System.out.print("\nInforme os dados do condutor \n");
				System.out.print("cpf: ");
				cpf_cond = entrada.next();
				System.out.print("nome: ");
				nome_cond = entrada.next();
				Validacao.validarNome(nome_cond);//rever
				System.out.print("telefone: ");
				telefone_cond = entrada.next();
				System.out.print("email: ");
				email_cond = entrada.next();
				System.out.print("endereco: ");
				endereco_cond = entrada.next();
				System.out.print("data de nascimento: ");
				data_cond = entrada.next();
				SimpleDateFormat formatar4 = new SimpleDateFormat("dd/MM/yyyy");
				Date data_Cond = formatar4.parse(data_cond);
				Condutor condutor = new Condutor(nome_cond, endereco_cond, telefone_cond, email_cond, cpf_cond, data_Cond, listaSinistros);
				//encontrar a seguradora
				System.out.print("nome da seguradora: ");
				nome_seguradora = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					//System.out.println("Entrei");
					Seguradora seguradora = seguradoras.get(i);
					if (seguradora.getNome().equals(nome_seguradora)) {
						//encontrar seguro
						System.out.print("ID do seguro: ");
						id_seguro = entrada.nextInt();
						ArrayList<Seguro> seguros = seguradora.getListaSeguros();
						for(var j = 0; j < seguros.size(); j++) {
							Seguro seguro = seguros.get(j);
							if (seguro.getId() == id_seguro) {
								//adiciona condutor
								boolean adiciona = seguro.autorizarCondutor(condutor);
								System.out.println("Condutor autorizado!");
							}
						}
					}
				}
				break;
			case CADASTRAR_SEGURADORA:
				//System.out.println("Chamar metodo cadastrar seguradora");
				String cnpj_seg, nome_seg, telefone_seg, email_seg, endereco_seg;
				System.out.print("\nInforme os dados da seguradora \n");
				System.out.print("nome: ");
				nome_seg = entrada.next();
				Validacao.validarNome(nome_seg);//rever
				System.out.print("cnpj: ");
				cnpj_seg = entrada.next();
				System.out.print("telefone: ");
				telefone_seg = entrada.next();
				System.out.print("email: ");
				email_seg = entrada.next();
				System.out.print("endereco: ");
				endereco_seg = entrada.next();
				ArrayList<Cliente> listaClientes = null;
				ArrayList<Seguro> listaSeguro = null;
				Seguradora seguradora = new Seguradora(cnpj_seg, nome_seg, telefone_seg, email_seg, endereco_seg, listaClientes, listaSeguro);
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
								ArrayList<Sinistro> sinistros = seguradora3.getSinistroPorCliente(cliente2);
								for(var w = 0; w < sinistros.size(); w++) {
									Sinistro sinistro = sinistros.get(w);
									System.out.printf("Sinistro %d: %s\n", w, sinistro.toString());
								}
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
								int tipo_frota;
								System.out.print("veiculo pertence a uma frota? Sim(1) Não(2)");
								tipo_frota = entrada.nextInt();
								if(tipo_frota == 2) {
									//listar veiculos
									ArrayList<Veiculo> veiculos2 = cliente3.getListaVeiculos();
									System.out.println("\nVeiculos do Cliente:\n");
									for(var w = 0; w < veiculos2.size(); w++) {
										Veiculo veiculo_c = veiculos2.get(w);
										System.out.printf("Veiculo %d: %s\n", w, veiculo_c.toString());
									}
								} else if(tipo_frota == 1) {
									//listar frota
									String code_frota2;
									System.out.print("Code da frota: ");
									code_frota2 = entrada.next();
									boolean listar = cliente3.getVeiculosPorFrota(code_frota2);
								}
							}
						}
					}
				}
				break;
			case LISTAR_SEGUROS_CLIENTE:
				//System.out.println("Chamar metodo listar clientes");
				String nome1;
				System.out.print("nome da seguradora: ");
				nome1 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora1 = seguradoras.get(i);
					if (seguradora1.getNome().equals(nome1)) {
						//encontrar cliente
						String nome_cliente3;
						System.out.print("nome do cliente: ");
						nome_cliente3 = entrada.next();
						ArrayList<Cliente> clientes3 = seguradora1.getListaClientes();
						for(var j = 0; j < clientes3.size(); j++) {
							Cliente cliente3 = clientes3.get(j);
							if (cliente3.getNome().equals(nome_cliente3)) {
								System.out.println("\nSeguros do Cliente:\n");
								ArrayList<Seguro> seguros_c = seguradora1.getSegurosPorCliente(cliente3);
								for(var w = 0; w < seguros_c.size(); w++) {
									Seguro seguro = seguros_c.get(w);
									System.out.printf("Seguro %d: %s\n", w, seguro.toString());
								}
							}
						}
					}
				}
				break;
			case LISTAR_SEGUROS_SEG:
				//System.out.println("Chamar metodo listar seguros");
				String nome12;
				System.out.print("nome da seguradora: ");
				nome12 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora1 = seguradoras.get(i);
					if (seguradora1.getNome().equals(nome12)) {
						ArrayList<Seguro> seguros = seguradora1.getListaSeguros();
						for(var w = 0; w < seguros.size(); w++) {
							Seguro seguro = seguros.get(w);
							System.out.printf("Seguro %d: %s\n", w, seguro.toString());
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
						int tipo_frota;
						System.out.print("veiculo pertence a uma frota? Sim(1) Não(2)");
						tipo_frota = entrada.nextInt();
						//encontrar cliente
						String nome_cliente6;
						System.out.print("nome do cliente: ");
						nome_cliente6 = entrada.next();
						ArrayList<Cliente> clientes6 = seguradora7.getListaClientes();
						for(var j = 0; j < clientes6.size(); j++) {
							Cliente cliente6 = clientes6.get(j);
							if (cliente6.getNome().equals(nome_cliente6)) {
								if(tipo_frota == 2) {
									//listar veiculos
									String placa_veiculo;
									System.out.print("placa do veiculo: ");
									placa_veiculo = entrada.next();
									ArrayList<Veiculo> veiculos4 = cliente6.getListaVeiculos();
									for(var w = 0; w < veiculos4.size(); w++) {
										Veiculo veiculo_c = veiculos4.get(w);
										if (veiculo_c.getPlaca().equals(placa_veiculo)) {
											boolean remove = cliente6.removerVeiculo(veiculo_c);
										}
									}
								} else if(tipo_frota == 1) {
									//listar frota
									String code_frota2;
									System.out.print("Code da frota: ");
									code_frota2 = entrada.next();
									ArrayList<Frota> frota2 = cliente6.getListaFrota();
									for(var w = 0; w < frota2.size(); w++) {
										Frota frota_c = frota2.get(w);
										if (frota_c.getCode().equals(code_frota2)) {
											//listar veiculos
											String placa_veiculo;
											System.out.print("placa do veiculo: ");
											placa_veiculo = entrada.next();
											ArrayList<Veiculo> veiculos4 = cliente6.getListaVeiculos();
											for(var h = 0; h < veiculos4.size(); h++) {
												Veiculo veiculo_c = veiculos4.get(h);
												if (veiculo_c.getPlaca().equals(placa_veiculo)) {
													boolean remove = cliente6.atualizarFrota(2, frota_c, veiculo_c);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				break;
			case EXCLUIR_FROTA:
				//System.out.println("Chamar metodo excluir frota");
				String nome8;
				System.out.print("nome da seguradora: ");
				nome6 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora6 = seguradoras.get(i);
					if (seguradora6.getNome().equals(nome6)) {
						//encontrar cliente
						String nome_cliente5;
						System.out.print("nome do cliente: ");
						nome_cliente5 = entrada.next();
						ArrayList<Cliente> clientes5 = seguradora6.getListaClientes();
						for(var j = 0; j < clientes5.size(); j++) {
							Cliente cliente5 = clientes5.get(j);
							if (cliente5.getNome().equals(nome_cliente5)) {
								//listar frota
								String code_frota2;
								System.out.print("Code da frota: ");
								code_frota2 = entrada.next();
								ArrayList<Frota> frota2 = cliente5.getListaFrota();
								for(var w = 0; w < frota2.size(); w++) {
									Frota frota_c = frota2.get(w);
									if (frota_c.getCode().equals(code_frota2)) {
										boolean remove = cliente5.atualizarFrota(3, frota_c, null);
									}
								}
							}
						}
					}
				}
				break;
			case EXCLUIR_CONDUTOR:
				//System.out.println("Chamar metodo excluir condutor");
				//encontrar a seguradora
				System.out.print("nome da seguradora: ");
				nome_seguradora = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					//System.out.println("Entrei");
					Seguradora seguradora1 = seguradoras.get(i);
					if (seguradora1.getNome().equals(nome_seguradora)) {
						//encontrar seguro
						System.out.print("ID do seguro: ");
						id_seguro = entrada.nextInt();
						ArrayList<Seguro> seguros = seguradora1.getListaSeguros();
						for(var j = 0; j < seguros.size(); j++) {
							Seguro seguro = seguros.get(j);
							if (seguro.getId() == id_seguro) {
								//listar condutores
								String cpf_condu;
								System.out.print("CPF do condutor: ");
								cpf_condu = entrada.next();
								ArrayList<Condutor> condutores2 = seguro.getListaCondutores();
								for(var h = 0; h < condutores2.size(); h++) {
									Condutor condutor_c = condutores2.get(h);
									if (condutor_c.getCpf().equals(cpf_condu)) {
										//remove condutor
										boolean remove = seguro.desautorizarCondutor(condutor_c);
										System.out.println("Condutor desautorizado!");
									}
								}
							}
						}
					}
				}
				break;
			case EXCLUIR_SINISTRO:
				//System.out.println("Chamar metodo excluir sinistro");
				String nome81;
				System.out.print("nome da seguradora: ");
				nome81 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora8 = seguradoras.get(i);
					if (seguradora8.getNome().equals(nome81)) {
						//encontrar cliente
						int id_seguro1;
						System.out.print("ID do seguro: ");
						id_seguro1 = entrada.nextInt();
						ArrayList<Seguro> seguros = seguradora8.getListaSeguros();
						for(var j = 0; j < seguros.size(); j++) {
							Seguro seguro = seguros.get(j);
							if (seguro.getId() == id_seguro1) {
								ArrayList<Sinistro> sinistros = seguro.getListaSinistros();
								int id_sinistro;
								System.out.print("ID do sinistro: ");
								id_sinistro = entrada.nextInt();
								for(var w = 0; w < sinistros.size(); w++) {
									Sinistro sinistro_r = sinistros.get(w);
									if (sinistro_r.getId() == id_sinistro) {
										sinistros.remove(sinistro_r);
									}
								}
							}
						}
					}
				}
				break;
			case EXCLUIR_SEGURO:
				//System.out.println("Chamar metodo excluir seguro");
				String nome10;
				System.out.print("nome da seguradora: ");
				nome10 = entrada.next();
				for(var i = 0; i < seguradoras.size(); i++) {
					Seguradora seguradora8 = seguradoras.get(i);
					if (seguradora8.getNome().equals(nome10)) {
						//encontrar cliente
						int id_seguro1;
						System.out.print("ID do seguro: ");
						id_seguro1 = entrada.nextInt();
						boolean remove = seguradora8.cancelarSeguro(id_seguro1);
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
