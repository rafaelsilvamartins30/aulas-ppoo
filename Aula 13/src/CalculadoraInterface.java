import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraInterface extends JFrame {

    // 1. Atributos dos Componentes
    private JTextField numero1Field;
    private JTextField numero2Field;
    private JButton botaoSoma;
    private JButton botaoSubtracao;
    private JButton botaoMultiplicacao;
    private JButton botaoDivisao;

    public CalculadoraInterface() {
        // Configuração básica da janela (JFrame)
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Inicialização dos campos de texto com valores de exemplo da Figura 1
        numero1Field = new JTextField("6.2", 5);
        numero2Field = new JTextField("4.2", 5);
        
        // Inicialização dos botões
        botaoSoma = new JButton("+");
        botaoSubtracao = new JButton("-");
        botaoMultiplicacao = new JButton("*");
        botaoDivisao = new JButton("/");

        // Montagem da interface e tratamento de eventos
        montarJanela();
        registrarOuvintes();

        pack(); // Ajusta o tamanho da janela aos componentes
        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }

    private void montarJanela() {
        // Uso de FlowLayout para organizar os elementos de forma simples (sequencial) [cite: 340, 361]
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Painel para os rótulos e campos de texto
        JPanel painelNumeros = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelNumeros.add(new JLabel("Numero 1:"));
        painelNumeros.add(numero1Field);
        painelNumeros.add(new JLabel("Numero 2:"));
        painelNumeros.add(numero2Field);

        // Painel para os botões usando GridLayout para a grade 1x4
        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 5, 5)); 
        painelBotoes.add(botaoSoma);
        painelBotoes.add(botaoSubtracao);
        painelBotoes.add(botaoMultiplicacao);
        painelBotoes.add(botaoDivisao);

        // Adiciona os painéis à janela principal
        add(painelNumeros);
        add(painelBotoes);
    }

    private void registrarOuvintes() {
        // 2. Tratamento de Eventos usando Classes Internas Anônimas
        
        // Botão de SOMA (+)
        botaoSoma.addActionListener(new ActionListener() { // Classe anônima [cite: 925, 935]
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEExibir("+");
            }
        });

        // Botão de SUBTRAÇÃO (-)
        botaoSubtracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEExibir("-");
            }
        });

        // Botão de MULTIPLICAÇÃO (*)
        botaoMultiplicacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEExibir("*");
            }
        });

        // Botão de DIVISÃO (/)
        botaoDivisao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEExibir("/");
            }
        });
    }

    /**
     * Lógica para calcular e exibir o resultado na caixa de mensagem.
     */
    private void calcularEExibir(String operacao) {
        try {
            // Tenta obter os números dos campos de texto
            double num1 = Double.parseDouble(numero1Field.getText());
            double num2 = Double.parseDouble(numero2Field.getText());
            double resultado = 0.0;
            String operacaoTexto = "";

            switch (operacao) {
                case "+":
                    resultado = num1 + num2;
                    operacaoTexto = "soma";
                    // Formatação para resultado simples (ex: 10.4)
                    break;
                case "-":
                    resultado = num1 - num2;
                    operacaoTexto = "subtração";
                    // Formatação para resultado simples (ex: 2.0)
                    break;
                case "*":
                    resultado = num1 * num2;
                    operacaoTexto = "multiplicação";
                    // A saída de Double.toString() pode ter mais precisão, como no exemplo
                    break;
                case "/":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Erro: Divisão por zero!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultado = num1 / num2;
                    operacaoTexto = "divisão";
                    // A saída de Double.toString() pode ter mais precisão, como no exemplo
                    break;
            }

            // Criação da mensagem a ser exibida
            String mensagem = String.format("O resultado da %s é %s", operacaoTexto, Double.toString(resultado));

            // Exibe a caixa de mensagem (JOptionPane.showMessageDialog) [cite: 557]
            JOptionPane.showMessageDialog(this, mensagem, "Mensagem", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            // Trata erro caso os campos não contenham números válidos
            JOptionPane.showMessageDialog(this, "Por favor, insira números válidos nos campos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Inicia a aplicação na Thread de Despacho de Eventos (EDT)
        SwingUtilities.invokeLater(() -> new CalculadoraInterface());
    }
}