import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> lista;

    public Agenda() {
        lista = new ArrayList<Contato>();
    }

    public void addPessoaJuridica(String nome, String endereco, String email, String cnpj, int inscricaoEstadual){
        lista.add(new PessoaJuridica(nome, endereco, email, cnpj, inscricaoEstadual));
    }

    public void addPessoaFisica(String nome, String endereco, String email, String cpf, String estadoCivil){
        lista.add(new PessoaFisica(nome, endereco, email, cpf, estadoCivil));
    }

    private Contato buscarContato(String cpfOuCnpj){
        for (Contato contato : lista) {
            if (contato.getIndentificador().equals(cpfOuCnpj)) {
                return contato;
            }            
        }
        return null;
    }

    public boolean removerContato(String cpfOuCnpj){
        Contato aux = buscarContato(cpfOuCnpj);
        if (aux != null) {
            lista.remove(aux);
            return true;
        }
        return false;
    }

    public String imprimirLista(){
        String listaCompleta = "Lista de Contatos \n" ;
        for (Contato contato : lista) {
            listaCompleta = listaCompleta + contato;
        }
        return listaCompleta;
    }
}
