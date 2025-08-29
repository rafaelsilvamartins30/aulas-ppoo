public class Correcao {
    private int idQuestao;
    private int tentativas;
    private boolean acertou;

    public Correcao(int idQuestao, int tentativas, boolean acertou){
        this.idQuestao = idQuestao;
        this.tentativas = tentativas;
        this.acertou = acertou;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public int getTentativas() {
        return tentativas;
    }

    public boolean isAcertou() {
        return acertou;
    }
    
}
