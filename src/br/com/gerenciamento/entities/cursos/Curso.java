package br.com.gerenciamento.entities.cursos;

import java.util.List;

import br.com.gerenciamento.entities.Aluno;
import br.com.gerenciamento.entities.Professor;

public class Curso {
	private String nome;
	private Double custo;
	private List<String> horarios;
	private List<Aluno> listaAlunos;
	private List<Professor> listaProfessores;
}
