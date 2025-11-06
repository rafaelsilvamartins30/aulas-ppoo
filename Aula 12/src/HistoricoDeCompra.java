import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HistoricoDeCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Compra> compras;

    public HistoricoDeCompra() {
        compras = new ArrayList<>();
    }

    public void adicionarCompra(Compra compra) {
        compras.add(compra);
    }

    public Comparator<Compra> getComparadorPorPreco() {
        return new Comparator<Compra>() {
            @Override
            public int compare(Compra c1, Compra c2) {
                return Double.compare(c1.getValor(), c2.getValor());
            }
        };
    }

    public List<Compra> filtrarPorCpf(String cpf) {
        List<Compra> comprasFiltradas = new ArrayList<>();
        for (Compra compra : compras) {
            if (compra.getCpf().equals(cpf)) {
                comprasFiltradas.add(compra);
            }
        }
        return comprasFiltradas;
    }

}
