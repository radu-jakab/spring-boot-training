package radu.jakab.springboottraining.books;

import radu.jakab.springboottraining.authors.AuthorDTO;

public record BookDTO(
        String id,
        String title,
        String shortDescription,
        AuthorDTO author
) {
}
