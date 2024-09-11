package model;
import java.time.LocalDate;


public class Livro {
    private String titulo;
    private Autor autor;
    private String isbn;
    private boolean disponivel;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Livro(String titulo, Autor autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    // Métodos para emprestar e devolver o livro
    public void emprestar(LocalDate dataEmprestimo) throws Exception {
        if (!disponivel) {
            throw new Exception("O livro '" + titulo + "' já está emprestado.");
        }
        this.disponivel = false;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataEmprestimo.plusDays(14); // 14 dias para devolução
    }

    public void devolver() throws Exception {
        if (disponivel) {
            throw new Exception("O livro '" + titulo + "' já foi devolvido.");
        }
        this.disponivel = true;
        this.dataEmprestimo = null;
        this.dataDevolucao = null;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor.getNome() + ", ISBN: " + isbn +
                ", Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
