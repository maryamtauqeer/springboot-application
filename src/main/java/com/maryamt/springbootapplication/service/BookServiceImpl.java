package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.BookDTO;
import com.maryamt.springbootapplication.entity.Book;
import com.maryamt.springbootapplication.mapper.BookMapper;
import com.maryamt.springbootapplication.repository.BookRepo;
import com.maryamt.springbootapplication.repository.GenreRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private GenreRepo genreRepo;
    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book= BookMapper.mapToBook(bookDTO);
        Book savedBook= bookRepo.save(book);
        return BookMapper.mapToBookDto(savedBook);
    }

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
        existingBook.setReviews(book.getReviews());
        Book updatedBook=bookRepo.save(existingBook);
        return BookMapper.mapToBookDto(updatedBook);
    }

    @Override
    public void deleteBook(Long book_Id) {
        bookRepo.deleteById(book_Id);
    }
}
