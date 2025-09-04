import java.util.Comparator;

public class Aluno {
    private String nome;
    private int nota;
    private int falta;

    public Aluno(String nome, int nota, int falta) {
        this.nome = nome;
        this.nota = nota;
        this.falta = falta;
    }

    public String getNome() {
        return nome;
    }

    public int getNota() {
        return nota;
    }

    public int getFaltas() {
        return falta;
    }

    private static Comparator<Aluno> comparador = new Comparator<Aluno>( ){
        @Override
        public int compare( Aluno a1, Aluno a2){
            return (a1.getNota() - a2.getNota()) * -1;
        }
    };

    public static Comparator<Aluno> getComparador() {
        return comparador;
    }

    public String getSituacao(){
        if (nota >= 60 && falta <19) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }
    
    
}
