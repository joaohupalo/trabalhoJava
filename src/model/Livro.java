package model;

import model.ENUM.EstadoLivro;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String isbn;
    private EstadoLivro estado;  // Usando o enum EstadoLivro para controlar o estado do livro
    private Autor autor;
    private List<Emprestimo> listaEmprestimos;

    // Construtor com estado inicial DISPONIVEL
    public Livro(String titulo, String isbn, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.estado = EstadoLivro.DISPONIVEL;  // Inicia como disponível
        this.autor = autor;
        this.listaEmprestimos = new ArrayList<>();
    }

    // Construtor padrão
    public Livro() {
        this.titulo = "";
        this.isbn = "";
        this.estado = EstadoLivro.DISPONIVEL;  // Inicia como disponível
        this.autor = new Autor();
        this.listaEmprestimos = new ArrayList<>();
    }

    // Getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public EstadoLivro getEstado() {
        return estado;
    }

    public void setEstado(EstadoLivro estado) {
        this.estado = estado;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    // Método para emprestar livro
    public void emprestarLivro(Emprestimo emprestimo) {
        if (this.estado == EstadoLivro.DISPONIVEL) {
            this.listaEmprestimos.add(emprestimo);
            setEstado(EstadoLivro.EMPRESTADO);  // Altera estado para EMPRESTADO
        } else {
            System.out.println("Livro não está disponível para empréstimo.");
        }
    }

    // Método para devolver livro
    public void devolverLivro(Emprestimo emprestimo) {
        if (this.estado == EstadoLivro.EMPRESTADO) {
            emprestimo.setDateTimeDevolucao(LocalDateTime.now());  // Define a data de devolução
            setEstado(EstadoLivro.DISPONIVEL);  // Altera o estado para DISPONIVEL
        } else {
            System.out.println("Livro já está disponível.");
        }
    }

    // Verificar disponibilidade do livro
    public String verificarDisponibilidade() {
        if (this.estado == EstadoLivro.DISPONIVEL) {
            return "Livro disponível" +
                    "\nAutor: " + getAutor().getNome();
        } else {
            Emprestimo ultimoEmprestimo = getListaEmprestimos().get(getListaEmprestimos().size() - 1);  // Último empréstimo
            return "Livro indisponível" +
                    "\nAutor: " + getAutor().getNome() +
                    "\nLocado pela última vez em: " + ultimoEmprestimo.getDateTimeEmprestimo() +
                    "\nPor: " + ultimoEmprestimo.getQuemEmprestou().getId();
        }
    }
}
