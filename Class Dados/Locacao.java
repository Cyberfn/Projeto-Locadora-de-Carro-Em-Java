import java.sql.Date;

public class Locacao {
	private int id;
	private int idCliente;
	private int idCarro;
	private Date dataLocacao;
	private Date dataDevolucao;
	private double custo;

	public Locacao() {
	}

	public Locacao(int id, int idCliente, int idCarro, Date dataLocacao, Date dataDevolucao, double custo) {
		this.id = id;
		this.idCliente = idCliente;
		this.idCarro = idCarro;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
		this.custo = custo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	
	@Override
    public String toString() {
        return "Locação [ID: " + id + ", Cliente: " + idCliente + ", Carro: " + idCarro +
                ", Data de Locação: " + dataLocacao + ", Data de Devolução: " + dataDevolucao +
                ", Custo: " + custo + "]";
    }
	
}
