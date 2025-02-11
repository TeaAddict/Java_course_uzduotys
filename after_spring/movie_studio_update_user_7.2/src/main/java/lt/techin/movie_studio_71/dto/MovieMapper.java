package lt.techin.movie_studio_71.dto;

import lt.techin.movie_studio_71.model.Movie;
import org.springframework.data.domain.Page;

import java.util.List;

public class MovieMapper {

  public static List<MovieDTO> toMovieDTOList(List<Movie> movies) {
    return movies.stream()
            .map(movie -> new MovieDTO(movie.getName(),
                    movie.getDirector(),
                    movie.getDirector(),
                    movie.getScreenings(),
                    movie.getActors()))
            .toList();
  }

  public static MovieDTO toMovieDTO(Movie movie) {
    return new MovieDTO(movie.getName(),
            movie.getDirector(),
            movie.getDescription(),
            movie.getScreenings(),
            movie.getActors());
  }

  public static Movie toMovie(MovieDTO movieDTO) {
    Movie movie = new Movie();
    movie.setName(movieDTO.name());
    movie.setDirector(movieDTO.director());
    movie.setDescription(movieDTO.description());

    return movie;
  }

  public static void updateMovieFromDTO(Movie movie, MovieDTO movieDTO) {
    movie.setName(movieDTO.name());
    movie.setDirector(movieDTO.director());
    movie.setDescription(movieDTO.description());
  }

  public static Page<MovieDTO> pageMoviesToMovieDTO(Page<Movie> pageMovie) {
    return pageMovie.map(MovieMapper::toMovieDTO);
  }
}
