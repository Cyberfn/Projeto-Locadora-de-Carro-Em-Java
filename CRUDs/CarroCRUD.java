import java.sql.*;

public class CarroCRUD {

	private static Conexao dao = new Conexao();
	private static Connection conexao = dao.conectaDB();

// Método para criar um novo carro
	public static void criarCarro(Carro carro) {
		try {
			String sql = "INSERT INTO carros (marca, modelo, ano, disponivel, placa, cor) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, carro.getMarca());
			statement.setString(2, carro.getModelo());
			statement.setInt(3, carro.getAno());
			statement.setBoolean(4, carro.isDisponivel());
			statement.setString(5, carro.getPlaca());
			statement.setString(6, carro.getCor());

			statement.executeUpdate();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				Long idGerado = generatedKeys.getLong(1);
				carro.setidcar(idGerado);
			}

			System.out.println("Carro criado com sucesso!");

			statement.close();
		} catch (SQLException e) {
			System.out.println("Erro ao criar o carro: " + e.getMessage());
		} 
	}

	// Método para listar todos os carros
	public static void listarCarros() {
		String sql = "SELECT * FROM carros";

		try (PreparedStatement prep = conexao.prepareStatement(sql)) {
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
				Long idcar = rs.getInt("idcar");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");
				String placa = rs.getString("placa");
				String cor = rs.getString("cor");
				int ano = rs.getInt("ano");
				boolean disponivel = rs.getBoolean("disponivel");

				System.out.println("---------------------------");
				System.out.println("ID: " + idcar);
				System.out.println("Marca: " + marca);
				System.out.println("Modelo: " + modelo);
				System.out.println("Placa: " + placa);
				System.out.println("Cor: " + cor);
				System.out.println("Ano: " + ano);
				System.out.println("Disponível: " + disponivel);
				System.out.println("---------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	// Método para atualizar um carro
	public static void atualizarCarro(Carro carro) {

		String sql = "UPDATE carros SET marca = ?, modelo = ?, placa = ?, cor = ?, ano = ?, disponivel = ? WHERE idcar = ?";

		try (PreparedStatement prep = conexao.prepareStatement(sql)) {
			prep.setString(1, carro.getMarca());
			prep.setString(2, carro.getModelo());
			prep.setString(3, carro.getPlaca());
			prep.setString(4, carro.getCor());
			prep.setInt(5, carro.getAno());
			prep.setBoolean(6, carro.isDisponivel());
			prep.setLong(7, carro.getidcar());

			prep.executeUpdate();
			System.out.println("Carro atualizado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	// Método para excluir um carro
	public static void excluirCarro(Long id) {

		String sql = "DELETE FROM carros WHERE idcar = ?";

		try (PreparedStatement prep = conexao.prepareStatement(sql)) {
			prep.setLong(1, id);

			int linhasAfetadas = prep.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Carro excluído com sucesso!");
			} else {
				System.out.println("Nenhum carro encontrado com o ID especificado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
