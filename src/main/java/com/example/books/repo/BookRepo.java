package com.example.books.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.books.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
	public Optional<Book> findBookByTitle(String title);

}
