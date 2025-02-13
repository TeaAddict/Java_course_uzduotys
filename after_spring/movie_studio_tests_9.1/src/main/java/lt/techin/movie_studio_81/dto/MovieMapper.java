package lt.techin.movie_studio_81.dto;

import lt.techin.movie_studio_81.model.Movie;
import org.springframework.data.domain.Page;

import java.util.List;

public class MovieMapper {

  public static List<MovieResponseDTO> toMovieResponseDTOList(List<MovieRequestDTO> movies) {
    return movies.stream()
            .map(movie -> new MovieResponseDTO(
                    movie.getId(),
                    movie.getName(),
                    movie.getDirector(),
                    movie.getDescription(),
                    movie.getScreenings(),
                    movie.getActors()))
            .toList();
  }

  public static MovieResponseDTO toMovieDTO(MovieRequestDTO movie) {
    return new MovieResponseDTO(
            movie.getId(),
            movie.getName(),
            movie.getDirector(),
            movie.getDescription(),
            movie.getScreenings(),
            movie.getActors());
  }

  public static Movie toMovie(MovieRequestDTO movieDTO) {
    Movie movie = new Movie();
    movie.setName(movieDTO.name());
    movie.setDirector(movieDTO.director());
    movie.setDescription(movieDTO.description());

    return movie;
  }

  public static void updateMovieFromDTO(Movie movie, MovieRequestDTO movieDTO) {
    movie.setName(movieDTO.name());
    movie.setDirector(movieDTO.director());
    movie.setDescription(movieDTO.description());
  }

  public static Page<MovieResponseDTO> pageMoviesToMovieDTO(Page<Movie> pageMovie) {
    return pageMovie.map(MovieMapper::toMovieDTO);
  }
}
