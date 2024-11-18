package br.com.gerenciamento.entities;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.aulas.GerenciadorDeAulas;
import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.i.Agendavel;

public class Professor extends Pessoa implements Agendavel { // hierarquia da classe Pessoa com a subclasse Professor
	
	// atributos da subclasse Professor
	private String especialidade; 
	private GerenciadorDeAulas gerenciadorDeAula;
	
	
	//construtor
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
	// sobrescrita do método agendarAula
	
	@Override
	public void agendarAula(Aula aula) {
		gerenciadorDeAula.agendarAula(aula);

	}
	// sobrescrita do método cancelarAula
	@Override
	public void cancelarAula(Aula aula) {
		gerenciadorDeAula.cancelarAula(aula);

}
	
	//método que lista as aulas agendadas para o professor
	public void listarAulasAgendas() {
		gerenciadorDeAula.listarAulas();
	}
	
	// sobrescrita do método toString() que fornece detalhes das informações do professor
	@Override
    public String toString() {
        return String.format(
            "Nome: %s\nIdade: %d\nEndereço: %s\nCPF: %s\nRegistro do Professor: %d\nEspecialidade: %s",
            super.getNome(),           
            super.getIdade(),          
            super.getEndereco(),       
            this.especialidade       
        );
    }
}
