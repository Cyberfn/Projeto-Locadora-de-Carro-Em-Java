import java.sql.*;
import java.util.Date;

public class ClienteCRUD {

	private static Conexao dao = new Conexao();
	private static Connection conexao = dao.conectaDB();

	// Método para criar um novo cliente
	public static void criarCliente(Cliente cliente) {
		try {
			String sql = "INSERT INTO clientes (nome, dtnasc, cpf, cnh, email) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, cliente.getNome());
			statement.setDate(2, new java.sql.Date(cliente.getDtnasc().getTime()));
			statement.setString(3, cliente.getCpf());
			statement.setString(4, cliente.getCnh());
			statement.setString(5, cliente.getEmail());

			statement.executeUpdate();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				Long idGerado = generatedKeys.getLong(1);
				cliente.setIdcli(idGerado);
			}

			System.out.println("Cliente criado com sucesso!");

			statement.close();
		} catch (SQLException e) {
			System.out.println("Erro ao criar o cliente: " + e.getMessage());
		} finally {

		}
	}

	// Método para listar todos os clientes
	public static void listarClientes() {

		String sql = "SELECT * FROM clientes";

		try (PreparedStatement prep = conexao.prepareStatement(sql)) {
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("idcli");
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
		} finally {

		}
	}

	// Método para atualizar um cliente
	public static void atualizarCliente(Cliente cliente) {

		String sql = "UPDATE clientes SET nome = ?, dtnasc = ?, cpf = ?, cnh = ?, email = ? WHERE idcli = ?";

		try (PreparedStatement prep = conexao.prepareStatement(sql)) {
			prep.setString(1, cliente.getNome());
			prep.setDate(2, new java.sql.Date(cliente.getDtnasc().getTime()));
			prep.setString(3, cliente.getCpf());
			prep.setString(4, cliente.getCnh());
			prep.setString(5, cliente.getEmail());
			prep.setLong(6, cliente.getIdcli());

			prep.executeUpdate();
			System.out.println("Cliente atualizado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}

	// Método para excluir um cliente
	public static void excluirCliente(int id) {

		String sql = "DELETE FROM clientes WHERE idcli = ?";

		try (PreparedStatement prep = conexao.prepareStatement(sql)) {
			prep.setInt(1, id);

			int linhasAfetadas = prep.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Cliente excluído com sucesso!");
			} else {
				System.out.println("Nenhum cliente encontrado com o ID especificado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
	}
}
