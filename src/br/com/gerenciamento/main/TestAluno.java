package br.com.gerenciamento.main;

import br.com.gerenciamento.entities.Aluno;
import br.com.gerenciamento.entities.curso.Curso;
import br.com.gerenciamento.entities.curso.CursoFactory;
import br.com.gerenciamento.entities.curso.TipoCurso;

public class TestAluno {
	public static void main(String[] args) {
		Curso curso1 = CursoFactory.newCurso(TipoCurso.CANTO, 20);

		
        // Criando um objeto Aluno
        Aluno aluno = new Aluno(
            "João Silva",          // Nome
            20,                    // Idade
            "Rua das Flores, 123", // Endereço
            "123.456.789-00",      // CPF
            1010,                  // Matrícula
            "Intermediário"        // Nível
        );

        // Exibindo os dados do aluno (toString sobrescrito na classe Aluno)
        System.out.println(aluno);

        // Simulando métodos da classe
        aluno.listarCursosInscritos(); // Exemplo de lista vazia inicialmente
        aluno.listarHorariosAulas();  // Exemplo de lista vazia inicialmente
   
        aluno.adicionarCurso(curso1);
        
        aluno.listarCursosInscritos(); // Exemplo de lista vazia inicialmente
        aluno.listarHorariosAulas();
	}
}
