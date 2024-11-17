package br.com.gerenciamento.entities;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.enums.Nivel;
import br.com.gerenciamento.i.Agendavel;

//CLASSE FILHA - Aluno
public class Aluno extends Pessoa implements Agendavel {
	//Atributo
	private int matricula;
	private Nivel nivel;
	private List<Curso> listaDosCursos = new ArrayList<>();
	private List<Aula> listaHorariosAulas = new ArrayList<>();;
	
	//Construtor
	public Aluno(String nome, int idade, String endereco, int matricula, Nivel nivel) {
		super(nome, idade, endereco);
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

	public Nivel getNivel() { 
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}	

	//IMPLEMENTAÇÃO DOSS MÉTODOS DA INTERFACE
	//Polimorfismo - sobrescrita do método agendarAula
	@Override
	public void agendarAula(LocalTime horaInicio, Aula aula) {	
		System.out.println("*Aula agendada com sucesso! -> " +aula);
	}

	//Polimorfismo - sobrescrita do método cancelarAula
	@Override
	public void cancelarAula(Aula aula) {
		System.out.println("*Aula Cancelada -> " +aula);
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

	@Override
	public String toString() {
	    return String.format(
	        "Nome: %s\nIdade: %d\nEndereço: %s\nMatrícula: %d\nNível do aluno: %s",
	        super.getNome(),       // Nome
	        super.getIdade(),      // Idade
	        super.getEndereco(),   // Endereço
	        this.matricula,        // Matrícula
	        this.nivel             // Nível (formatado automaticamente como string)
	    );
	
	}
	
	
}
