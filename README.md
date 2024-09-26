# Sistema de Gerenciamento de Biblioteca

## Descrição

Este projeto implementa um sistema simples de gerenciamento de biblioteca utilizando o paradigma de programação orientada a objetos em Java. O sistema permite adicionar livros, gerenciar membros (estudantes e professores), realizar empréstimos e listar os itens na biblioteca.

## Estrutura do Projeto

- **Modelos (Classes)**:
    - `Autor`: Representa o autor de um livro, com informações como nome, nacionalidade e data de nascimento.
    - `Livro`: Armazena informações sobre um livro, como título, autor e ISBN, além de verificar se o livro está disponível.
    - `Membro`: Classe abstrata que define atributos e comportamentos comuns para diferentes tipos de membros da biblioteca.
    - `Estudante` e `Professor`: Subclasses de `Membro`, que representam tipos específicos de membros da biblioteca com informações adicionais.
    - `Emprestimo`: Representa um empréstimo de livro, associando um membro a um livro emprestado.
    - `Biblioteca`: Gerencia a coleção de livros e membros, com métodos para adicionar, listar e pesquisar por livros e membros.

- **Enumeração**:
    - `TipoMembro`: Enum utilizado para definir os tipos de membros (Estudante e Professor).

## Funcionalidades

1. **Adicionar Livros**: Permite adicionar livros à biblioteca informando o título, autor e ISBN.
2. **Listar Livros**: Exibe todos os livros disponíveis na biblioteca.
3. **Adicionar Membros**: Permite adicionar estudantes ou professores como membros da biblioteca.
4. **Listar Membros**: Exibe todos os membros cadastrados na biblioteca.
5. **Emprestar Livros**: Gerencia o empréstimo de livros para os membros.
6. **Povoar Biblioteca**: Um método de inicialização que preenche a biblioteca com dados de exemplo para facilitar o uso inicial.

## Exemplo de Uso

Ao iniciar o sistema, o usuário pode interagir através de um menu no terminal:

--- Sistema de Biblioteca ---

1. Adicionar Livro
2. Listar Livros
3. Adicionar Membro
4. Listar Membros
5. Sair

O sistema permite que o usuário adicione novos livros e membros, liste os itens existentes e saia da aplicação.

## Decisões de Design

- **Encapsulamento**: Todos os atributos das classes são privados, com métodos `getter` e `setter` para acessá-los. Isso garante o controle e a validação adequada dos dados.
- **Herança**: As classes `Estudante` e `Professor` herdam da classe abstrata `Membro`, reutilizando código comum e adicionando comportamentos específicos.
- **Uso de Enum**: O `enum` `TipoMembro` foi utilizado para restringir os tipos de membros permitidos, facilitando a criação e validação de membros.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Compile o código:
```bash
  javac -d out/production/bibliotecaControle -cp . src/view/Main.java
```
3. Executar o programa:
```bash
  java -cp .:out/production/bibliotecaControle view.Main
``` 
## Requisitos
Java 8 ou superior

##  Contribuição
Sinta-se à vontade para enviar pull requests ou abrir issues para reportar problemas e sugerir melhorias.