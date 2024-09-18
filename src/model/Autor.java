package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Autor {
    private String nome;
    private String nacionalidade;
    private String dataNascimento;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Autor() {}

    public Autor(String nome, String nacionalidade, String dataNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        setDataNascimento(dataNascimento); // Usa o setter que valida a data
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        try {
            dateFormat.setLenient(false); // Força a validação estrita da data
            dateFormat.parse(dataNascimento); // Tenta fazer o parsing da data
            this.dataNascimento = dataNascimento;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data de nascimento inválida. Use o formato dd/MM/yyyy.");
        }
    }

    @Override
    public String toString() {
        return "Autor: " + nome + ", Nacionalidade: " + nacionalidade + ", Nascimento: " + dataNascimento;
    }

    public String getNome() {
        return nome;
    }
}
