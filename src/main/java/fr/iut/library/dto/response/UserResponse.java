package fr.iut.library.dto.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    // Note : On ne renvoie pas le mot de passe dans la réponse pour des raisons de sécurité
}