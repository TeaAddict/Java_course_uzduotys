package com.example.carRental.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CarRequestDTO(
        @NotNull
        @Size(min = 2, max = 50, message = "Maximum 50 characters")
        String brand,

        @NotNull
        @Size(min = 2, max = 50, message = "Maximum 50 characters")
        String model,

        @NotNull
        @Min(0)
        // TODO: Missing max value (currentYear)
        int year,

        @NotNull
        String status
) {
}