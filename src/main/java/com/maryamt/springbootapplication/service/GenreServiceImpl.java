package com.maryamt.springbootapplication.service;


import com.maryamt.springbootapplication.dto.GenreDTO;
import com.maryamt.springbootapplication.entity.Genre;
import com.maryamt.springbootapplication.mapper.GenreMapper;
import com.maryamt.springbootapplication.repository.GenreRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepo genreRepo;
    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = GenreMapper.mapToGenre(genreDTO);
        Genre savedGenre= genreRepo.save(genre);
        return GenreMapper.mapToGenreDto(savedGenre);
    }

    @Override
    public GenreDTO getGenreById(Long genre_id) {
        Optional<Genre> optionalGenre=genreRepo.findById(genre_id);
        Genre genre= optionalGenre.get();
        return GenreMapper.mapToGenreDto(genre);
    }

    @Override
    public List<GenreDTO> getAllGenre() {
        List<Genre> genres=genreRepo.findAll();
        return genres.stream().map(GenreMapper::mapToGenreDto).collect(Collectors.toList());
    }

    @Override
    public GenreDTO updateGenre(GenreDTO genreDTO) {
        Genre genre= GenreMapper.mapToGenre(genreDTO);
        Genre existingGenre = genreRepo.findById(genre.getGenre_id()).get();
        existingGenre.setName(genre.getName());
        Genre updatedGenre=genreRepo.save(existingGenre);
        return GenreMapper.mapToGenreDto(updatedGenre);
    }

    @Override
    public void deleteGenre(Long genre_id) {
        genreRepo.deleteById(genre_id);
    }
}
