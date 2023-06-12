package com.maryamt.springbootapplication.controller;

import com.maryamt.springbootapplication.dto.BookDTO;
import com.maryamt.springbootapplication.entity.Book;
import com.maryamt.springbootapplication.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO){
        BookDTO savedBook=bookService.createBook(bookDTO);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long book_id){
        BookDTO bookDTO=bookService.getBookById(book_id);
        return new ResponseEntity<>(bookDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBook(){
        List<BookDTO> books=bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable("id")Long book_id, @RequestBody BookDTO bookDTO){
        bookDTO.setBook_id(book_id);
        BookDTO updatedBook =bookService.updateBook(bookDTO);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id")Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted successfully.",HttpStatus.OK);
    }

}
