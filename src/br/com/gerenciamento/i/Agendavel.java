package br.com.gerenciamento.i;

<<<<<<< HEAD
import java.time.LocalTime;

import br.com.gerenciamento.entities.Aula;

=======
//OBSERVER
>>>>>>> d72bac8eb2bc58ba75d2a42f0eb75eafa5b7ffe7
public interface Agendavel {
	    
	    // Método para agendar uma aula
	    void agendarAula(LocalTime horaInicio, Aula aula);
	    
	    // Método para cancelar uma aula
	    void cancelarAula(Aula aula);
	    
	}

