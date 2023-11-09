package com.jobhacker.user.dto;

import com.jobhacker.user.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private final long id;

    @NotEmpty(message = "username shouldn't be null")
    @NotBlank(message = "username shouldn't be a blank")
    private final String username;

    @NotEmpty(message = "password shouldn't be null")
    @NotBlank(message = "password shouldn't be a blank")
    private final String password;

    @Email(message = "Invalid email format")
    private final String email;

    private final Role role;

    private final boolean status;
}
