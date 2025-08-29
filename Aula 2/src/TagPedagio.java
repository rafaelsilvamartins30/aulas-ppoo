public class TagPedagio {
    private String placa;
    private double saldo;
    
    public TagPedagio(String placa, double saldo){
        this.placa = placa;
        this.saldo = 10 + saldo;
    }

    public TagPedagio(String placa ){
        this.placa = placa;
        saldo = 10;
    }

    public void atualizarSaldo(double valor){
        saldo = saldo + valor;
    }

    public String passarPedagio(double valor){
        if (saldo >= valor) {
            saldo = saldo - valor;
            return "Passagem liberada para " + placa +". Novo saldo: " + saldo;
        } else{
            return "Passagem bloqueada para " + placa +". Saldo insuficiente!";
        }
    }
}