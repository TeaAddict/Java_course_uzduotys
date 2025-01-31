package lt.techin.movie_spring_3.exceptions;

public class MovieNotFoundException extends RuntimeException {
  public MovieNotFoundException(String message) {
    super(message);
  }
}
