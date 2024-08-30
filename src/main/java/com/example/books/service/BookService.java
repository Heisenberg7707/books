package com.example.books.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.books.dto.AuthorDTO;
import com.example.books.exception.ResourceNotFoundException;
import com.example.books.model.Author;
import com.example.books.model.Book;
import com.example.books.repo.BookRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class BookService {
	private final BookRepo bookRepo;
	
	public Book saveBook(Book book) {
		log.info("saving book {}", book.getTitle());
		return bookRepo.save(book);
	}
	
	public List<Book> findAll(){
		List<Book> books = bookRepo.findAll();
		log.info("Finded {} books", books.size());
		return books;
	}
	
	//TODO Add ResourceNotFoundException
	public Book updateBook(Book book) {
		log.info("updating book {}", book);
		bookRepo.findById(book.getId())
				.orElseThrow(() -> new ResourceNotFoundException("This book not exists"));
		return bookRepo.save(book);
	}
	
	public void deleteBookById(Long id) {
		log.info("deleting book {}", bookRepo.findById(id));
		bookRepo.deleteById(id);
	}
	
	public Optional<Book> findBookByTitle(String title) {
		log.info("finding book {}", title);
		return bookRepo.findBookByTitle(title);
	}
	
	public Book findBookById(Long id) {
		log.info("finding book by id {}", id);
		return bookRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
	}
	
    public List<AuthorDTO> findBookAuthors(Long bookId) {
        log.info("Started finding authors for book with id: {}", bookId);
        
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> {
                    log.error("Book not found with id: {}", bookId);
                    return new ResourceNotFoundException("Book not found with id: " + bookId);
                });

        log.info("Successfully found book with id: {}", bookId);
        
        Set<Author> authors = book.getAuthors();

        List<AuthorDTO> authorDTOs = authors.stream()
                .map(author -> new AuthorDTO(
                        author.getId(),
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBirthday(),
                        author.getDeathday()
                )).collect(Collectors.toList());

        log.info("Successfully created AuthorDTO list for book with id: {}", bookId);

        return authorDTOs;
    }

}
