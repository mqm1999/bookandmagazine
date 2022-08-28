package fa.training.service.impl;

import fa.training.entities.Book;
import fa.training.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public boolean addBook(Book book) {

    }

    @Override
    public List<Book> findBookByPublicationYearAndPublisher(int publicationYear, String publisher) {
        return null;
    }

    @Override
    public boolean addAuthor(String author, String isbn) {
        return false;
    }

    @Override
    public List<Book> findBookByIsbn(String isbn) {
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> findBookByPublisher(String publisher) {
        return null;
    }
}
