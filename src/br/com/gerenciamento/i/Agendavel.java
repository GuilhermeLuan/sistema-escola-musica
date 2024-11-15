package br.com.gerenciamento.i;

//OBSERVER
public interface Agendavel {
	    
	    // Método para agendar uma aula
	    void agendarAula(String dataHora, String nomeDaAula);
	    
	    // Método para cancelar uma aula
	    void cancelarAula(String dataHora, String nomeDaAula);
	    
	}

