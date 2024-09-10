package view;

import model.*;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        inicializarDados();

        int opcao = 0;
        do {
            System.out.println("==== Sistema de Biblioteca ====");
            System.out.println("1. Adicionar novo livro");
            System.out.println("2. Adicionar novo estudante");
            System.out.println("3. Adicionar novo professor");
            System.out.println("4. Emprestar livro");
            System.out.println("5. Devolver livro");
            System.out.println("6. Verificar disponibilidade de livro");
            System.out.println("7. Listar livros disponíveis");
            System.out.println("8. Listar todos os livros");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarNovoLivro();
                    break;
                case 2:
                    adicionarNovoEstudante();
                    break;
                case 3:
                    adicionarNovoProfessor();
                    break;
                case 4:
                    emprestarLivro();
                    break;
                case 5:
                    devolverLivro();
                    break;
                case 6:
                    verificarDisponibilidade();
                    break;
                case 7:
                    listarLivrosDisponiveis();
                    break;
                case 8:
                    listarTodosLivros();
                    break;
                case 9:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);
    }

}
