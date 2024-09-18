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

    // Listar livros de um autor específico
    public void listarLivrosPorAutor(Autor autor) {
        boolean encontrou = false;
        for (Livro livro : livros) {
            if (livro.getAutor().equals(autor)) {
                System.out.println(livro);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum livro encontrado para o autor: " + autor.getNome());
        }
    }
}
