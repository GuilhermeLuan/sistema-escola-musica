package br.com.gerenciamento.entities.curso;

import br.com.gerenciamento.enums.TipoCurso;

// classe para instanciar cursos

public class CursoFactory {
    public static Curso novoCurso(TipoCurso tipoCurso, int duracaoHoras) {
        switch (tipoCurso) {
            case CANTO:
                return new CursoDeCanto(duracaoHoras);
            case PIANO:
                return new CursoDePiano(duracaoHoras);
            case VIOLAO:
                return new CursoDeViolao(duracaoHoras);
            case TEORIA_MUSICAL:
                return new CursoDeTeoriaMusical(duracaoHoras);

            default:
                System.out.println(" !!! ERRO: Este curso não existe no sistema: " + tipoCurso + " !!!");
                return null;
        }
    }
}
