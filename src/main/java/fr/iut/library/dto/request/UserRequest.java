package fr.iut.library.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
}