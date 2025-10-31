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
    for(Conta c: contas){
      res += "\n\nNumero: " + c.getNumero() + "\nSaldo: " + c.getSaldo();
    }
    return res;
  }
  
  public void depositar(int numeroConta, double valor){
    Conta contaDestino = contas.get(numeroConta-1);
    contaDestino.depositar(valor);
  }
  
  public void sacar(int numeroConta, double valor){
    Conta contaDestino = contas.get(numeroConta-1);
    contaDestino.sacar(valor);
  }
  
  public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor){
    Conta contaOrigem = contas.get(numeroContaOrigem-1);
    Conta contaDestino = contas.get(numeroContaDestino-1);
    contaOrigem.transferir(contaDestino, valor);
  }
  
}
