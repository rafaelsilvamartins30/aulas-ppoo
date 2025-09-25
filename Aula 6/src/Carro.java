public class Carro extends Veiculo {
    private int capacidadePortaMalas;
    private int numeroPortas;

    public Carro(String marca, String ano, String cor, int capacidadePortaMalas, int numeroPortas) {
        super(marca, ano, cor);
        this.capacidadePortaMalas = capacidadePortaMalas;
        this.numeroPortas = numeroPortas;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() +
               "\nCapacidade do Porta Malas: " + capacidadePortaMalas +
               "\nNúmero de Portas: " + numeroPortas;
    }
}
