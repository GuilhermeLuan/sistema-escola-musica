package br.com.gerenciamento.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Aula {
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    public Aula(LocalDate data, LocalTime horaInicio, LocalTime horaFim) {
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }
}