package fa.training.service;

import fa.training.entities.Book;

import java.util.List;

public interface BookService {
    boolean addBook(Book book);

    List<Book> findBookByPublicationYearAndPublisher(int publicationYear, String publisher);

    boolean addAuthor(String author, String isbn);

    List<Book> findBookByIsbn(String isbn);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByPublisher(String publisher);
}
