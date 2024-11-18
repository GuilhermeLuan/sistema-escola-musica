package br.com.gerenciamento.entities.curso;

	// classe base dos cursos

public class Curso {
	
   // atributos da classe cursos
	
	private String nome;
	private int duracaoHoras;

	// contrutor
	
	public Curso(String nome, int duracaoHoras) {
		super();
		this.nome = nome;
		this.duracaoHoras = duracaoHoras;
	}

	// encapsulamento
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDuracaoHoras() {
		return duracaoHoras;
	}

	public void setDuracaoHoras(int duracaoHoras) {
		this.duracaoHoras = duracaoHoras;
	}
}
