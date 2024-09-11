package model;

public class Professor extends Membro {
    private String departamento;

    public Professor() {}

    public Professor(String nome, int idMembro, String departamento) {
        super(nome, idMembro);
        this.departamento = departamento;
    }

    // Getter e Setter
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + ", Departamento: " + departamento;
    }
}
