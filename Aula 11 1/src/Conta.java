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
  
  public void sacar(double valor){
    saldo -= valor;
  }
  
  public void transferir(Conta contaDestino, double valor){
    sacar(valor);
    contaDestino.depositar(valor);
    
  }
}
