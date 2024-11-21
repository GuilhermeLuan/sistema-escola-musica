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

public class TesteConflitoAlunoSimples {
    public static void main(String[] args) {
        GerenciadorDeAulas gerenciadorDeAulas = GerenciadorDeAulas.getInstancia();

        // Criando cursos
        Curso curso1 = CursoFactory.novoCurso(TipoCurso.CANTO, 20);
        Curso curso2 = CursoFactory.novoCurso(TipoCurso.VIOLAO, 20);

        // Criando professores
        Professor professor1 = new Professor("Lucas Lima", 34, "Rua A", curso1, "Canto", gerenciadorDeAulas);
        Professor professor2 = new Professor("Stilgar Ben", 52, "Sietch Tabr", curso2, "Violão", gerenciadorDeAulas);

        // Criando aluno
        Aluno aluno1 = new Aluno("João Silva", 20, "Rua das Flores, 123", 1010, Nivel.INICIANTE, gerenciadorDeAulas);

        // Criando aulas
        Aula aula1 = new Aula(TipoCurso.CANTO, LocalDate.of(2024, 11, 22), LocalTime.of(10, 0), LocalTime.of(12, 0), aluno1, professor1);
        Aula aula2 = new Aula(TipoCurso.VIOLAO, LocalDate.of(2024, 11, 22), LocalTime.of(10, 0), LocalTime.of(12, 0), aluno1, professor2); // Conflito com aluno1

        // Teste 1: Agendar a primeira aula (Canto)
        System.out.println("\n>>> Tentando agendar a aula de Canto:");
        professor1.agendarAula(aula1); // Deve ser agendada com sucesso

        // Teste 2: Agendar a segunda aula (Violão) com o mesmo aluno no mesmo horário
        System.out.println("\n>>> Tentando agendar a aula de Violão:");
        professor2.agendarAula(aula2); // Deve falhar devido ao conflito do aluno

        // Listando aulas agendadas
        System.out.println("\n>>> Listando aulas agendadas:");
        gerenciadorDeAulas.listarAulas();
    }
}
