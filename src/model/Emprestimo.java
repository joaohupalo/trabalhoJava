package model;

import java.time.LocalDateTime;


public class Emprestimo {
    private Membro quemEmprestou;
    private Livro livro;
    private LocalDateTime dateTimeEmprestimo;
    private LocalDateTime dateTimeDevolucao;
    private Boolean devolvido;

    // construtor
    public Emprestimo(Membro quemEmprestou, Livro livro, LocalDateTime dateTimeEmprestimo) {
        this.quemEmprestou = quemEmprestou;
        this.livro = livro;
        this.dateTimeEmprestimo = dateTimeEmprestimo;
        this.devolvido = false;
    }

    // contrutor default
    public Emprestimo() {
        this.quemEmprestou = new Membro();
        this.livro = new Livro();
        this.dateTimeEmprestimo = null;
        this.devolvido = false;
    }

    // getters and setters

    public Membro getQuemEmprestou() {
        return quemEmprestou;
    }

    public void setQuemEmprestou(Membro quemEmprestou) {
        this.quemEmprestou = quemEmprestou;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDateTime getDateTimeEmprestimo() {
        return dateTimeEmprestimo;
    }

    public void setDateTimeEmprestimo(LocalDateTime dateTimeEmprestimo) {
        this.dateTimeEmprestimo = dateTimeEmprestimo;
    }

    public LocalDateTime getDateTimeDevolucao() {
        return dateTimeDevolucao;
    }

    public void setDateTimeDevolucao(LocalDateTime dateTimeDevolucao) {
        this.dateTimeDevolucao = dateTimeDevolucao;
    }

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }
    // Método para devolver o livro
    public void devolverLivro() {
        this.dateTimeDevolucao = LocalDateTime.now(); // Define a data/hora de devolução como o momento atual
        this.devolvido = true;
    }

    // toString
    @Override
    public String toString() {
        return "Emprestimo{" +
                "quemEmprestou=" + quemEmprestou +
                ", livro=" + livro +
                ", dateTimeEmprestimo=" + dateTimeEmprestimo +
                ", dateTimeDevolucao=" + dateTimeDevolucao +
                ", devolvido=" + devolvido +
                '}';
    }
}
