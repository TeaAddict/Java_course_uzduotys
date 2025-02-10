package lt.techin.movie_studio_71.repository;

import lt.techin.movie_studio_71.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
