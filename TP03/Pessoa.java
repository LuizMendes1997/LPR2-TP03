package TP03;

public class Pessoa {
    // Atributos estáticos e de instância
    private static int kp = 0;   // contador estático de pessoas criadas
    private String nome;
    private char sexo;
    private int idade;
    
    // Construtores
    public Pessoa() {
        // Construtor padrão
        kp++;
    }

    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        kp++; // Incrementa o contador ao criar uma nova pessoa
    }

    // Métodos setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            System.out.println("Sexo inválido! Use 'M' para Masculino ou 'F' para Feminino.");
        }
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Métodos getters
    public static int getKp() {
        return kp;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    // Método toString para exibir as informações sem o total de pessoas
    @Override
    public String toString() {
        return "Nome: " + nome + "\nSexo: " + sexo + "\nIdade: " + idade;
    }
}
