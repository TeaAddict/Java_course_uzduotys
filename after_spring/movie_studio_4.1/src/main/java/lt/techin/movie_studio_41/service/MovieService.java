package lt.techin.movie_studio_41.service;

import lt.techin.movie_studio_41.model.Movie;
import lt.techin.movie_studio_41.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
  private final MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie saveMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public boolean existsMovieById(long id) {
    return movieRepository.existsById(id);
  }

  public Optional<Movie> findMovieById(long id) {
    return movieRepository.findById(id);
  }
}
