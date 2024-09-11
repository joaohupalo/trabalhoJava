package model;


import model.ENUM.TipoMembro;

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

    // Função estática para criar membros usando enum TipoMembro
    public static Membro criarMembro(String nome, int id, TipoMembro tipo, String atributoEspecifico) {
        switch (tipo) {
            case ESTUDANTE:
                return new Estudante(nome, id, atributoEspecifico); // atributoEspecifico será o curso
            case PROFESSOR:
                return new Professor(nome, id, atributoEspecifico); // atributoEspecifico será o departamento
            default:
                throw new IllegalArgumentException("Tipo de Membro desconhecido: " + tipo);
        }
    }

    @Override
    public String toString() {
        return "Membro: " + nome + ", ID: " + idMembro;
    }
}
