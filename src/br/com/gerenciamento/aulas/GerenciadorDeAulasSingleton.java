package br.com.gerenciamento.aulas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.gerenciamento.entities.Aluno;
import br.com.gerenciamento.entities.Professor;

public class GerenciadorDeAulasSingleton {

    
    private static GerenciadorDeAulasSingleton instancia;

    // Lista para armazenar as  aulas agendadas
    private List<Aula> aulasAgendadas;

    
    // Matodo para obter a instancia unica do siingleton
    public static synchronized GerenciadorDeAulasSingleton getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorDeAulasSingleton();
        }
        return instancia;
    }

    
    public boolean agendarAula(Aula aula, Aluno aluno, Professor professor) { // Metodo para agendar uma aula
    	
        // Verificar os conflitos de horario
        for (Aula a : aulasAgendadas) {
            if (a.getData().equals(aula.getData()) &&
                a.getHoraInicio().equals(aula.getHoraInicio()) &&
                a.getCurso().equals(aula.getCurso())) {
                System.out.println("Conflito de horário detectado. Aula não pode ser agendada.");
                return false;
            }
        }

        // Adicionar a aulas agendadas
        aulasAgendadas.add(aula);


        aluno.getListaHorariosAulas().add(aula);  // Associar a aula com o aluno e ao professor
        professor.getAulasAgendadas().add(aula);

        System.out.println("A aula foi agendada ");
        return true;
    }

    public boolean cancelarAula(Aula aula, Aluno aluno, Professor professor) { // Metodo para cancelar uma aula
        if (aulasAgendadas.contains(aula)) {
           
            aulasAgendadas.remove(aula); // Remover a aula das listas
            aluno.getListaHorariosAulas().remove(aula);
            professor.getAulasAgendadas().remove(aula);

            System.out.println("A aula cancelada ");
            return true;
        } else {
            System.out.println("Aula não encontrada.");
            return false;
        }
    }

    
    public void listarAulasAgendadas() { // Metodo para listar todas as aulas agendadas
        System.out.println("Aulas agendadas:");
        for (Aula aula : aulasAgendadas) {
            System.out.printf("Curso: %s, Data: %s, Horário: %s-%s\n",
                aula.getCurso(), aula.getData(), aula.getHoraInicio(), aula.getHoraFim());
        }
    }
}
