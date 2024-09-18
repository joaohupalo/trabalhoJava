package model;

public class Estudante extends Membro {
    private String curso;

    // Construtor padrão
    public Estudante() {}

    // Construtor com validações
    public Estudante(String nome, int idMembro, String curso) {
        super(nome, idMembro);
        setCurso(curso);
    }

    // Getter e Setter com validação
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        if (curso == null || curso.trim().isEmpty()) {
            throw new IllegalArgumentException("Curso não pode ser vazio.");
        }
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + ", Curso: " + curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudante)) return false;
        if (!super.equals(o)) return false;
        Estudante estudante = (Estudante) o;
        return curso.equals(estudante.curso);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + curso.hashCode();
    }
}
