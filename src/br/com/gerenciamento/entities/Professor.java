package br.com.gerenciamento.entities;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.aulas.GerenciadorDeAulas;
import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.i.Agendavel;

public class Professor extends Pessoa implements Agendavel { // hierarquia da classe Pessoa com a subclasse Professor
	
	// propriedade da subclasse Professor
	private String especialidade; 
	private GerenciadorDeAulas gerenciadorDeAula;
	
	// mudar isso dps para o singleton fazer sentido 
	//construtoor
	public Professor(String nome, int idade, String endereco, Curso curso, String especialidade, GerenciadorDeAulas gerenciadorDeAula) {
		super(nome, idade, endereco);
		this.especialidade = especialidade;
		this.gerenciadorDeAula = gerenciadorDeAula;
	}

	//encapsulamento 
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	//IMPLEMENTAÇÃO DOSS MÉTODOS DA INTERFACE
	//Polimorfismo - sobrescrita do método agendarAula
	@Override
	public void agendarAula(Aula aula) {
		gerenciadorDeAula.agendarAula(aula);

	}

	@Override
	public void cancelarAula(Aula aula) {
		gerenciadorDeAula.cancelarAula(aula);

}
	
	//metodo para listar as aulas agendadas para professorr
	public void listarAulasAgendas() {
		gerenciadorDeAula.listarAulas();
	}
	
	@Override
    public String toString() {
        return String.format(
            "Nome: %s\nIdade: %d\nEndereço: %s\nCPF: %s\nRegistro do Professor: %d\nEspecialidade: %s",
            super.getNome(),           // Obtém o nome da superclasse Pessoa
            super.getIdade(),          // Obtém a idade da superclasse Pessoa
            super.getEndereco(),       // Obtém o endereço da superclasse Pessoa
            this.especialidade         // Especialidade do professor
        );
    }
}
