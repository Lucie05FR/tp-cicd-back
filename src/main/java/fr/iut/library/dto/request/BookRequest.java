package fr.iut.library.dto.request;

import lombok.Data;

@Data
public class BookRequest {
    private String title;
    private Integer publishYear;
    private String isbn;
    private Long authorId;  // Seulement l'ID de l'auteur est nécessaire
}