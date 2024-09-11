
Explicação Detalhada do Sistema de Biblioteca em Java
Este documento explica como o código de um sistema de gestão de uma biblioteca em Java funciona. O código segue os princípios de Programação Orientada a Objetos (POO), utilizando conceitos como herança, interfaces, enums, padrão de projeto Singleton, e Factory.

1. Interface Emprestavel
   `public interface Emprestavel {
   void emprestarLivro(Livro livro) throws Exception;
   void devolverLivro(Livro livro) throws Exception;
   }`
   Explicação:
   Interface: A interface define um contrato que classes que a implementam devem seguir.
   Aqui, a interface Emprestavel define dois métodos: emprestarLivro() e devolverLivro().
   Qualquer classe que implementa essa interface (como Membro) precisa fornecer a implementação desses métodos.
   Uso da Interface: Ao invés de forçar uma herança, a interface permite que classes não relacionadas (ou com herança diferente) compartilhem o comportamento de emprestar e devolver livros.
2. Classe Autor

   import java.time.LocalDate;

public class Autor {
private String nome;
private String nacionalidade;
private LocalDate dataNascimento;

    public Autor(String nome, String nacionalidade, LocalDate dataNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Autor: " + nome + ", Nacionalidade: " + nacionalidade + ", Nascimento: " + dataNascimento;
    }
}
Explicação:
Atributos privados: Os atributos nome, nacionalidade, e dataNascimento são privados, o que segue o princípio de encapsulamento, protegendo-os de acessos externos.
Construtor: O construtor inicializa os atributos do autor quando um objeto da classe é criado.
Getters: Métodos de acesso são usados para retornar os valores dos atributos privados, permitindo o controle sobre o acesso aos dados.
Método toString(): Sobrescreve o método para fornecer uma saída amigável do objeto Autor ao ser impresso.
3. Classe Livro
   java
   Copiar código
   import java.time.LocalDate;

public class Livro {
private String titulo;
private Autor autor;
private String isbn;
private boolean disponivel;
private LocalDate dataEmprestimo;
private LocalDate dataDevolucao;

    public Livro(String titulo, Autor autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar(LocalDate dataEmprestimo) throws Exception {
        if (!disponivel) {
            throw new Exception("O livro '" + titulo + "' já está emprestado.");
        }
        this.disponivel = false;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataEmprestimo.plusDays(14); // 14 dias para devolução
    }

    public void devolver() throws Exception {
        if (disponivel) {
            throw new Exception("O livro '" + titulo + "' já foi devolvido.");
        }
        this.disponivel = true;
        this.dataEmprestimo = null;
        this.dataDevolucao = null;
    }
}
Explicação:
Atributos: A classe Livro contém atributos como titulo, autor, isbn, e disponivel. O atributo disponivel é booleano e indica se o livro pode ser emprestado.
Métodos de Empréstimo e Devolução:
emprestar: Verifica se o livro está disponível. Se sim, marca o livro como emprestado e define as datas de empréstimo e devolução.
devolver: Verifica se o livro já foi devolvido, e se não, marca-o como disponível novamente.
Encapsulamento: Todos os atributos são privados e só podem ser acessados por meio de métodos públicos (getters e setters).
4. Classe Abstrata Membro
   java
   Copiar código
   public abstract class Membro implements Emprestavel {
   private String nome;
   private int idMembro;
   private List<Livro> historicoEmprestimos;

   public Membro(String nome, int idMembro) {
   this.nome = nome;
   this.idMembro = idMembro;
   this.historicoEmprestimos = new ArrayList<>();
   }

   @Override
   public void emprestarLivro(Livro livro) throws Exception {
   if (!livro.isDisponivel()) {
   throw new Exception("Livro indisponível.");
   }
   historicoEmprestimos.add(livro);
   livro.emprestar(LocalDate.now());
   }

   @Override
   public void devolverLivro(Livro livro) throws Exception {
   if (!historicoEmprestimos.contains(livro)) {
   throw new Exception("Este livro não foi emprestado por este membro.");
   }
   historicoEmprestimos.remove(livro);
   livro.devolver();
   }

