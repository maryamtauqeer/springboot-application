package com.maryamt.springbootapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long author_id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String nationality;
    @Column(nullable = false)
    private String writing_style;

//    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_book", referencedColumnName = "author_id")
//    private List<Book> books;
}
