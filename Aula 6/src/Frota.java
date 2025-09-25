import java.util.ArrayList;

public class Frota {
    private ArrayList<Carro> carros = new ArrayList<>();
    private ArrayList<Caminhao> caminhoes = new ArrayList<>();

    public void adicionarCarro(Carro c) {
        carros.add(c);
    }

    public void adicionarCaminhao(Caminhao c) {
        caminhoes.add(c);
    }

    public void exibirInformacoesVeiculos() {
        for (Carro c : carros) {
            System.out.println(c.exibirInformacoes());
            System.out.println();
        }
        for (Caminhao c : caminhoes) {
            System.out.println(c.exibirInformacoes());
            System.out.println();
        }
    }
}
