package lt.techin.movie_spring_3.repository;

import lt.techin.movie_spring_3.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
