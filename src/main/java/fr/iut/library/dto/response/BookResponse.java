package fr.iut.library.dto.response;

import lombok.Data;

@Data
public class BookResponse {
    private Long id;
    private String title;
    private Integer publishYear;
    private String isbn;
    private AuthorResponse author;  // Objet auteur complet
}