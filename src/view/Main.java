import model.*;
import model.ENUM.TipoMembro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
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
                System.out.println("8. Verificar Disponibilidade de Livro");
                System.out.println("9. Ver Histórico de Empréstimos do Membro");
                System.out.println("10. Sair");
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
                        verificarDisponibilidadeLivro(biblioteca, scanner);
                        break;
                    case 9:
                        verHistoricoEmprestimosMembro(biblioteca, scanner);
                        break;
                    case 10:
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

        // Criando membros
        Membro estudante1 = Membro.criarMembro("Alice", 1, TipoMembro.ESTUDANTE, "Ciência da Computação");
        Membro professor1 = Membro.criarMembro("Dr. João", 2, TipoMembro.PROFESSOR, "Física");

        // Adicionando membros à biblioteca
        biblioteca.adicionarMembro(estudante1);
        biblioteca.adicionarMembro(professor1);

        System.out.println("Biblioteca populada com dados iniciais!");
    }

    public static void adicionarLivro(Biblioteca biblioteca, Scanner scanner) {
        try {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            System.out.print("Nome do Autor: ");
            String nomeAutor = scanner.nextLine();
            System.out.print("Nacionalidade do Autor: ");
            String nacionalidade = scanner.nextLine();
            System.out.print("Data de Nascimento do Autor (dd/mm/yyyy): ");
            String dataNascimento = scanner.nextLine();
            if (!validarData(dataNascimento)) {
                throw new IllegalArgumentException("Formato de data inválido. Use o formato dd/mm/yyyy.");
            }

            Autor autor = new Autor(nomeAutor, nacionalidade, dataNascimento);

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            Livro livro = new Livro(titulo, autor, isbn);
            biblioteca.adicionarLivro(livro);
            System.out.println("Livro adicionado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar o livro. Por favor, tente novamente.");
        }
    }

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
                throw new IllegalArgumentException("Tipo de membro inválido. Escolha 1 para Estudante ou 2 para Professor.");
            }
            System.out.println("Membro adicionado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada. Certifique-se de digitar um número válido.");
            scanner.nextLine(); // Limpar entrada inválida
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar membro. Por favor, tente novamente.");
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
                if (livro.isDisponivel()) {
                    membro.registrarEmprestimo(livro);
                    System.out.println("Empréstimo realizado com sucesso.");
                } else {
                    System.out.println("O livro não está disponível para empréstimo.");
                }
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
                System.out.println("Devolução realizada com sucesso.");
            } else {
                System.out.println("Livro ou Membro não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao devolver livro. Verifique os dados e tente novamente.");
        }
    }

    // Função para validar data no formato dd/MM/yyyy
    public static boolean validarData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void listarLivrosPorAutor(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scanner.nextLine();
        biblioteca.listarLivrosPorAutor(nomeAutor);
    }

    public static void verificarDisponibilidadeLivro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        Livro livro = biblioteca.buscarLivroPorISBN(isbn);
        if (livro != null) {
            if (livro.isDisponivel()) {
                System.out.println("O livro está disponível.");
            } else {
                System.out.println("O livro está emprestado.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void verHistoricoEmprestimosMembro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("ID do Membro: ");
        int idMembro = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        Membro membro = biblioteca.buscarMembroPorId(idMembro);

        if (membro != null) {
            List<Livro> historico = membro.getHistoricoEmprestimos();
            if (historico.isEmpty()) {
                System.out.println("Nenhum empréstimo registrado.");
            } else {
                System.out.println("Histórico de Empréstimos:");
                for (Livro livro : historico) {
                    System.out.println(livro.getTitulo());
                }
            }
        } else {
            System.out.println("Membro não encontrado.");
        }
    }
}
