package com.example.books.repo;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.books.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Long> {

}
