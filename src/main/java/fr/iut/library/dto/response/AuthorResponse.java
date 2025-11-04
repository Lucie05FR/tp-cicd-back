package fr.iut.library.dto.response;

import lombok.Data;

@Data
public class AuthorResponse {
    private Long id;
    private String firstName;
    private String lastName;
}