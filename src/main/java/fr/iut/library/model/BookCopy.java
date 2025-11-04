package fr.iut.library.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BookCopy")
public class BookCopy {
    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    
    private Boolean available;
    
    private String state;
}