package lt.techin.movie_studio_71.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lt.techin.movie_studio_71.dto.UserMapper;
import lt.techin.movie_studio_71.dto.UserRequestDTO;
import lt.techin.movie_studio_71.dto.UserResponseDTO;
import lt.techin.movie_studio_71.exception.UserAlreadyExistsException;
import lt.techin.movie_studio_71.exception.UserNotFoundException;
import lt.techin.movie_studio_71.model.Role;
import lt.techin.movie_studio_71.model.User;
import lt.techin.movie_studio_71.service.RoleService;
import lt.techin.movie_studio_71.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
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
  public ResponseEntity<UserResponseDTO> getUser(@PathVariable long id) {
    return userService.findUserById(id)
            .map(UserMapper::toUserResponseDTO)
            .map(ResponseEntity::ok)
            .orElseThrow(() -> new UserNotFoundException(id));
  }

  @GetMapping("/users")
  public ResponseEntity<List<UserResponseDTO>> getUsers() {
    final List<User> users = userService.findAllUsers();

    if (users.isEmpty()) {
      return ResponseEntity.noContent().build();
    }

    final List<UserResponseDTO> usersResponseDTO = users.stream()
            .map(UserMapper::toUserResponseDTO)
            .toList();

    return ResponseEntity.ok(usersResponseDTO);
  }

  @PostMapping("/users")
  public ResponseEntity<UserResponseDTO> saveUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

    userService.findByUsername(userRequestDTO.username())
            .ifPresent(u -> {
              throw new UserAlreadyExistsException(u.getUsername());
            });

    User user = UserMapper.toUser(userRequestDTO);
    user.setPassword(passwordEncoder.encode(user.getPassword()));

    Role role = roleService.ensureRoleExists("ROLE_USER");
    user.setRoles(List.of(role));

    User savedUser = userService.saveUser(user);
    UserResponseDTO userResponseDTO = UserMapper.toUserResponseDTO(savedUser);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(userResponseDTO.id())
                            .toUri())
            .body(userResponseDTO);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable long id) {
    userService.findUserById(id)
            .orElseThrow(() -> new UserNotFoundException(id));

    userService.deleteUser(id);
    
    return ResponseEntity.noContent().build();
  }
}
