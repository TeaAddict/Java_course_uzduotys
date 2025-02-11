package lt.techin.movie_studio_81.service;

import jakarta.transaction.Transactional;
import lt.techin.movie_studio_81.model.Role;
import lt.techin.movie_studio_81.repository.RoleRepository;
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

  public Role saveRole(Role role) {
    return roleRepository.save(role);
  }

  @Transactional
  public Role ensureRoleExists(String name) {
    Role role = roleRepository.findByName(name);

    if (role == null) {
      role = new Role(name);
      return saveRole(role);
    }

    return role;
  }
}
