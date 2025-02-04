package lt.techin.movie_studio_51.repository;

import lt.techin.movie_studio_51.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
