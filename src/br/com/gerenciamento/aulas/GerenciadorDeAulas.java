package br.com.gerenciamento.aulas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeAulas {
    private List<Aula> aulasAgendadas;
    private static GerenciadorDeAulas instancia;

    // Construtor
    public GerenciadorDeAulas() {
        this.aulasAgendadas = new ArrayList<>();
    }
    

    // Matodo para obter a instancia unica do Singleton 
    public static GerenciadorDeAulas getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorDeAulas();
        }
        return instancia;
    }

    // Método para agendar uma aula
    public boolean agendarAula(Aula novaAula) {
        boolean conflito = aulasAgendadas.stream()
            .anyMatch(a -> 
                a.getData().equals(novaAula.getData()) && // Verifica se a data é a mesma
                (novaAula.getHoraInicio().isBefore(a.getHoraFim()) && novaAula.getHoraFim().isAfter(a.getHoraInicio()))
            );

        if (conflito) {
            System.out.println("Erro: Conflito de horários. Aula não pode ser agendada.");
            return false;
        } else {
            aulasAgendadas.add(novaAula);
            System.out.println("Aula agendada com sucesso: " + novaAula);
            return true;
        }
    }
    // Método para cancelar uma aula
    public boolean cancelarAula(Aula aula) {
        if (aulasAgendadas.remove(aula)) {
            System.out.println("Aula cancelada com sucesso: " + aula);
            return true;
        } else {
            System.out.println("Erro: Aula não encontrada para cancelamento.");
            return false;
        }
    }

    // Método para listar todas as aulas agendadas
    public void listarAulas() {
        System.out.println("Lista de Aulas agendadas!");

        for (Aula aula : aulasAgendadas) {
            System.out.println(aula);
        }
    }
}