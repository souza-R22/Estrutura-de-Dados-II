package arvoreLivros;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArvoreLivros arvore = new ArvoreLivros();

        arvore.inserir(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        arvore.inserir(new Livro("O Hobbit", "J. R. R. Tolkien", 1937));
        arvore.inserir(new Livro("1984", "George Orwell", 1949));
        arvore.inserir(new Livro("A Revolução dos Bichos", "George Orwell", 1945));
        arvore.inserir(new Livro("Harry Potter", "J. K. Rowling", 1997));
        arvore.inserir(new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943));
        arvore.inserir(new Livro("Percy Jackson", "Rick Riordan", 2005));
        arvore.inserir(new Livro("Código Limpo", "Robert C. Martin", 2008));

        int opcao;

        do {

            System.out.println("\n========== CATÁLOGO DE LIVROS ==========");
            System.out.println("1 - Inserir livro");
            System.out.println("2 - Buscar livro");
            System.out.println("3 - Remover livro");
            System.out.println("4 - Exibir em-ordem");
            System.out.println("5 - Exibir pré-ordem");
            System.out.println("6 - Exibir pós-ordem");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Título: ");
                    String titulo = teclado.nextLine();

                    System.out.print("Autor: ");
                    String autor = teclado.nextLine();

                    System.out.print("Ano: ");
                    int ano = teclado.nextInt();
                    teclado.nextLine();

                    Livro livro = new Livro(titulo, autor, ano);
                    arvore.inserir(livro);

                    System.out.println("Livro inserido com sucesso!");
                    break;

                case 2:

                    System.out.print("Digite o título: ");
                    titulo = teclado.nextLine();

                    Livro encontrado = arvore.buscar(titulo);

                    if (encontrado != null) {
                        System.out.println("\nLivro encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }

                    break;

                case 3:

                    System.out.print("Digite o título do livro: ");
                    titulo = teclado.nextLine();

                    arvore.remover(titulo);

                    break;

                case 4:

                    System.out.println("\n=== Livros em ordem alfabética ===");
                    arvore.emOrdem();

                    break;

                case 5:

                    System.out.println("\n=== Pré-Ordem ===");
                    arvore.preOrdem();

                    break;

                case 6:

                    System.out.println("\n=== Pós-Ordem ===");
                    arvore.posOrdem();

                    break;

                case 0:

                    System.out.println("Programa encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        } while (opcao != 0);

        teclado.close();
    }
}