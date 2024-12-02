import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SequentialList lista = new SequentialList(5); // Inicializando com capacidade inicial
        Scanner scanner = new Scanner(System.in);
        BibliotecaTree<Book> arvore = new BibliotecaTree<>();


        while (true) {
            System.out.println("\nEscolha uma opção:\n");
            System.out.println("1 -  Adicionar livro");
            System.out.println("2 -  Remover livro (pelo índice)");
            System.out.println("3 -  Buscar livro (pelo título)");
            System.out.println("4 -  Mostrar todos os livros");
            System.out.println("5 -  Ordenar livros por título e autor");
            System.out.println("6 -  Recomendar livros por autor");
            System.out.println("7 -  Exibir livros em pré ordem");
            System.out.println("8 -  Exibir livros em ordem ");
            System.out.println("9 -  Exibir livros em pós ordem");
            System.out.println("10 - Exibir livro sucessor");
            System.out.println("11 - Exibir livro antecessor");
            System.out.println("0 -  Sair\n");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o ano de lançamento (AAAA-MM-DD): ");
                    LocalDateTime anoLancamento = LocalDateTime.parse(scanner.nextLine() + "T00:00:00");
                    Book livro = new Book(autor, titulo, LocalDateTime.now(), anoLancamento);
                    lista.adicionar(livro);
                    arvore.adicionar(livro);
                    System.out.println("\nLivro adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o índice do livro a ser removido: ");
                    int indice = scanner.nextInt();
                    lista.remover(indice);
                    break;
                case 3:
                    System.out.print("Digite o título do livro para buscar: ");
                    String tituloBusca = scanner.nextLine();
                    int indiceEncontrado = lista.buscar(tituloBusca);
                    if (indiceEncontrado != -1) {
                        System.out.println("\nLivro encontrado: " + lista.getLivro(indiceEncontrado));
                    } else {
                        System.out.println("\nLivro não encontrado");
                    }
                    break;
                case 4:
                    lista.mostrarLista();
                    break;
                case 5:
                    lista.ordenarPorTituloEAutor();
                    break;
                case 6:
                    System.out.print("Digite o autor para recomendar livros: ");
                    String autorBusca = scanner.nextLine();
                    List<Book> recomendacoes = arvore.buscarPorAutor(autorBusca);
                    if (recomendacoes.isEmpty()) {
                        System.out.println("\nNenhum livro encontrado para o autor: " + autorBusca);
                    } else {
                        System.out.println("\nLivros recomendados:\n");
                        for (Book b : recomendacoes) {
                            System.out.println(b);
                        }
                    }
                    break;
                case 7:
                    List<Book> livrosPreOrdem = arvore.preOrdem();
                    if (livrosPreOrdem.isEmpty()) {
                        System.out.println("\nNenhum livro encontrado");
                    } else {
                        System.out.println("\nExibindo livros em pré ordem\n");

                        for (Book livro_ : livrosPreOrdem) {
                            System.out.println(livro_);
                        }
                    }
                    break;
                case 8:
                    List<Book> livrosEmOrdem = arvore.emOrdem();
                    if (livrosEmOrdem.isEmpty()) {
                        System.out.println("\nNenhum livro encontrado");
                    } else {
                        System.out.println("\nExibindo livros em ordem\n");

                        for (Book livro_ : livrosEmOrdem) {
                            System.out.println(livro_);
                        }
                    }
                    break;
                case 9:
                    List<Book> livrosPosOrdem = arvore.posOrdem();
                    if (livrosPosOrdem.isEmpty()) {
                        System.out.println("\nNenhum livro encontrado");
                    } else {
                        System.out.println("\nExibindo livros em pós ordem\n");

                        for (Book livro_ : livrosPosOrdem) {
                            System.out.println(livro_);
                        }
                    }
                    break;
                case 10:
                    System.out.println("Exibindo livro sucessor ao atual\n");
                    System.out.print("Digite o título do livro para encontrar o sucessor: ");
                    String tituloLivro = scanner.nextLine();

                    // Usa o método buscar da SequentialList para encontrar o índice do livro
                    int indiceLivro = lista.buscar(tituloLivro);

                    if (indiceLivro != -1) {
                        // Se o livro for encontrado, obtém o livro e busca o sucessor na árvore
                        Book livroBusca = lista.getLivro(indiceLivro);  // Acessa o livro usando o índice
                        Book sucessor = arvore.buscarSucessor(livroBusca);
                        if (sucessor != null) {
                            System.out.println("\nLivro sucessor encontrado: " + sucessor);
                        } else {
                            System.out.println("\nNão existe sucessor para o livro informado");
                        }
                    } else {
                        System.out.println("\nLivro não encontrado na lista");
                    }
                    break;
                case 11:
                    System.out.println("Exibindo livro antecessor ao atual\n");
                    // Pergunta o título do livro que o usuário deseja buscar
                    System.out.print("Digite o título do livro para encontrar o antecessor: ");
                    String tituloBuscaAntecessor = scanner.nextLine();

                    // Usa o método buscar da SequentialList para encontrar o índice do livro
                    int indiceAntecessor = lista.buscar(tituloBuscaAntecessor);

                    if (indiceAntecessor != -1) {
                        // Se o livro for encontrado, obtém o livro e busca o antecessor na árvore
                        Book livroBusca = lista.getLivro(indiceAntecessor);  // Acessa o livro usando o índice
                        Book livroAntecessor = arvore.buscarAntecessor(livroBusca);
                        if (livroAntecessor != null) {
                            System.out.println("\nLivro antecessor encontrado: " + livroAntecessor);
                        } else {
                            System.out.println("\nNão existe antecessor para o livro informado");
                        }
                    } else {
                        System.out.println("\nLivro não encontrado na lista");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;


            }
        }
    }
}
