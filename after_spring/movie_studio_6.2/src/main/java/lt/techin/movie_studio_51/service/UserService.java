package lt.techin.movie_studio_51.service;

import lt.techin.movie_studio_51.model.User;
import lt.techin.movie_studio_51.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public Optional<User> findUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

}
