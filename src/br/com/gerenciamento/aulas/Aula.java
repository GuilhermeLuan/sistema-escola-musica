package br.com.gerenciamento.aulas;

import br.com.gerenciamento.entities.Aluno;
import br.com.gerenciamento.entities.Pessoa;
import br.com.gerenciamento.entities.Professor;
import br.com.gerenciamento.enums.TipoCurso;
import br.com.gerenciamento.i.Agendavel;

import java.time.LocalDate;
import java.time.LocalTime;

public class Aula {
    private TipoCurso curso;
    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private Aluno aluno;
    private Professor professor;
    private Agendavel listener;

    public Aula(TipoCurso curso, LocalDate data, LocalTime horaInicio, LocalTime horaFim, Aluno aluno,
                Professor professor) {
        super();
        this.curso = curso;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.aluno = aluno;
        this.professor = professor;
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


    public Aluno getAluno() {
        return aluno;
    }


    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


    public Professor getProfessor() {
        return professor;
    }


    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    public Agendavel getListener() {
        return listener;
    }


    public void setListener(Agendavel listener) {
        this.listener = listener;
    }


    //OBSERVER - A aula observa se o professor ou o aluno estão agendando ou cancelando uma aula
    //adicionando o listener
    public void adicionarListener(Agendavel listener) {
        this.listener = listener;
    }

    public void agendarAula(Aula aula) {
        listener.agendarAula(aula);

    }

    public void cancelarAula(Aula aula, Pessoa pessoaRequisitante) {
        listener.cancelarAula(aula, pessoaRequisitante);

    }

    @Override
    public String toString() {
        return String.format(
                "\n *CURSO: %s\n - Data: %s\n - Hora de Início: %s\n - Hora de Término: %s\n - Aluno: %s\n - Professor: %s\n",
                curso,                              // Tipo do curso
                data,                               // Data da aula
                horaInicio,                         // Hora de início da aula
                horaFim,                            // Hora de término da aula
                aluno != null ? aluno.getNome() : "Nenhum aluno associado",  // Nome do aluno ou mensagem alternativa
                professor != null ? professor.getNome() : "Nenhum professor associado" // Nome do professor ou mensagem alternativa
        );
    }
}