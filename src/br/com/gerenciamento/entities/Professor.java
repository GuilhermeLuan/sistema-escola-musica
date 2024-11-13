package br.com.gerenciamento.entities;
import java.util.List;

import br.com.gerenciamento.entities.curso.*;

public class Professor extends Pessoa { // hierarquia da classe Pessoa com a subclasse Professor
	
	// propriedade da subclasse Professor
	private float Salario; 
	private List<Professor> HorariosDisponivel;
	
	//construtor
	public Professor(String nome, int idade, String endereco, String cpf, Curso curso, float salario,
			List<Professor> horariosDisponivel) {
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

	public List<Professor> getHorariosDisponivel() {
		return HorariosDisponivel;
	}

	public void setHorariosDisponivel(List<Professor> horariosDisponivel) {
		HorariosDisponivel = horariosDisponivel;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString().replace("}", "")+
				"Horário: " +HorariosDisponivel + '\''+
				"Salário: " +Salario+
				'}';
	}

 
	
	
	
	
	
}
