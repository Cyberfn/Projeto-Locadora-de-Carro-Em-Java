import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ClienteCRUD {

    private static ConexaoDAO dao = new ConexaoDAO();
    private static Connection conexao = dao.conectaDB();

    // Método para criar um novo cliente
    public static void criarCliente(Cliente novoCliente) {
        String sql = "INSERT INTO Clientes (nome, dtnasc, cpf, cnh, email) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement prep = conexao.prepareStatement(sql)) {
            prep.setString(1, novoCliente.getNome());
            prep.setDate(2, new java.sql.Date(novoCliente.getDtnasc().getTime()));
            prep.setString(3, novoCliente.getCpf());
            prep.setString(4, novoCliente.getCnh());
            prep.setString(5, novoCliente.getEmail());

            prep.executeUpdate();
            System.out.println("Cliente criado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos os clientes
    public void listarClientes() {
        String sql = "SELECT * FROM Clientes";

        try (PreparedStatement prep = conexao.prepareStatement(sql)) {
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
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
    public static void atualizarCliente(Cliente clienteAtualizado) {
        String sql = "UPDATE Clientes SET nome = ?, dtnasc = ?, cpf = ?, cnh = ?, email = ? WHERE id = ?";

        try (PreparedStatement prep = conexao.prepareStatement(sql)) {
            prep.setString(1, clienteAtualizado.getNome());
            prep.setDate(2, new java.sql.Date(clienteAtualizado.getDtnasc().getTime()));
            prep.setString(3, clienteAtualizado.getCpf());
            prep.setString(4, clienteAtualizado.getCnh());
            prep.setString(5, clienteAtualizado.getEmail());
            prep.setInt(6, clienteAtualizado.getId());

            prep.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir um cliente
    public void excluirCliente(int id) {
        String sql = "DELETE FROM Clientes WHERE id = ?";

        try (PreparedStatement prep = conexao.prepareStatement(sql)) {
            prep.setInt(1, id);

            prep.executeUpdate();
            System.out.println("Cliente excluído com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
