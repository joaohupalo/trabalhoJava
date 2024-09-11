package model;

public class Estudante extends Membro {
    private String curso;

    public Estudante(String nome, int idMembro, String curso) {
        super(nome, idMembro);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String getDetalhes() {
        return "Estudante do curso: " + curso;
    }
}