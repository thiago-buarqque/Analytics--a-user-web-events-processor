package com.evry.analytics.model.entity;

import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table
public class User implements UserDetails {

    @NotNull private LocalDate birthday;

    @NotNull private OffsetDateTime createDate;

    @NotNull private String email;

    @NotNull private String firstName;

    private String gender;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @NotNull
    private long id;

    @NotNull private String lastName;

    private String middleName;

    @NotNull private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return email;
    }

}
