package br.com.gerenciamento.entities.curso;

/**
 * uma especialização da classe Curso, esta classe configura o nome do curso como "Teoria Musical" e permite especificar a duração em horas
 */

public class CursoDeTeoriaMusical extends Curso {

    public CursoDeTeoriaMusical(int duracaoHoras) {
        super("Teoria Musical", duracaoHoras);
    }

}
