package lt.techin.movie_studio_41.repository;

import lt.techin.movie_studio_41.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
  public boolean existsByName(String name);
}
