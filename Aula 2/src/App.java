public class App {
    public static void main(String[] args) {
        TagPedagio tag = new TagPedagio("ABC1D23");
        System.out.println(tag.passarPedagio(15));
        TagPedagio tag2 = new TagPedagio("EFG4H56", 20);
        tag2.atualizarSaldo(15);
        System.out.println(tag2.passarPedagio(23));
    }
}
