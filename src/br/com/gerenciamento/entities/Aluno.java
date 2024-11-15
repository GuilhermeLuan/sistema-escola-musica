package br.com.gerenciamento.entities;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.i.Agendavel;

//CLASSE FILHA - Aluno
public class Aluno extends Pessoa implements Agendavel {
	//Atributo
	private int matricula;
	private String nivel;
	private List<Curso> listaDosCursos = new ArrayList<>();
	private List<Aula> listaHorariosAulas = new ArrayList<>();;
	
	//Construtor
	public Aluno(String nome, int idade, String endereco, String cpf, int matricula, String nivel) {
		super(nome, idade, endereco, cpf);
		this.matricula = matricula;
		this.nivel = nivel;
	}
	
	
	public List<Curso> getListaDosCursos() {
		return listaDosCursos;
	}


	public List<Aula> getListaHorariosAulas() {
		return listaHorariosAulas;
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

	//IMPLEMENTAÇÃO DOSS MÉTODOS DA INTERFACE
	//Polimorfismo - sobrescrita do método agendarAula
	@Override
	public void agendarAula(LocalTime horaInicio, Aula aula) {	
		
	}

	//Polimorfismo - sobrescrita do método cancelarAula
	@Override
	public void cancelarAula(Aula aula) {
	
		
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
		for (Aula aulas : listaHorariosAulas) {
			System.out.printf(" - Horarios das aulas: %s\n", aulas);
		}

	}

	// Adiciona o Curso
	public void adicionarCurso(Curso curso) {
		listaDosCursos.add(curso);
	}
	
	// Remove o curso
	public void removerCurso(Curso curso) {
		listaDosCursos.remove(curso);
	}

	public String toString() {
	    return String.format(
	        "Nome: %s\nIdade: %d\nEndereço: %s\nCPF: %s\nMatrícula: %d\nNível do aluno: %s",
	        super.getNome(),       // Obtém o nome da superclasse Pessoa
	        super.getIdade(),      // Obtém a idade da superclasse Pessoa
	        super.getEndereco(),   // Obtém o endereço da superclasse Pessoa
	        super.getCpf(),        // Obtém o CPF da superclasse Pessoa
	        this.matricula,        // Matrícula do aluno
	        this.nivel             // Nível do aluno
	    );
	}
	
	
}
