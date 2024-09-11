package view;
import ENUM.TipoMembro;
import factory.MembroFactory;
import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstancia();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Biblioteca ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Adicionar Membro");
            System.out.println("4. Listar Membros");
            System.out.println("5. Emprestar Livro");
            System.out.println("6. Devolver Livro");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        // Adicionar livro
                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Nome do Autor: ");
                        String nomeAutor = scanner.nextLine();
                        System.out.print("Nacionalidade do Autor: ");
                        String nacionalidade = scanner.nextLine();
                        System.out.print("Data de Nascimento do Autor (AAAA-MM-DD): ");
                        String dataNascimento = scanner.nextLine();
                        Autor autor = new Autor(nomeAutor, nacionalidade, dataNascimento);

                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();

                        Livro livro = new Livro(titulo, autor, isbn);
                        biblioteca.adicionarLivro(livro);
                        System.out.println("Livro adicionado com sucesso!");
                        break;

                    case 2:
                        // Listar livros
                        biblioteca.listarLivros().forEach(System.out::println);
                        break;

                    case 3:
                        // Adicionar membro
                        System.out.print("Nome do Membro: ");
                        String nome = scanner.nextLine();
                        System.out.print("ID do Membro: ");
                        int idMembro = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha

                        System.out.println("Tipo de Membro: (1) Estudante, (2) Professor");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();  // Consumir nova linha

                        if (tipo == 1) {
                            System.out.print("Curso: ");
                            String curso = scanner.nextLine();
                            Membro estudante = MembroFactory.criarMembro(TipoMembro.ESTUDANTE, nome, idMembro, curso);
                            biblioteca.adicionarMembro(estudante);
                        } else if (tipo == 2) {
                            System.out.print("Departamento: ");
                            String departamento = scanner.nextLine();
                            Membro professor = MembroFactory.criarMembro(TipoMembro.PROFESSOR, nome, idMembro, departamento);
                            biblioteca.adicionarMembro(professor);
                        }
                        System.out.println("Membro adicionado com sucesso!");
                        break;

                    case 4:
                        // Listar membros
                        biblioteca.listarMembros().forEach(membro -> {
                            System.out.println(membro.getNome() + " - " + membro.getDetalhes());
                        });
                        break;

                    case 5:
                        // Emprestar livro
                        System.out.print("ID do Membro: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        Membro membro = biblioteca.listarMembros().stream()
                                .filter(m -> m.getIdMembro() == id)
                                .findFirst().orElseThrow(() -> new Exception("Membro não encontrado"));

                        System.out.print("ISBN do Livro: ");
                        String isbnEmprestimo = scanner.nextLine();
                        Livro livroEmprestimo = biblioteca.listarLivros().stream()
                                .filter(l -> l.getIsbn().equals(isbnEmprestimo))
                                .findFirst().orElseThrow(() -> new Exception("Livro não encontrado"));

                        membro.emprestarLivro(livroEmprestimo);
                        break;

                    case 6:
                        // Devolver livro
                        System.out.print("ID do Membro: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        membro = biblioteca.listarMembros().stream()
                                .filter(m -> m.getIdMembro() == id)
                                .findFirst().orElseThrow(() -> new Exception("Membro não encontrado"));

                        System.out.print("ISBN do Livro: ");
                        String isbnDevolucao = scanner.nextLine();
                        Livro livroDevolucao = biblioteca.listarLivros().stream()
                                .filter(l -> l.getIsbn().equals(isbnDevolucao))
                                .findFirst().orElseThrow(() -> new Exception("Livro não encontrado"));

                        membro.devolverLivro(livroDevolucao);
                        break;

                    case 7:
                        System.out.println("Saindo do sistema...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
