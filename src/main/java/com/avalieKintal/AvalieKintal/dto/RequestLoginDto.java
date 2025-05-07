package com.avalieKintal.AvalieKintal.dto;

import jakarta.validation.constraints.NotBlank;

public record RequestLoginDto(
        @NotBlank
        String phone,

        @NotBlank
        String password
) {}