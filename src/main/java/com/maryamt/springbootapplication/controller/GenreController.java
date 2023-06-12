package com.maryamt.springbootapplication.controller;

import com.maryamt.springbootapplication.dto.GenreDTO;
import com.maryamt.springbootapplication.entity.Genre;
import com.maryamt.springbootapplication.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/genre")
public class GenreController {
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO genreDTO){
        GenreDTO savedGenre=genreService.createGenre(genreDTO);
        return new ResponseEntity<>(savedGenre, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<GenreDTO> getGenreById(@PathVariable("id") Long genre_id){
        GenreDTO genreDTO=genreService.getGenreById(genre_id);
        return new ResponseEntity<>(genreDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getGenre(){
        List<GenreDTO> genres=genreService.getAllGenre();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable("id")Long genre_id, @RequestBody GenreDTO genreDTO){
        genreDTO.setGenre_id(genre_id);
        GenreDTO updatedGenre =genreService.updateGenre(genreDTO);
        return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable("id")Long id){
        genreService.deleteGenre(id);
        return new ResponseEntity<>("Genre deleted successfully.",HttpStatus.OK);
    }


}
