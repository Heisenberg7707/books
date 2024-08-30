package com.example.books.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private LocalDate deathday;

}
