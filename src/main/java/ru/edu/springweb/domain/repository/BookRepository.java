package ru.edu.springweb.domain.repository;

import org.springframework.stereotype.Component;
import ru.edu.springweb.domain.entity.Book;
import ru.edu.springweb.errorhandler.BookException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.edu.springweb.errorhandler.ErrorDescription.NOT_FOUND;

@Component
public class BookRepository {

    private final Map<Integer, Book> books = new HashMap<>();
    private volatile AtomicInteger currentId = new AtomicInteger(0);

    public Book save(Book book) {
        book.setId(currentId.addAndGet(1));
        books.put(book.getId(), book);
        return book;
    }

    public Book findById(int id) {
        return Optional.ofNullable(books.get(id)).orElseThrow(() -> new BookException(NOT_FOUND.getCode(), NOT_FOUND.getDescription() ));
    }

    public Book update(int id, Book book) {
        Book oldBook = findById(id);
        book.setId(id);
        books.put(id, book);
        return book;
    }

    public void delete(int id) {
        books.remove(id);
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
}
