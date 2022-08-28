package fa.training.service.impl;

import fa.training.entities.Book;
import fa.training.service.BookService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BookServiceImpl implements BookService {
    Scanner sc = new Scanner(System.in);

    @Override
    public void addBook(List<Book> bookList) throws ParseException {
        boolean flag = true;
        Set<String> authors = new HashSet<>();
        System.out.println("Input isbn: ");
        String isbn = sc.nextLine();
        addAuthorWithInput(flag, authors);
        System.out.println("Input publication place: ");
        String publicationPlace = sc.nextLine();
        System.out.println("Input publication year: ");
        int publicationYear = Integer.parseInt(sc.nextLine());
        System.out.println("Input publisher: ");
        String publisher = sc.nextLine();
        System.out.println("Input publicationDate: ");
        String date = sc.nextLine();
        Date publicationDate = convertStringToDate(date);
        Book book1 = new Book(publicationYear, publisher, publicationDate, isbn, authors, publicationPlace);
        bookList.add(book1);
    }

    private void addAuthorWithInput(boolean flag, Set<String> authors) {
        while (flag) {
            System.out.println("Input author name: ");
            String authorName = sc.nextLine();
            authors.add(authorName);
            flag = !checkKeepAdding();
        }
    }

    @Override
    public List<Book> findBookByPublicationYearAndPublisher(List<Book> bookList) {
        List<Book> result = new ArrayList<>();
        System.out.println("Input publication year: ");
        int publicationYear = Integer.parseInt(sc.nextLine());
        System.out.println("Input publisher: ");
        String publisher = sc.nextLine();
        for (Book book : bookList) {
            if (book.getPublisher().equalsIgnoreCase(publisher) && (book.getPublicationYear() == publicationYear)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public void addAuthor(String isbn, List<Book> bookList) {
        boolean flag = true;
        List<Book> book = new ArrayList<>();
        for (Book book1 : bookList) {
            if (book1.getIsbn().equalsIgnoreCase(isbn)) {
                book.add(book1);
            }
        }
        if (book.size() == 0) {
            System.out.println("Isbn not found");
        }
        addAuthorWithInput(flag, book.get(0).getAuthor());
    }

    @Override
    public List<Book> findBookByIsbn(String isbn, List<Book> bookList) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> findBookByAuthor(String author, List<Book> bookList) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().contains(author)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public List<Book> findBookByPublisher(String publisher, List<Book> bookList) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                result.add(book);
            }
        }
        return result;
    }

    // true: stop adding, false: keep adding
    public boolean checkKeepAdding() {
        System.out.println("Type n/N if you want to stop adding");
        String input = sc.nextLine();
        return input.equalsIgnoreCase("n");

    }

    public Date convertStringToDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.parse(date);
    }
}
