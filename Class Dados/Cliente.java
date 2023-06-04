import java.util.Date;

public class Cliente {
    private int idcli;
    private String nome;
    private Date dtnasc;
    private String cpf;
    private String cnh;
    private String email;

    public Cliente() {
    }

    public Cliente(int idcli, String nome, Date dtnasc, String cpf, String cnh, String email) {
        this.idcli = idcli;
        this.nome = nome;
        this.dtnasc = dtnasc;
        this.cpf = cpf;
        this.cnh = cnh;
        this.email = email;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void criarCliente() {
        ClienteCRUD.criarCliente(this);
    }

    public static void listarClientes() {
        ClienteCRUD.listarClientes();
    }

    public void atualizarCliente() {
        ClienteCRUD.atualizarCliente(this);
    }

    public static void excluirCliente(int id) {
        ClienteCRUD.excluirCliente(id);
    }
}
