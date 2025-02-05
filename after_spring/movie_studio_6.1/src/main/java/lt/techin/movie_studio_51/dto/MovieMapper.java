package lt.techin.movie_studio_51.dto;

import lt.techin.movie_studio_51.model.Movie;

import java.util.List;

public class MovieMapper {

  public static List<MovieDTO> toMovieDTOList(List<Movie> movies) {
    return movies.stream()
            .map(movie -> new MovieDTO(movie.getName(), movie.getDirector(), movie.getDirector()))
            .toList();
  }

  public static MovieDTO toMovieDTO(Movie movie) {
    return new MovieDTO(movie.getName(), movie.getDirector(), movie.getDescription());
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
}
