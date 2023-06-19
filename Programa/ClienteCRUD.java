import java.sql.*;
import java.util.Date;

public class ClienteCRUD {

	private static Conexao dao = new Conexao();
	private static Connection conexao = dao.conectaDB();

	// Método para criar um novo cliente
	public static void criarCliente(Cliente cliente) {
		try {
			String sql = "INSERT INTO clientes (nome, dtnasc, cpf, cnh, email) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement cr = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //É usado pra criar objeto que representa a instrucao sql
			
			 //interface de instrucao sql
			cr.setString(1, cliente.getNome()); 
			cr.setDate(2, new java.sql.Date(cliente.getDtnasc().getTime()));
			cr.setString(3, cliente.getCpf());
			cr.setString(4, cliente.getCnh());
			cr.setString(5, cliente.getEmail());

			cr.executeUpdate();

			ResultSet generatedKeys = cr.getGeneratedKeys();
			if (generatedKeys.next()) {
				Long idGerado = generatedKeys.getLong(1);
				cliente.setIdcli(idGerado);
			}

			System.out.println("Cliente criado com sucesso!");

			cr.close();
		} catch (SQLException e) {
			System.out.println("Erro ao criar o cliente: " + e.getMessage());
		} 
	}

	// Método para listar todos os clientes
	public static void listarClientes() {

		String sql = "SELECT * FROM clientes";

		try (PreparedStatement list = conexao.prepareStatement(sql)) {//É usado pra criar objeto que representa a instrucao sql
			ResultSet rs = list.executeQuery();//Executa para retornar um unico objeto matrix

			while (rs.next()) {
				Long id = rs.getLong("idcli");
				String nome = rs.getString("nome");
				Date dtnasc = rs.getDate("dtnasc");
				String cpf = rs.getString("cpf");
				String cnh = rs.getString("cnh");
				String email = rs.getString("email");

				System.out.println("---------------------------");
				System.out.println("ID: " + id);
				System.out.println("Nome: " + nome);
				System.out.println("Data de Nascimento: " + dtnasc);
				System.out.println("CPF: " + cpf);
				System.out.println("CNH: " + cnh);
				System.out.println("Email: " + email);
				System.out.println("---------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	// Método para atualizar um cliente
	public static void atualizarCliente(Cliente cliente) {

		String sql = "UPDATE clientes SET nome = ?, dtnasc = ?, cpf = ?, cnh = ?, email = ? WHERE idcli = ?";

		try (
			PreparedStatement att = conexao.prepareStatement(sql)) {//É usado pra criar objeto que representa a instrucao sql
			att.setString(1, cliente.getNome());
			att.setDate(2, new java.sql.Date(cliente.getDtnasc().getTime()));
			att.setString(3, cliente.getCpf());
			att.setString(4, cliente.getCnh());
			att.setString(5, cliente.getEmail());
			att.setLong(6, cliente.getIdcli());

			att.executeUpdate();
			System.out.println("Cliente atualizado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	// Método para excluir um cliente
	public static void excluirCliente(long idExcluir) {

		String sql = "DELETE FROM clientes WHERE idcli = ?";

		try (PreparedStatement ex = conexao.prepareStatement(sql)) {//É usado pra criar objeto que representa a instrucao sql
			ex.setLong(1, idExcluir);

			int linhasAfetadas = ex.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Cliente excluído com sucesso!");
			} else {
				System.out.println("Nenhum cliente encontrado com o ID especificado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}