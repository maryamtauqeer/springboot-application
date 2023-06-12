package com.maryamt.springbootapplication.dto;

import com.maryamt.springbootapplication.entity.Book;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {
    private Long genre_id;
    private String name;
}
