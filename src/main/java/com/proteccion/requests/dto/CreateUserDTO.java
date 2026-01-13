package com.proteccion.requests.dto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "CreateUserDTO", description = "DTO for creating a new user")
public class CreateUserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;

}
