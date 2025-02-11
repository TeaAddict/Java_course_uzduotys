package lt.techin.movie_studio_81.repository;

import lt.techin.movie_studio_81.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  public boolean existsByName(String name);

  public List<Movie> findAllMoviesByName(String name);

  public boolean existsByNameAndDirector(String name, String director);
}
