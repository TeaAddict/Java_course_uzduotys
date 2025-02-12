package lt.techin.movie_studio_81.exception;

public class AccessDeniedException extends RuntimeException {
  public AccessDeniedException() {
    super("You can only update your own details");
  }
}
