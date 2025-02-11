package lt.techin.movie_studio_81.exception;

public class MovieNotFoundException extends RuntimeException {
  public MovieNotFoundException(String message) {
    super(message);
  }
}
