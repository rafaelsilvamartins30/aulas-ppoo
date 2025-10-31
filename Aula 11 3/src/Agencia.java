import java.util.ArrayList;

public class Agencia{
  private String numero;
  private String nome;
  private ArrayList<Conta> contas;
  
  public Agencia(String numero, String nome){
    contas = new ArrayList<>();
    this.numero = numero;
    this.nome = nome;
  }
  
  public void criarConta(){
    contas.add(new Conta(contas.size()+1));
  }
  
  public String getRelatorio(){
    String res = "Lista de Contas Bancarias:";
    
    if(contas.size() > 0){
      for(Conta c: contas){
        res += "\n\nNumero: " + c.getNumero() + "\nSaldo: " + c.getSaldo();
      }
    }else{
      res += "\nNao ha contas cadastradas nesta agencia!";
    }
    
    return res;
  }
  

  public void depositar(int numeroConta, double valor){
    Conta contaDestino = getConta(numeroConta);
    if(contaDestino != null){
      contaDestino.depositar(valor);
    }
    else{
      
      throw new RuntimeException("ERRO: Conta de destino nao encontrada.");
    }
  }


  public void sacar(int numeroConta, double valor) throws SaldoInsuficienteException {
    Conta contaDestino = getConta(numeroConta);
    if(contaDestino != null){
      contaDestino.sacar(valor);
    }
    else{
      throw new RuntimeException("ERRO: Conta nao encontrada.");
    }
  }

  public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) throws SaldoInsuficienteException {
    Conta contaOrigem = getConta(numeroContaOrigem);
    Conta contaDestino = getConta(numeroContaDestino);

    if(contaOrigem == null){
      throw new RuntimeException("ERRO: Conta de origem nao encontrada.");
    } 
    
   
    if(contaDestino == null){ 
      throw new RuntimeException("ERRO: Conta de destino nao encontrada.");
    }
    
    
    contaOrigem.transferir(contaDestino, valor);
  }
  

  public Conta getConta(int numeroConta){
    for(Conta c: contas){
      if(c.getNumero() == numeroConta){
        return c;
      }
    }
    return null;
  }
}