package fr.iut.library.controller;

import fr.iut.library.dto.request.AuthorRequest;
import fr.iut.library.dto.response.AuthorResponse;
import fr.iut.library.mapper.AuthorMapper;
import fr.iut.library.model.Author;
import fr.iut.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @GetMapping
    public List<AuthorResponse> getAllAuthors() {
        return authorService.findAll().stream()
                .map(authorMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Long id) {
        return authorService.findById(id)
                .map(authorMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AuthorResponse createAuthor(@RequestBody AuthorRequest request) {
        Author author = authorMapper.toEntity(request);
        return authorMapper.toResponse(authorService.save(author));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorResponse> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequest request) {
        return authorService.findById(id)
                .map(author -> {
                    authorMapper.updateEntity(author, request);
                    return ResponseEntity.ok(authorMapper.toResponse(authorService.save(author)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        if (!authorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}