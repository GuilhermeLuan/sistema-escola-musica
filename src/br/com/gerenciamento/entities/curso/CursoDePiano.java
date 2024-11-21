package br.com.gerenciamento.entities.curso;

/**
 * uma especialização da classe Curso, esta classe configura o nome do curso como "Piano" e permite especificar a duração em horas
 */

public class CursoDePiano extends Curso {

    public CursoDePiano(int duracaoHoras) {
        super("Piano", duracaoHoras);
    }

}
