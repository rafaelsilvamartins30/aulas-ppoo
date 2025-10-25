public abstract class Imovel implements Segurado {
    private int metrosQuadrados;

    public Imovel(int metrosQuadrados) {
        this.metrosQuadrados = metrosQuadrados;
    }

    public int getMetrosQuadrados() {
        return metrosQuadrados;
    }

    @Override
    public String toString() {
        return " Metros Quadrados: " + metrosQuadrados + " Valor do Premio: " + calcularPremio();
    }
}
