package com.codewithtopgyal.store.dtos;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserDto {
//    @JsonIgnore  - to ignore field
//    @JsonProperty("user_id") - rename
    private Long id;
    private String name;
    private String email;
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String phoneNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
}
