package com.maryamt.springbootapplication.service;


import com.maryamt.springbootapplication.dto.BookDTO;
import com.maryamt.springbootapplication.entity.Book;

import java.util.List;

public interface BookService{
    BookDTO createBook(BookDTO bookDTO);

    BookDTO getBookById(Long book_id);

    List<BookDTO> getAllBooks();

    BookDTO updateBook(BookDTO bookDTO);

    void deleteBook(Long book_Id);
}
