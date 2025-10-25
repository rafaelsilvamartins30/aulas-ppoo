public class PessoaJuridica extends Contato {
    private String cnpj;
    private int inscricaoEstadual;
    
    public PessoaJuridica(String nome, String endereco, String email, String cnpj, int inscricaoEstadual) {
        super(nome, endereco, email);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String getIndentificador(){
        return cnpj;
    }

    @Override
    public String toString() {
        return super.toString() + "CNPJ = " + cnpj + ", Inscricao Estadual = " + inscricaoEstadual+ "\n";
    }

}