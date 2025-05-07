package com.avalieKintal.AvalieKintal.dto;

import java.sql.Timestamp;

public record ResponseUserDto(
        Integer id,
        String name,
        String email,
        String phone,
        boolean status
) {
}
