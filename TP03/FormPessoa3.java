package TP03;
//Luiz Carlos Mendes
//CB3012123
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FormPessoa3 {
    private JFrame frame;
    private JTextField txtNome, txtIdade;
    private JRadioButton rbMasculino, rbFeminino;  
    private JLabel lblNumero;
    private JButton btnOk, btnMostrar, btnLimpar, btnSair;
    
   
    private ArrayList<Pessoa> pessoas = new ArrayList<>();
    
    public FormPessoa3() {
        
        frame = new JFrame("Cadastro de Pessoa");
        frame.setSize(350, 280);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
      
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));  
        
        // Labels
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
        
       
        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setBounds(100, 60, 100, 25);
        rbFeminino = new JRadioButton("Feminino");
        rbFeminino.setBounds(200, 60, 100, 25);
        
       
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(rbMasculino);
        sexoGroup.add(rbFeminino);
        
      
        contentPanel.add(rbMasculino);
        contentPanel.add(rbFeminino);
        
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
                char sexo = ' ';  
                if (rbMasculino.isSelected()) {
                    sexo = 'M';  
                } else if (rbFeminino.isSelected()) {
                    sexo = 'F';  
                }
                
                
                if (nome.isEmpty() || sexo == ' ' || txtIdade.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                } else {
                    int idade = Integer.parseInt(txtIdade.getText());
                    
                    
                    Pessoa novaPessoa = new Pessoa(nome, sexo, idade);
                    pessoas.add(novaPessoa);
                    
                    
                    lblNumero.setText(String.valueOf(Pessoa.getKp()));
                    
                    
                    txtNome.setText("");
                    txtIdade.setText("");
                    sexoGroup.clearSelection(); 
                }
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
                sexoGroup.clearSelection(); 
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
        new FormPessoa3();
    }
}

