package model;

public class Livro {
    private String titulo;
    private Autor autor;
    private String isbn;
    private boolean disponivel;

    // Construtor padrão
    public Livro() {}

    // Construtor com argumentos
    public Livro(String titulo, Autor autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true; // Por padrão, o livro está disponível
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Métodos para emprestar e devolver o livro
    public void emprestarLivro() {
        if (disponivel) {
            disponivel = false;
            System.out.println("O livro '" + titulo + "' foi emprestado.");
        } else {
            System.out.println("O livro '" + titulo + "' não está disponível.");
        }
    }

    public void devolverLivro() {
        disponivel = true;
        System.out.println("O livro '" + titulo + "' foi devolvido.");
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor.getNome() + ", ISBN: " + isbn + ", Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
