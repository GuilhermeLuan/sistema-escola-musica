package br.com.gerenciamento.main;

import br.com.gerenciamento.entities.curso.Curso;
import br.com.gerenciamento.entities.curso.CursoFactory;
import br.com.gerenciamento.entities.curso.TipoCurso;

public class main {

	public static void main(String[] args) {
		Curso curso1 = CursoFactory.newCurso(TipoCurso.CANTO);
		Curso curso2 = CursoFactory.newCurso(TipoCurso.PIANO);
		Curso curso3 = CursoFactory.newCurso(TipoCurso.TEORIA_MUSICAL);

		System.out.println(curso1);
		System.out.println(curso2);
		System.out.println(curso3);

	}

}
