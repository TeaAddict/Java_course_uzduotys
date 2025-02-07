package lt.techin.movie_studio_51.service;

import lt.techin.movie_studio_51.model.Role;
import lt.techin.movie_studio_51.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
  private final RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  public Role getRoleByName(String name) {
    return roleRepository.findByName(name);
  }

  public Role saveRole(String name) {
    return roleRepository.save(name);
  }
}
