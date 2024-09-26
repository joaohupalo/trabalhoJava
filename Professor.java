package model;

import java.util.Objects;

public class Professor extends Membro {
    private String departamento;

    // Construtor padrão
    public Professor() {}

    // Construtor com validação
    public Professor(String nome, int idMembro, String departamento) {
        super(nome, idMembro);
        setDepartamento(departamento); // Validação do departamento
    }

    // Getter e Setter com validação
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento == null || departamento.trim().isEmpty()) {
            throw new IllegalArgumentException("Departamento não pode ser nulo ou vazio.");
        }
        this.departamento = departamento;
    }

    // Sobrescrevendo o método toString para incluir o departamento
    @Override
    public String toString() {
        return super.toString() + ", Departamento: " + departamento;
    }

    // Sobrescrevendo equals para comparar corretamente objetos Professor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return departamento.equals(professor.departamento);
    }

    // Sobrescrevendo hashCode para compatibilidade com equals
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departamento);
    }
}
