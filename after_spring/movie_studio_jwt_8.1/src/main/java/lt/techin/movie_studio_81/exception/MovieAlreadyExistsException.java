package lt.techin.movie_studio_81.exception;

public class MovieAlreadyExistsException extends RuntimeException {
  public MovieAlreadyExistsException(String name) {
    super("Movie with name: " + name + ", already exists");
  }
}
