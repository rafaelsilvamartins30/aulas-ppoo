public class App {
    public static void main(String[] args) throws Exception {
        ClasseGenerica<String> string = new ClasseGenerica<String>("arroz", "feijao", "macarrao");
        ClasseGenerica<Double> doubles = new ClasseGenerica<Double>(20.0, 15.0, 10.0);
        System.out.println(string);
        System.out.println(doubles);
    }
}
