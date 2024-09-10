package model;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

public class Membro {
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private List <Emprestimo> listaEmprestimos;
    private String CPF;

    // Construtores
    public Membro() {
        id = 0;
        nome = "";
        this.listaEmprestimos = new ArrayList<>();
        this.dataNascimento = null;
        this.CPF = "";
    }

    public Membro(Integer id, String nome, LocalDate dataNascimento, String CPF) {
        this.id = id;
        this.nome = nome;
        this.listaEmprestimos = new ArrayList<>();
        this.dataNascimento = dataNascimento;
        this.CPF = CPF;
    }

    // getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public List<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    // Método para adicionar um empréstimo à lista
    // unica forma de muta a lista de empréstimos
    public void addEmprestimo(Emprestimo emprestimo) {
        this.listaEmprestimos.add(emprestimo);
    }
}
