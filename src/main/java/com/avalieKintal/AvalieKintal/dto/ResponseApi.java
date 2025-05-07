package com.avalieKintal.AvalieKintal.dto;

import java.time.Instant;

public record ResponseApi<T>(
        int status,
        String message,
        T data,
        String timestamp
) {
    public static <T> ResponseApi<T> success(String message, T data) {
        return new ResponseApi<>(200, message, data, Instant.now().toString());
    }

    public static <T> ResponseApi<T> error(int status, String message) {
        return new ResponseApi<>(status, message, null, Instant.now().toString());
    }
}
