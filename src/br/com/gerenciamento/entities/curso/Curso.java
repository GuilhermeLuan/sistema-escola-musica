package br.com.gerenciamento.entities.curso;

public class Curso {
	private String nome;
	private int duracaoHoras;

	public Curso(String nome, int duracaoHoras) {
		super();
		this.nome = nome;
		this.duracaoHoras = duracaoHoras;
	}

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
