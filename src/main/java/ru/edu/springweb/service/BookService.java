package ru.edu.springweb.service;

import ru.edu.springweb.domain.entity.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    Book findById(int id);

    Book update(int id, Book book);

    void delete(int id);

    List<Book> findAll();
}