   public abstract String getDetalhes();
   }
   Explicação:
   Classe Abstrata: A classe Membro é abstrata, o que significa que não pode ser instanciada diretamente. Isso obriga as subclasses (como Estudante e Professor) a fornecer uma implementação do método getDetalhes.
   Herança e Interface: Membro implementa a interface Emprestavel, então qualquer classe que herde Membro herdará também os métodos para emprestar e devolver livros.
   Atributos: Além de nome e idMembro, a classe contém um historicoEmprestimos, que registra todos os livros emprestados pelo membro.
5. Subclasses Estudante e Professor
   java
   Copiar código
   public class Estudante extends Membro {
   private String curso;

   public Estudante(String nome, int idMembro, String curso) {
   super(nome, idMembro);
   this.curso = curso;
   }

   @Override
   public String getDetalhes() {
   return "Estudante do curso: " + curso;
   }
   }
   java
   Copiar código
   public class Professor extends Membro {
   private String departamento;

   public Professor(String nome, int idMembro, String departamento) {
   super(nome, idMembro);
   this.departamento = departamento;
   }

   @Override
   public String getDetalhes() {
   return "Professor do departamento: " + departamento;
   }
   }
   Explicação:
   Herança: As classes Estudante e Professor estendem Membro, herdando todos os atributos e métodos da classe base.
   Polimorfismo: Cada classe tem sua própria implementação de getDetalhes, fornecendo uma descrição específica para estudantes e professores.
   Construtores: Cada subclasse chama o construtor da superclasse Membro para inicializar os atributos herdados, usando o método super().
6. Singleton - Classe Biblioteca
   java
   Copiar código
   import java.util.ArrayList;
   import java.util.List;

public class Biblioteca {
private static Biblioteca instancia;
private List<Livro> livros;
private List<Membro> membros;

    private Biblioteca() {
        livros = new ArrayList<>();
        membros = new ArrayList<>();
    }

    public static Biblioteca getInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }
}
Explicação:
Padrão Singleton: A classe Biblioteca usa o padrão de projeto Singleton, que garante que exista apenas uma instância da biblioteca durante o ciclo de vida da aplicação.
O método getInstancia() verifica se a instância já foi criada. Se não, cria uma nova instância.
Vantagem: Isso impede a criação de múltiplas instâncias da biblioteca, garantindo que os dados sejam centralizados.
7. Factory - MembroFactory
   java
   Copiar código
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
   Explicação:
   Padrão Factory: O padrão de fábrica é usado para criar objetos sem expor a lógica de criação ao cliente.
   MembroFactory é responsável por criar diferentes tipos de membros (Estudante ou Professor) com base no TipoMembro fornecido.
   Vantagem: Desacopla a criação de objetos complexos do código principal, melhorando a legibilidade e manutenibilidade.
8. Enum - TipoMembro
   java
   Copiar código
   public enum TipoMembro {
   ESTUDANTE,
   PROFESSOR
   }
   Explicação:
   Enumeração: TipoMembro define um conjunto fixo de constantes, que representam os tipos de membros possíveis: ESTUDANTE e PROFESSOR.
   Vantagem: Utilizar enum torna o código mais seguro e legível, evitando erros de digitação ou valores inválidos ao trabalhar com tipos.
9. Classe Main - Aplicativo
   java
   Copiar código
   import java.util.Scanner;

public class BibliotecaApp {
public static void main(String[] args) {
Biblioteca biblioteca = Biblioteca.getInstancia();
Scanner scanner = new Scanner(System.in);

        // Exemplo básico de uso
        Autor autor = new Autor("J.K. Rowling", "Britânica", LocalDate.of(1965, 7, 31));
        Livro livro = new Livro("Harry Potter", autor, "123456789");

        biblioteca.adicionarLivro(livro);

        Membro estudante = MembroFactory.criarMembro(TipoMembro.ESTUDANTE, "João", 1, "Ciências da Computação");
        biblioteca.adicionarMembro(estudante);

        try {
            estudante.emprestarLivro(livro);
            System.out.println("Livro emprestado: " + livro.getTitulo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
Explicação:
Main: O ponto de entrada do programa. Ele configura o sistema de biblioteca, cria alguns objetos como autores, livros, membros e demonstra como eles interagem.
Factory em Ação: Utiliza o padrão Factory para criar um membro do tipo Estudante.
Singleton em Ação: Biblioteca.getInstancia() é usado para garantir que estamos interagindo com a única instância da biblioteca.