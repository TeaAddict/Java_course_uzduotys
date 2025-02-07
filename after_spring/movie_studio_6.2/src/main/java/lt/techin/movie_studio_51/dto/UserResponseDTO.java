package lt.techin.movie_studio_51.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lt.techin.movie_studio_51.model.Role;

import java.util.List;

public record UserResponseDTO(
        @NotNull
        long id,

        @NotNull
        @Size(min = 8, max = 100)
        String username,

        @NotEmpty
        List<Role> roles) {

  @Override
  public String username() {
    return username;
  }

  @Override
  public List<Role> roles() {
    return roles;
  }
}
