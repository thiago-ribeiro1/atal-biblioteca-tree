package ListaSequencial;

import java.awt.print.Book;

public class ListSequencial {

    private Book[] livros;

    private int tamanho;


    public ListSequencial(int capacidade) {
        this.livros = new Book[capacidade];
        this.tamanho = 0;
    }


    public void adicionar(Book livro) {

        if (tamanho == livros.length) {
            aumenterCapacidade();
        }

        livros[tamanho] = livro;
        tamanho++;


    }

    public void remover(int index) {
        if (index >= 0 && index < tamanho) {
            for (int i = index; index < tamanho - 1; i++) {
                livros[i] = livros[i + 1];
            }
            livros[tamanho - 1] = null;
            tamanho--;
        }
    }

    private void aumenterCapacidade() {
        int novaCapacidade = livros.length * 2;

        Book[] novoArray = new Book[novaCapacidade];

        for (int i = 0; i < livros.length; i++) {
            novoArray[i] = livros[i];
        }

        livros = novoArray;


    }


}
