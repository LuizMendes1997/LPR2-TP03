package TP03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Luiz Carlos Mendes
//CB3012123
public class Calculadora {
    
    private double num1, num2, resultado;
    private String operador;

    public static void main(String[] args) {
    
        Calculadora calc = new Calculadora();
        calc.criarCalculadora();
    }

    
    public void criarCalculadora() {
     
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false); 

       
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 10)); 
        
        JTextField display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 4));  
      
        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*", 
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"  
        };

        
        for (String texto : botoes) {
            JButton button = new JButton(texto);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            painel.add(button);

           
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String comando = e.getActionCommand();
                    try {
                        if ("C".equals(comando)) {
                            display.setText("");
                            num1 = num2 = resultado = 0;
                            operador = "";
                        } else if ("=".equals(comando)) {
                            
                            num2 = Double.parseDouble(display.getText());  
                            calcular(display);
                        } else if ("+".equals(comando) || "-".equals(comando) || "*".equals(comando) || "/".equals(comando)) {
                            num1 = Double.parseDouble(display.getText());  
                            operador = comando;
                            display.setText("");
                        } else {
                            display.setText(display.getText() + comando);
                        }
                    } catch (NumberFormatException ex) {
                        
                        JOptionPane.showMessageDialog(frame, "Erro: Entrada inválida. Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        display.setText("");  
                    } catch (ArithmeticException ex) {
                        
                        JOptionPane.showMessageDialog(frame, "Erro: Divisão por zero não permitida.", "Erro", JOptionPane.ERROR_MESSAGE);
                        display.setText(""); 
                    } catch (Exception ex) {
                       
                        JOptionPane.showMessageDialog(frame, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        display.setText(""); 
                    } finally {
                        
                    }
                }
            });
        }

       
        panel.add(display, BorderLayout.NORTH);
        panel.add(painel, BorderLayout.CENTER);

        
        frame.add(panel);

       
        frame.setVisible(true);
    }

    
    public void calcular(JTextField display) {
        try {
            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Divisão por zero");
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    break;
            }
            display.setText(String.valueOf(resultado));
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Erro: Divisão por zero não permitida.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
