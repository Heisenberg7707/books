package com.example.books.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "author_id")
	private Long id;
	
	@NotBlank(message = "cannot be empty")
	@Column(name = "firstName", nullable = false, updatable = false)
	private String firstName;
	
	@NotBlank(message = "cannot be empty")
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull(message = "cannot be null")
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "deathday")
	private LocalDate deathday;
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "author_book",
				joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id"),
				inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "book_id"))
	private Set<Book> books = new HashSet<>();

}
