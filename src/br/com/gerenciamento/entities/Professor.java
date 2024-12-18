package br.com.gerenciamento.entities;

import br.com.gerenciamento.aulas.Aula;
import br.com.gerenciamento.aulas.GerenciadorDeAulas;
import br.com.gerenciamento.entities.curso.Curso;
import br.com.gerenciamento.i.Agendavel;

import java.util.Objects;

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
        System.out.println("_________________________________________________________________-");
        System.out.println("\n (O PROFESSOR " + nome + " requeriu um AGENDAMENTO de aula...)");
        gerenciadorDeAula.agendarAula(aula);

    }

    // sobrescrita do método cancelarAula
    @Override
    public void cancelarAula(Aula aula, Pessoa pessoaRequisitante) {
        System.out.println("_________________________________________________________________-");
        System.out.println("\n (O PROFESSOR " + nome + " requeriu um CANCELAMENTO de aula...)");
        gerenciadorDeAula.cancelarAula(aula, pessoaRequisitante);

    }

    //método que lista as aulas agendadas para o professor
    public void listarAulasAgendas() {
        gerenciadorDeAula.listarAulas();
    }

    // sobrescrita do método toString() que fornece detalhes das informações do professor
    @Override
    public String toString() {
        return String.format(
                " - Nome: %s\n - Idade: %d\n - Endereço: %s\n - Especialidade: %s",
                super.getNome(),
                super.getIdade(),
                super.getEndereco(),
                this.especialidade
        );
    }
}
