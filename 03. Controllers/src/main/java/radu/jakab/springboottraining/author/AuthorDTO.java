package radu.jakab.springboottraining.author;

import java.time.LocalDate;

public record AuthorDTO(
        String id,
        String name,
        LocalDate datOfBirth
) {
}
