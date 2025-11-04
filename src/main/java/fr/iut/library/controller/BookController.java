package fr.iut.library.controller;

import fr.iut.library.dto.request.BookRequest;
import fr.iut.library.dto.response.BookResponse;
import fr.iut.library.mapper.BookMapper;
import fr.iut.library.model.Book;
import fr.iut.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<BookResponse> getAllBooks() {
        return bookService.findAll().stream()
                .map(bookMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        return bookService.findById(id)
                .map(bookMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BookResponse createBook(@RequestBody BookRequest request) {
        Book book = bookMapper.toEntity(request);
        return bookMapper.toResponse(bookService.save(book));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody BookRequest request) {
        return bookService.findById(id)
                .map(book -> {
                    bookMapper.updateEntity(book, request);
                    return ResponseEntity.ok(bookMapper.toResponse(bookService.save(book)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (!bookService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}