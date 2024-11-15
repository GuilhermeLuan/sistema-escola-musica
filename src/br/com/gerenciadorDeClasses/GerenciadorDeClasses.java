package br.com.gerenciadorDeClasses;


import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeClasses {

    private List<Aula> aulasAgendadas;
    private List<Observer> observadores; // Lista de observadores

    public GerenciadorDeClasses() {
        this.aulasAgendadas = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    // Método para adicionar um observador
    public void adicionarObservador(Observer observador) {
        this.observadores.add(observador);
    }

    // Método para remover um observador
    public void removerObservador(Observer observador) {
        this.observadores.remove(observador);
    }

    // Método para notificar todos os observadores
    private void notificarObservadores(String mensagem) {
        for (Observer observador : observadores) {
            observador.atualizar(mensagem);
        }
    }

    // Método para agendar uma nova aula
    public boolean agendarAula(Aula novaAula) {
        if (verificarConflito(novaAula)) {
            notificarObservadores("Conflito de horário! Aula não agendada.");
            return false;
        } else {
            aulasAgendadas.add(novaAula);
            notificarObservadores("Aula agendada com sucesso!");
            return true;
        }
    }

    // Método privado para verificar conflitos de horário
    private boolean verificarConflito(Aula novaAula) {
        for (Aula aula : aulasAgendadas) {
            if (aula.getData().equals(novaAula.getData())) {
                if (aula.getHoraInicio().isBefore(novaAula.getHoraFim()) && 
                    novaAula.getHoraInicio().isBefore(aula.getHoraFim())) {
                    return true;
                }
            }
        }
        return false;
    }
}

