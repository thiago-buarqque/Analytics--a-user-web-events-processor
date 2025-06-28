package com.evry.analytics.model.entity;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

    private String address;

    @NotNull private LocalDate birthday;

    @NotNull private OffsetDateTime createDate;

    @NotNull private String email;

    @NotNull private String firstName;

    private String gender;

    @GeneratedValue
    @Id
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID uuid;

    @NotNull private String lastName;

    private String middleName;

    @NotNull private String password;

    private String phone;

    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority((role)));
    }

    @Override
    public String getUsername() {
        return email;
    }

}
