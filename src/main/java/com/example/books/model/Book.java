package com.example.books.model;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "title")
	@NotBlank
	@Size(min = 3, max = 50)
	private String title;
	
	@Column(name = "description")
	@NotBlank
	@Size(min = 10)
	private String description;
	
	@Column(name = "writingDate")
	@NotBlank
	private LocalDate writingDate;
	

	@JsonBackReference
	@ManyToMany(mappedBy = "books")
	private Set<Author> authors = new HashSet<>();
	
}
