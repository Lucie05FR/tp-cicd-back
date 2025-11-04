package fr.iut.library.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    private Long id;
    
    private String username;
    
    private String password;
}