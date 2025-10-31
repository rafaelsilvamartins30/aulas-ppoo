public class SaldoInsuficienteException extends Exception {
  
    public SaldoInsuficienteException(int numeroConta) {
       
        super("ERRO: Saldo insuficiente na conta " + numeroConta);
    }
}