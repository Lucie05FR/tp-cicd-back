package fr.iut.library.dto.response;

import lombok.Data;

@Data
public class BookCopyResponse {
    private Long id;
    private BookResponse book;  // Objet livre complet
    private Boolean available;
    private String state;
}