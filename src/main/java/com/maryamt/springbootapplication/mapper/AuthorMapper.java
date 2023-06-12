package com.maryamt.springbootapplication.mapper;

import com.maryamt.springbootapplication.dto.AuthorDTO;
import com.maryamt.springbootapplication.entity.Author;

public class AuthorMapper {
    // Convert Author JPA Entity into AuthorDTO
    public static AuthorDTO mapToAuthorDto(Author author){
        AuthorDTO authorDTO= new AuthorDTO(
                author.getAuthor_id(),
                author.getName(),
                author.getNationality(),
                author.getWriting_style()
        );
        return authorDTO;
    }

    // Convert AuthorDTO into User JPA Entity
    public static Author mapToAuthor(AuthorDTO authorDTO){
        Author author = new Author(
                authorDTO.getAuthor_id(),
                authorDTO.getName(),
                authorDTO.getNationality(),
                authorDTO.getWriting_style()
        );
        return author;
    }
}
