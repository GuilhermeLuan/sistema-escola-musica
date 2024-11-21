package br.com.gerenciamento.aulas;

import br.com.gerenciamento.entities.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeAulas {
    private List<Aula> aulasAgendadas;
    private static GerenciadorDeAulas instancia;

    // Construtor
    public GerenciadorDeAulas() {
        this.aulasAgendadas = new ArrayList<>();
    }


    // padrão singleton 
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
                        a.getData().equals(novaAula.getData()) &&
                        novaAula.getHoraInicio().isBefore(a.getHoraFim()) &&
                        novaAula.getHoraFim().isAfter(a.getHoraInicio()) &&
                        (a.getAluno().equals(novaAula.getAluno()) || // Verifica conflito de horário do aluno
                         a.getProfessor().equals(novaAula.getProfessor())) // Verifica conflito de horário do professor
                );


        if (conflito) {
            System.out.println(" !!!ERRO: Conflito de horários - A aula não pode ser agendada!!!");
            System.out.println(" <AVISO: A aula que você está tentando agendar coincide com o");
            System.out.println(" horário de outra aula já agendada anteriormente.>");
            return false;
        } else {
            aulasAgendadas.add(novaAula);
            System.out.println(" (A aula foi AGENDADA com sucesso!)");
            return true;
        }
    }

    // Método para cancelar uma aula
    public boolean cancelarAula(Aula aula, Pessoa pessoaRequisitante) {
        if (!aulasAgendadas.contains(aula)) {
            System.out.println(" !!!ERRO: A aula não foi encontrada para efetuar o cancelamento!!!");
            return false;
        }

        if (aula.getAluno().equals(pessoaRequisitante) || aula.getProfessor().equals(pessoaRequisitante)) {
            aulasAgendadas.remove(aula);
            System.out.println(" (A aula foi devidamente CANCELADA!)");
            System.out.println(" *Informações da aula: " + aula);
            return true;
        }

        System.out.println("Erro: Apenas o Professor ou o Aluno da aula podem cancelá-la.");
        return false;
    }

    // Método para listar todas as aulas agendadas
    public void listarAulas() {
        System.out.println("\n +++ Lista de TODAS as aulas agendadas:");

        for (Aula aula : aulasAgendadas) {
            System.out.println(aula);
        }
    }

    public void listarAulasDoProfessorOuAluno(Pessoa p) {
        System.out.printf("\n +++ Lista de todas as aulas agendadas do %s:%n", p.getNome());
        for (Aula a : aulasAgendadas) {
            if (a.getAluno().getNome() == p.getNome() || a.getProfessor().getNome() == p.getNome())
                System.out.println(a);
        }
    }
}