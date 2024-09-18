package model.ENUM;

public enum TipoMembro {
    ESTUDANTE("Estudante"),
    PROFESSOR("Professor");

    private String descricao;

    // Construtor privado
    TipoMembro(String descricao) {
        this.descricao = descricao;
    }

    // Getter para descrição
    public String getDescricao() {
        return descricao;
    }

    // Sobrescrever toString para exibir a descrição ao invés do nome constante
    @Override
    public String toString() {
        return descricao;
    }

    // Método estático para buscar por nome
    public static TipoMembro fromString(String nome) {
        for (TipoMembro tipo : TipoMembro.values()) {
            if (tipo.name().equalsIgnoreCase(nome) || tipo.getDescricao().equalsIgnoreCase(nome)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de Membro desconhecido: " + nome);
    }
}
