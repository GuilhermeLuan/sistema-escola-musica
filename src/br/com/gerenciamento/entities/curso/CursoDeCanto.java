package br.com.gerenciamento.entities.curso;

/**
 * uma especialização da classe Curso, esta classe configura o nome do curso como "Canto" e permite especificar a duração em horas
 */

public class CursoDeCanto extends Curso {

    public CursoDeCanto(int duracaoHoras) {
        super("Canto", duracaoHoras);
    }

}
