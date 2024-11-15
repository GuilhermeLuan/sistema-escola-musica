package br.com.gerenciamento.i;

import java.time.LocalTime;

import br.com.gerenciamento.entities.Aula;

public interface Agendavel {
	    
	    // Método para agendar uma aula
	    void agendarAula(LocalTime horaInicio, Aula aula);
	    
	    // Método para cancelar uma aula
	    void cancelarAula(Aula aula);
	    
	}

