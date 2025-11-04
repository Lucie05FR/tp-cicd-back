package fr.iut.library.mapper;

import fr.iut.library.dto.request.BookRequest;
import fr.iut.library.dto.response.BookResponse;
import fr.iut.library.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface BookMapper {
    BookResponse toResponse(Book book);

    @Mapping(source = "authorId", target = "author.id")
    Book toEntity(BookRequest bookRequest);

    void updateEntity(@MappingTarget Book target, BookRequest source);
}