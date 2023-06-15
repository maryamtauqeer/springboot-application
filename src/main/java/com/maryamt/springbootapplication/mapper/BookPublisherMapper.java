package com.maryamt.springbootapplication.mapper;

import com.maryamt.springbootapplication.dto.BookPublisherDTO;
import com.maryamt.springbootapplication.entity.Publisher;
import com.maryamt.springbootapplication.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookPublisherMapper {

    public static List<BookPublisherDTO> mapPublishersDTO(List<Publisher> publishers, Long book_id) {
        List<BookPublisherDTO> bookPublisherDTOs = new ArrayList<>();
        for (Publisher publisher : publishers) {
            bookPublisherDTOs.add(new BookPublisherDTO(book_id, publisher.getPub_id()));
        }
        return bookPublisherDTOs;
    }




    public static List<BookPublisherDTO> mapBooksDTO(List<Book> books, Long pub_id) {
        List<BookPublisherDTO> bookPublisherDTOs = new ArrayList<>();
        for (Book book : books) {
            bookPublisherDTOs.add(new BookPublisherDTO(book.getBook_id(), pub_id));
        }
        return bookPublisherDTOs;
    }


    public static List<Publisher> mapToPublishers(List<BookPublisherDTO> bookPublisherDTOs) {
        List<Publisher> publishers = new ArrayList<>();
        for (BookPublisherDTO bookPublisherDTO : bookPublisherDTOs) {
            Publisher publisher = new Publisher();
            publisher.setPub_id(bookPublisherDTO.getPublisherId());
            publishers.add(publisher);
        }
        return publishers;
    }

    public static List<Book> mapToBooks(List<BookPublisherDTO> bookPublisherDTOs) {
        List<Book> books = new ArrayList<>();
        for (BookPublisherDTO bookPublisherDTO : bookPublisherDTOs) {
            Book book = new Book();
            book.setBook_id(bookPublisherDTO.getBookId());
            books.add(book);
        }
        return books;
    }



}
