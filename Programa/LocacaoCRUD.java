import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocacaoCRUD {

    static Conexao dao = new Conexao();
    static Connection conexao = dao.conectaDB();

    public static void criarLocacao(Locacao locacao) {
        String sql = "INSERT INTO Locacoes (id_cliente, id_carro, data_locacao, data_devolucao, custo) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement cr = conexao.prepareStatement(sql)) {
        	cr.setLong(1, locacao.getId_cliente());
        	cr.setLong(2, locacao.getId_carro());
        	cr.setDate(3, new java.sql.Date(locacao.getData_locacao().getTime()));
        	cr.setDate(4, new java.sql.Date(locacao.getData_devolucao().getTime()));
            cr.setDouble(5, locacao.getCusto());

            cr.executeUpdate();
            System.out.println("Locação criada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarLocacoes() {
        String query = "SELECT * FROM Locacoes";
        try (PreparedStatement list = conexao.prepareStatement(query)) {
            ResultSet resultSet = list.executeQuery();
            while (resultSet.next()) {
                Long idCliente = resultSet.getLong("id_cliente");
                Long idCarro = resultSet.getLong("id_carro");
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
        String sql = "UPDATE Locacoes SET id_cliente=?, id_carro=?, data_locacao=?, data_devolucao=?, custo=?;";
        try (PreparedStatement att = conexao.prepareStatement(sql)) {
        	att.setLong(1, locacao.getId_cliente());
        	att.setLong(2, locacao.getId_carro());
        	att.setDate(3, new java.sql.Date(locacao.getData_locacao().getTime()));
        	att.setDate(4, new java.sql.Date(locacao.getData_devolucao().getTime()));
        	att.setDouble(5, locacao.getCusto());



        	att.executeUpdate();
            System.out.println("Locação atualizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void excluirLocacao(long id_Cliente, long id_Carro) {
        String sql = "DELETE FROM Locacoes WHERE id_cliente = ? AND id_carro = ?";
        try (PreparedStatement ex = conexao.prepareStatement(sql)) {
        	ex.setLong(1, id_Cliente);
        	ex.setLong(2, id_Carro);
            int rowsAffected = ex.executeUpdate();

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