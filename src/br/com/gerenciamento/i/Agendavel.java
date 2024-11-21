package br.com.gerenciamento.i;

import br.com.gerenciamento.aulas.Aula;

// PADRÃO OBSERVER
public interface Agendavel {

    // Método para agendar uma aula
    void agendarAula(Aula aula);

    // Método para cancelar uma aula
    void cancelarAula(Aula aula);

}

