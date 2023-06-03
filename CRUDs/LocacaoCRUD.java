import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocacaoCRUD {

        static ConexaoDAO dao = new ConexaoDAO();
		static Connection conexao = dao.conectaDB();
    

    public void criarLocacao(Locacao locacao) {
        String query = "INSERT INTO Locacoes (id_cliente, id_carro, data_locacao, data_devolucao, custo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement prep = conexao.prepareStatement(query)) {
            prep.setInt(1, locacao.getIdCliente());
            prep.setInt(2, locacao.getIdCarro());
            prep.setDate(3, locacao.getDataLocacao());
            prep.setDate(4, locacao.getDataDevolucao());
            prep.setDouble(5, locacao.getCusto());
            prep.executeUpdate();
            System.out.println("Locação criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarLocacoes() {
        String query = "SELECT * FROM Locacoes";
        try (PreparedStatement prep = conexao.prepareStatement(query)) {
            ResultSet resultSet = prep.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCliente = resultSet.getInt("id_cliente");
                int idCarro = resultSet.getInt("id_carro");
                Date dataLocacao = resultSet.getDate("data_locacao");
                Date dataDevolucao = resultSet.getDate("data_devolucao");
                double custo = resultSet.getDouble("custo");

                System.out.println("---------------------------");
                System.out.println("ID: " + id);
                System.out.println("ID do Cliente: " + idCliente);
                System.out.println("ID do Carro: " + idCarro);
                System.out.println("Data de Locação: " + dataLocacao);
                System.out.println("Data de Devolução: " + dataDevolucao);
                System.out.println("Custo: " + custo);
                System.out.println("---------------------------");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarLocacao(Locacao locacao) {
        String query = "UPDATE Locacoes SET id_cliente=?, id_carro=?, data_locacao=?, data_devolucao=?, custo=? WHERE id=?";
        try (PreparedStatement prep = conexao.prepareStatement(query)) {
            prep.setInt(1, locacao.getIdCliente());
            prep.setInt(2, locacao.getIdCarro());
            prep.setDate(3, locacao.getDataLocacao());
            prep.setDate(4, locacao.getDataDevolucao());
            prep.setDouble(5, locacao.getCusto());
            prep.setInt(6, locacao.getId());
            prep.executeUpdate();
            System.out.println("Locação atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirLocacao(int id) {
        String query = "DELETE FROM Locacoes WHERE id=?";
        try (PreparedStatement prep = conexao.prepareStatement(query)) {
            prep.setInt(1, id);
            prep.executeUpdate();
            System.out.println("Locação excluída com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	}
