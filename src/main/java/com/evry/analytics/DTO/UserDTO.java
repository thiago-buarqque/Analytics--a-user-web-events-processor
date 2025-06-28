package com.evry.analytics.DTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
public class UserDTO {

    private String uuid;

    private String address;

    @NotNull(message = "User birthday must be provided.")
    private LocalDate birthday;

    @NotBlank(message = "User e-mail must be provided.")
    private String email;

    @NotBlank(message = "User first name must be provided.")
    private String firstName;

    private String gender;

    @NotBlank(message = "User last name must be provided.")
    private String lastName;

    private String middleName;

    private String phone;

    private String role;
}
