package com.example.books.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import com.example.books.exception.ResourceNotFoundException;
import com.example.books.model.Author;
import com.example.books.model.Book;
import com.example.books.repo.AuthorRepo;
import com.example.books.repo.BookRepo;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AuthorService {
	private final AuthorRepo authorRepo;
	private final BookRepo bookRepo;
	
	
	public List<Author> getAllAuthors(){
		List<Author> authors = authorRepo.findAll();
		log.info("Getting {} authors", authors.size());
		return authors;

	}
	
	public Author saveAuthor(Author author) {
		log.info("Saving author: {}", author);
		return authorRepo.save(author);
	}
	
	
	public void deleteAuthorById(Long id) {
		log.info("Deleting author by id {}", id);
		authorRepo.deleteById(id);
	}
	

	public Author findById(Long id) {
	    Author author = authorRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
	    
	    Hibernate.initialize(author.getBooks());
	    
	    return author;
	}
	
	public Author updateAuthor(Author author) {
		authorRepo.findById(author.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + author.getId()));
		return authorRepo.save(author);
	}
	
	
    public Author addBookToAuthor(Long authorId, Long bookId) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        
        author.getBooks().add(book);
        return authorRepo.save(author);
    }
	
	public Set<Book> getBooksByAuthorId(Long id){
		Author author = authorRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found with id" + id));
		return author.getBooks();
	}
	
	public Author clearAuthorBooks(Long authorId) {
		Author author = authorRepo.findById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
		author.getBooks().clear();
		return authorRepo.save(author);
	}
	
	public Author deleteAuthorBookById(Long authorId, Long bookId) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + authorId));
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        author.getBooks().remove(book);
        return authorRepo.save(author);
	}
}
