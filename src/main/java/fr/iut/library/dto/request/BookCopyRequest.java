package fr.iut.library.dto.request;

import lombok.Data;

@Data
public class BookCopyRequest {
    private Long bookId;  // Seulement l'ID du livre est nécessaire
    private Boolean available;
    private String state;
}