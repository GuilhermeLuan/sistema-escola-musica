package br.com.gerenciamento.aulas;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gerenciamento.enums.TipoCurso;
import br.com.gerenciamento.i.Agendavel;

public class Aula{
	private TipoCurso curso;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Agendavel listener;
    
	public Aula(TipoCurso curso, LocalDate data, LocalTime horaInicio, LocalTime horaFim) {
		super();
		this.curso = curso;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	public TipoCurso getCurso() {
		return curso;
	}

	public void setCurso(TipoCurso curso) {
		this.curso = curso;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}
	
	//OBSERVER - A aula observa se o professor ou o aluno estão agendando ou cancelando uma aula
	//adicionando o listener
	public void adicionarListener(Agendavel listener) {
		this.listener = listener;
	}

	public void agendarAula(LocalTime horaInicio, Aula aula) {
		listener.agendarAula(horaInicio, aula);
		
	}

	public void cancelarAula(Aula aula) {
		listener.cancelarAula(aula);
		
	}    
}