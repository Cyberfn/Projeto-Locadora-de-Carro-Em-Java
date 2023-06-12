import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocacaoCRUD {

    static ConexaoDAO dao = new ConexaoDAO();
    static Connection conexao = dao.conectaDB();

    public static void criarLocacao(Locacao locacao) {
        String query = "INSERT INTO Locacoes (id_cliente, id_carro, data_locacao, data_devolucao, custo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement prep = conexao.prepareStatement(query)) {
            prep.setInt(1, locacao.getId_cliente());
            prep.setInt(2, locacao.getId_carro());
            prep.setDate(3, new java.sql.Date(locacao.getData_locacao().getTime()));
            prep.setDate(4, new java.sql.Date(locacao.getData_devolucao().getTime()));
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
                int idCliente = resultSet.getInt("id_cliente");
                int idCarro = resultSet.getInt("id_carro");
                Date dataLocacao = resultSet.getDate("data_locacao");
                Date dataDevolucao = resultSet.getDate("data_devolucao");
                double custo = resultSet.getDouble("custo");

                System.out.println("---------------------------");
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

    public static void atualizarLocacao(Locacao locacao) {
        String query = "UPDATE Locacoes SET id_cliente=?, id_carro=?, data_locacao=?, data_devolucao=?, custo=?;";
        try (PreparedStatement prep = conexao.prepareStatement(query)) {
            prep.setInt(1, locacao.getId_cliente());
            prep.setInt(2, locacao.getId_carro());
            prep.setDate(3, new java.sql.Date(locacao.getData_locacao().getTime()));
            prep.setDate(4, new java.sql.Date(locacao.getData_devolucao().getTime()));
            prep.setDouble(5, locacao.getCusto());



            prep.executeUpdate();
            System.out.println("Locação atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void excluirLocacao(int idCliente, int idCarro) {
        String query = "DELETE FROM Locacoes WHERE id_cliente = ? AND id_carro = ?";
        try (PreparedStatement prep = conexao.prepareStatement(query)) {
            prep.setInt(1, idCliente);
            prep.setInt(2, idCarro);
            int rowsAffected = prep.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Locação excluída com sucesso!");
            } else {
                System.out.println("A locação não foi encontrada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
