package com.avalieKintal.AvalieKintal.dto;

import java.time.LocalDateTime;

public record ResponseFeedbackDto(int id,
                                  Double foodRating,
                                  Double serviceRating,
                                  Double experienceRating,
                                  String comments,
                                  String customerName,
                                  LocalDateTime submittedAt) {
}
