package model;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private static Biblioteca instancia;
    private List<Livro> livros;
    private List<Membro> membros;

    private Biblioteca() {
        livros = new ArrayList<>();
        membros = new ArrayList<>();
    }

    public static Biblioteca getInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Membro> listarMembros() {
        return membros;
    }
}
