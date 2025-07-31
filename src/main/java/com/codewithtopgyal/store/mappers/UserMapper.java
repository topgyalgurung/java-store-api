package com.codewithtopgyal.store.mappers;

import com.codewithtopgyal.store.dtos.RegisterUserRequest;
import com.codewithtopgyal.store.dtos.UpdateUserRequest;
import com.codewithtopgyal.store.dtos.UserDto;
import com.codewithtopgyal.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
