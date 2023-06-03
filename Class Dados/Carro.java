public class Carro {
    private int id;
    private String marca;
    private String modelo;
    private String placa;
    private String cor;
    private int ano;
    private boolean disponivel;
    
	public Carro() {
		// TODO Auto-generated constructor stub
	}

    // Construtor
    public Carro(String marca, String modelo, String placa, String cor, int ano, boolean disponivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.ano = ano;
        this.disponivel = disponivel;
    }

    
    
    // Getters e Setters}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
