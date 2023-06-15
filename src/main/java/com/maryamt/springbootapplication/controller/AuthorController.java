package com.maryamt.springbootapplication.controller;


import com.maryamt.springbootapplication.dto.AuthorDTO;
import com.maryamt.springbootapplication.entity.Author;
import com.maryamt.springbootapplication.exception.ResourceNotFoundException;
import com.maryamt.springbootapplication.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/authors")
public class AuthorController {
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO author){
        AuthorDTO savedAuthor = authorService.createAuthor(author);
        return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }

//    @GetMapping("{id}")
//    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable("id") Long authorId){
//        AuthorDTO author = authorService.getAuthorById(authorId);
//        return new ResponseEntity<>(author, HttpStatus.OK);
//    }

//    @GetMapping("{id}")
//    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable("id") Long authorId) throws ResourceNotFoundException {
//        AuthorDTO author = authorService.getAuthorById(authorId);
//
//        if (author != null) {
//            return new ResponseEntity<>(author, HttpStatus.OK);
//        } else {
//            throw new ResourceNotFoundException("Author not found for this id :: " + authorId);
//        }
//    }

    @GetMapping("{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable("id") Long authorId) throws ResourceNotFoundException {
        try {
            AuthorDTO author = authorService.getAuthorById(authorId);
            return new ResponseEntity<>(author, HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage(), ex);
        }
    }




    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(){
        List<AuthorDTO> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable("id") Long authorId,
                                           @RequestBody AuthorDTO author){
        author.setAuthor_id(authorId);
        AuthorDTO updatedAuthor = authorService.updateAuthor(author);
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") Long authorId){
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>("Author successfully deleted!", HttpStatus.OK);
    }
}
