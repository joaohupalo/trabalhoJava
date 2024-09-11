package model;

public class Estudante extends Membro {
    private String curso;

    public Estudante() {}

    public Estudante(String nome, int idMembro, String curso) {
        super(nome, idMembro);
        this.curso = curso;
    }

    // Getter e Setter
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + ", Curso: " + curso;
    }
}
