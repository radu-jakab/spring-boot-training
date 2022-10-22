package radu.jakab.springboottraining.authors;

import java.time.LocalDate;

public record AuthorDTO(
        String id,
        String name,
        LocalDate datOfBirth
) {
}
