package com.maryamt.springbootapplication.dto;

import com.maryamt.springbootapplication.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
    private Long pub_id;
    private String name;
    private List<Book> books;
}

