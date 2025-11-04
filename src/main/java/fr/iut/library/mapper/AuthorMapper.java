package fr.iut.library.mapper;

import fr.iut.library.dto.request.AuthorRequest;
import fr.iut.library.dto.response.AuthorResponse;
import fr.iut.library.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorResponse toResponse(Author author);
    Author toEntity(AuthorRequest authorRequest);
    void updateEntity(@MappingTarget Author target, AuthorRequest source);
}