import java.util.Date;

public class Cliente {
	private Long idcli;
	private String nome;
	private Date dtnasc;
	private String cpf;
	private String cnh;
	private String email;
	
	public Cliente(){
	}
	
	// Construtor que serve para inicializar os atributos da classe com os valores fornecidos ao criar um objeto
	public Cliente(Long idcli, String nome, Date dtnasc, String cpf, String cnh, String email) {
		this.idcli = idcli;
		this.nome = nome;
		this.dtnasc = dtnasc;
		this.cpf = cpf;
		this.cnh = cnh;
		this.email = email;
	}

	public Long getIdcli() {
		return idcli;
	}

	public void setIdcli(Long idGerado) {
		this.idcli = idGerado;
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

	public static void excluirCliente(Long id) {
		ClienteCRUD.excluirCliente(id);
	}
}