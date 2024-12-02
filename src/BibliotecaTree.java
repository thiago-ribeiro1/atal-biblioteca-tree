import java.util.ArrayList;
import java.util.List;

public class BibliotecaTree<TIPO extends Comparable<TIPO>> {
    private Elemento<TIPO> raiz;

    // Adiciona um novo elemento na árvore
    public void adicionar(TIPO valor) {
        // Cria um novo nó da árvore com o valor fornecido
        Elemento<TIPO> novo = new Elemento<>(valor);

        // Verifica se a raiz está vazia (árvore sem elementos)
        if (raiz == null) {
            // Se estiver vazia, define o novo elemento como a raiz da árvore
            raiz = novo;
        } else {
            // Se a raiz não estiver vazia, chama o método recursivo para encontrar
            // o local na árvore para adicionar o novo elemento
            adicionarRecursivo(raiz, novo);
        }
    }

    // Método recursivo para adicionar na árvore binária
    private void adicionarRecursivo(Elemento<TIPO> atual, Elemento<TIPO> novo) {
        if (novo.getValor().compareTo(atual.getValor()) < 0) { // Se o valor do novo nó for menor, vai para a esquerda
            // verifica se já existe um nó na esquerda
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novo); // adiciona o novo elemento na esquerda
            } else {
                adicionarRecursivo(atual.getEsquerda(), novo); // Caso contrário, continua a recursão na subárvore esquerda
            }
        } else { // Se o valor do novo nó for maior, vai para a direita
            // verifica se já existe algum nó na direita
            if (atual.getDireita() == null) {
                atual.setDireita(novo); // adiciona o novo elemento na direita
            } else {
                adicionarRecursivo(atual.getDireita(), novo); // Caso contrário, continua a recursão na subárvore direita
            }
        }
    }

    // Método para buscar livros por autor
    public List<TIPO> buscarPorAutor(String autor) {
        List<TIPO> livrosEncontrados = new ArrayList<>();
        buscarPorAutorRecursivo(raiz, autor, livrosEncontrados);
        return livrosEncontrados;
    }

    private void buscarPorAutorRecursivo(Elemento<TIPO> atual, String autor, List<TIPO> livrosEncontrados) {
        if (atual != null) {
            // Verifica se o autor do livro no nó atual corresponde ao autor desejado
            Book livro = (Book) atual.getValor();
            if (livro.getAuthor().equalsIgnoreCase(autor)) {
                livrosEncontrados.add((TIPO) livro);
            }

            // Chama recursivamente para a subárvore esquerda e direita
            buscarPorAutorRecursivo(atual.getEsquerda(), autor, livrosEncontrados);
            buscarPorAutorRecursivo(atual.getDireita(), autor, livrosEncontrados);
        }
    }

    // Método para percorrer a árvore em pré-ordem (raiz, esquerda, direita)
    public List<TIPO> preOrdem() {
        List<TIPO> resultado = new ArrayList<>();
        percorrerPreOrdem(raiz, resultado);
        return resultado;
    }

    private void percorrerPreOrdem(Elemento<TIPO> atual, List<TIPO> resultado) {
        if (atual != null) {
            resultado.add(atual.getValor()); // Nó atual (raiz)
            percorrerPreOrdem(atual.getEsquerda(), resultado); // Subárvore Esquerda
            percorrerPreOrdem(atual.getDireita(), resultado); // Subárvore Direita
        }
    }

    // Método para percorrer a árvore em ordem (esquerda, raiz, direita)
    public List<TIPO> emOrdem() {
        List<TIPO> resultado = new ArrayList<>();
        percorrerEmOrdem(raiz, resultado);
        return resultado;
    }

    private void percorrerEmOrdem(Elemento<TIPO> atual, List<TIPO> resultado) {
        if (atual != null) {
            percorrerEmOrdem(atual.getEsquerda(), resultado); // Subárvore Esquerda
            resultado.add(atual.getValor()); // Nó atual (raiz)
            percorrerEmOrdem(atual.getDireita(), resultado); // Subárvore Direita
        }
    }

    // Método para percorrer a árvore em pós-ordem (esquerda, direita, raiz)
    public List<TIPO> posOrdem() {
        List<TIPO> resultado = new ArrayList<>();
        percorrerPosOrdem(raiz, resultado);
        return resultado;
    }

    private void percorrerPosOrdem(Elemento<TIPO> atual, List<TIPO> resultado) {
        if (atual != null) {
            percorrerPosOrdem(atual.getEsquerda(), resultado); // Subárvore Esquerda
            percorrerPosOrdem(atual.getDireita(), resultado); // Subárvore Direita
            resultado.add(atual.getValor()); // Nó atual (raiz)
        }
    }

    // Busca o sucessor de um valor na árvore
    public TIPO buscarSucessor(TIPO valor) {
        Elemento<TIPO> atual = raiz; // Começa a busca a partir da raiz
        TIPO sucessor = null; // Inicializa o sucessor como null

        while (atual != null) {
            // Se o valor é menor que o nó atual, o sucessor potencial é o nó atual
            if (valor.compareTo(atual.getValor()) < 0) {
                sucessor = atual.getValor();
                atual = atual.getEsquerda(); // Move para a subárvore esquerda
            } else {
                atual = atual.getDireita();  // Se o valor é maior, move para a subárvore direita
            }
        }

        return sucessor;
    }

    // Busca o antecessor de um valor na árvore
    public TIPO buscarAntecessor(TIPO valor) {
        Elemento<TIPO> atual = raiz;
        TIPO antecessor = null;

        while (atual != null) {
            if (valor.compareTo(atual.getValor()) > 0) {
                antecessor = atual.getValor();
                atual = atual.getDireita();
            } else {
                atual = atual.getEsquerda();
            }
        }

        return antecessor;
    }

}
