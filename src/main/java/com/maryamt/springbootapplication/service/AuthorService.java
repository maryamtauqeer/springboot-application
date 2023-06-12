package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.AuthorDTO;
import com.maryamt.springbootapplication.entity.Author;

import java.util.List;

public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO author);

    AuthorDTO getAuthorById(Long author_id);

    List<AuthorDTO> getAllAuthors();

    AuthorDTO updateAuthor(AuthorDTO author);

    void deleteAuthor(Long author_Id);
}
