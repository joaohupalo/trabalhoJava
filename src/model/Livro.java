package model;

public class Livro {
    private String titulo;
    private Autor autor;
    private String isbn;
    private boolean disponivel;

    // Construtor padrão
    public Livro() {}

    // Construtor com validações
    public Livro(String titulo, Autor autor, String isbn) {
        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);
        this.disponivel = true; // Livro é inicialmente disponível
    }

    // Getters e Setters com validação
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
        }
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("Autor não pode ser nulo.");
        }
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN não pode ser nulo ou vazio.");
        }
        this.isbn = isbn;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Método para emprestar livro
    public void emprestarLivro() {
        if (!disponivel) {
            throw new IllegalStateException("O livro '" + titulo + "' já está emprestado.");
        }
        disponivel = false;
        System.out.println("O livro '" + titulo + "' foi emprestado.");
    }

    // Método para devolver livro
    public void devolverLivro() {
        if (disponivel) {
            throw new IllegalStateException("O livro '" + titulo + "' já está disponível.");
        }
        disponivel = true;
        System.out.println("O livro '" + titulo + "' foi devolvido.");
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor.getNome() + ", ISBN: " + isbn + ", Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
