package model;

import java.time.LocalDate;

public class Autor {
    private String nome;
    private String nacionalidade;
    private String dataNascimento;

    // Construtor padrão
    public Autor() {}

    // Construtor com argumentos
    public Autor(String nome, String nacionalidade, String dataNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }


    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Autor: " + nome + ", Nacionalidade: " + nacionalidade + ", Nascimento: " + dataNascimento;
    }
}
