package com.maryamt.springbootapplication.mapper;

import com.maryamt.springbootapplication.dto.BookDTO;
import com.maryamt.springbootapplication.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookMapper {

    public static BookDTO mapToBookDto(Book book){
        BookDTO bookDTO= new BookDTO(
                book.getBook_id(),
                book.getName(),
                AuthorMapper.mapToAuthorDto(book.getAuthor()),
                GenreMapper.mapToGenreDto(book.getGenre()),
//                PublisherMapper.mapToPubDTOsList(book.getPublishers()),
                BookPublisherMapper.mapPublishersDTO(book.getPublishers(), book.getBook_id())
//                ReviewMapper.mapToReviewDTOsList(book.getReviews())
//                book.getReviews()
        );
        return bookDTO;

    }

    public static Book mapToBook(BookDTO bookDTO){
        Book book = new Book(
                bookDTO.getBook_id(),
                bookDTO.getName(),
                AuthorMapper.mapToAuthor(bookDTO.getAuthor()),
                GenreMapper.mapToGenre(bookDTO.getGenre()),
//                PublisherMapper.mapToPubList(bookDTO.getPublishers()),
                BookPublisherMapper.mapToPublishers(bookDTO.getPublishers())
//                ReviewMapper.mapToReviewsList(bookDTO.getReviews())
//                bookDTO.getReviews()
        );
        return book;
    }

    public static List<Book> mapToBooksList(List<BookDTO> bookDTOs) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOs) {
            books.add(mapToBook(bookDTO));
        }
        return books;
    }

    public static List<BookDTO> mapToBookDTOsList(List<Book> books) {
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(mapToBookDto(book));
        }
        return bookDTOs;
    }

}
