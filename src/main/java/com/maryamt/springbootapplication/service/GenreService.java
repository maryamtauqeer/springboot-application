package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.GenreDTO;
import com.maryamt.springbootapplication.entity.Genre;

import java.util.List;

public interface GenreService {
    GenreDTO createGenre(GenreDTO genreDTO);

    GenreDTO getGenreById(Long genre_id);

    List<GenreDTO> getAllGenre();

    GenreDTO updateGenre(GenreDTO genreDTO);

    void deleteGenre(Long genre_id);
}
