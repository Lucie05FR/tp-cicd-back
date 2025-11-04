package fr.iut.library.controller;

import fr.iut.library.dto.request.BookCopyRequest;
import fr.iut.library.dto.response.BookCopyResponse;
import fr.iut.library.mapper.BookCopyMapper;
import fr.iut.library.model.BookCopy;
import fr.iut.library.service.BookCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookcopies")
@RequiredArgsConstructor
public class BookCopyController {
    private final BookCopyService bookCopyService;
    private final BookCopyMapper bookCopyMapper;

    @GetMapping
    public List<BookCopyResponse> getAllBookCopies() {
        return bookCopyService.findAll().stream()
                .map(bookCopyMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCopyResponse> getBookCopyById(@PathVariable Long id) {
        return bookCopyService.findById(id)
                .map(bookCopyMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BookCopyResponse createBookCopy(@RequestBody BookCopyRequest request) {
        BookCopy bookCopy = bookCopyMapper.toEntity(request);
        return bookCopyMapper.toResponse(bookCopyService.save(bookCopy));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookCopyResponse> updateBookCopy(@PathVariable Long id, @RequestBody BookCopyRequest request) {
        return bookCopyService.findById(id)
                .map(bookCopy -> {
                    bookCopyMapper.updateEntity(bookCopy, request);
                    return ResponseEntity.ok(bookCopyMapper.toResponse(bookCopyService.save(bookCopy)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCopy(@PathVariable Long id) {
        if (!bookCopyService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bookCopyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}