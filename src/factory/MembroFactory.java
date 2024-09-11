package factory;

import ENUM.TipoMembro;
import model.Estudante;
import model.Membro;
import model.Professor;

public class MembroFactory {
    public static Membro criarMembro(TipoMembro tipo, String nome, int idMembro, String detalhe) {
        switch (tipo) {
            case ESTUDANTE:
                return new Estudante(nome, idMembro, detalhe);
            case PROFESSOR:
                return new Professor(nome, idMembro, detalhe);
            default:
                throw new IllegalArgumentException("Tipo de membro inválido.");
        }
    }
}
