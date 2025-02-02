package lt.techin.movie_spring_3.controller;

import lt.techin.movie_spring_3.exceptions.MovieNotFoundException;
import lt.techin.movie_spring_3.model.Movie;
import lt.techin.movie_spring_3.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieController {
  private final MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> getMovies() {
    return ResponseEntity.ok(movieService.getAllMovies());
  }

  @GetMapping("/movies/{id}")
  public ResponseEntity<?> getMovie(@PathVariable long id) {
    Optional<Movie> movie = movieService.getMovieById(id);

    if (movie.isEmpty()) {
      return ResponseEntity.badRequest().body("Movie missing");
    }

    return ResponseEntity.ok(movie.get());
  }

  @GetMapping("/movies/search")
  public ResponseEntity<?> findMovie(@RequestParam String title) {
    if (title.length() > 100) {
      return ResponseEntity.badRequest().body("Provided title is over 100 characters");
    }

    for (Movie movie : movieService.getAllMovies()) {
      if (movie.getTitle().equalsIgnoreCase(title)) {
        return ResponseEntity.ok().body(movie);
      }
    }

    return ResponseEntity.badRequest().body("Movie not found...");
  }

  @PostMapping("/movies")
  public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
    String title = movie.getTitle();
    String director = movie.getDirector();

    if (title == null) {
      return ResponseEntity.badRequest().body("Missing title");
    }

    if (director == null) {
      return ResponseEntity.badRequest().body("Missing director");
    }

    if (title.length() >= 100) {
      return ResponseEntity.badRequest().body("'Title' length is over 100 characters");
    }

    if (director.length() >= 50) {
      return ResponseEntity.badRequest().body("'Director' length is over 50 characters");
    }

    if (movieService.existsMovieByTitle(title) && movieService.existsMovieByDirector(director)) {
      return ResponseEntity.badRequest().body("A movie with such title and director already exists");
    }

    Movie savedMovie = movieService.saveMovie(movie);

    // Nebutinas...
    if (savedMovie != null) {
      return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

  @PutMapping("/movies/{id}")
  public ResponseEntity<?> updateMovie(@PathVariable long id, @RequestBody Movie movie) {
    Optional<Movie> optionalMovie = movieService.findMovieById(id);
    String title = movie.getTitle();
    String director = movie.getDirector();

    if (movie.getTitle() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing title");
    }

    if (movie.getDirector() == null) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing director");
    }

    if (title.length() >= 100) {
      return ResponseEntity.badRequest().body("'Title' length is over 100 characters");
    }

    if (director.length() >= 50) {
      return ResponseEntity.badRequest().body("'Director' length is over 50 characters");
    }

    if (optionalMovie.isPresent()) {
      Movie movieToUpdate = optionalMovie.get();
      movieToUpdate.setTitle(movie.getTitle());
      movieToUpdate.setDirector(movie.getDirector());
      movieService.saveMovie(movieToUpdate);
      return ResponseEntity.ok(movieToUpdate);
    } else {
      throw new MovieNotFoundException("Movie not found with id " + id);
    }
  }

  @DeleteMapping("/movies/{id}")
  public ResponseEntity<?> deleteMovie(@PathVariable long id) {
    Optional<Movie> movie = movieService.findMovieById(id);

    if (movie.isEmpty()) {
      return ResponseEntity.badRequest().body("Movie does not exist");
    }

    movieService.deleteMovieById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
