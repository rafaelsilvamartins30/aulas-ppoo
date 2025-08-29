import java.util.Random;

public class Questao {
    private String enunciado;
    private int resposta;
    private static int contador;
    private int idQuestao;

    public Questao(){
        contador++;
        idQuestao = contador;
        Random aux = new Random();
        int x = aux.nextInt(10);
        int y = aux.nextInt(10);
        enunciado = "Questão " + idQuestao + "\nQuanto é " + x + " * " + y + "?";
        resposta = x * y;
    }
    
    public String getEnun(){
        return enunciado;
    }
    public int getId(){
        return idQuestao;
    }
    public boolean verifica(int i){
        return i == resposta;
    }
}