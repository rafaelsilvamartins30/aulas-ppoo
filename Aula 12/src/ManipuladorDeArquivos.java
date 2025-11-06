import java.io.*;
import java.util.List;

public class ManipuladorDeArquivos {

    public HistoricoDeCompra lerArquivoTexto(String nomeArquivo) {
        HistoricoDeCompra historico = new HistoricoDeCompra();
        
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            
            while ((linha = br.readLine()) != null) {
                try {
                    String[] dados = linha.split(",");
                    
                    if (dados.length == 4) {
                        String cpf = dados[0].trim();
                        String data = dados[1].trim();
                        String produto = dados[2].trim();
                        double valor = Double.parseDouble(dados[3].trim());
                        
                        Compra compra = new Compra(cpf, data, produto, valor);
                        historico.adicionarCompra(compra);
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter valor numérico na linha: " + linha);
                    System.err.println("Detalhes: " + e.getMessage());
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Erro: formato inválido na linha: " + linha);
                    System.err.println("Detalhes: " + e.getMessage());
                }
            }
            
            System.out.println("Arquivo texto lido com sucesso!");
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo texto: " + nomeArquivo);
            System.err.println("Detalhes: " + e.getMessage());
        }
        
        return historico;
    }
    

    public HistoricoDeCompra lerArquivoBinario(String nomeArquivo) {
        HistoricoDeCompra historico = new HistoricoDeCompra();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            historico = (HistoricoDeCompra) ois.readObject();
            
            System.out.println("Arquivo binário lido com sucesso!");
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo binário: " + nomeArquivo);
            System.err.println("Detalhes: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: classe não encontrada ao deserializar o arquivo: " + nomeArquivo);
            System.err.println("Detalhes: " + e.getMessage());
        }
        
        return historico;
    }
    
    public void salvarRelatorioTexto(String nomeArquivo, List<Compra> compras) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            
            for (Compra compra : compras) {
                String linha = String.format("%s, %s, %.2f", 
                    compra.getData(), 
                    compra.getProduto(), 
                    compra.getValor());
                bw.write(linha);
                bw.newLine();
            }
            
            System.out.println("Relatório salvo com sucesso no arquivo: " + nomeArquivo);
            
        } catch (IOException e) {
            System.err.println("Erro ao salvar o relatório no arquivo: " + nomeArquivo);
            System.err.println("Detalhes: " + e.getMessage());
        }
    }
}