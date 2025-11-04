package fr.iut.library.mapper;

import fr.iut.library.dto.request.BookCopyRequest;
import fr.iut.library.dto.response.BookCopyResponse;
import fr.iut.library.model.BookCopy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface BookCopyMapper {
    BookCopyResponse toResponse(BookCopy bookCopy);

    @Mapping(source = "bookId", target = "book.id")
    BookCopy toEntity(BookCopyRequest bookCopyRequest);

    void updateEntity(@MappingTarget BookCopy target, BookCopyRequest source);
}