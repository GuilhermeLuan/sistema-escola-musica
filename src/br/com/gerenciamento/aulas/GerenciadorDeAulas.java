package br.com.gerenciamento.aulas;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeAulas {
    private List<Aula> aulasAgendadas;

    // Construtor
    public GerenciadorDeAulas() {
        this.aulasAgendadas = new ArrayList<>();
    }

    // Método para agendar uma aula
    public boolean agendarAula(LocalTime horaInicio, Aula aula) {
        boolean conflito = aulasAgendadas.stream()
            .anyMatch(a -> a.getHoraInicio().equals(horaInicio));

        if (conflito) {
            System.out.println("Erro: Conflito de horários. Aula não pode ser agendada.");
            return false;
        } else {
            aulasAgendadas.add(aula);
            System.out.println("Aula agendada com sucesso para o horário: " + horaInicio);
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
        System.out.println("Aulas atualmente agendadas:");
        for (Aula aula : aulasAgendadas) {
            System.out.println(aula);
        }
    }
}