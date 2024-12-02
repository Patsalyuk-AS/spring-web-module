package ru.edu.springweb.service.impl;

import org.springframework.stereotype.Service;
import ru.edu.springweb.domain.entity.Book;
import ru.edu.springweb.domain.repository.BookRepository;
import ru.edu.springweb.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book update(int id, Book book) {
        return bookRepository.update(id, book);
    }

    @Override
    public void delete(int id) {
        bookRepository.delete(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
