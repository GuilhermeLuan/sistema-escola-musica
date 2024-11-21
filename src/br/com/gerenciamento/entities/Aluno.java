package br.com.gerenciamento.entities;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.aulas.GerenciadorDeAulas;
import br.com.gerenciamento.enums.Nivel;
import br.com.gerenciamento.i.Agendavel;


public class Aluno extends Pessoa implements Agendavel {

    private int matricula;
    private Nivel nivel;
    private GerenciadorDeAulas gerenciadorDeAula;


    public Aluno(String nome, int idade, String endereco, int matricula, Nivel nivel, GerenciadorDeAulas gerenciadorDeAula) {
        super(nome, idade, endereco);
        this.matricula = matricula;
        this.nivel = nivel;
        this.gerenciadorDeAula = gerenciadorDeAula;
    }

    //ENCAPSULAMENTO
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    //IMPLEMENTAÇÃO DOSS MÉTODOS DA INTERFACE
    //sobrescrita do método agendarAula
    @Override
    public void agendarAula(Aula aula) {
        System.out.println("_________________________________________________________________-");
        System.out.println("\n (O ALUNO " + nome + " requeriu um AGENDAMENTO de aula...)");
        gerenciadorDeAula.agendarAula(aula);
    }

    // sobrescrita do método cancelarAula
    @Override
    public void cancelarAula(Aula aula) {
        System.out.println("_________________________________________________________________-");
        System.out.println("\n (O ALUNO " + nome + " requeriu um CANCELAMENTO de aula...)");
        gerenciadorDeAula.cancelarAula(aula);
    }

    // sobrescrita do método toString() que fornece detalhes das informações de aluno
    @Override
    public String toString() {
        return String.format(
                " - Nome: %s\n - Idade: %d\n - Endereço: %s\n - Matrícula: %d\n - Nível do aluno: %s",
                super.getNome(),
                super.getIdade(),
                super.getEndereco(),
                this.matricula,
                this.nivel
        );

    }


}
