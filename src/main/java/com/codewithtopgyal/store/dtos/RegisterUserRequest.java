package com.codewithtopgyal.store.dtos;

import lombok.Data;

@Data
//@Data is combination of @getter, @setter, toString and toHashCode
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
}
