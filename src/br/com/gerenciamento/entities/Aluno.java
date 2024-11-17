package br.com.gerenciamento.entities;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.aulas.GerenciadorDeAulas;
import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.enums.Nivel;
import br.com.gerenciamento.i.Agendavel;

//CLASSE FILHA - Aluno
public class Aluno extends Pessoa implements Agendavel {
	//Atributo
	private int matricula;
	private Nivel nivel;
	private List<Curso> listaDosCursos = new ArrayList<>();
	private GerenciadorDeAulas gerenciadorDeAula;
	
	//Construtor
	public Aluno(String nome, int idade, String endereco, int matricula, Nivel nivel, GerenciadorDeAulas gerenciadorDeAula) {
		super(nome, idade, endereco);
		this.matricula = matricula;
		this.nivel = nivel;
		this.gerenciadorDeAula = gerenciadorDeAula;
	}
	
	public List<Curso> getListaDosCursos() {
		return listaDosCursos;
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
	public void agendarAula(Aula aula) {	
		gerenciadorDeAula.agendarAula(aula);
	}

	//Polimorfismo - sobrescrita do método cancelarAula
	@Override
	public void cancelarAula(Aula aula) {
		gerenciadorDeAula.cancelarAula(aula);
	}
	
	//Método para listar os cursos inscritos
	public void listarCursosInscritos() {
		//loop for-each -- percorre a lista 
		for (Curso curso : listaDosCursos) {
			System.out.printf(" - Cursos inscritos: %s\n", curso.getNome());
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
