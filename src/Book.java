import java.time.LocalDateTime;

public class Book implements Comparable<Book> {

    private String author;
    private String title;
    private LocalDateTime creationDate;
    private LocalDateTime yearOfRelease;

    // Construtor
    public Book(String author, String title, LocalDateTime creationDate, LocalDateTime yearOfRelease) {
        this.author = author;
        this.title = title;
        this.creationDate = creationDate;
        this.yearOfRelease = yearOfRelease;
    }

    // Construtor sem parâmetros
    public Book() {
    }


    // Getters e Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(LocalDateTime yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    // Implementação do compareTo para ordenar por título
    @Override
    public int compareTo(Book outro) {
        return this.title.compareTo(outro.title); // Comparando pelo título
    }

    // Método toString para imprimir o livro de forma legível
    @Override
    public String toString() {
        return "Livro{" +
                "Autor = '" + author + '\'' +
                ", Título = '" + title + '\'' +
                ", Data de Criação = " + creationDate +
                ", Ano de Lançamento = " + yearOfRelease +
                '}';
    }
}
