package model;

import model.ENUM.EstadoLivro;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Estudante> estudantes = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();

    // Métodos para adicionar livros, estudantes e professores
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarEstudante(Estudante estudante) {
        estudantes.add(estudante);
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    // Métodos para buscar livros, estudantes e professores
    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Estudante buscarEstudantePorId(int id) {
        for (Estudante estudante : estudantes) {
            if (estudante.getId() == id) {
                return estudante;
            }
        }
        return null;
    }

    public Professor buscarProfessorPorId(int id) {
        for (Professor professor : professores) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        return null;
    }

    // Métodos para listar livros
    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getEstado() == EstadoLivro.DISPONIVEL) {
                livrosDisponiveis.add(livro);
            }
        }
        return livrosDisponiveis;
    }

    public List<Livro> listarTodosLivros() {
        return livros;
    }

    // Métodos para emprestar e devolver livros
    public void emprestarLivro(String titulo, Membro usuario) {
        Livro livro = buscarLivroPorTitulo(titulo);
        if (livro != null && livro.getEstado() == EstadoLivro.DISPONIVEL) {
            Emprestimo emprestimo = new Emprestimo(usuario, livro, LocalDateTime.now());
            livro.setEmprestimoAtual(emprestimo);
            livro.setEstado(EstadoLivro.EMPRESTADO);
            usuario.addEmprestimo(emprestimo);
        }
    }

    public void devolverLivro(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);
        if (livro != null && livro.getEstado() == EstadoLivro.EMPRESTADO) {
            livro.devolverLivro();
            livro.setEstado(EstadoLivro.DISPONIVEL);
        }
    }

    // Métodos para verificar disponibilidade
    public boolean verificarDisponibilidade(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);
        return livro != null && livro.getEstado() == EstadoLivro.DISPONIVEL;
    }
}

