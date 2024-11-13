package br.com.gerenciamento.entities.curso;

import java.util.List;

import br.com.gerenciamento.entities.Aluno;
import br.com.gerenciamento.entities.Professor;

public class Curso {
	private String nome;
	private Double custo;
	private List<String> horarios;
	private List<Aluno> listaAlunos;
	private List<Professor> listaProfessores;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getCusto() {
		return custo;
	}
	
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
	public List<String> getHorarios() {
		return horarios;
	}
	
	public List<Aluno> getListaAlunos() {
		return listaAlunos;
	}
	
	public List<Professor> getListaProfessores() {
		return listaProfessores;
	}
	
	public void addAluno(Aluno aluno) {
		listaAlunos.add(aluno);
	}
	
	public void addProfessor(Professor professor) {
		listaProfessores.add(professor);
	}
	
	public void removerAluno(Aluno aluno) {
		listaAlunos.remove(aluno);
	}
	
	public void removerProfessor(Professor professor) {
		listaProfessores.remove(professor);
	}
}
