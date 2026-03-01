package com.project.lms.service;

import com.project.lms.entity.Book;
import java.util.List;

public interface BookService {

    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
}