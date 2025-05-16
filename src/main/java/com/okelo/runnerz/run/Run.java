package com.okelo.runnerz.run;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startTime,
        @Future
        LocalDateTime endTime,
        @Positive
        Integer miles,
        Location location
) {
    public Run {
        if (id == null || title == null || startTime == null || endTime == null || miles == null || location == null) {
            throw new IllegalArgumentException("All fields must be provided");
        }
        if (miles <= 0) {
            throw new IllegalArgumentException("Distance must be greater than zero");
        }
    }
}
