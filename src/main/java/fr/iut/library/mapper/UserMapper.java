package fr.iut.library.mapper;

import fr.iut.library.dto.request.UserRequest;
import fr.iut.library.dto.response.UserResponse;
import fr.iut.library.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse toResponse(User user);
    User toEntity(UserRequest userRequest);
    void updateEntity(@MappingTarget User target, UserRequest source);
}