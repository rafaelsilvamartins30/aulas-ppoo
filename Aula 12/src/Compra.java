import java.io.Serializable;

public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    private String cpf;
    private String data;
    private String produto;
    private double valor;

    public Compra(String cpf, String data, String produto, double valor) {
        this.cpf = cpf;
        this.data = data;
        this.produto = produto;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Compra [cpf=" + cpf + ", data=" + data + ", produto=" + produto + ", valor=" + valor + "]";
    }   

    public String getCpf() {
        return cpf;
    }

    public String getData() {
        return data;
    }

    public String getProduto() {
        return produto;
    }

    public double getValor() {
        return valor;
    }
    
}
