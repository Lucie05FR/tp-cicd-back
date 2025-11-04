package fr.iut.library.service;

import fr.iut.library.model.BookCopy;
import fr.iut.library.repository.BookCopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookCopyService {
    private final BookCopyRepository bookCopyRepository;

    public List<BookCopy> findAll() {
        return bookCopyRepository.findAll();
    }

    public Optional<BookCopy> findById(Long id) {
        return bookCopyRepository.findById(id);
    }

    public BookCopy save(BookCopy bookCopy) {
        return bookCopyRepository.save(bookCopy);
    }

    public void deleteById(Long id) {
        bookCopyRepository.deleteById(id);
    }
}