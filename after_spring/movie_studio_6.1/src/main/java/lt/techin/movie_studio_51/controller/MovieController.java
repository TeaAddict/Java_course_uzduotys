package lt.techin.movie_studio_51.controller;

import jakarta.validation.Valid;
import lt.techin.movie_studio_51.model.Movie;
import lt.techin.movie_studio_51.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
  private final MovieService movieService;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> getAllMovies() {
    return ResponseEntity.ok(movieService.getAllMovies());
  }

  @PostMapping("/movies")
  public ResponseEntity<Movie> saveMovie(@Valid @RequestBody Movie movie) {
    Movie savedMovie = movieService.saveMovie(movie);
    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedMovie.getId())
                            .toUri())
            .body(savedMovie);
  }

  @PutMapping("/movies/{id}")
  public ResponseEntity<?> updateMovie(@Valid @RequestBody Movie movie, @PathVariable long id) {

    if (movieService.existsMovieById(id)) {
      Movie movieFromDb = movieService.findMovieById(id).get();

      movieFromDb.setName(movie.getName());
      movieFromDb.setDirector(movie.getDirector());
      movieFromDb.setDescription(movie.getDescription());
      movieFromDb.setScreenings(movie.getScreenings());
      movieFromDb.setActors(movie.getActors());

      return ResponseEntity.ok(movieService.saveMovie(movieFromDb));
    }

    Movie savedMovie = movieService.saveMovie(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .replacePath("/api/movies/{id}")
                            .buildAndExpand(savedMovie.getId())
                            .toUri())
            .body(movie);
  }
}
