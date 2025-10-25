import java.util.Scanner;

public class Menu { 
    private Agenda agenda;
    private Scanner scan;

    public Menu() {
        agenda = new Agenda();
        scan = new Scanner(System.in);
    }

    private void exibirMenu(){
        System.out.println("=======Menu de Opções=======");
        System.out.println("1 - Cadastrar uma pessoa física");
        System.out.println("2 - Cadastrar uma pessoa jurídica");
        System.out.println("3 - Remover um contato");
        System.out.println("4 - Imprimir dados da agenda");
        System.out.println("5 - Sair");
        System.out.println("============================");
    }



    public void iniciar(){
        int aux = 0;
         do {
           exibirMenu();
           aux = Integer.parseInt(scan.nextLine());
           switch (aux) {
            case 1:
                adicionarPessoaFisica();
                break;
            case 2:
                adicionarPessoaJuridica();
                break;
            case 3:
                removePeloId();
                break;
            case 4:
                imprimirLista();
                break;
            case 5:
                System.out.println("voce saiu do sistema");
                break;               
            default:
                System.out.println("opcao invalida");
                break;
           }
        } while (aux != 5);
        scan.close();
    }

    private String pedirString( String solicitada){
        System.out.println(solicitada);
        String aux = scan.nextLine();
        return aux;
    } 

    private void adicionarPessoaJuridica(){
        String nome = pedirString( "Nome: ");
        String endereco = pedirString("Endereco: ");
        String email = pedirString("Email: ");
        String cnpj = pedirString("CNPJ: ");
        System.out.println("Inscricao Estadual: ");
        int inscricaoEstadual = Integer.parseInt(scan.nextLine());
        agenda.addPessoaJuridica(nome, endereco, email, cnpj, inscricaoEstadual);
        System.out.println("Pessoa Juridica Adicionada");
    }

    private void adicionarPessoaFisica(){
        String nome = pedirString( "Nome: ");
        String endereco = pedirString("Endereco: ");
        String email = pedirString("Email: ");
        String cpf = pedirString("CPF: ");
        String estadoCivil = pedirString("Estado Civil: ");
        agenda.addPessoaFisica(nome, endereco, email, cpf, estadoCivil);
        System.out.println("Pessoa Fisica Adicionada");
    }

    private void removePeloId(){
        String id = pedirString("CPF ou CNPJ a ser removido: ");
        if (agenda.removerContato(id)) {
            System.out.println("Contato Removido");
        } else{
            System.out.println("Contato não encontrado");
        }
    }

    private void imprimirLista(){
        System.out.println(agenda.imprimirLista());
    }
}
