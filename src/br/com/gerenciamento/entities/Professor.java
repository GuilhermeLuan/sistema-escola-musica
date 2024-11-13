package br.com.gerenciamento.entities;
import java.util.List;

import br.com.gerenciamento.entities.curso.*;
import br.com.gerenciamento.i.Agendavel;

public class Professor extends Pessoa implements Agendavel { // hierarquia da classe Pessoa com a subclasse Professor
	
	// propriedade da subclasse Professor
	private float Salario; 
	private List<String> HorariosDisponivel;
	
	//construtor
	public Professor(String nome, int idade, String endereco, String cpf, Curso curso, float salario,
			List<String> horariosDisponivel) {
		super(nome, idade, endereco, cpf, curso);
		Salario = salario;
		HorariosDisponivel = horariosDisponivel;
	}
	
	
	//encapsulamento //vvvvvvvvvv
	public float getSalario() { 
		return Salario;
	}

	public void setSalario(float salario) {
		Salario = salario;
	}

	public List<String> getHorariosDisponivel() {
		return HorariosDisponivel;
	}

	public void adicionarHorario(String horario){
		HorariosDisponivel.add(horario);
	}
	
	public void removerHorario(String horario){
		HorariosDisponivel.remove(horario);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString().replace("}", "")+
				"Horário: " +HorariosDisponivel + '\''+
				"Salário: " +Salario+
				'}';
	}


	//IMPLEMENTAÇÃO DOSS MÉTODOS DA INTERFACE
	//Polimorfismo - sobrescrita do método agendarAula
	@Override
	public void agendarAula() {
		// TODO Auto-generated method stub
		
	}


	//Polimorfismo - sobrescrita do método cancelarAula
	@Override
	public void cancelarAula() {
		// TODO Auto-generated method stub
		
	}

 
	
	
	
	
	
}
