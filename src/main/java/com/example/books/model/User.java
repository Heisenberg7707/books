package com.example.books.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;



@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, updatable = false)
	private Long id;
	
	@NotBlank(message = "cannot be empty")
	@Column(name = "login")
	private String login;
	
	@NotBlank(message = "cannot be empty")
	@Column(name = "password")
	private String password;
	
	@NotBlank(message = "cannot be empty")
	@Column(name = "firstName")
	private String firstName;
	
	@NotBlank(message = "cannot be empty")
	@Column(name = "lastName")
	private String lastName;
	
	@NotNull(message = "cannot be empty")
	@Column(name = "birthday")
	private LocalDate birthday;
	
}
