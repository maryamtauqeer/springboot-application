package com.maryamt.springbootapplication.dto;

import com.maryamt.springbootapplication.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long review_id;
    private Book book;
    private String comment;
    private float rating;
}
