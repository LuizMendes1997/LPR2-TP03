package TP03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
//Luiz Carlos Mendes
//CB3012123
public class FormPessoa2 {
    private JFrame frame;
    private JTextField txtNome, txtIdade;
    private JComboBox<String> comboSexo;  
    private JLabel lblNumero;
    private JButton btnOk, btnMostrar, btnLimpar, btnSair;
    
  
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    public FormPessoa2() {
        
        frame = new JFrame("Cadastro de Pessoa");
        frame.setSize(350, 280);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
       
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 20, 80, 25); 
        contentPanel.add(lblNome);
        
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(10, 60, 80, 25);  
        contentPanel.add(lblSexo);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 100, 80, 25);  
        contentPanel.add(lblIdade);

        JLabel lblNumeroLabel = new JLabel("Número:");
        lblNumeroLabel.setBounds(10, 140, 80, 25);  
        contentPanel.add(lblNumeroLabel);
        
        
        txtNome = new JTextField();
        txtNome.setBounds(100, 20, 150, 25);
        contentPanel.add(txtNome);
        
        
        comboSexo = new JComboBox<>(new String[] {"M", "F"});  
        comboSexo.setBounds(100, 60, 60, 25);
        contentPanel.add(comboSexo);
        
        txtIdade = new JTextField();
        txtIdade.setBounds(100, 100, 60, 25);
        contentPanel.add(txtIdade);
        
        lblNumero = new JLabel("0");
        lblNumero.setBounds(100, 140, 50, 25);
        contentPanel.add(lblNumero);
        
       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));  
        buttonPanel.setBounds(10, 180, 320, 40);  
        
        
        btnOk = new JButton("OK");
        buttonPanel.add(btnOk);
        
        
        btnLimpar = new JButton("Limpar");
        buttonPanel.add(btnLimpar);
        
        btnMostrar = new JButton("Mostrar");
        buttonPanel.add(btnMostrar);
        
        btnSair = new JButton("Sair");
        buttonPanel.add(btnSair);
        
        
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String sexo = comboSexo.getSelectedItem().toString(); 
                int idade = Integer.parseInt(txtIdade.getText());
                
                
                Pessoa novaPessoa = new Pessoa(nome, sexo.charAt(0), idade);
                pessoas.add(novaPessoa);
                
                
                lblNumero.setText(String.valueOf(Pessoa.getKp()));
                
                
                txtNome.setText("");
                txtIdade.setText("");
                comboSexo.setSelectedIndex(0); 
            }
        });
        
       
        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pessoas.size() > 0) {
                    StringBuilder dados = new StringBuilder();
                    
                  
                    for (Pessoa pessoa : pessoas) {
                        dados.append(pessoa.toString()).append("\n");
                    }
                    
                    
                    dados.append("\nTotal de pessoas: ").append(Pessoa.getKp());
                    JOptionPane.showMessageDialog(frame, dados.toString());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma pessoa registrada!");
                }
            }
        });
        
       
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                txtNome.setText("");
                txtIdade.setText("");
                lblNumero.setText("0");
                comboSexo.setSelectedIndex(0);
            }
        });
        
        
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                frame.dispose();
            }
        });
        
        
        frame.add(contentPanel, BorderLayout.CENTER);
        
        
        contentPanel.add(buttonPanel);  
        
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new FormPessoa2();
    }
}


