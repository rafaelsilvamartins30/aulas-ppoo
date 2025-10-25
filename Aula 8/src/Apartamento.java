public class Apartamento extends Imovel{
    private int numAndares;

    public Apartamento(int metrosQuadrados, int numAndares) {
        super(metrosQuadrados);
        this.numAndares = numAndares;
    }

    @Override
    public double calcularPremio(){
        if (numAndares > 4) {
            return 3 * getMetrosQuadrados();
        }
        return 4 * getMetrosQuadrados();
    }

    @Override
    public String toString() {
        return "Casa\nNumero de Andares: " + numAndares + super.toString();
    }
}
