package com.avalieKintal.AvalieKintal.dto;
import jakarta.validation.constraints.*;

public record RequestFeedbackDto(
    @NotNull
    @DecimalMin("0.0") @DecimalMax("5.0")
    Double foodRating,
    @NotNull
    @DecimalMin("0.0") @DecimalMax("5.0")
    Double serviceRating,
    @NotNull
    @DecimalMin("0.0") @DecimalMax("5.0")
    Double experienceRating,
    @Size(max = 1000)
    String comments,
    @NotBlank
    @Size(max = 100)
    String customerName
){}
