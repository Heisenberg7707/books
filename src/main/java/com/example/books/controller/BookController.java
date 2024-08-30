package com.example.books.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.dto.AuthorDTO;
import com.example.books.model.Book;
import com.example.books.service.BookService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("books")
@AllArgsConstructor
public class BookController {
	private final BookService bookService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping()
	public List<Book> findAllBooks(){
		return bookService.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/save")
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Book findBookById(@PathVariable Long id) {
		return bookService.findBookById(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{bookId}/authors")
	public List<AuthorDTO> findBookAuthors(@PathVariable Long bookId){
		return bookService.findBookAuthors(bookId);
	}

}
