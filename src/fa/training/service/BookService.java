package fa.training.service;

import fa.training.entities.Book;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

public interface BookService {
    void addBook(List<Book> bookList) throws ParseException;

    List<Book> findBookByPublicationYearAndPublisher(List<Book> bookList);

    void addAuthor(String isbn, List<Book> bookList);

    List<Book> findBookByIsbn(String isbn, List<Book> bookList);

    List<Book> findBookByAuthor(String author, List<Book> bookList);

    List<Book> findBookByPublisher(String publisher, List<Book> bookList);
}
