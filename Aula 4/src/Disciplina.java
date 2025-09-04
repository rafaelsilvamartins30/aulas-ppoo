import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Aluno> alunos;

    public Disciplina(String nome) {
        this.nome = nome;
        alunos = new ArrayList<Aluno>();
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void ordenarDiario(){
        alunos.sort(Aluno.getComparador());
    }

    public String getCodigo() {
        return nome;
    }

    public List<Aluno> getListaAlunos() {
        return alunos;
    }
    

}

