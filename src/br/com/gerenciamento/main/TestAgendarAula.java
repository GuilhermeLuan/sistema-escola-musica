package br.com.gerenciamento.main;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.aulas.GerenciadorDeAulas;
import br.com.gerenciamento.entities.Aluno;
import br.com.gerenciamento.entities.Professor;
import br.com.gerenciamento.entities.curso.Curso;
import br.com.gerenciamento.entities.curso.CursoFactory;
import br.com.gerenciamento.enums.Nivel;
import br.com.gerenciamento.enums.TipoCurso;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestAgendarAula {
    public static void main(String[] args) {
        GerenciadorDeAulas gerenciadorDeAulas = GerenciadorDeAulas.getInstancia();

        // Criando cursos
        Curso curso1 = CursoFactory.novoCurso(TipoCurso.CANTO, 20);
        Curso curso2 = CursoFactory.novoCurso(TipoCurso.VIOLAO, 20);

        // Criando professores
        Professor professor1 = new Professor("Lucas Lima", 34, "Rua A", curso1, "Canto", gerenciadorDeAulas);
        Professor professor2 = new Professor("Stilgar Ben", 52, "Sietch Tabr", curso2, "Violão", gerenciadorDeAulas);

        // Criando alunos
        Aluno aluno1 = new Aluno("João Silva", 20, "Rua das Flores, 123", 1010, Nivel.INICIANTE, gerenciadorDeAulas);
        Aluno aluno2 = new Aluno("Marcos Alia", 12, "Rua B", 2938, Nivel.INTERMEDIARIO, gerenciadorDeAulas);

        // Criando aulas
        Aula aula1 = new Aula(TipoCurso.CANTO, LocalDate.of(2024, 11, 22), LocalTime.of(10, 0), LocalTime.of(12, 0), aluno1, professor1);
        Aula aula2 = new Aula(TipoCurso.VIOLAO, LocalDate.of(2024, 11, 22), LocalTime.of(10, 0), LocalTime.of(12, 0), aluno2, professor1); // Conflito de horário (professor)
        Aula aula3 = new Aula(TipoCurso.CANTO, LocalDate.of(2024, 11, 22), LocalTime.of(10, 0), LocalTime.of(12, 0), aluno1, professor2); // Conflito de horário (aluno)

        // Teste 1: Agendar uma aula válida
        System.out.println("\n>>> Tentando agendar aula 1:");
        professor1.agendarAula(aula1); // Deve ser agendada com sucesso

        // Teste 2: Agendar aula com conflito de professor
        System.out.println("\n>>> Tentando agendar aula 2:");
        professor1.agendarAula(aula2); // Deve falhar devido ao conflito do professor

        // Teste 3: Agendar aula com conflito de aluno
        System.out.println("\n>>> Tentando agendar aula 3:");
        professor2.agendarAula(aula3); // Deve falhar devido ao conflito do aluno

        // Listando aulas agendadas
        System.out.println("\n>>> Listando aulas agendadas:");
        gerenciadorDeAulas.listarAulas();
    }
}

