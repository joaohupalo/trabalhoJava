package view;


import model.*;
import model.ENUM.TipoMembro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        povoarBiblioteca(biblioteca);

        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("\n--- Sistema de Biblioteca ---");
                System.out.println("1. Adicionar Livro");
                System.out.println("2. Listar Livros");
                System.out.println("3. Adicionar Membro");
                System.out.println("4. Listar Membros");
                System.out.println("5. Emprestar Livro");
                System.out.println("6. Devolver Livro");
                System.out.println("7. Listar Livros por Autor");
                System.out.println("8. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                switch (opcao) {
                    case 1:
                        adicionarLivro(biblioteca, scanner);
                        break;
                    case 2:
                        biblioteca.listarLivros();
                        break;
                    case 3:
                        adicionarMembro(biblioteca, scanner);
                        break;
                    case 4:
                        biblioteca.listarMembros();
                        break;
                    case 5:
                        emprestarLivro(biblioteca, scanner);
                        break;
                    case 6:
                        devolverLivro(biblioteca, scanner);
                        break;
                    case 7:
                        listarLivrosPorAutor(biblioteca, scanner);
                        break;
                    case 8:
                        continuar = false;
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro de entrada. Por favor, insira uma opção válida.");
                scanner.nextLine(); // Limpar entrada inválida
            }
        }
        scanner.close(); // Fechar o scanner ao final
    }


    // Função para pré-povoar a biblioteca com dados iniciais
    public static void povoarBiblioteca(Biblioteca biblioteca) {
        // Criando autores
        Autor autor1 = new Autor("George Orwell", "Britânico", "25/06/1903");
        Autor autor2 = new Autor("J.K. Rowling", "Britânica", "31/07/1965");

        // Criando livros
        Livro livro1 = new Livro("1984", autor1, "123-456-789");
        Livro livro2 = new Livro("Harry Potter e a Pedra Filosofal", autor2, "987-654-321");

        // Adicionando livros à biblioteca
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        // Criando membros (Estudantes e Professores)
        Membro estudante1 = Membro.criarMembro("Alice", 1, TipoMembro.ESTUDANTE, "Ciência da Computação");
        Membro professor1 = Membro.criarMembro("Dr. João", 2, TipoMembro.PROFESSOR, "Física");

        // Adicionando membros à biblioteca
        biblioteca.adicionarMembro(estudante1);
        biblioteca.adicionarMembro(professor1);

        System.out.println("Biblioteca populada com dados iniciais!");
    }

    public static void listarLivrosPorAutor(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine();
        biblioteca.listarLivrosPorAutor(nomeAutor);
    }


    // Função para adicionar livro
    public static void adicionarLivro(Biblioteca biblioteca, Scanner scanner) {
        try {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Nome do Autor: ");
            String nomeAutor = scanner.nextLine();
            System.out.print("Nacionalidade do Autor: ");
            String nacionalidade = scanner.nextLine();
            System.out.print("Data de Nascimento do Autor: ");
            String dataNascimento = scanner.nextLine();
            Autor autor = new Autor(nomeAutor, nacionalidade, dataNascimento);

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            Livro livro = new Livro(titulo, autor, isbn);
            biblioteca.adicionarLivro(livro);
            System.out.println("Livro adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar o livro. Por favor, tente novamente.");
        }
    }

    public static void emprestarLivro(Biblioteca biblioteca, Scanner scanner) {
        try {
            System.out.print("ID do Membro: ");
            int idMembro = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            System.out.print("ISBN do Livro: ");
            String isbn = scanner.nextLine();

            Livro livro = biblioteca.buscarLivroPorISBN(isbn);
            Membro membro = biblioteca.buscarMembroPorId(idMembro);

            if (livro != null && membro != null) {
                membro.registrarEmprestimo(livro);
            } else {
                System.out.println("Livro ou Membro não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao emprestar livro. Verifique os dados e tente novamente.");
        }
    }

    public static void devolverLivro(Biblioteca biblioteca, Scanner scanner) {
        try {
            System.out.print("ID do Membro: ");
            int idMembro = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            System.out.print("ISBN do Livro: ");
            String isbn = scanner.nextLine();

            Livro livro = biblioteca.buscarLivroPorISBN(isbn);
            Membro membro = biblioteca.buscarMembroPorId(idMembro);

            if (livro != null && membro != null) {
                membro.registrarDevolucao(livro);
            } else {
                System.out.println("Livro ou Membro não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao devolver livro. Verifique os dados e tente novamente.");
        }
    }

    // Função para adicionar membro
    public static void adicionarMembro(Biblioteca biblioteca, Scanner scanner) {
        try {
            System.out.print("Nome do Membro: ");
            String nome = scanner.nextLine();
            System.out.print("ID do Membro: ");
            int idMembro = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            System.out.println("Tipo de Membro: (1) Estudante, (2) Professor");
            int tipo = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            if (tipo == 1) {
                System.out.print("Curso: ");
                String curso = scanner.nextLine();
                Estudante estudante = new Estudante(nome, idMembro, curso);
                biblioteca.adicionarMembro(estudante);
            } else if (tipo == 2) {
                System.out.print("Departamento: ");
                String departamento = scanner.nextLine();
                Professor professor = new Professor(nome, idMembro, departamento);
                biblioteca.adicionarMembro(professor);
            } else {
                System.out.println("Tipo de membro inválido.");
            }
            System.out.println("Membro adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada. Verifique os dados e tente novamente.");
            scanner.nextLine(); // Limpar entrada inválida
        } catch (Exception e) {
            System.out.println("Erro ao adicionar membro. Por favor, tente novamente.");
        }
    }
}
