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

public class Main {
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
        System.out.println(professorStilgar); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)
        System.out.println("\n_________________________________________________________________-\n");
        //professorFrank - professor de PIANO
        Professor professorFrank = new Professor("Frank Herbert", 28, "Avenida dos Pássaros", curso4, "Piano", gerenciadorDeAulas);
        System.out.println(professorFrank); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)

        // Criando objetos do tipo Aluno
        System.out.println("\n===========================+ ALUNOS +=============================\n");
        //alunoJoaoSilva
        Aluno alunoJoaoSilva = new Aluno("João Silva", 20, "Rua das Flores", 1010, Nivel.INICIANTE, gerenciadorDeAulas);
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
        
        //agendando as aulas
        System.out.println("\n\n::::::::::::::::: SOLICITAÇÕES DE AGENDAMENTO ::::::::::::::::::::");
        //agendando a aula de canto
        professorLucasLima.agendarAula(aulaCanto);
        //testando se o aluno consegue agendar uma aula que já foi agendada pelo professor
        //como a aula já foi agendada pelo professor, não há necessidade de o aluno agendá-la novamente
        alunoJoaoSilva.agendarAula(aulaCanto);
        
        //testando o conflito de aulas, onde o aluno tenta agendar a mesma aula duas vezes
        //a primeira solicitação é aceita e a segunda solicitação entra em conflito
        alunoMarcosAlia.agendarAula(aulaTeoriaMusical);
        alunoMarcosAlia.agendarAula(aulaTeoriaMusical);
        //testando se o professor consegue agendar uma aula que já foi agendada pelo aluno
        //mesma questão das linhas de código 95 e 96, o aluno já agendou a aula
        professorDuncanIdaho.agendarAula(aulaTeoriaMusical);

        //testando o agendamento 
        professorFrank.agendarAula(aulaPiano);
        
        //efetuando os cancelamentos
        System.out.println("\n\n::::::::::::::::: SOLICITAÇÕES DE CANCELAMENTO ::::::::::::::::::::");
        //testando o cancelamento de aula - quando o aluno cancela a aula agendada pelo professor
        //como o aluno pertence a aula, ele pode cancela-la
        alunoJoaoSilva.cancelarAula(aulaCanto, alunoJoaoSilva);
        //testando o cancelamento de aula - quando não é um aluno ou professor da respectiva aula
        //apenas o aluno ou o professor da aula podem cancela-la
        alunoJoaoSilva.cancelarAula(aulaTeoriaMusical, alunoJoaoSilva);
        //testando o cancelamento de aula agendada pelo próprio professor
        professorFrank.cancelarAula(aulaPiano, professorFrank);

        System.out.println("\n\n::::::::::::::::::::::: LISTA DAS AULAS ::::::::::::::::::::::::::::");
        gerenciadorDeAulas.listarAulas();
        //como todas as aulas do professor Lucas foram canceladas, irá imprimir uma mensagem para indicar que não há aulas
        gerenciadorDeAulas.listarAulasDoProfessorOuAluno(professorLucasLima);
        //como este professor possui aulas agendadas, ela aparece no terminal
        gerenciadorDeAulas.listarAulasDoProfessorOuAluno(professorDuncanIdaho);



    }
}
