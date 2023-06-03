import java.util.Date;

public class Cliente {
    private int id;
    private String nome;
    private Date dtnasc;
    private String cpf;
    private String cnh;
    private String email;

    public Cliente() {
    }

    public Cliente(int id, String nome, Date dtnasc, String cpf, String cnh, String email) {
        this.id = id;
        this.nome = nome;
        this.dtnasc = dtnasc;
        this.cpf = cpf;
        this.cnh = cnh;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

	
}
