package lt.techin.movie_studio_51.controller;

import jakarta.websocket.server.PathParam;
import lt.techin.movie_studio_51.dto.UserMapper;
import lt.techin.movie_studio_51.dto.UserRequestDTO;
import lt.techin.movie_studio_51.dto.UserResponseDTO;
import lt.techin.movie_studio_51.model.Role;
import lt.techin.movie_studio_51.model.User;
import lt.techin.movie_studio_51.repository.RoleRepository;
import lt.techin.movie_studio_51.service.RoleService;
import lt.techin.movie_studio_51.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;
  private final RoleService roleService;

  public UserController(UserService userService, PasswordEncoder passwordEncoder, RoleService roleService) {
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
    this.roleService = roleService;
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<?> getUser(@PathVariable long id) {
    Optional<User> user = userService.findUserById(id);

    if (user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok().body(user);
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok().body(userService.findAllUsers());
  }

  @PostMapping("/users")
  public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO) {
    User user = UserMapper.toUser(userRequestDTO);
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    Role role = roleService.getRoleByName("user");

    if (role == null){
      roleService.save
    }

    user.setRoles(List.of(role));

    userService.saveUser(user);

    UserResponseDTO userResponseDTO = UserMapper.toUserResponseDTO(user);
    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(userResponseDTO.id())
                            .toUri())
            .body(userResponseDTO);
  }
}
