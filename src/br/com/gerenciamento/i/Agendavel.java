package br.com.gerenciamento.i;

import java.time.LocalTime;

import br.com.gerenciamento.aulas.Aula;

//OBSERVER
public interface Agendavel {
	    
	    // Método para agendar uma aula
	    void agendarAula(Aula aula);
	    
	    // Método para cancelar uma aula
	    void cancelarAula(Aula aula);
	    
	}

