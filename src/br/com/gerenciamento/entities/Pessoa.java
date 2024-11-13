package br.com.gerenciamento.entities;

public class Pessoa {
	
	private String nome;
    private int idade;
    private String endereco;
    private String cpf;
    private String curso;

    public Pessoa(String nome, int idade, String endereco, String cpf, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

   
    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome='" + nome + '\'' +
                ", Idade=" + idade +
                ", Endereco='" + endereco + '\'' +
                ", CPF='" + cpf + '\'' +
                ", Curso='" + curso + '\'' +
                '}';
    }
}
