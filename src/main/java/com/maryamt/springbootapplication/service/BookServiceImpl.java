package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.BookDTO;
import com.maryamt.springbootapplication.dto.BookPublisherDTO;
import com.maryamt.springbootapplication.entity.Book;
import com.maryamt.springbootapplication.entity.Publisher;
import com.maryamt.springbootapplication.entity.Review;
import com.maryamt.springbootapplication.mapper.BookMapper;
import com.maryamt.springbootapplication.mapper.BookPublisherMapper;
import com.maryamt.springbootapplication.repository.BookRepo;
import com.maryamt.springbootapplication.repository.GenreRepo;
import com.maryamt.springbootapplication.repository.PublisherRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private PublisherRepo publisherRepo;
    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book= BookMapper.mapToBook(bookDTO);
        Book savedBook= bookRepo.save(book);
        return BookMapper.mapToBookDto(savedBook);
    }
//    @Override
//    public BookDTO createBook(BookDTO bookDTO) {
//        Book book = BookMapper.mapToBook(bookDTO);
//
//        // Set the book reference for each review
//        if (book.getReviews() != null) {
//            for (Review review : book.getReviews()) {
//                review.setBook(book);
//            }
//        }
//
//        Book savedBook = bookRepo.save(book);
//        return BookMapper.mapToBookDto(savedBook);
//    }


    @Override
    public BookDTO getBookById(Long book_id) {
        Optional<Book> optionalBook= bookRepo.findById(book_id);
        Book book=optionalBook.get();
        return BookMapper.mapToBookDto(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books=bookRepo.findAll();
        return books.stream().map(BookMapper::mapToBookDto).collect(Collectors.toList());
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        Book book= BookMapper.mapToBook(bookDTO);
        Book existingBook = bookRepo.findById(book.getBook_id()).get();
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setPublishers(book.getPublishers());
//        existingBook.setReviews(book.getReviews());
        Book updatedBook=bookRepo.save(existingBook);
        return BookMapper.mapToBookDto(updatedBook);
    }

//    @Override
//    public BookDTO addPublisher(List<BookPublisherDTO> pub, Long book_id) {
//        List<Publisher> publishers= BookPublisherMapper.mapToPublishers(pub);
//        Book existingBook = bookRepo.findById(book_id).get();
//        existingBook.setPublishers(publishers);
//        System.out.println(publishers);
//        Book updatedBook=bookRepo.save(existingBook);
//        return BookMapper.mapToBookDto(updatedBook);
//    }

    @Override
    public BookDTO addPublisher(List<BookPublisherDTO> pub, Long book_id) {
        List<Publisher> publishers = new ArrayList<>();
        for (BookPublisherDTO bookPublisherDTO : pub) {
            Publisher publisher = new Publisher();
            publisher.setPub_id(bookPublisherDTO.getPublisherId());
            publisher.setName(publisherRepo.findById(bookPublisherDTO.getPublisherId()).map(Publisher::getName).orElse(null));
            publishers.add(publisher);
        }

        Book existingBook = bookRepo.findById(book_id).orElse(null);
        if (existingBook != null) {
            existingBook.setPublishers(publishers);
            Book updatedBook = bookRepo.save(existingBook);
            return BookMapper.mapToBookDto(updatedBook);
        } else {
            // Handle case when book with the provided ID doesn't exist
            return null;
        }
    }



    @Override
    public void deleteBook(Long book_Id) {
        bookRepo.deleteById(book_Id);
    }
}
