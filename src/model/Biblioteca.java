package model;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Membro> membros;

    public Biblioteca(List<Livro> livros, List<Membro> membros) {
        this.livros = livros;
        this.membros = membros;
    }

    public Biblioteca() {
        livros = new ArrayList<>();
        membros = new ArrayList<>();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    // Adicionar livro à biblioteca
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Listar todos os livros
    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    // Adicionar membro à biblioteca
    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }

    // Listar todos os membros
    public void listarMembros() {
        for (Membro membro : membros) {
            System.out.println(membro);
        }
    }

    // Listar livros de um autor específico
    public void listarLivrosPorAutor(Autor autor) {
        for (Livro livro : livros) {
            if (livro.getAutor().equals(autor)) {
                System.out.println(livro);
            }
        }
    }
}
