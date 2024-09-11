package model;
import java.util.Date;

public class Emprestimo {
    private Membro membro;
    private Livro livro;
    private Date dataEmprestimo;

    public Emprestimo(Membro membro, Livro livro, Date dataEmprestimo) {
        this.membro = membro;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Empréstimo: " + membro.getNome() + " emprestou o livro '" + livro.getTitulo() + "' em " + dataEmprestimo;
    }
}
