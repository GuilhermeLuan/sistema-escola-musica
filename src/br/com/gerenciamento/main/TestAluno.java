package br.com.gerenciamento.main;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.aulas.GerenciadorDeAulas;
import br.com.gerenciamento.entities.Aluno;
import br.com.gerenciamento.entities.Professor;
import br.com.gerenciamento.entities.curso.Curso;
import br.com.gerenciamento.entities.curso.CursoFactory;
import br.com.gerenciamento.enums.Nivel;
import br.com.gerenciamento.enums.TipoCurso;

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
        //professor1 - professor de CANTO
        Professor professor1 = new Professor("Lucas Lima", 34, "Rua A", curso1, "Canto", gerenciadorDeAulas);
        System.out.println(professor1); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)
        System.out.println("\n_________________________________________________________________-\n");
        //professor2 - professor de TEORIA MUSICAL
        Professor professor2 = new Professor("Duncan Idaho", 40, "Imperial Basin", curso2, "Teoria Musical", gerenciadorDeAulas);
        System.out.println(professor2); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)
        System.out.println("\n_________________________________________________________________-\n");
        //professor3 - professor de VIOLÃO
        Professor professor3 = new Professor("Stilgar Ben", 52, "Sietch Tabr", curso3, "Violão", gerenciadorDeAulas);
        System.out.println(professor2); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)
        System.out.println("\n_________________________________________________________________-\n");
        //professor4 - professor de PIANO
        Professor professor4 = new Professor("Frank Herbert", 28, "Avenida dos Pássaros", curso4, "Piano", gerenciadorDeAulas);
        System.out.println(professor3); // Exibindo os dados do PROFESSOR (toString sobrescrito na classe Professor)
		
        // Criando objetos do tipo Aluno
        System.out.println("\n===========================+ ALUNOS +=============================\n");
        //aluno1
        Aluno aluno1 = new Aluno("João Silva", 20, "Rua das Flores, 123", 1010, Nivel.INICIANTE, gerenciadorDeAulas);
        System.out.println(aluno1); // Exibindo os dados do ALUNO (toString sobrescrito na classe Aluno)
        System.out.println("\n_________________________________________________________________-\n");
        //aluno2
        Aluno aluno2 = new Aluno("Marcos Alia", 12, "Rua B",2938, Nivel.INTERMEDIARIO, gerenciadorDeAulas);
        System.out.println(aluno2);// Exibindo os dados do ALUNO (toString sobrescrito na classe Aluno)
        System.out.println("\n_________________________________________________________________-\n");
        //aluno3
        Aluno aluno3 = new Aluno("Paul Atreides", 15, "Bronken Land",3001, Nivel.AVANCADO, gerenciadorDeAulas);
        System.out.println(aluno3);// Exibindo os dados do ALUNO (toString sobrescrito na classe Aluno)
        
        //criando as aulas
        //aqui será testado o conflito de horários, onde um aluno tentará marcar aulas que os os horários coincidem
        Aula aulaCanto = new Aula(TipoCurso.CANTO, LocalDate.of(2024,10,12), LocalTime.of(16,0), LocalTime.of(18,0), aluno1, professor1);
        Aula aulaTeoriaMusical = new Aula(TipoCurso.TEORIA_MUSICAL, LocalDate.of(2024,10,12), LocalTime.of(18,0), LocalTime.of(20,0), aluno2, professor2);
        Aula aulaViolao = new Aula(TipoCurso.VIOLAO, LocalDate.of(2024,10,12), LocalTime.of(18,0), LocalTime.of(20,0), aluno2, professor3);
        Aula aulaPiano = new Aula(TipoCurso.PIANO, LocalDate.of(2024,10,12), LocalTime.of(13,0), LocalTime.of(15,0), aluno3, professor4);

        //utilizando o padrão OBSERVER para a notificação do agendamento e cancelamento das aulas
        //adicionando na aula de CANTO (o professor responsável e os possíveis alunos que gostariam de agendar ou cancelar a aula)
        aulaCanto.adicionarListener(professor1);
        aulaCanto.adicionarListener(aluno1);
        aulaCanto.adicionarListener(aluno2);
        aulaCanto.adicionarListener(aluno3);
        //adicionando na aula de TEORIA MUSICAL (o professor responsável e os possíveis alunos que gostariam de agendar ou cancelar a aula)
        aulaTeoriaMusical.adicionarListener(professor2);
        aulaTeoriaMusical.adicionarListener(aluno1);
        aulaTeoriaMusical.adicionarListener(aluno2);
        aulaTeoriaMusical.adicionarListener(aluno3);
        //adicionando na aula de VIOLÃO (o professor responsável e os possíveis alunos que gostariam de agendar ou cancelar a aula)
        aulaViolao.adicionarListener(professor3);
        aulaViolao.adicionarListener(aluno1);
        aulaViolao.adicionarListener(aluno2);
        aulaViolao.adicionarListener(aluno3);
        //adicionando na aula de PIANO (o professor responsável e os possíveis alunos que gostariam de agendar ou cancelar a aula)
        aulaPiano.adicionarListener(professor4);
        aulaPiano.adicionarListener(aluno1);
        aulaPiano.adicionarListener(aluno2);
        aulaPiano.adicionarListener(aluno3);
                
        System.out.println("\n:::::::::::::::::: AGENDAMENTOS E CANCELAMENTOS :::::::::::::::::::::::");
        
        //agendando as aulas
        professor1.agendarAula(aulaCanto);
       
        //testando o conflito de aulas, onde o aluno tenta marcar aulas que estão no mesmo horário
        aluno2.agendarAula(aulaTeoriaMusical);
        aluno2.agendarAula(aulaTeoriaMusical);
        
        //professor4.agendarAula(aulaPiano);
        //aluno3.agendarAula(aulaPiano
        
        //testando o cancelamento de aulas
        //System.out.println("--- DEBUG ---");
        //gerenciadorDeAulas.listarAulas();
        //gerenciadorDeAulas.listarAulasDoProfessorOuAluno(aluno3);
        //gerenciadorDeAulas.listarAulasDoProfessorOuAluno(professor3);

        
        
        
        //aluno3.agendarAula(aulaViolao); // Era pra da certo!
        //professor3.agendarAula(aulaViolao); //Era pra da certo!
        //professor3.cancelarAula(aulaViolao); //Era pra da certo
        
        //gerenciadorDeAulas.listarAulas();

        
        //System.out.println("--- FIM - DEBUG ---");

        System.out.println("\n::::::::::::::::::::::: LISTA DAS AULAS ::::::::::::::::::::::::::::");
        //aulaCanto.agendarAula(aulaCanto);
        //aulaCanto.agendarAula(aulaPiano);
        //System.out.println();
        //aulaCanto.agendarAula(aulaCanto);
        //System.out.println();
        //gerenciadorDeAulas.listarAulasDoProfessorOuAluno(professor1);
        
        
     // Simulando métodos da classe
        //aluno1.listarCursosInscritos(); // Exemplo de lista vazia inicialmente
        //aluno1.adicionarCurso(curso1);
        //aluno1.listarCursosInscritos();
        
  
        
        // aulaTeoriaMusical = new Aula(TipoCurso.TEORIA_MUSICAL, LocalDate.of(2024,10,20), LocalTime.of(18,0), LocalTime.of(19,0), aluno2, professor2);

        //System.out.println();
        //System.out.println();

        
        //aluno2.adicionarCurso(curso2);
        //aluno2.listarCursosInscritos();
       
        //aulaTeoriaMusical.agendarAula(aulaTeoriaMusical);
        //System.out.println();
        //gerenciadorDeAulas.listarAulasDoProfessorOuAluno(aluno2);


        


	}
}
