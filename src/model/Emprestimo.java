package model;

import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {
    private Membro membro;
    private Livro livro;
    private LocalDate dataEmprestimo;

    // Construtor padrão
    public Emprestimo() {}

    // Construtor com validações
    public Emprestimo(Membro membro, Livro livro, LocalDate dataEmprestimo) {
        setMembro(membro);
        setLivro(livro);
        setDataEmprestimo(dataEmprestimo);
    }

    // Getters e Setters com validação
    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        if (membro == null) {
            throw new IllegalArgumentException("Membro não pode ser nulo.");
        }
        this.membro = membro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo.");
        }
        this.livro = livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        if (dataEmprestimo == null || dataEmprestimo.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de empréstimo inválida.");
        }
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Empréstimo: " + membro.getNome() + " emprestou o livro '" + livro.getTitulo() + "' em " + dataEmprestimo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(membro, that.membro) &&
                Objects.equals(livro, that.livro) &&
                Objects.equals(dataEmprestimo, that.dataEmprestimo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(membro, livro, dataEmprestimo);
    }
}
