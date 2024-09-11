package model;


import java.util.ArrayList;
import java.util.List;

public abstract class Membro {
    private String nome;
    private int idMembro;
    private List<Livro> historicoEmprestimos;

    // Construtor padrão
    public Membro() {
        this.historicoEmprestimos = new ArrayList<>();
    }

    // Construtor com argumentos
    public Membro(String nome, int idMembro) {
        this.nome = nome;
        this.idMembro = idMembro;
        this.historicoEmprestimos = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(int idMembro) {
        this.idMembro = idMembro;
    }

    public List<Livro> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    // Método para adicionar livro ao histórico de empréstimos
    public void registrarEmprestimo(Livro livro) {
        historicoEmprestimos.add(livro);
        livro.emprestarLivro();
    }

    // Método para registrar a devolução do livro
    public void registrarDevolucao(Livro livro) {
        historicoEmprestimos.remove(livro);
        livro.devolverLivro();
    }

    @Override
    public String toString() {
        return "Membro: " + nome + ", ID: " + idMembro;
    }
}
