package com.evry.analytics.DTO;

import com.evry.analytics.model.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode
@Getter
@Setter
public class SignUpUserDTO {

    public SignUpUserDTO() {}

    public SignUpUserDTO(User user) {
        if (user != null) {
            address = user.getAddress();
            birthday = user.getBirthday();
            email = user.getEmail();
            firstName = user.getFirstName();
            gender = user.getGender();
            lastName = user.getLastName();
            middleName = user.getMiddleName();
            phone = user.getPhone();
            role = user.getRole();
        }
    }

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

    @NotBlank(message = "A password must be provided.")
    private String password;

    private String phone;

    private String role;
}
