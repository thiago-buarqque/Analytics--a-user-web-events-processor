package com.evry.analytics.DTO;

import com.evry.analytics.model.entity.User;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@EqualsAndHashCode
@Getter
@Setter
public class UserDTO {

    public UserDTO() {}

    public UserDTO(User user) {
        if (user != null) {
            address = user.getAddress();
            birthday = user.getBirthday();
            email = user.getEmail();
            firstName = user.getFirstName();
            gender = user.getGender();
            uuid = String.valueOf(user.getUuid());
            lastName = user.getLastName();
            middleName = user.getMiddleName();
            phone = user.getPhone();
            role = user.getRole();
        }
    }

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
