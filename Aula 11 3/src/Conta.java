public class Conta{
  private int numero;
  private double saldo;
  
  public Conta(int numero){
    this.numero = numero;
    saldo = 0.0;
  }
  
  public int getNumero(){
    return numero;
  }
  
  public double getSaldo(){
    return saldo;
  }
  
  public void depositar(double valor){
    saldo += valor;
  }
  

  public void sacar(double valor) throws SaldoInsuficienteException {
    if(saldo >= valor){
      saldo -= valor;
    }
    else{
      
      throw new SaldoInsuficienteException(this.numero);
    }
  }
  
  public void transferir(Conta contaDestino, double valor) throws SaldoInsuficienteException {
    try
    {
      sacar(valor); 
      contaDestino.depositar(valor);
    }
    catch (SaldoInsuficienteException e)
    {
      
      throw e; 
    }
  }
}