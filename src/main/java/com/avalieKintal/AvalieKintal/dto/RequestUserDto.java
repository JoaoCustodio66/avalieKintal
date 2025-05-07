package com.avalieKintal.AvalieKintal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record RequestUserDto(
        @NotNull
        String name,
        @NotNull
        String phone,
        @NotNull
        String password,
        boolean status,
        @Email
        @NotNull
        String email
){ }

