import java.util.Scanner;
import java.util.InputMismatchException; // Boa prática adicionar

public class Menu{
  private Agencia ag;
  private Scanner entrada;
  
  public void executar(){
    entrada = new Scanner(System.in);
    ag = new Agencia("0364-6","Campus UFLA");
    int opcao = 0; // Inicializar
    
    do{
      exibirMenu();
      try { // Adicionado para robustez (evita crash se digitar letra)
        opcao = entrada.nextInt();
        executarOpcao(opcao);
      } catch (InputMismatchException e) {
        System.out.println("ERRO: Por favor, digite apenas numeros.");
        entrada.nextLine(); // Limpa o buffer do scanner
        opcao = 0; // Reseta a opção
      }
    }while(opcao != 6);
  }
  
  private  void exibirMenu(){
    System.out.println("\n=======MENU=======");
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
        System.out.println("Sistema encerrado.");
        break;
      default: 
        System.out.println("Opção inválida!");
    }
  }
  
  private void criarConta(){
    ag.criarConta();
    System.out.println("Conta criada com sucesso!");
  }
  
  private void gerarRelatorio(){
    System.out.println(ag.getRelatorio());
  }
  
  private void depositar(){
    try
    {
      ag.depositar(pedirContaDestino(),pedirValor());
      System.out.println(">>> Deposito realizado com sucesso!");
    }
    catch(Exception e){ // Captura RuntimeException (conta não encontrada)
      System.out.println(e.getMessage());
    }
  }
  
  private void sacar(){
    try
    {
      ag.sacar(pedirContaDestino(),pedirValor());
      System.out.println(">>> Saque realizado com sucesso!");
    }
    // Captura específica (Questão 4)
    catch(SaldoInsuficienteException e){ 
      System.out.println(e.getMessage());
    }
    // Captura RuntimeException (conta não encontrada)
    catch(Exception e){ 
      System.out.println(e.getMessage());
    }
  }
  
  private void transferir(){
    try
    {
      ag.transferir(pedirContaOrigem(),pedirContaDestino(),pedirValor());
      System.out.println(">>> Transferencia realizada com sucesso!");
    }
    // Captura específica (Questão 4)
    catch(SaldoInsuficienteException e){
      System.out.println(e.getMessage());
    }
    // Captura RuntimeException (contas não encontradas)
    catch(Exception e){
      System.out.println(e.getMessage());
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