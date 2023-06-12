package com.maryamt.springbootapplication.dto;

import com.maryamt.springbootapplication.entity.Author;
import com.maryamt.springbootapplication.entity.Genre;
import com.maryamt.springbootapplication.entity.Publisher;
import com.maryamt.springbootapplication.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long book_id;
    private String name;
    private Author author;
    private Genre genre;
    private List<Publisher> publishers;
    private List<Review> reviews;
}
