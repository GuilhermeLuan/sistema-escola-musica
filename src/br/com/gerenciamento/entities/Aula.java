package br.com.gerenciamento.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.gerenciamento.entities.curso.TipoCurso;

public class Aula {
	private TipoCurso curso;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    
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
}