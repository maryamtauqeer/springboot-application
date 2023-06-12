package com.maryamt.springbootapplication.mapper;

import com.maryamt.springbootapplication.dto.BookDTO;
import com.maryamt.springbootapplication.entity.Book;

public class BookMapper {

    public static BookDTO mapToBookDto(Book book){
        BookDTO bookDTO= new BookDTO(
                book.getBook_id(),
                book.getName(),
                book.getAuthor(),
                book.getGenre(),
                book.getPublishers(),
                book.getReviews()
        );
        return bookDTO;

    }

    public static Book mapToBook(BookDTO bookDTO){
        Book book = new Book(
                bookDTO.getBook_id(),
                bookDTO.getName(),
                bookDTO.getAuthor(),
                bookDTO.getGenre(),
                bookDTO.getPublishers(),
                bookDTO.getReviews()
        );
        return book;
    }
}
