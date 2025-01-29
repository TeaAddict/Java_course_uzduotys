package lt.techin.movie_management.controller;

import lt.techin.movie_management.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MovieController {
  private List<Movie> movies = new ArrayList<>();

  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> getMovies() {
    return ResponseEntity.ok(movies);
  }

  @GetMapping("/movies/{index}")
  public ResponseEntity<Movie> getMovie(@PathVariable int index) {
    if (index > movies.size() - 1) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(movies.get(index));
  }

  @PostMapping("/movies")
  public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
    if (movie.getId().isEmpty() || movie.getDirector().isEmpty() || movie.getTitle().isEmpty()) {
      return ResponseEntity.badRequest().build();
    }

    movies.add(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{index}")
                            .buildAndExpand(movies.size() - 1)
                            .toUri())
            .body(movie);
  }

  @GetMapping("/movies/search")
  public ResponseEntity<List<Movie>> searchMovie(@RequestParam String title) {
    List<Movie> res = movies.stream().filter(movie -> movie.getTitle().equalsIgnoreCase(title)).toList();

    return ResponseEntity.ok(res);
  }

}