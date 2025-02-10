package lt.techin.movie_studio_71.controller;

public class ErrorResponse {
  private String message;
  private int status;

  public ErrorResponse(String message, int status) {
    this.message = message;
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatusCode() {
    return status;
  }

  public void setStatusCode(int status) {
    this.status = status;
  }
}
