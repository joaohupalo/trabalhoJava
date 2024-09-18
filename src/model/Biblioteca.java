package model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Membro> membros;

    // Construtor com listas pré-existentes
    public Biblioteca(List<Livro> livros, List<Membro> membros) {
        if (livros == null) {
            throw new IllegalArgumentException("A lista de livros não pode ser nula.");
        }
        if (membros == null) {
            throw new IllegalArgumentException("A lista de membros não pode ser nula.");
        }
        this.livros = new ArrayList<>(livros); // Cópia defensiva
        this.membros = new ArrayList<>(membros); // Cópia defensiva
    }

    // Construtor padrão inicializando as listas
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.membros = new ArrayList<>();
    }

    // Retorna uma cópia da lista de livros (evita manipulação externa)
    public List<Livro> getLivros() {
        return new ArrayList<>(livros);
    }

    public void setLivros(List<Livro> livros) {
        if (livros == null) {
            throw new IllegalArgumentException("A lista de livros não pode ser nula.");
        }
        this.livros = new ArrayList<>(livros); // Cópia defensiva
    }

    // Retorna uma cópia da lista de membros
    public List<Membro> getMembros() {
        return new ArrayList<>(membros);
    }

    public void setMembros(List<Membro> membros) {
        if (membros == null) {
            throw new IllegalArgumentException("A lista de membros não pode ser nula.");
        }
        this.membros = new ArrayList<>(membros); // Cópia defensiva
    }

    // Adicionar livro à biblioteca com validação
    public void adicionarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo.");
        }
        if (!livros.contains(livro)) {
            livros.add(livro);
        } else {
            System.out.println("Este livro já está cadastrado.");
        }
    }

    // Listar todos os livros
    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado na biblioteca.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    // Adicionar membro à biblioteca com validação
    public void adicionarMembro(Membro membro) {
        if (membro == null) {
            throw new IllegalArgumentException("Membro não pode ser nulo.");
        }
        if (!membros.contains(membro)) {
            membros.add(membro);
        } else {
            System.out.println("Este membro já está cadastrado.");
        }
    }

    // Listar todos os membros
    public void listarMembros() {
        if (membros.isEmpty()) {
            System.out.println("Nenhum membro cadastrado na biblioteca.");
        } else {
            for (Membro membro : membros) {
                System.out.println(membro);
            }
        }
    }

    public Livro buscarLivroPorISBN(String isbn) {
        for (Livro livro : livros) {  // Assumindo que 'livros' é a lista de livros da biblioteca
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;  // Retorna null se o livro não for encontrado
    }

    public Membro buscarMembroPorId(int idMembro) {
        for (Membro membro : membros) {  // Assumindo que 'membros' é a lista de membros da biblioteca
            if (membro.getIdMembro() == idMembro) {
                return membro;
            }
        }
        return null;  // Retorna null se o membro não for encontrado
    }


    // Listar livros de um autor específico
    public void listarLivrosPorAutor(String nomeAutor) {
        boolean encontrou = false;
        for (Livro livro : livros) {
            System.out.println("Verificando o autor: " + livro.getAutor().getNome());  // Adicionado para debug
            if (livro.getAutor().getNome().equalsIgnoreCase(nomeAutor)) {
                System.out.println(livro);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum livro encontrado para o autor: " + nomeAutor);
        }
    }
}
