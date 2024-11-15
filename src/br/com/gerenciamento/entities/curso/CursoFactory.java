package br.com.gerenciamento.entities.curso;

import br.com.gerenciamento.enums.TipoCurso;

public class CursoFactory {
	public static Curso newCurso(TipoCurso tipoCurso, int duracaoHoras) {
		switch (tipoCurso) {
			case CANTO: 
				return new CursoDeCanto(duracaoHoras);
			case PIANO:
				return new CursoDePiano(duracaoHoras);
			case VIOLAO:
				return new CursoDeViolao(duracaoHoras);
			case TEORIA_MUSICAL:
				return new CursoDeTeoriaMusical(duracaoHoras);
			
			default: throw new IllegalArgumentException("Unexpected value: " + tipoCurso);
		}
	}
}
