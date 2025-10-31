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
  
  public boolean depositar(int numeroConta, double valor){
    Conta contaDestino = getConta(numeroConta);
    if(contaDestino != null){
      contaDestino.depositar(valor);
      return true; // Sucesso
    }
    return false; // Falha (conta não encontrada)
  }

  public boolean sacar(int numeroConta, double valor){
    Conta contaDestino = getConta(numeroConta);
    if(contaDestino != null){
      // O método sacar da Conta já retorna true (sucesso) ou false (saldo insuficiente)
      return contaDestino.sacar(valor); 
    }
    return false; // Falha (conta não encontrada)
  }
  
  public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor){
    Conta contaOrigem = getConta(numeroContaOrigem);
    Conta contaDestino = getConta(numeroContaDestino);
    if( (contaOrigem != null) && (contaDestino != null) ){
      // O método transferir da Conta já retorna true/false
      return contaOrigem.transferir(contaDestino, valor);
    }
    return false; // Falha (uma ou ambas as contas não foram encontradas)
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
