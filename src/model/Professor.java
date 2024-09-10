package model;

import java.time.LocalDate;

public class Professor extends Membro{
    private String curso;

    // Construtores
    public Professor() {
        super();
        this.curso = "";
    }

    public Professor(Integer id, String nome, LocalDate dataNascimento, String CPF, String curso) {
        super(id, nome, dataNascimento, CPF);
        this.curso = curso;
    }

    // Getters and Setters
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    // toString do obj professor

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", CPF='" + getCPF() + '\'' +
                ", curso='" + getCurso() + '\'' +
                '}';
    }

}
