public class App {
 public static void main(String[] args) {
 Frota frota = new Frota( );
 frota.adicionarCarro(new Carro("VW", "2016", "branca", 280, 4));
 frota.adicionarCarro(new Carro("Fiat", "2023", "preta", 300, 4));
 frota.adicionarCaminhao(new Caminhao("Mercedes", "2001", "azul", 4, 1500));
 frota.adicionarCaminhao(new Caminhao("Iveco", "2020", "cinza", 5, 2000));
 frota.exibirInformacoesVeiculos( );
 }
}
