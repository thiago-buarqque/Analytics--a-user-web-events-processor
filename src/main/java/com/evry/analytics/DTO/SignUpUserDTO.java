package com.evry.analytics.DTO;

import com.evry.analytics.model.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Setter
public class SignUpUserDTO {

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

    @NotBlank(message = "A password must be provided.")
    private String password;

}
