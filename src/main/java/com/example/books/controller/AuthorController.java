package com.example.books.controller;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.model.Author;
import com.example.books.model.Book;
import com.example.books.service.AuthorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("authors")
@AllArgsConstructor
public class AuthorController {
	private final AuthorService authorService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create")
	public Author createAuthor(@RequestBody Author author) {
		return authorService.saveAuthor(author);

	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Author findAuthorById(@PathVariable Long id) {
		return authorService.findById(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void deleteAuthorById(@PathVariable Long id) {
		authorService.deleteAuthorById(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update")
	public Author updateAuthor(@RequestBody Author author){
		return authorService.updateAuthor(author);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{authorId}/AddBook/{bookId}")
	public Author addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
		return authorService.addBookToAuthor(authorId, bookId);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}/books")
	public Set<Book> getBooksOfAuthor(@PathVariable Long id){
		return authorService.getBooksByAuthorId(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{authorId}/deleteBooks")
	public Author clearAuthorBooks(@PathVariable Long authorId) {
		return authorService.clearAuthorBooks(authorId);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{authorId}/deleteBook/{bookId}")
	public Author deleteAuthorBookById(@PathVariable Long authorId, @PathVariable Long bookId) {
		return authorService.deleteAuthorBookById(authorId, bookId);
	}
	
}