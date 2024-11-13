package br.com.gerenciamento.entities;

import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.i.Agendavel;

//CLASSE FILHA - Aluno
public class Aluno extends Pessoa implements Agendavel {
	//Atributo
	private int matricula;
	private String nivel;
	
	//Construtor
	public Aluno(String nome, int idade, String endereco, String cpf, Curso curso, int matricula, String nivel) {
		super(nome, idade, endereco, cpf, curso);
		this.matricula = matricula;
		this.nivel = nivel;
	}
	
	//ENCAPSULAMENTO - protegendo os atributos
	public int getMatricula() { //matricula
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNivel() { //nivel
		return nivel;
	}
	public void setNivel(String nivel) {
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

	//IMPLEMENTAÇÃO DOSS MÉTODOS DA INTERFACE
	//Polimorfismo - sobrescrita do método agendarAula
	@Override
	public void agendarAula() {
		// TODO Auto-generated method stub
		
	}

	//Polimorfismo - sobrescrita do método cancelarAula
	@Override
	public void cancelarAula() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
