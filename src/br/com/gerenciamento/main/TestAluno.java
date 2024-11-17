package br.com.gerenciamento.main;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.entities.Aluno;
import br.com.gerenciamento.entities.Professor;
import br.com.gerenciamento.entities.curso.Curso;
import br.com.gerenciamento.entities.curso.CursoFactory;
import br.com.gerenciamento.enums.Nivel;
import br.com.gerenciamento.enums.TipoCurso;

public class TestAluno {
	public static void main(String[] args) {
		Curso curso1 = CursoFactory.newCurso(TipoCurso.CANTO, 20);

		
        // Criando um objeto Aluno
        Aluno aluno = new Aluno(
            "João Silva",          // Nome
            20,                    // Idade
            "Rua das Flores, 123", // Endereço
            1010,                  // Matrícula
            Nivel.INTERMEDIARIO       // Nível
        );

        // Exibindo os dados do aluno (toString sobrescrito na classe Aluno)
        System.out.println(aluno);

        // Simulando métodos da classe
        aluno.listarCursosInscritos(); // Exemplo de lista vazia inicialmente
        aluno.listarHorariosAulas();  // Exemplo de lista vazia inicialmente
   
        aluno.adicionarCurso(curso1);
        
        aluno.listarCursosInscritos(); // Exemplo de lista vazia inicialmente
        aluno.listarHorariosAulas();
        
        Aluno aluno1 = new Aluno("Marcos", 12, "Rua B",298, Nivel.INICIANTE);
        Professor professor = new Professor("Lucas", 34, "Rua A", curso1, null);
        
        Aula aulaCanto = new Aula(TipoCurso.CANTO, LocalDate.of(2024,10,12), LocalTime.of(16,0), LocalTime.of(18,0));
        aulaCanto.adicionarListener(professor);
        aulaCanto.agendarAula(LocalTime.of(16,0), aulaCanto);
	}
}
