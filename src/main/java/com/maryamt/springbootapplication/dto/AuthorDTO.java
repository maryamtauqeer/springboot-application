package com.maryamt.springbootapplication.dto;

import com.maryamt.springbootapplication.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private Long author_id;
    private String name;
    private String nationality;
    private String writing_style;
//    private List<Book> books;
}
