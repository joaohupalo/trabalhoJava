package model;


import java.time.LocalDate;

public class Estudante extends Membro{
    private String matricula;
    private String curso;

    // Construtores padrão e com argumentos
    public Estudante() {
        this.matricula = "";
        this.curso = "";
    }

    public Estudante(Integer id, String nome, LocalDate dataNascimento, String CPF , String matricula, String curso) {
        super(id, nome, dataNascimento, CPF);
        this.matricula = matricula;
        this.curso = curso;
    }

    // getters and setters
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    // toString do obj estudante
    @Override
    public String toString() {
        return "Estudante{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                ", matricula='" + matricula + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
