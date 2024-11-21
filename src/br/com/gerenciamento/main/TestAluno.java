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

public class TestAluno {
    public static void main(String[] args) {
        System.out.println("\n::::::::::::::::::::::( ESCOLA DE MÚSICA ):::::::::::::::::::::::\n");
        //criando o gerencidador de aulas
        GerenciadorDeAulas gerenciadorDeAulas = GerenciadorDeAulas.getInstancia();

        //chamando o factory (nossa fábrica de objetos do tipo "Curso")
        Curso curso1 = CursoFactory.novoCurso(TipoCurso.CANTO, 20);
        Curso curso2 = CursoFactory.novoCurso(TipoCurso.TEORIA_MUSICAL, 20);
        Curso curso3 = CursoFactory.novoCurso(TipoCurso.VIOLAO, 20);
        Curso curso4 = CursoFactory.novoCurso(TipoCurso.PIANO, 20);

        //criando objetos do tipo Professor
        System.out.println("\n========================+ PROFESSORES +==========================\n");
        //professorLucasLima - professor de CANTO
        Professor professorLucasLima = new Professor("Lucas Lima", 34, "Rua A", curso1, "Canto", gerenciadorDeAulas);
        System.out.println(professorLucasLima); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)
        System.out.println("\n_________________________________________________________________-\n");
        //professorDuncanIdaho - professor de TEORIA MUSICAL
        Professor professorDuncanIdaho = new Professor("Duncan Idaho", 40, "Imperial Basin", curso2, "Teoria Musical", gerenciadorDeAulas);
        System.out.println(professorDuncanIdaho); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)
        System.out.println("\n_________________________________________________________________-\n");
        //professor3 - professor de VIOLÃO
        Professor professorStilgar = new Professor("Stilgar Ben", 52, "Sietch Tabr", curso3, "Violão", gerenciadorDeAulas);
        System.out.println(professorDuncanIdaho); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)
        System.out.println("\n_________________________________________________________________-\n");
        //professorFrank - professor de PIANO
        Professor professorFrank = new Professor("Frank Herbert", 28, "Avenida dos Pássaros", curso4, "Piano", gerenciadorDeAulas);
        System.out.println(professorStilgar); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)

        // Criando objetos do tipo Aluno
        System.out.println("\n===========================+ ALUNOS +=============================\n");
        //alunoJoaoSilva
        Aluno alunoJoaoSilva = new Aluno("João Silva", 20, "Rua das Flores, 123", 1010, Nivel.INICIANTE, gerenciadorDeAulas);
        System.out.println(alunoJoaoSilva); // Exibindo os dados do ALUNO (toString sobrescrito na classe Aluno)
        System.out.println("\n_________________________________________________________________-\n");
        //alunoMarcosAlia
        Aluno alunoMarcosAlia = new Aluno("Marcos Alia", 12, "Rua B", 2938, Nivel.INTERMEDIARIO, gerenciadorDeAulas);
        System.out.println(alunoMarcosAlia);// Exibindo os dados do ALUNO (toString sobrescrito na classe Aluno)
        System.out.println("\n_________________________________________________________________-\n");
        //alunoPaulAtreides
        Aluno alunoPaulAtreides = new Aluno("Paul Atreides", 15, "Bronken Land", 3001, Nivel.AVANCADO, gerenciadorDeAulas);
        System.out.println(alunoPaulAtreides);// Exibindo os dados do ALUNO (toString sobrescrito na classe Aluno)

        //criando as aulas
        //aqui será testado o conflito de horários, onde um aluno tentará marcar aulas que os os horários coincidem
        Aula aulaCanto = new Aula(TipoCurso.CANTO, LocalDate.of(2024, 10, 12), LocalTime.of(16, 0), LocalTime.of(18, 0), alunoJoaoSilva, professorLucasLima);
        Aula aulaTeoriaMusical = new Aula(TipoCurso.TEORIA_MUSICAL, LocalDate.of(2024, 10, 12), LocalTime.of(18, 0), LocalTime.of(20, 0), alunoMarcosAlia, professorDuncanIdaho);
        Aula aulaViolao = new Aula(TipoCurso.VIOLAO, LocalDate.of(2024, 10, 12), LocalTime.of(18, 0), LocalTime.of(20, 0), alunoMarcosAlia, professorStilgar);
        Aula aulaPiano = new Aula(TipoCurso.PIANO, LocalDate.of(2024, 10, 12), LocalTime.of(13, 0), LocalTime.of(15, 0), alunoPaulAtreides, professorFrank);

        //utilizando o padrão OBSERVER para a notificação do agendamento e cancelamento das aulas
        //adicionando na aula de CANTO (o professor responsável e os possíveis alunos que gostariam de agendar ou cancelar a aula)
        aulaCanto.adicionarListener(professorLucasLima);
        aulaCanto.adicionarListener(alunoJoaoSilva);
        aulaCanto.adicionarListener(alunoMarcosAlia);
        aulaCanto.adicionarListener(alunoPaulAtreides);


        //adicionando na aula de TEORIA MUSICAL (o professor responsável e os possíveis alunos que gostariam de agendar ou cancelar a aula)
        aulaTeoriaMusical.adicionarListener(professorDuncanIdaho);
        aulaTeoriaMusical.adicionarListener(alunoJoaoSilva);
        aulaTeoriaMusical.adicionarListener(alunoMarcosAlia);
        aulaTeoriaMusical.adicionarListener(alunoPaulAtreides);
        //adicionando na aula de VIOLÃO (o professor responsável e os possíveis alunos que gostariam de agendar ou cancelar a aula)
        aulaViolao.adicionarListener(professorStilgar);
        aulaViolao.adicionarListener(alunoJoaoSilva);
        aulaViolao.adicionarListener(alunoMarcosAlia);
        aulaViolao.adicionarListener(alunoPaulAtreides);
        //adicionando na aula de PIANO (o professor responsável e os possíveis alunos que gostariam de agendar ou cancelar a aula)
        aulaPiano.adicionarListener(professorFrank);
        aulaPiano.adicionarListener(alunoJoaoSilva);
        aulaPiano.adicionarListener(alunoMarcosAlia);
        aulaPiano.adicionarListener(alunoPaulAtreides);

        System.out.println("\n:::::::::::::::::: AGENDAMENTOS E CANCELAMENTOS :::::::::::::::::::::::");

        //agendando as aulas
        professorLucasLima.agendarAula(aulaCanto);
        alunoJoaoSilva.agendarAula(aulaCanto);

        //testando o conflito de aulas, onde o aluno tenta marcar aulas que estão no mesmo horário
        alunoMarcosAlia.agendarAula(aulaTeoriaMusical);
        alunoMarcosAlia.agendarAula(aulaTeoriaMusical);
        professorDuncanIdaho.agendarAula(aulaTeoriaMusical);
        alunoJoaoSilva.cancelarAula(aulaTeoriaMusical); // Ele não pode cancelar uma aula q não é dele

        professorFrank.agendarAula(aulaPiano);
        professorFrank.cancelarAula(aulaPiano);
        //alunoPaulAtreides.agendarAula(aulaPiano

        //testando o cancelamento de aulas
        //System.out.println("--- DEBUG ---");
        //gerenciadorDeAulas.listarAulas();
        //gerenciadorDeAulas.listarAulasDoProfessorOuAluno(alunoPaulAtreides);
        //gerenciadorDeAulas.listarAulasDoProfessorOuAluno(professor3);


        //gerenciadorDeAulas.listarAulas();


        //System.out.println("--- FIM - DEBUG ---");

        System.out.println("\n::::::::::::::::::::::: LISTA DAS AULAS ::::::::::::::::::::::::::::");
        gerenciadorDeAulas.listarAulas();
        gerenciadorDeAulas.listarAulasDoProfessorOuAluno(professorLucasLima);


        // Simulando métodos da classe
        //alunoJoaoSilva.listarCursosInscritos(); // Exemplo de lista vazia inicialmente
        //alunoJoaoSilva.adicionarCurso(curso1);
        //alunoJoaoSilva.listarCursosInscritos();


        // aulaTeoriaMusical = new Aula(TipoCurso.TEORIA_MUSICAL, LocalDate.of(2024,10,20), LocalTime.of(18,0), LocalTime.of(19,0), alunoMarcosAlia, professorDuncanIdaho);

        //System.out.println();
        //System.out.println();


        //alunoMarcosAlia.adicionarCurso(curso2);
        //alunoMarcosAlia.listarCursosInscritos();

        //aulaTeoriaMusical.agendarAula(aulaTeoriaMusical);
        //System.out.println();
        //gerenciadorDeAulas.listarAulasDoProfessorOuAluno(alunoMarcosAlia);


    }
}
