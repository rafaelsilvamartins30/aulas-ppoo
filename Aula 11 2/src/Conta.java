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
  
  public boolean sacar(double valor){
    if(saldo >= valor){
      saldo -= valor;
      return true;
    }
    else{
      return false;
    }
    
  }
  
  public boolean transferir(Conta contaDestino, double valor){
    if(sacar(valor)){
      contaDestino.depositar(valor);
      return true;
    }
    else{
      return false;
    }
    
  }
}
