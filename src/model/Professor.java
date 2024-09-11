package model;

public class Professor extends Membro {
    private String departamento;

    public Professor(String nome, int idMembro, String departamento) {
        super(nome, idMembro);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String getDetalhes() {
        return "Professor do departamento: " + departamento;
    }
}