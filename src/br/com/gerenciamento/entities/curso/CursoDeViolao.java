 package br.com.gerenciamento.entities.curso;

public class CursoDeViolao extends Curso{

	/**
	 * uma especialização da classe Curso, esta classe configura o nome do curso como "Violão" e permite especificar a duração em horas
	 */	
	
	
	public CursoDeViolao(int duracaoHoras) {
		super("Violão", duracaoHoras);
	}

}
