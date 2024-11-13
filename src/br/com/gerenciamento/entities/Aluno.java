package br.com.gerenciamento.entities;

import br.com.gerenciamento.entities.cursos.Curso;

//CLASSE FILHA - Aluno
public class Aluno extends Pessoa {
	//Atributo
	private int matricula;
	private String nivel;
	
	//Construtor
	public Aluno(String nome, int idade, String endereco, String cpf, Curso curso, int matricula, String nivel) {
		super(nome, idade, endereco, cpf, curso);
		this.matricula = matricula;
		this.nivel = nivel;
	}

	//Polimorfismo - sobrescrita do método toString
	@Override
	public String toString() {
		return super.toString().replace("}", "")+
		"Matricula: " +matricula+ '\''+
		"Nível do aluno: " +nivel+
		'}';
		
	}
	
	
	
	

}
