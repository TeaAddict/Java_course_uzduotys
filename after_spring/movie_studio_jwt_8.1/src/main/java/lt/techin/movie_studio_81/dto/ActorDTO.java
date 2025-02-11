package lt.techin.movie_studio_81.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ActorDTO(
        @NotNull
        @Size(min = 2, max = 50, message = "Actor name size should be between 2-50 characters")
        String name,

        @Min(value = 18, message = "Minimum age is 18")
        @Max(value = 110, message = "Maximum age is 130")
        int age) {
}
