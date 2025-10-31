import java.util.Scanner;
public class Menu{
  private Agencia ag;
  private Scanner entrada;
  
  public void executar(){
    entrada = new Scanner(System.in);
    ag = new Agencia("0364-6","Campus UFLA");
    int opcao;
    
    do{
      exibirMenu();
      opcao = entrada.nextInt();
      executarOpcao(opcao);
    }while(opcao != 6);
  }
  
  private  void exibirMenu(){
    System.out.println("=======MENU=======");
    System.out.println("1 - Criar conta");
    System.out.println("2 - Gerar relatorio");
    System.out.println("3 - Depositar");
    System.out.println("4 - Sacar");
    System.out.println("5-  Transferir");
    System.out.println("6 - Sair\n");
    System.out.print("Digite sua opcao: ");
  }
  
  private void executarOpcao(int opcao){
    switch(opcao){
      case 1:
        criarConta();
        break;
      case 2:
        gerarRelatorio();
        break;
      case 3:
        depositar();
        break;
      case 4:
        sacar();
        break;
      case 5:
        transferir();
        break;
      case 6://sair
        break;
      default: 
        System.out.println("Opção inválida!");
    }
  }
  
  private void criarConta(){
    ag.criarConta();
  }
  
  private void gerarRelatorio(){
    System.out.println(ag.getRelatorio());
  }
  
  private void depositar(){
    boolean sucesso = ag.depositar(pedirContaDestino(),pedirValor());
    if (sucesso) {
        System.out.println(">>> Deposito realizado com sucesso!");
    } else {
        System.out.println(">>> ERRO: Conta de destino nao encontrada.");
    }
  }
  
  private void sacar(){
    boolean sucesso = ag.sacar(pedirContaDestino(),pedirValor());
    if (sucesso) {
        System.out.println(">>> Saque realizado com sucesso!");
    } else {
        System.out.println(">>> ERRO: Conta nao encontrada ou saldo insuficiente.");
    }
  }
  
  private void transferir(){
    boolean sucesso = ag.transferir(pedirContaOrigem(),pedirContaDestino(),pedirValor());
    if (sucesso) {
        System.out.println(">>> Transferencia realizada com sucesso!");
    } else {
        System.out.println(">>> ERRO: Conta(s) nao encontrada(s) ou saldo insuficiente na origem.");
    }
  }
  
  private int pedirContaOrigem(){
    System.out.print("Digite o numero da conta de origem: ");
    return entrada.nextInt();
  }
  
  private int pedirContaDestino(){
    System.out.print("Digite o numero da conta de destino: ");
    return entrada.nextInt();
  }
  
  private double pedirValor(){
    System.out.print("Digite o valor: ");
    return entrada.nextDouble();
  } 
  
}