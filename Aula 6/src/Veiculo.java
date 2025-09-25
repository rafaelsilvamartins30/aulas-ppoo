public class Veiculo {
    private String marca;
    private String anoFabricacao;
    private String cor;

    public Veiculo(String marca, String anoFabricacao, String cor) {
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
    }

    public String getMarca() { return marca; }
    public String getAnoFabricacao() { return anoFabricacao; }
    public String getCor() { return cor; }

    // Método polimórfico (será sobrescrito nas subclasses)
    public String exibirInformacoes() {
        return "Marca: " + marca +
               "\nAno: " + anoFabricacao +
               "\nCor: " + cor;
    }
}