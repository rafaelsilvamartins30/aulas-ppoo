import java.util.Scanner;

public class raizQuadrada {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);  // declaracao de scanner para leitura
        double numero, raizAproximada, aproximacaoAnterior, tolerancia = 0.0001 ; // declaracao de variavel
        System.out.print("Digite um número: "); // leitura do numero
        numero = entrada.nextDouble();
        raizAproximada = numero / 2; // atribuicao do valor 
        do { // Método de Newton-Raphson em do-while
            aproximacaoAnterior = raizAproximada;
            raizAproximada = (raizAproximada + (numero / raizAproximada)) / 2;
        } while (Math.abs(raizAproximada - aproximacaoAnterior) > tolerancia); 
        System.out.printf("A raiz quadrada aproximada de %.1f é %.15f\n", numero, raizAproximada); // impressao do resultado
        entrada.close();  // fechamento do scanner
    }
}
