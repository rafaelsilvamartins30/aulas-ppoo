import java.util.Scanner;

public class App{

    public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);   
    String frase, maiorPalavra;
    int maxVogais = 0;
    System.out.print("Digite uma frase para descobrir qual palavra tem mais vogais: "); 
    frase = entrada.nextLine();
    String [] palavras;
    char [] vogais = {'a', 'e', 'i', 'o', 'u'};
    palavras = frase.split(" ");
    maiorPalavra = palavras[0];
    int numVogais, k;
    for(int i = 0; i < palavras.length; i++){
        numVogais = 0;
        for (int j = 0; j < palavras[i].length(); j++) {
            char letra = palavras[i].charAt(j);
            k = 0;
            while (k < 5 && letra != vogais[k]) {
                    k++;
            }
            if (k < 5) {
                numVogais++;    
            }  
        }
        if (numVogais > maxVogais) {
            maxVogais = numVogais;
            maiorPalavra = palavras[i];
        }
    }
    
    System.out.println("Palavra com maior número de vogais: " + maiorPalavra);
    System.out.println("Quantidade de vogais: " + maxVogais);
    entrada.close();
    }
}