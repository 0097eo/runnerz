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
        LocalDateTime start_time,
        @Future
        LocalDateTime end_time,
        @Positive
        Integer miles,
        Location location
) {
    public Run {
        if (title == null || start_time == null || end_time == null || miles == null || location == null) {
            throw new IllegalArgumentException("All fields must be provided");
        }
        if (miles <= 0) {
            throw new IllegalArgumentException("Distance must be greater than zero");
        }
    }
}
