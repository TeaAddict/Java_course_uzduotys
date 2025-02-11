package lt.techin.movie_studio_71.validation;

import jakarta.validation.ConstraintViolationException;
import lt.techin.movie_studio_71.controller.ErrorResponse;
import lt.techin.movie_studio_71.exception.AccessDeniedException;
import lt.techin.movie_studio_71.exception.MovieAlreadyExistsException;
import lt.techin.movie_studio_71.exception.UserAlreadyExistsException;
import lt.techin.movie_studio_71.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
    );

    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Map<String, String>> handleValidationErrors(ConstraintViolationException ex) {

    Map<String, String> errors = new HashMap<>();

    ex.getConstraintViolations().forEach(error -> {
      errors.put(error.getPropertyPath().toString(), error.getMessage());
    });

    return ResponseEntity.badRequest().body(errors);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleUserAlreadyExistsException(Exception ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MovieAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleMovieAlreadyExistsException(Exception ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ErrorResponse> handleAccessDeniedException(Exception ex) {
    return new ResponseEntity<>(new ErrorResponse(ex.getMessage(), HttpStatus.FORBIDDEN.value()), HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
    return new ResponseEntity<>(new ErrorResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
