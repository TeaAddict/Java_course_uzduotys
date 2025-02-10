package lt.techin.movie_studio_71.repository;

import lt.techin.movie_studio_71.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  public Role findByName(String name);
}
