import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prova {
    private List<Questao> questoes;
    private List<Correcao> correcoes;

    public Prova(){
        questoes = new ArrayList<Questao>();
        for(int i = 0; i < 5; i++){
            questoes.add(new Questao());
        }
        correcoes = new ArrayList<Correcao>();
    }

    public void aplicar(){
        Scanner scan = new Scanner(System.in);
        for (Questao questao2 : questoes) {
            System.out.println(questao2.getEnun());
            int tentativas = 1;
            boolean acertou = false;
            while ( tentativas < 3  && !acertou ) {
                if (questao2.verifica(scan.nextInt())) {
                    System.out.println("Você tentou " + tentativas + " vez e acertou a questão. ");
                    acertou = true;
                } else {
                    System.out.println("Infelizmente você errou!");
                    if (tentativas < 2) {
                        System.out.println("Você ganhou mais uma chance! Digite outra resposta para a questão: ");    
                    } else {
                        System.out.println("Você tentou 2 vezes e errou a questão.");
                    }
                    tentativas++;
                }
            }    
            correcoes.add(new Correcao(questao2.getId(),tentativas, acertou));
        }
        scan.close();
    }

    public void gerarRelatorio(){
        System.out.println("Questao   Situacao   Numero Tentativas");
        for (Correcao correcao : correcoes) {
            System.out.println("   " + correcao.getIdQuestao() + "       " + (correcao.isAcertou() ? "acertou      " : "   errou      ") + correcao.getTentativas());
        }
    }
}
