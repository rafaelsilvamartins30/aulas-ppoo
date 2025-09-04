import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 

public class Sig {
    private List<Disciplina> disciplinas;
    private Scanner scan ;

    
    public Sig() {
       disciplinas = new ArrayList<Disciplina>() ;
       scan = new Scanner(System.in);
    }

    public void executar(){
        int aux = 0;
        while (aux != 4) {
            exibiMenu();
            aux = Integer.parseInt(scan.nextLine());
            executarOpcao(aux);
        }
    }

    private void exibiMenu(){
        System.out.println("### MENU ###\n" + //
                        "1. Cadastrar disciplina\n" + //
                        "2. Cadastrar dados de aluno em disciplina\n" + //
                        "3. Mostrar diario de disciplina\n" + //
                        "4. Sair\n" + //
                        "Escolha uma opcao:");
    }

    private void executarOpcao(int i){
        switch (i) {
            case 1:
                cadastrarDisciplina();
                break;
            case 2:
                cadastrarAluno();
                break;
            case 3:
                mostrarDiario();
                break;
            case 4:
                System.out.println("Você encerrou o programa");
                break;
            default:
                System.out.println("opção invalida");
                break;
        }
    }


    private void cadastrarAluno(){
        if (disciplinas.size() > 0) {
            System.out.println("Escolha a disciplina: ");
            for (int i = 0; i < disciplinas.size(); i++) {
                System.out.println((i+1) + ". " + disciplinas.get(i).getCodigo());
            }
            int escolha = Integer.parseInt(scan.nextLine()) - 1;
            if (escolha >= 0 && escolha < disciplinas.size()) {
                System.out.println("Escolha os dados dos alunos da disciplina");
                System.out.println("Nome: ");
                String nome = scan.nextLine();
                System.out.println("Notas: ");
                int aux = Integer.parseInt(scan.nextLine());
                System.out.println("Faltas: ");
                int aux2 = Integer.parseInt(scan.nextLine());
                disciplinas.get(escolha).adicionarAluno(new Aluno(nome, aux, aux2));
            } else {
                System.out.println("Disciplina inválida");
            }
        } else {
            System.out.println("nenhuma disciplina criada ainda");
        }   
    }

    private void mostrarDiario(){
        if (disciplinas.size() > 0) {
            System.out.println("Escolha a disciplina: ");
            for (int i = 0; i < disciplinas.size(); i++) {
                System.out.println((i+1) + ". " + disciplinas.get(i).getCodigo());
            }
            int escolha = Integer.parseInt(scan.nextLine()) - 1;
            if (escolha >= 0 && escolha < disciplinas.size()) {
                disciplinas.get(escolha).ordenarDiario();
                System.out.println("\nDisciplina: " + disciplinas.get(escolha).getCodigo());
                System.out.printf("%-10s %-12s %-8s %-10s %n","Nome","Nota","Faltas","Situacao");
                for (Aluno a : disciplinas.get(escolha).getListaAlunos()){
                    System.out.printf("%-10s %-12s %-8s %-10s %n",a.getNome(),a.getNota(),a.getFaltas(),a.getSituacao());
                }
            } else {
                System.out.println("Disciplina inválida");
            }
        } else {
            System.out.println("nenhuma disciplina criada ainda");
        }   
    }

    private void cadastrarDisciplina(){
        System.out.println("Escolha o nome da nova disciplina: ");
        String aux = scan.nextLine();
        disciplinas.add(new Disciplina(aux));
    }
}
