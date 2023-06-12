package com.maryamt.springbootapplication.repository;

import com.maryamt.springbootapplication.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {
}
