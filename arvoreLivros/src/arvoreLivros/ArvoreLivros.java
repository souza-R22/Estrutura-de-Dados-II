package arvoreLivros;

public class ArvoreLivros {

    // Raiz da árvore.
    // É o primeiro nó e serve como ponto de partida para todas as operações.
    private No raiz;

    // Construtor da árvore.
    // Inicializa a árvore vazia.
    public ArvoreLivros() {
        raiz = null;
    }

    // Método público de inserção.
    // Recebe um livro e inicia a inserção pela raiz.
    public void inserir(Livro livro) {
        raiz = inserir(raiz, livro);
    }

    // Método recursivo responsável por inserir um livro.
    private No inserir(No atual, Livro livro) {

        // Se chegou a uma posição vazia,
        // cria um novo nó com o livro.
        if (atual == null) {
            return new No(livro);
        }

        // Compara o livro recebido com o livro do nó atual.
        // Se for menor, continua procurando pela esquerda.
        if (livro.compareTo(atual.livro) < 0) {

            atual.esquerda = inserir(atual.esquerda, livro);

        }
        // Se for maior, continua procurando pela direita.
        else if (livro.compareTo(atual.livro) > 0) {

            atual.direita = inserir(atual.direita, livro);

        }

        // Retorna o nó atual para manter a estrutura da árvore.
        return atual;
    }

    // Método público de busca.
    // Recebe o título do livro e chama o método recursivo.
    public Livro buscar(String titulo) {

        No encontrado = buscar(raiz, titulo);

        // Se encontrou o livro, retorna o objeto.
        if (encontrado != null) {
            return encontrado.livro;
        }

        // Caso contrário retorna null.
        return null;
    }

    // Método recursivo responsável pela busca.
    private No buscar(No atual, String titulo) {

        // Se chegou ao final da árvore,
        // significa que o livro não existe.
        if (atual == null) {
            return null;
        }

        // Compara o título informado com o título do nó atual.
        int comparacao = titulo.compareToIgnoreCase(atual.livro.getTitulo());

        // Se encontrou o título, retorna o nó.
        if (comparacao == 0) {
            return atual;
        }

        // Se o título for menor,
        // continua procurando na esquerda.
        if (comparacao < 0) {
            return buscar(atual.esquerda, titulo);
        }

        // Caso contrário procura na direita.
        return buscar(atual.direita, titulo);

    }

    // Método público de remoção.
    // Inicia a remoção pela raiz.
    public void remover(String titulo) {
        raiz = remover(raiz, titulo);
    }

    // Método recursivo responsável pela remoção.
    private No remover(No atual, String titulo) {

        // Caso o nó não exista.
        if (atual == null) {
            return null;
        }

        // Compara o título informado com o título atual.
        int comparacao = titulo.compareToIgnoreCase(atual.livro.getTitulo());

        // Continua procurando na esquerda.
        if (comparacao < 0) {

            atual.esquerda = remover(atual.esquerda, titulo);

        }
        // Continua procurando na direita.
        else if (comparacao > 0) {

            atual.direita = remover(atual.direita, titulo);

        }
        // Encontrou o livro que será removido.
        else {

            // ===== CASO 1 =====
            // O nó não possui filhos.
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }

            // ===== CASO 2 =====
            // Possui apenas filho à direita.
            if (atual.esquerda == null) {
                return atual.direita;
            }

            // ===== CASO 2 =====
            // Possui apenas filho à esquerda.
            if (atual.direita == null) {
                return atual.esquerda;
            }

            // ===== CASO 3 =====
            // O nó possui dois filhos.

            // Procura o menor elemento da subárvore direita
            // (sucessor).
            No sucessor = menorNo(atual.direita);

            // Copia os dados do sucessor para o nó atual.
            atual.livro = sucessor.livro;

            // Remove o sucessor da posição original.
            atual.direita = remover(atual.direita,
                    sucessor.livro.getTitulo());

        }

        // Retorna o nó atualizado.
        return atual;

    }

    // Método que encontra o menor nó
    // de uma determinada subárvore.
    private No menorNo(No atual) {

        // Enquanto existir um filho à esquerda,
        // continua caminhando.
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }

        // Retorna o menor nó encontrado.
        return atual;

    }

    // Percurso Em Ordem.
    // Exibe os livros em ordem crescente.
    public void emOrdem() {

        // Verifica se a árvore está vazia.
        if (raiz == null) {
            System.out.println("\nÁrvore vazia.");
            return;
        }

        emOrdem(raiz);

    }

    // Método recursivo do percurso Em Ordem.
    private void emOrdem(No atual) {

        if (atual != null) {

            // Visita a esquerda.
            emOrdem(atual.esquerda);

            // Visita a raiz.
            System.out.println("---------------------------");
            System.out.println(atual.livro);

            // Visita a direita.
            emOrdem(atual.direita);

        }

    }

    // Percurso Pré-Ordem.
    public void preOrdem() {

        if (raiz == null) {
            System.out.println("\nÁrvore vazia.");
            return;
        }

        preOrdem(raiz);

    }

    // Método recursivo do percurso Pré-Ordem.
    private void preOrdem(No atual) {

        if (atual != null) {

            // Primeiro visita a raiz.
            System.out.println("---------------------------");
            System.out.println(atual.livro);

            // Depois esquerda.
            preOrdem(atual.esquerda);

            // Depois direita.
            preOrdem(atual.direita);

        }

    }

    // Percurso Pós-Ordem.
    public void posOrdem() {

        if (raiz == null) {
            System.out.println("\nÁrvore vazia.");
            return;
        }

        posOrdem(raiz);

    }

    // Método recursivo do percurso Pós-Ordem.
    private void posOrdem(No atual) {

        if (atual != null) {

            // Primeiro visita a esquerda.
            posOrdem(atual.esquerda);

            // Depois a direita.
            posOrdem(atual.direita);

            // Por último visita a raiz.
            System.out.println("---------------------------");
            System.out.println(atual.livro);

        }

    }

}