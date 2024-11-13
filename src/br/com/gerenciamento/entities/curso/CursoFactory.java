package br.com.gerenciamento.entities.curso;

public class CursoFactory {
	public static Curso newCurso(TipoCurso tipoCurso) {
		switch (tipoCurso) {
			case CANTO: 
				return new CursoDeCanto();
			case PIANO:
				return new CursoDePiano();
			case VIOLAO:
				return new CursoDeViolao();
			case TEORIA_MUSICAL:
				return new CursoDeTeoriaMusical();
			
			default: throw new IllegalArgumentException("Unexpected value: " + tipoCurso);
		}
	}
}
