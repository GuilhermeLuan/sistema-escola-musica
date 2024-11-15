package br.com.gerenciamento.entities;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.i.Agendavel;

public class Professor extends Pessoa implements Agendavel { // hierarquia da classe Pessoa com a subclasse Professor
	
	// propriedade da subclasse Professor
	private String especialidade; 
	private List<String> aulasAgendadas;
	
	
	//construtoor
	public Professor(String nome, int idade, String endereco, String cpf, Curso curso, String especialidade,
			List<String> aulasAgendadas) {
		super(nome, idade, endereco, cpf);
		this.especialidade = especialidade;
		this.aulasAgendadas = new ArrayList<>();
	}

	//encapsulamento 
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public List<String> getAulasAgendadas() {
		return aulasAgendadas;
	}
	
	//IMPLEMENTAÇÃO DOSS MÉTODOS DA INTERFACE
	//Polimorfismo - sobrescrita do método agendarAula
	@Override
	public void agendarAula(LocalTime horaInicio, Aula aula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarAula(Aula aula) {
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
	
	@Override
    public String toString() {
        return String.format(
            "Nome: %s\nIdade: %d\nEndereço: %s\nCPF: %s\nRegistro do Professor: %d\nEspecialidade: %s",
            super.getNome(),           // Obtém o nome da superclasse Pessoa
            super.getIdade(),          // Obtém a idade da superclasse Pessoa
            super.getEndereco(),       // Obtém o endereço da superclasse Pessoa
            super.getCpf(),            // Obtém o CPF da superclasse Pessoa
            this.especialidade         // Especialidade do professor
        );
    }
}
