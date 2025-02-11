package lt.techin.movie_studio_81.repository;

import lt.techin.movie_studio_81.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  public Role findByName(String name);
}
