package com.codewithtopgyal.store.mappers;

import com.codewithtopgyal.store.dtos.UserDto;
import com.codewithtopgyal.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
