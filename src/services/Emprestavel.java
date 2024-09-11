package services;

import model.Livro;

public interface Emprestavel {
    void emprestarLivro(Livro livro) throws Exception;
    void devolverLivro(Livro livro) throws Exception;
}
