import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Segurado> lista = new ArrayList<Segurado>();

        lista.add(new Pessoa(25, true));
        lista.add(new Pessoa(65, false));
        lista.add(new Casa(120, true));
        lista.add(new Casa(85, false));
        lista.add(new Apartamento(100, 3));
        lista.add(new Apartamento(150, 5));


        for (Segurado segurado : lista) {
            System.out.println(segurado);
        }
    }
}
