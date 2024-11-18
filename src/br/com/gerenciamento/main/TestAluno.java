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
		GerenciadorDeAulas gerenciadorDeAulas = GerenciadorDeAulas.getInstancia();
		Curso curso1 = CursoFactory.newCurso(TipoCurso.CANTO, 20);
		Curso curso2 = CursoFactory.newCurso(TipoCurso.TEORIA_MUSICAL, 20);

        System.out.println("================= Professor ===================");

		
        // Criando um objeto Aluno
        Aluno aluno = new Aluno(
            "João Silva",          // Nome
            20,                    // Idade
            "Rua das Flores, 123", // Endereço
            1010,                  // Matrícula
            Nivel.INTERMEDIARIO,
            gerenciadorDeAulas// Nível
        );

        // Exibindo os dados do aluno (toString sobrescrito na classe Aluno)
        System.out.println(aluno);

        // Simulando métodos da classe
        aluno.listarCursosInscritos(); // Exemplo de lista vazia inicialmente
   
        aluno.adicionarCurso(curso1);
        
        aluno.listarCursosInscritos();
        
        Aluno aluno1 = new Aluno("Marcos", 12, "Rua B",298, Nivel.INICIANTE, gerenciadorDeAulas);
        Professor professor = new Professor("Lucas", 34, "Rua A", curso1, "Canto", gerenciadorDeAulas);
        
        Aula aulaCanto = new Aula(TipoCurso.CANTO, LocalDate.of(2024,10,12), LocalTime.of(16,0), LocalTime.of(18,0), aluno1, professor);
        Aula aulaPiano = new Aula(TipoCurso.PIANO, LocalDate.of(2024,10,12), LocalTime.of(18,0), LocalTime.of(19,0), aluno1, professor);

        aulaCanto.adicionarListener(professor);
                
        aulaCanto.agendarAula(aulaCanto);
        aulaCanto.agendarAula(aulaPiano);
        System.out.println();
        aulaCanto.agendarAula(aulaCanto);
        System.out.println();
        gerenciadorDeAulas.listarAulasDoProfessorOuAluno(professor);
        
        System.out.println("================= Aluno ===================");
        
        Aluno aluno2 = new Aluno("Paul Atreides", 15, "Bronken Land",300, Nivel.INTERMEDIARIO, gerenciadorDeAulas);
        Professor professor2 = new Professor("Duncan Idaho", 34, "Imperial Basin", curso1, "Piano", gerenciadorDeAulas);
        Aula aulaTeoriaMusical = new Aula(TipoCurso.TEORIA_MUSICAL, LocalDate.of(2024,10,20), LocalTime.of(18,0), LocalTime.of(19,0), aluno2, professor2);

        System.out.println();
        System.out.println(aluno2);
        System.out.println();

        
        aluno2.adicionarCurso(curso2);
        aluno2.listarCursosInscritos();
        
        aulaTeoriaMusical.adicionarListener(aluno2);
        aulaTeoriaMusical.agendarAula(aulaTeoriaMusical);
        System.out.println();
        gerenciadorDeAulas.listarAulasDoProfessorOuAluno(aluno2);


        


	}
}
