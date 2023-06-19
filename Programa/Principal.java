import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // permite a leitura de entrada do usuário
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // permite a formatação e análise de datas no formato especificado

		int opcao = 0; 

		do {
			System.out.println("=========================="); //tela de interacao com o usuario para escolher oque vai gerencia
			System.out.println("Escolha uma opção:       |");
			System.out.println("[1] Gerenciar carros     |");
			System.out.println("[2] Gerenciar clientes   |");
			System.out.println("[3] Gerenciar locações   |");
			System.out.println("[0] Sair                 |");
			System.out.println("==========================");
			System.out.println("Opção: ");

			opcao = sc.nextInt();
			sc.nextLine(); // Consumir a quebra de linha pendente

			switch (opcao) {
			case 0:

				System.out.println("Encerrado");
				System.exit(0); // encerrar execução do programa

				break;

			case 1:
				int opcaoCarros = 0;

				do {
					System.out.println("========================="); //tela de interacao com o usuario no gerenciamento dos carros
					System.out.println("Escolha uma opção:	|");
					System.out.println("[1] Listar carros	|");
					System.out.println("[2] Adicionar carro	|");
					System.out.println("[3] Atualizar carro	|");
					System.out.println("[4] Excluir carro	|");
					System.out.println("[5] Voltar		|");
					System.out.println("=========================");
					System.out.print("Opção: ");

					opcaoCarros = sc.nextInt();
					sc.nextLine(); // Consumir a quebra de linha pendente

					switch (opcaoCarros) {
					case 1:
						CarroCRUD.listarCarros(); // chama a função listarCarros() da classe CarroCRUD
						break;
					case 2:
						System.out.println("Informe os dados do carro:"); // solicita as informacoes do carro
						System.out.print("Marca: ");
						String marca = sc.nextLine();

						System.out.print("Modelo: ");
						String modelo = sc.nextLine();

						System.out.print("Ano: ");
						int ano = sc.nextInt();

						System.out.print("Disponível (true/false): ");
						boolean disponivel = sc.nextBoolean();

						sc.nextLine();
						System.out.print("Placa: ");
						String placa = sc.nextLine();

						System.out.print("Cor: ");
						String cor = sc.nextLine();

						Carro novoCarro = new Carro(); // Chama a função criarCarro(novoCarro) da classe CarroCRUD
						
						//Define os valores dos atributos do objeto novoCarro com base nas variáveis 
						novoCarro.setMarca(marca);
						novoCarro.setModelo(modelo);
						novoCarro.setAno(ano);
						novoCarro.setDisponivel(disponivel);
						novoCarro.setPlaca(placa);
						novoCarro.setCor(cor);

						CarroCRUD.criarCarro(novoCarro); // chama o método criarCarro() da classe CarroCRUD e passa o objeto novoCarro como argumento
						break;
					case 3:
						System.out.print("Informe o ID do carro a ser atualizado: ");
						Long idAtualizar = sc.nextLong(); // informar o id do carro a ser atualizado e armazena o valor
															// na variável idAtualizar do tipo Long
						sc.nextLine(); //

						System.out.println("Informe os novos dados do carro:"); // solicita as novas informacoes do carro
						System.out.print("Marca: ");
						String novaMarca = sc.nextLine();

						System.out.print("Modelo: ");
						String novoModelo = sc.nextLine();

						System.out.print("Ano: ");
						int novoAno = sc.nextInt();

						sc.nextLine(); //
						System.out.print("Disponível (true/false): ");
						boolean novoDisponivel = sc.nextBoolean();

						sc.nextLine(); //
						System.out.print("Placa: ");
						String novaPlaca = sc.nextLine();

						System.out.print("Cor: ");
						String novaCor = sc.nextLine();

						Carro carroAtualizar = new Carro(); // Cria um novo objeto Carro chamado carroAtualizar
															// utilizando o construtor padrão new Carro()
						
						//Define os atributos  do objeto "carroAtualizar" com os valores que foram fornecidos 
						carroAtualizar.setidcar(idAtualizar);
						carroAtualizar.setMarca(novaMarca);
						carroAtualizar.setModelo(novoModelo);
						carroAtualizar.setAno(novoAno);
						carroAtualizar.setDisponivel(novoDisponivel);
						carroAtualizar.setPlaca(novaPlaca);
						carroAtualizar.setCor(novaCor);

						CarroCRUD.atualizarCarro(carroAtualizar); // chama-se a função atualizarCarro(carroAtualizar) da classe CarroCRUD
						break;
					case 4:
						System.out.print("Informe o ID do carro a ser excluído: "); // informar o id do carro a ser excluido
						Long idExcluir = sc.nextLong();
						sc.nextLine(); //

						CarroCRUD.excluirCarro(idExcluir); // Chama a função excluirCarro(idExcluir) da classe CarroCRUD, passando o ID do carro a ser excluído como argumento
						break;
					case 5:
						System.out.println("Voltando..."); // opcao para voltar a menu de escolha de gerenciamento
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}
				} while (opcaoCarros != 5); // Se a condição for falsa (ou seja, opcaoCarros for igual a 5), o laço de repetição será encerrado e o programa continuará a partir do código após o bloco
				break;
			case 2://Opção de gerenciar clientes
				int opcaoClientes = 0;

				do {
					System.out.println("==========================");//tela de interacao com o usuario no gerenciamento dos clientes
					System.out.println("Escolha uma opção:	 |");
					System.out.println("[1] Listar clientes	 |");
					System.out.println("[2] Adicionar cliente	 |");
					System.out.println("[3] Atualizar cliente	 |");
					System.out.println("[4] Excluir cliente	 |");
					System.out.println("[5] Voltar		 |");
					System.out.println("==========================");
					System.out.print("Opção: ");

					opcaoClientes = sc.nextInt();
					sc.nextLine(); // Consumir a quebra de linha pendente

					switch (opcaoClientes) {
					case 1:
						ClienteCRUD.listarClientes(); // chama a função listarClientes() da classe ClienteCRUD
						break;
					case 2:

						System.out.println("Informe os dados do cliente:"); // solicita as informacoes do cliente
						System.out.print("Nome: ");
						String nome = sc.nextLine();

						System.out.print("Data de nascimento (yyyy-MM-dd): ");
						String dtnascString = sc.nextLine();
						java.util.Date dtnasc = null;
						try {
							dtnasc = dateFormat.parse(dtnascString);//converter uma string em um objeto de data usando o método parse() de uma classe DateFormat
						} catch (ParseException e) {
							e.printStackTrace();
						}
						System.out.print("CPF: ");
						String cpf = sc.nextLine();

						System.out.print("CNH: ");
						String cnh = sc.nextLine();

						System.out.print("Email: ");
						String email = sc.nextLine();

						Cliente novoCliente = new Cliente(); //Chama a função criarCliente(novoCliente) da classe ClienteCRUD	
						//Define os valores dos atributos do objeto com base nas variáveis
						novoCliente.setNome(nome);			
						novoCliente.setDtnasc(dtnasc);
						novoCliente.setCpf(cpf);
						novoCliente.setCnh(cnh);
						novoCliente.setEmail(email);

						ClienteCRUD.criarCliente(novoCliente);//chama o método criarCliente() da classe ClienteCRUD, passando um objeto novoCliente como argumento
						break;

					case 3:
						System.out.print("Informe o ID do cliente a ser atualizado: ");
						Long idAtualizar = sc.nextLong(); // informar o id do cliente a ser atualizado e armazena o valor
														// na variável idAtualizar do tipo Long
						sc.nextLine(); 

						System.out.println("Informe os novos dados do cliente:"); // solicita as novas informacoes do cliente
						System.out.print("Nome: ");
						String novoNome = sc.nextLine();

						System.out.print("CPF: ");
						String novoCpf = sc.nextLine();

						System.out.print("CNH: ");
						String novoCnh = sc.nextLine();

						System.out.print("Data de Nascimento (yyyy-MM-dd): ");
						String novaDataNascimentoStr = sc.nextLine();

						System.out.print("Email: ");
						String novoEmail = sc.nextLine();

						Cliente clienteAtualizar = new Cliente();// Cria um novo objeto Cliente chamado clienteAtualizar utilizando o construtor padrão new Cliente()
						//Define os atributos  do objeto "clienteAtualizar" com os valores que foram fornecidos 
						clienteAtualizar.setIdcli(idAtualizar);
						clienteAtualizar.setNome(novoNome);
						clienteAtualizar.setCpf(novoCpf);
						clienteAtualizar.setCnh(novoCnh);
						clienteAtualizar.setEmail(novoEmail);

						try {
							clienteAtualizar.setDtnasc(dateFormat.parse(novaDataNascimentoStr)); //A string (novaDataNascimentoStr) está sendo convertida em um objeto de data usando um objeto dateFormat
						} catch (ParseException e) {
							System.out.println("Data de Nascimento inválida!");//Se ocorrer uma exceção ParseException durante o processo de conversão, uma mensagem de erro é exibida no console e o loop é interrompido
							break;
						}

						ClienteCRUD.atualizarCliente(clienteAtualizar);//chama-se a função atualizarCliente(clienteAtualizar) da classe ClienteCRUD
						break;
					case 4:
						System.out.print("Informe o ID do cliente a ser excluído: ");  // informar o id do carro a ser excluido
						int idExcluir = sc.nextInt();
						sc.nextLine(); 

						ClienteCRUD.excluirCliente(idExcluir);// Chama a função excluirCliente(idExcluir) da classe ClienteCRUD, passando o ID do carro a ser excluído como argumento
						break;
					case 5:
						System.out.println("Voltando..."); //opcao para voltar a menu de escolha de gerenciamento
						break;
					default:
						System.out.println("Opção inválida!"); 
					break;
					}

				} while (opcaoClientes != 5); // Se a condição for falsa (ou seja, opcaoCarros for igual a 5), o laço de
									// repetição será encerrado e o programa continuará a partir do código após o bloco
				
				break;
			case 3://Opção de gerenciar locacoes
				int opcaoLocacoes = 0;

				do {
					System.out.println("==========================");
					System.out.println("Escolha uma opção:	 |");
					System.out.println("[1] Listar locações	 |");
					System.out.println("[2] Adicionar locação	 |");
					System.out.println("[3] Atualizar locação	 |");
					System.out.println("[4] Excluir locação	 |");
					System.out.println("[5] Voltar		 |");
					System.out.println("==========================");
					System.out.print("Opção: ");

					opcaoLocacoes = sc.nextInt();
					sc.nextLine(); // Consumir a quebra de linha pendente

					switch (opcaoLocacoes) {
					case 1:
						LocacaoCRUD.listarLocacoes(); //chama a função listarLocacoes() da classe LocacaoCRUD
						break;

					case 2:
						System.out.println("Informe os dados da locação:");// informar o id do cliente e do carro a ser atualizado e armazena os valores nas variávels idCliente e idCarro do tipo Long
						System.out.print("ID do cliente: "); //id do cliente
						Long idCliente = sc.nextLong();
						sc.nextLine(); 

						System.out.print("ID do carro: ");//id do carro
						long idCarro = sc.nextLong();
						sc.nextLine(); 

						System.out.print("Data de Locação (yyyy-MM-dd): ");
						String dataInicioStr = sc.nextLine();

						System.out.print("Data de Devolução (yyyy-MM-dd): ");
						String dataTerminoStr = sc.nextLine();

						System.out.print("Custo da locação: ");
						double custo = sc.nextDouble();
						sc.nextLine(); 

						Locacao novaLocacao = new Locacao(); //Chama a função criarLocacao(novaLocacao) da classe LocacaoCRUD
						novaLocacao.setId_cliente(idCliente);
						novaLocacao.setId_carro(idCarro);
						novaLocacao.setCusto(custo);
						
						//As duas strings (novaDataLocacaoStr e novaDataDevolucaoStr) estão sendo convertidas em objetos de data usando um objeto dateFormat
						try {
						    novaLocacao.setData_locacao(new java.sql.Date(dateFormat.parse(dataInicioStr).getTime())); 
						    novaLocacao.setData_devolucao(new java.sql.Date(dateFormat.parse(dataTerminoStr).getTime()));
						} catch (ParseException e) {
						    System.out.println("Data inválida!");//Se ocorrer uma exceção ParseException durante o processo de conversão, uma mensagem de erro é exibida no console e o loop é interrompido
						    break;
						}
						LocacaoCRUD.criarLocacao(novaLocacao);//chama o método criarLocacao(novaLocacao) da classe ClienteCRUD,
						
						break;

					case 3:
						System.out.println("Informe os novos dados da locação:"); //solicita as novas informacoes da locacao
						System.out.print("ID Cliente: ");
						Long novoIdCliente = sc.nextLong();

						System.out.print("ID Carro: ");
						Long novoIdCarro = sc.nextLong();

						System.out.print("Data de Locação (yyyy-MM-dd): ");
						String novaDataLocacaoStr = sc.next();

						System.out.print("Data de Devolução (yyyy-MM-dd): ");
						String novaDataDevolucaoStr = sc.next();

						System.out.print("Custo: ");
						double novoCusto = sc.nextDouble();

						Locacao locacaoAtualizada = new Locacao();//Cria um novo objeto Locacao chamado locacaoAtualizada utilizando o construtor padrão new Locacao()
						
						//Define os atributos  do objeto "clienteAtualizar" com os valores que foram fornecidos 
						locacaoAtualizada.setId_cliente(novoIdCliente);
						locacaoAtualizada.setId_carro(novoIdCarro);
						locacaoAtualizada.setCusto(novoCusto);
						//As duas strings (novaDataLocacaoStr e novaDataDevolucaoStr) estão sendo convertidas em objetos de data usando um objeto dateFormat
						try {
							locacaoAtualizada.setData_locacao(dateFormat.parse(novaDataLocacaoStr));
							locacaoAtualizada.setData_devolucao(dateFormat.parse(novaDataDevolucaoStr));
						} catch (ParseException e) { //Se ocorrer uma exceção ParseException durante o processo de conversão, uma mensagem de erro é exibida no console e o loop é interrompido
							System.out.println("Data inválida!");
							break;
						}

						LocacaoCRUD.atualizarLocacao(locacaoAtualizada);
						break;
					case 4: 
						System.out.print("Informe o ID do cliente: "); //informar o id do cliente a ser excluido
						int id_Cliente = sc.nextInt();
						sc.nextLine(); 

						System.out.print("Informe o ID do carro: ");// informar o id do carro a ser excluido
						int id_Carro = sc.nextInt();
						sc.nextLine(); 

						LocacaoCRUD.excluirLocacao(id_Cliente, id_Carro);/// Chama a função excluirLocacao(id_Cliente, id_Carro) da classe LocacaoCRUD,
						
						break;

					}

				} while (opcaoLocacoes != 5);// Se a condição for falsa (ou seja, opcaoLocacoes for igual a 5), o laço de
				// repetição será encerrado e o programa continuará a partir do código após o bloco

				break;
			case 5:
				System.out.println("Voltando...");//opcao para voltar a menu de escolha de gerenciamento
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (opcao != 5);

		sc.close();
	}
}