import java.util.Date;

public class Locacao {
    private Long id_cliente;
    private Long id_carro;
    private Date data_locacao;
    private Date data_devolucao;
    private double custo;

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_carro() {
        return id_carro;
    }

    public void setId_carro(Long id_carro) {
        this.id_carro = id_carro;
    }

    public Date getData_locacao() {
        return data_locacao;
    }

    public void setData_locacao(Date data_locacao) {
        this.data_locacao = data_locacao;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
