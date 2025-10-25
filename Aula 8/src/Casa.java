public class Casa extends Imovel {
    private boolean eCondominio;

    public Casa(int metrosQuadrados, boolean eCondominio) {
        super(metrosQuadrados);
        this.eCondominio = eCondominio;
    }

    @Override
    public double calcularPremio(){
        if (eCondominio) {
            return 5 * getMetrosQuadrados();    
        } 
        return  7 * getMetrosQuadrados(); 
    }

    @Override
    public String toString() {
        return "Casa\nLocalizada no Condominio: " + (eCondominio ? "Sim" : "Não") + super.toString();
    }
}
