import java.util.Scanner;
public class loja {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); // declaracao de scanner para leitura
        int produto, quantidade; // declaracao de variavel
        double valorDoDesconto, valorComDesconto, desconto = 0, valor = 0, valorTotal;
        System.out.print("Entre com o numero do produto entre 1 e 40: "); // leitura do produto
        produto = entrada.nextInt();
        System.out.print("Entre com a quantidade do produto: "); // leitura da quantidade
        quantidade = entrada.nextInt();
        if (produto >= 1 && produto <= 10 ) { // condicional sobre valor do produto
            valor = 10;
        } else if (produto >= 11 && produto <= 20 ) {
            valor = 15;
        } else if (produto >= 21 && produto <= 30 ) {
            valor = 20;
        } else if (produto >= 31 && produto <= 40 ) {
            valor = 30;
        }
        valorTotal = quantidade * valor; // operacao para valor da compra total
        if (valorTotal <= 250 ) { // condicional sobre o total do desconto
            desconto = 0.05;
        } else if (valorTotal >= 251 && valorTotal <= 500) {
            desconto = 0.1;
        } else if (valorTotal > 500 ) {
            desconto = 0.15;
        } 
        valorDoDesconto = valorTotal * desconto; // operacao para valor do desconto
        valorComDesconto = valorTotal - valorDoDesconto; // operacao para o valor com desconto
        System.out.printf("Preço unitário: R$ %.2f\n", valor); // impressoes com formatação correta
        System.out.printf("Valor bruto: R$ %.2f\n", valorTotal);
        System.out.printf("Desconto aplicado: R$ %.2f\n", valorDoDesconto);
        System.out.printf("Valor final a pagar: R$ %.2f\n", valorComDesconto);
        entrada.close(); // fechamento do scanner
    }
}
