package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.AuthorDTO;
import com.maryamt.springbootapplication.entity.Author;
import com.maryamt.springbootapplication.mapper.AuthorMapper;
import com.maryamt.springbootapplication.repository.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepo authorRepository;
    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author= AuthorMapper.mapToAuthor(authorDTO);
        Author savedAuthor = authorRepository.save(author);
        return AuthorMapper.mapToAuthorDto(savedAuthor);
    }

    @Override
    public AuthorDTO getAuthorById(Long author_id) {
        Optional<Author> optionalAuthor= authorRepository.findById(author_id);
        Author author=optionalAuthor.get();
        return AuthorMapper.mapToAuthorDto(author);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors=authorRepository.findAll();
        return authors.stream().map(AuthorMapper::mapToAuthorDto).collect(Collectors.toList());
    }

    @Override
    public AuthorDTO updateAuthor(AuthorDTO authorDTO) {
        Author author=AuthorMapper.mapToAuthor(authorDTO);
        Author existingAuthor = authorRepository.findById(author.getAuthor_id()).get();
        existingAuthor.setName(author.getName());
        existingAuthor.setNationality(author.getNationality());
        existingAuthor.setWriting_style(author.getWriting_style());
        Author updatedAuthor = authorRepository.save(existingAuthor);
        return AuthorMapper.mapToAuthorDto(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Long author_Id) {
        authorRepository.deleteById(author_Id);
    }
}
