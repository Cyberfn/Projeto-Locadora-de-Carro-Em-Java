import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Principal {

	private static String novoEmail;

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		int opcao = 0;

		do {
			System.out.println("==========================");
			System.out.println("|Escolha uma opção:      |");
			System.out.println("|1. Gerenciar carros     |");
			System.out.println("|2. Gerenciar clientes   |");
			System.out.println("|3. Gerenciar locações   |");
			System.out.println("|0. Sair                 |");
			System.out.println("==========================");
			System.out.println("Opção: ");

			opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha pendente

			switch (opcao) {
			case 0:

				System.out.println("Encerrado");
				System.exit(0);

				break;

			case 1:
				int opcaoCarros = 0;

				do {
					System.out.println("=========================");
					System.out.println("|Escolha uma opção:	|");
					System.out.println("|1. Listar carros	|");
					System.out.println("|2. Adicionar carro	|");
					System.out.println("|3. Atualizar carro	|");
					System.out.println("|4. Excluir carro	|");
					System.out.println("|5. Voltar		|");
					System.out.println("=========================");
					System.out.print("Opção: ");

					opcaoCarros = scanner.nextInt();
					scanner.nextLine(); // Consumir a quebra de linha pendente

					switch (opcaoCarros) {
					case 1:
						CarroCRUD.listarCarros();
						break;
					case 2:
						System.out.println("Informe os dados do carro:");
						System.out.print("Marca: ");
						String marca = scanner.nextLine();

						System.out.print("Modelo: ");
						String modelo = scanner.nextLine();

						System.out.print("Ano: ");
						int ano = scanner.nextInt();

						System.out.print("Disponível (true/false): ");
						boolean disponivel = scanner.nextBoolean();

						scanner.nextLine(); // Consumir a quebra de linha pendente
						System.out.print("Placa: ");
						String placa = scanner.nextLine();

						System.out.print("Cor: ");
						String cor = scanner.nextLine();

						Carro novoCarro = new Carro();
						novoCarro.setMarca(marca);
						novoCarro.setModelo(modelo);
						novoCarro.setAno(ano);
						novoCarro.setDisponivel(disponivel);
						novoCarro.setPlaca(placa);
						novoCarro.setCor(cor);

						CarroCRUD.criarCarro(novoCarro);
						break;
					case 3:
						System.out.print("Informe o ID do carro a ser atualizado: ");
						int idAtualizar = scanner.nextInt();
						scanner.nextLine(); // Consumir a quebra de linha pendente

						System.out.println("Informe os novos dados do carro:");
						System.out.print("Marca: ");
						String novaMarca = scanner.nextLine();

						System.out.print("Modelo: ");
						String novoModelo = scanner.nextLine();

						System.out.print("Ano: ");
						int novoAno = scanner.nextInt();

						scanner.nextLine(); // Consumir a quebra de linha pendente
						System.out.print("Disponível (true/false): ");
						boolean novoDisponivel = scanner.nextBoolean();

						scanner.nextLine(); // Consumir a quebra de linha pendente
						System.out.print("Placa: ");
						String novaPlaca = scanner.nextLine();

						System.out.print("Cor: ");
						String novaCor = scanner.nextLine();

						Carro carroAtualizar = new Carro();
						carroAtualizar.setId(idAtualizar);
						carroAtualizar.setMarca(novaMarca);
						carroAtualizar.setModelo(novoModelo);
						carroAtualizar.setAno(novoAno);
						carroAtualizar.setDisponivel(novoDisponivel);
						carroAtualizar.setPlaca(novaPlaca);
						carroAtualizar.setCor(novaCor);

						CarroCRUD.atualizarCarro(carroAtualizar);
						break;
					case 4:
						System.out.print("Informe o ID do carro a ser excluído: ");
						int idExcluir = scanner.nextInt();
						scanner.nextLine(); // Consumir a quebra de linha pendente

						CarroCRUD.excluirCarro(idExcluir);
						break;
					case 5:
						System.out.println("Voltando...");
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}

				} while (opcaoCarros != 5);

				break;
			case 2:
				int opcaoClientes = 0;

				do {
					System.out.println("==========================");
					System.out.println("|Escolha uma opção:	 |");
					System.out.println("|1. Listar clientes	 |");
					System.out.println("|2. Adicionar cliente	 |");
					System.out.println("|3. Atualizar cliente	 |");
					System.out.println("|4. Excluir cliente	 |");
					System.out.println("|5. Voltar		 |");
					System.out.println("==========================");
					System.out.print("Opção: ");

					opcaoClientes = scanner.nextInt();
					scanner.nextLine(); // Consumir a quebra de linha pendente

					switch (opcaoClientes) {
					case 1:
						ClienteCRUD.listarClientes();
						break;
					case 2:

						System.out.println("Informe os dados do cliente:");
						System.out.print("Nome: ");
						String nome = scanner.nextLine();

						System.out.print("Data de nascimento (yyyy-MM-dd): ");
						String dtnascString = scanner.nextLine();
						java.util.Date dtnasc = null;
						try {
							dtnasc = dateFormat.parse(dtnascString);
						} catch (ParseException e) {
							e.printStackTrace();
						}

						System.out.print("CPF: ");
						String cpf = scanner.nextLine();

						System.out.print("CNH: ");
						String cnh = scanner.nextLine();

						System.out.print("Email: ");
						String email = scanner.nextLine();

						Cliente novoCliente = new Cliente();
						novoCliente.setNome(nome);
						novoCliente.setDtnasc(new java.sql.Date(dtnasc.getTime()));
						novoCliente.setCpf(cpf);
						novoCliente.setCnh(cnh);
						novoCliente.setEmail(email);

						ClienteCRUD.criarCliente(novoCliente);
						break;

					case 3:
						System.out.print("Informe o ID do cliente a ser atualizado: ");
						int idAtualizar = scanner.nextInt();
						scanner.nextLine(); // Consumir a quebra de linha pendente

						System.out.println("Informe os novos dados do cliente:");
						System.out.print("Nome: ");
						String novoNome = scanner.nextLine();

						System.out.print("CPF: ");
						String novoCpf = scanner.nextLine();

						System.out.print("CNH: ");
						String novoCnh = scanner.nextLine();

						System.out.print("Data de Nascimento (yyyy-MM-dd): ");
						String novaDataNascimentoStr = scanner.nextLine();

						System.out.print("Email: ");
						String novoEmail = scanner.nextLine();

						Cliente clienteAtualizar = new Cliente();
						clienteAtualizar.setId(idAtualizar);
						clienteAtualizar.setNome(novoNome);
						clienteAtualizar.setCpf(novoCpf);
						clienteAtualizar.setCnh(novoCnh);
						clienteAtualizar.setEmail(novoEmail);

						try {
							clienteAtualizar.setDtnasc(dateFormat.parse(novaDataNascimentoStr));
						} catch (ParseException e) {
							System.out.println("Data de Nascimento inválida!");
							break;
						}

						ClienteCRUD.atualizarCliente(clienteAtualizar);
						break;
					case 4:
						System.out.print("Informe o ID do cliente a ser excluído: ");
						int idExcluir = scanner.nextInt();
						scanner.nextLine(); // Consumir a quebra de linha pendente

						ClienteCRUD.excluirCliente(idExcluir);
						break;
					case 5:
						System.out.println("Voltando...");
						break;
					default:
						System.out.println("Opção inválida!");
						break;
					}

				} while (opcaoClientes != 5);

				break;
			case 3:
				int opcaoLocacoes = 0;

				do {
					System.out.println("==========================");
					System.out.println("|Escolha uma opção:	 |");
					System.out.println("|1. Listar locações	 |");
					System.out.println("|2. Adicionar locação	 |");
					System.out.println("|3. Atualizar locação	 |");
					System.out.println("|4. Excluir locação	 |");
					System.out.println("|5. Voltar		 |");
					System.out.println("==========================");
					System.out.print("Opção: ");

					opcaoLocacoes = scanner.nextInt();
					scanner.nextLine(); // Consumir a quebra de linha pendente

					switch (opcaoLocacoes) {
					case 1:
						LocacaoCRUD.listarLocacoes();
						break;

					case 2:
						System.out.println("Informe os dados da locação:");
						System.out.print("ID do cliente: ");
						int idCliente = scanner.nextInt();
						scanner.nextLine(); // Consumir a quebra de linha pendente

						System.out.print("ID do carro: ");
						int idCarro = scanner.nextInt();
						scanner.nextLine(); // Consumir a quebra de linha pendente

						System.out.print("Data de Locação (yyyy-MM-dd): ");
						String dataInicioStr = scanner.nextLine();

						System.out.print("Data de Devolução (yyyy-MM-dd): ");
						String dataTerminoStr = scanner.nextLine();

						System.out.print("Custo da locação: ");
						double custo = scanner.nextDouble();
						scanner.nextLine(); // Consumir a quebra de linha pendente

						Locacao novaLocacao = new Locacao();
						novaLocacao.setIdCliente(idCliente);
						novaLocacao.setIdCarro(idCarro);
						novaLocacao.setCusto(custo);
						try {
							java.util.Date dataInicio = dateFormat.parse(dataInicioStr);
							java.util.Date dataTermino = dateFormat.parse(dataTerminoStr);
							novaLocacao.setDataLocacao(new java.sql.Date(dataInicio.getTime()));
							novaLocacao.setDataDevolucao(new java.sql.Date(dataTermino.getTime()));
						} catch (ParseException e) {
							System.out.println("Data inválida!");
							break;
						}

						LocacaoCRUD.criarLocacao(novaLocacao);
						break;

					case 3:
						System.out.print("Informe o ID da locação a ser atualizada: ");
						int idAtualizar = scanner.nextInt();

						System.out.println("Informe os novos dados da locação:");
						System.out.print("ID Cliente: ");
						int novoIdCliente = scanner.nextInt();

						System.out.print("ID Carro: ");
						int novoIdCarro = scanner.nextInt();

						System.out.print("Data de Locação (AAAA-MM-DD): ");
						String novaDataLocacaoStr = scanner.next();

						System.out.print("Data de Devolução (AAAA-MM-DD): ");
						String novaDataDevolucaoStr = scanner.next();

						System.out.print("Custo: ");
						double novoCusto = scanner.nextDouble();

						Locacao locacaoAtualizada = new Locacao();
						locacaoAtualizada.setId(idAtualizar);
						locacaoAtualizada.setIdCliente(novoIdCliente);
						locacaoAtualizada.setIdCarro(novoIdCarro);
						locacaoAtualizada.setDataDevolucao(java.sql.Date.valueOf(novaDataDevolucaoStr));
						locacaoAtualizada.setDataLocacao(java.sql.Date.valueOf(novaDataLocacaoStr));
						locacaoAtualizada.setCusto(novoCusto);

						LocacaoCRUD.atualizarLocacao(locacaoAtualizada);
						break;
					case 4:
						System.out.print("Informe o ID da locação a ser encerrada: ");
						int idEncerrar = scanner.nextInt();
						scanner.nextLine(); // Consumir a quebra de linha pendente

						LocacaoCRUD.excluirLocacao(idEncerrar);
						break;
					}

				} while (opcaoLocacoes != 5);

				break;
			case 5:
				System.out.println("Voltando...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (opcao != 5);

		scanner.close();
	}
}
