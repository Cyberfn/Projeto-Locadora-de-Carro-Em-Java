import java.sql.*;

public class CarroCRUD {

	private static Conexao dao = new Conexao();
	private static Connection conexao = dao.conectaDB();

// Método para criar um novo carro
	public static void criarCarro(Carro carro) {
		try {
			String sql = "INSERT INTO carros (marca, modelo, ano, disponivel, placa, cor) VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement cr = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //É usado pra criar objeto que representa a instrucao sql 
			
			cr.setString(1, carro.getMarca());
			cr.setString(2, carro.getModelo());
			cr.setInt(3, carro.getAno());
			cr.setBoolean(4, carro.isDisponivel());
			cr.setString(5, carro.getPlaca());
			cr.setString(6, carro.getCor());

			cr.executeUpdate();

			ResultSet generatedKeys = cr.getGeneratedKeys(); //é usado em um objeto Statement para obter as chaves geradas após uma consulta de inserção no banco de dados
			if (generatedKeys.next()) {
				Long idGerado = generatedKeys.getLong(1);
				carro.setidcar(idGerado);
			}

			System.out.println("Carro criado com sucesso!");

			cr.close();
		} catch (SQLException e) {
			System.out.println("Erro ao criar o carro: " + e.getMessage());
		} finally {
		}
	}

	// Método para listar todos os carros
	public static void listarCarros() {
		String sql = "SELECT * FROM carros";

		try (PreparedStatement list = conexao.prepareStatement(sql)) { //É usado pra criar objeto que representa a instrucao sql 

			ResultSet rs = list.executeQuery();

			while (rs.next()) {
				Long idcar = rs.getLong("idcar");
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
		} finally {
		}
	}

	// Método para atualizar um carro
	public static void atualizarCarro(Carro carro) {

		String sql = "UPDATE carros SET marca = ?, modelo = ?, placa = ?, cor = ?, ano = ?, disponivel = ? WHERE idcar = ?";

		try (PreparedStatement att = conexao.prepareStatement(sql)) {//É usado pra criar objeto que representa a instrucao sql 

			att.setString(1, carro.getMarca());
			att.setString(2, carro.getModelo());
			att.setString(3, carro.getPlaca());
			att.setString(4, carro.getCor());
			att.setInt(5, carro.getAno());
			att.setBoolean(6, carro.isDisponivel());
			att.setLong(7, carro.getidcar());

			att.executeUpdate();
			System.out.println("Carro atualizado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		} 
	}

	// Método para excluir um carro
	public static void excluirCarro(long idExcluir) {

		String sql = "DELETE FROM carros WHERE idcar = ?";

		try (PreparedStatement ex = conexao.prepareStatement(sql)) {//É usado pra criar objeto que representa a instrucao sql 

			ex.setLong(1, idExcluir);

			int linhasAfetadas = ex.executeUpdate();
			if (linhasAfetadas > 0) {
				System.out.println("Carro excluído com sucesso!");
			} else {
				System.out.println("Nenhum carro encontrado com o ID especificado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		} 
	}
}