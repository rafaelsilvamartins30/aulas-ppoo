public class Caminhao extends Veiculo {
    private int numeroEixos;
    private int capacidadeCarga;

    public Caminhao(String marca, String ano, String cor, int numeroEixos, int capacidadeCarga) {
        super(marca, ano, cor);
        this.numeroEixos = numeroEixos;
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() +
               "\nNúmero de Eixos: " + numeroEixos +
               "\nCapacidade de Carga: " + capacidadeCarga;
    }
}
