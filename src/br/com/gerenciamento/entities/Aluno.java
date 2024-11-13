package br.com.gerenciamento.entities;

import java.util.List;
import java.util.ArrayList;

import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.i.Agendavel;

//CLASSE FILHA - Aluno
public class Aluno extends Pessoa implements Agendavel {
	//Atributo
	private int matricula;
	private String nivel;
	private List<Curso> listaDosCursos;
	private List<String> listaHorariosAulas;
	
	//Construtor
	public Aluno(String nome, int idade, String endereco, String cpf, Curso curso, int matricula, String nivel) {
		super(nome, idade, endereco, cpf, curso);
		this.matricula = matricula;
		this.nivel = nivel;
		this.listaDosCursos = new ArrayList<>();
		this.listaHorariosAulas = new ArrayList<>();
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
	public void agendarAula(String dataHora, String nomeDaAula) {
		
	}

	//Polimorfismo - sobrescrita do método cancelarAula
	@Override
	public void cancelarAula(String dataHora, String nomeDaAula) {
	
		
	}
	
	//Método para listar os cursos inscritos
	public void listarCursosInscritos() {
		//loop for-each -- percorre a lista 
		for (Curso curso : listaDosCursos) {
			System.out.printf(" - Cursos inscritos: %s\n", curso.getNome());
		}

	}
	
	//Método para listar os horários das aulas
	public void listarHorariosAulas() {
		//loop for-each -- percorre a lista 
		for (String horario : listaHorariosAulas) {
			System.out.printf(" - Horarios das aulas: %s\n", horario);
		}

	}

}
