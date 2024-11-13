package br.com.gerenciamento.entities;
import java.util.List;

import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.i.Agendavel;

public class Professor extends Pessoa implements Agendavel { // hierarquia da classe Pessoa com a subclasse Professor
	
	// propriedade da subclasse Professor
	private String Especialidade; 
	private List<String> aulasAgendadas;
	
	
	//construtoor
	public Professor(String nome, int idade, String endereco, String cpf, Curso curso, String especialidade,
			List<String> aulasAgendadas) {
		super(nome, idade, endereco, cpf, curso);
		Especialidade = especialidade;
		this.aulasAgendadas = aulasAgendadas;
	}

	//encapsulamento 
	public String getEspecialidade() {
		return Especialidade;
	}

	public void setEspecialidade(String especialidade) {
		Especialidade = especialidade;
	}

	public List<String> getAulasAgendadas() {
		return aulasAgendadas;
	}

	public void setAulasAgendadas(List<String> aulasAgendadas) {
		this.aulasAgendadas = aulasAgendadas;
	}
	
	

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString().replace("}", "")+
				"Especialidade: " +Especialidade+ '\''+
				"Aulas Agendadas " +aulasAgendadas+
				'}';
	}


	

	//IMPLEMENTAÇÃO DOSS MÉTODOS DA INTERFACE
	//Polimorfismo - sobrescrita do método agendarAula
	@Override
	public void agendarAula(String dataHora, String nomeDaAula) {
		// TODO Auto-generated method stub
		
	}


	//Polimorfismo - sobrescrita do método cancelarAula
	@Override
	public void cancelarAula(String dataHora, String nomeDaAula) {
		// TODO Auto-generated method stub
		
	}
	
	//metodo para listar as aulas agendadas para professorr
	public void listarAulasAgendas() {
		System.out.println("Aulas agendadas para o professor " + getNome() + ":");
		 if (aulasAgendadas == null){
			 System.out.println("Nenhuma aula foi agendada");
		 }
		 else {
			 for(String aula : aulasAgendadas) {
				 System.out.println("" + aula);
	
			 }
		 }
	}
	
	

 
	
	
	
	
	
}
