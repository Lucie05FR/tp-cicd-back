package fr.iut.library.dto.request;

import lombok.Data;

@Data
public class AuthorRequest {
    private String firstName;
    private String lastName;
}