package lt.techin.movie_studio_81.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record UserResponseDTO(
        @NotNull
        long id,

        @NotNull
        @Size(min = 8, max = 100)
        String username,

        @NotNull
        List<String> roles) {
}
