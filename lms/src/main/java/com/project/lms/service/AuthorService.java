package com.project.lms.service;

import com.project.lms.entity.Author;
import java.util.List;

public interface AuthorService {

    Author addAuthor(Author author);
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);
}