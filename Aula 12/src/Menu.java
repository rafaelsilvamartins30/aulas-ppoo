import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private ManipuladorDeArquivos manipulador;
    private HistoricoDeCompra historico;
    
    public Menu() {
        scanner = new Scanner(System.in);
        manipulador = new ManipuladorDeArquivos();
        historico = null;
    }
    
    public void executar() {
        int opcao;
        
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 5);
        
        scanner.close();
        System.out.println("Programa encerrado. Até logo!");
    }
    
    private void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("       SISTEMA DE COMPRAS - MENU");
        System.out.println("========================================");
        System.out.println("1 - Carregar dados de arquivo texto");
        System.out.println("2 - Carregar dados de arquivo binário");
        System.out.println("3 - Gerar relatório na tela");
        System.out.println("4 - Salvar relatório em arquivo de texto");
        System.out.println("5 - Sair");
        System.out.println("========================================");
        System.out.print("Escolha uma opção: ");
    }
    
    private int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (Exception e) {
            scanner.nextLine(); 
            return -1;
        }
    }
    
    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                carregarArquivoTexto();
                break;
            case 2:
                carregarArquivoBinario();
                break;
            case 3:
                gerarRelatorioTela();
                break;
            case 4:
                salvarRelatorioArquivo();
                break;
            case 5:
                break;
            default:
                System.out.println("\nOpção inválida! Por favor, escolha uma opção de 1 a 5.");
        }
    }
    

    private void carregarArquivoTexto() {
        String nomeArquivo = solicitarNomeArquivo("Digite o nome do arquivo texto: ");
        historico = manipulador.lerArquivoTexto(nomeArquivo);
    }
    
    private void carregarArquivoBinario() {
        String nomeArquivo = solicitarNomeArquivo("Digite o nome do arquivo binário: ");
        historico = manipulador.lerArquivoBinario(nomeArquivo);
    }
    
    private String solicitarNomeArquivo(String mensagem) {
        System.out.print("\n" + mensagem);
        return scanner.nextLine();
    }
    
    private String solicitarCpf() {
        System.out.print("\nDigite o CPF do cliente (formato: xxx.xxx.xxx-xx): ");
        return scanner.nextLine();
    }
    
    private void gerarRelatorioTela() {
        List<Compra> compras = obterComprasParaRelatorio();
        if (compras == null) {
            return;
        }
        
        String cpf = compras.get(0).getCpf();
        exibirRelatorioNaTela(cpf, compras);
    }
    
    private void salvarRelatorioArquivo() {
        List<Compra> compras = obterComprasParaRelatorio();
        if (compras == null) {
            return;
        }
        
        System.out.print("Digite o nome do arquivo para salvar (deixe em branco para usar o CPF): ");
        String nomeArquivo = scanner.nextLine().trim();
        
        if (nomeArquivo.isEmpty()) {
            String cpf = compras.get(0).getCpf();
            nomeArquivo = cpf + ".txt";
        } else if (!nomeArquivo.endsWith(".txt")) {
            nomeArquivo += ".txt";
        }
        
        manipulador.salvarRelatorioTexto(nomeArquivo, compras);
    }
    
    private List<Compra> obterComprasParaRelatorio() {
        if (!verificarHistoricoCarregado()) {
            return null;
        }
        
        String cpf = solicitarCpf();
        List<Compra> comprasDoCliente = historico.filtrarPorCpf(cpf);
        
        if (comprasDoCliente.isEmpty()) {
            System.out.println("\nNenhuma compra encontrada para o CPF: " + cpf);
            return null;
        }
        
        comprasDoCliente.sort(historico.getComparadorPorPreco());
        return comprasDoCliente;
    }
    
    private void exibirRelatorioNaTela(String cpf, List<Compra> compras) {
        System.out.println("\n========================================");
        System.out.println("    RELATÓRIO DE COMPRAS - CPF: " + cpf);
        System.out.println("========================================");
        
        for (Compra compra : compras) {
            System.out.println(compra.getData() + ", " + 
                             compra.getProduto() + ", " + 
                             String.format("%.2f", compra.getValor()));
        }
        
        System.out.println("========================================");
    }
    
    private boolean verificarHistoricoCarregado() {
        if (historico == null) {
            System.out.println("\n========================================");
            System.out.println("ERRO: Nenhum histórico carregado!");
            System.out.println("Por favor, carregue um arquivo primeiro");
            System.out.println("(opção 1 ou 2).");
            System.out.println("========================================");
            return false;
        }
        return true;
    }
     public static void main(String[] args) {
        Menu menu = new Menu();
        menu.executar();
    }
}