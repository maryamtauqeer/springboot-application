package com.maryamt.springbootapplication.mapper;


import com.maryamt.springbootapplication.dto.GenreDTO;
import com.maryamt.springbootapplication.entity.Genre;

public class GenreMapper {
    public static GenreDTO mapToGenreDto(Genre genre){
        GenreDTO genreDTO= new GenreDTO(
                genre.getGenre_id(),
                genre.getName()
        );
        return genreDTO;
    }

    public static Genre mapToGenre(GenreDTO genreDTO){
        Genre genre = new Genre(
                genreDTO.getGenre_id(),
                genreDTO.getName()
        );
        return genre;
    }
}
