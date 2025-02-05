package lt.techin.movie_studio_41.controller;

import lt.techin.movie_studio_41.model.Movie;
import lt.techin.movie_studio_41.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
    Movie savedMovie = movieService.saveMovie(movie);
    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedMovie.getId())
                            .toUri())
            .body(savedMovie);
  }

  @PutMapping("/movies/{id}")
  public ResponseEntity<?> updateMovie(@RequestBody Movie movie, @PathVariable long id) {
    if (movie.getName().isEmpty()) {
      return ResponseEntity.badRequest().body("Name is missing");
    }

    if (movieService.existsMovieById(id)) {
      Movie movieFromDb = movieService.findMovieById(id).get();

      movieFromDb.setName(movie.getName());
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

  @GetMapping("/movies/pagination")
  public ResponseEntity<?> getMoviesPage(@RequestParam int page,
                                         @RequestParam int size,
                                         @RequestParam(required = false) String sort) {

    return ResponseEntity.ok(movieService.findAllMoviePage(page, size, sort));
  }
}
