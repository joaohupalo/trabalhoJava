package model;
import services.Emprestavel;

import java.util.ArrayList;
import java.util.List;

public abstract class Membro implements Emprestavel {
    private String nome;
    private int idMembro;
    private List<Livro> historicoEmprestimos;

    public Membro(String nome, int idMembro) {
        this.nome = nome;
        this.idMembro = idMembro;
        this.historicoEmprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdMembro() {
        return idMembro;
    }

    public List<Livro> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    @Override
    public void emprestarLivro(Livro livro) throws Exception {
        if (!livro.isDisponivel()) {
            throw new Exception("Livro indisponível.");
        }
        historicoEmprestimos.add(livro);
        livro.emprestar(java.time.LocalDate.now());
        System.out.println(nome + " emprestou o livro: " + livro.getTitulo());
    }

    @Override
    public void devolverLivro(Livro livro) throws Exception {
        if (!historicoEmprestimos.contains(livro)) {
            throw new Exception("Este livro não foi emprestado por este membro.");
        }
        historicoEmprestimos.remove(livro);
        livro.devolver();
        System.out.println(nome + " devolveu o livro: " + livro.getTitulo());
    }

    public abstract String getDetalhes();
}
