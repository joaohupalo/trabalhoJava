package model;

import model.ENUM.TipoMembro;
import java.util.ArrayList;
import java.util.List;

public abstract class Membro {
    private String nome;
    private int idMembro;
    private List<Livro> historicoEmprestimos;
    private List<Livro> historicoDevolucoes;

    // Construtor padrão
    public Membro() {
        this.historicoEmprestimos = new ArrayList<>();
        this.historicoDevolucoes = new ArrayList<>();
    }


    // Construtor com validação
    public Membro(String nome, int idMembro) {
        setNome(nome);
        setIdMembro(idMembro);
        this.historicoEmprestimos = new ArrayList<>();
        this.historicoDevolucoes = new ArrayList<>();
    }

    // Getters e Setters com validação
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public int getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(int idMembro) {
        if (idMembro <= 0) {
            throw new IllegalArgumentException("ID do Membro deve ser maior que zero.");
        }
        this.idMembro = idMembro;
    }

    public List<Livro> getHistoricoEmprestimos() {
        return new ArrayList<>(historicoEmprestimos); // Cópia defensiva
    }

    public List<Livro> getHistoricoDevolucoes() {
        return new ArrayList<>(historicoDevolucoes); // Cópia defensiva
    }


    // Método para registrar empréstimo de um livro
    public void registrarEmprestimo(Livro livro) {
        if (livro == null || !livro.isDisponivel()) {
            throw new IllegalArgumentException("O livro não pode ser nulo e deve estar disponível.");
        }
        historicoEmprestimos.add(livro);
        livro.emprestarLivro();
    }

    // Método para registrar a devolução do livro
    public void registrarDevolucao(Livro livro) {
        if (livro == null || !historicoEmprestimos.contains(livro)) {
            throw new IllegalArgumentException("Este livro não está registrado no histórico de empréstimos.");
        }
        historicoDevolucoes.add(livro);
        livro.devolverLivro();
    }

    // Função estática para criar membros com base no TipoMembro
    public static Membro criarMembro(String nome, int id, TipoMembro tipo, String atributoEspecifico) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID do Membro deve ser maior que zero.");
        }
        if (atributoEspecifico == null || atributoEspecifico.trim().isEmpty()) {
            throw new IllegalArgumentException("Atributo específico não pode ser nulo ou vazio.");
        }

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
