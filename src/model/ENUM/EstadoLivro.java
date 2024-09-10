package model.ENUM;

public enum EstadoLivro {
    DISPONIVEL,    // Quando o livro está disponível para empréstimo
    EMPRESTADO,    // Quando o livro está emprestado
    ATRASADO,      // Quando o prazo de devolução foi ultrapassado
    RESERVADO      // Caso você queira permitir a reserva de livros
}