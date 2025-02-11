package lt.techin.movie_studio_71.controller;

import jakarta.validation.Valid;
import lt.techin.movie_studio_71.dto.MovieDTO;
import lt.techin.movie_studio_71.dto.MovieMapper;
import lt.techin.movie_studio_71.exception.MovieAlreadyExistsException;
import lt.techin.movie_studio_71.model.Movie;
import lt.techin.movie_studio_71.service.MovieService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
  public ResponseEntity<List<MovieDTO>> getAllMovies() {
    List<MovieDTO> moviesDTO = MovieMapper.toMovieDTOList(movieService.getAllMovies());
    return ResponseEntity.ok(moviesDTO);
  }

  @GetMapping("/movies/{id}")
  public ResponseEntity<MovieDTO> getMovie(@PathVariable long id) {
    Movie movie = movieService.getMovieById(id).get();
    MovieDTO movieDTO = MovieMapper.toMovieDTO(movie);
    return ResponseEntity.ok(movieDTO);
  }

  @GetMapping("/movies/search/by-name")
  public ResponseEntity<?> getMovieByName(@RequestParam String name) {
    if (name == null || name.trim().isEmpty()) {
      return ResponseEntity.badRequest().body("Movie name missing");
    }

    List<Movie> movie = movieService.getAllMoviesByName(name);

    if (movie == null) {
      String responseBody = "Movie by name " + name + " does not exist";
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody);
    }

    return ResponseEntity.ok().body(movie);
  }

  @PostMapping("/movies")
  public ResponseEntity<MovieDTO> saveMovie(@Valid @RequestBody MovieDTO movieDTO) {

    if (movieService.existsMovieByNameAndDirector(movieDTO.name(), movieDTO.director())) {
      throw new MovieAlreadyExistsException(movieDTO.name());
    }

    Movie movie = MovieMapper.toMovie(movieDTO);
    Movie savedMovie = movieService.saveMovie(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedMovie.getId())
                            .toUri())
            .body(movieDTO);
  }

  @PutMapping("/movies/{id}")
  public ResponseEntity<?> updateMovie(@Valid @RequestBody MovieDTO movieDTO, @PathVariable long id) {
//    MovieDTO movieDTO = MovieMapper.toMovieDTO(movie);

    if (movieService.existsMovieById(id)) {
      Movie movieFromDb = movieService.findMovieById(id).get();

      movieFromDb.setName(movieDTO.name());
      movieFromDb.setDirector(movieDTO.director());
      movieFromDb.setDescription(movieDTO.description());
      movieFromDb.setScreenings(movieDTO.screenings());
      movieFromDb.setActors(movieDTO.actors());

      return ResponseEntity.ok(movieService.saveMovie(movieFromDb));
    }

    Movie movie = MovieMapper.toMovie(movieDTO);

    Movie savedMovie = movieService.saveMovie(movie);

    return ResponseEntity.created(
                    ServletUriComponentsBuilder.fromCurrentRequest()
                            .replacePath("/api/movies/{id}")
                            .buildAndExpand(savedMovie.getId())
                            .toUri())
            .body(movieDTO);
  }

  @DeleteMapping("/movies/{id}")
  public ResponseEntity<?> deleteMovie(@PathVariable long id) {
    movieService.deleteMovie(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/movies/pagination")
  public ResponseEntity<?> getMoviesPagination(@RequestParam int page,
                                               @RequestParam int size) {
    Page<Movie> pageMovie = movieService.findAllMoviesPage(page, size);

    Page<MovieDTO> movieDTOpage = MovieMapper.pageMoviesToMovieDTO(pageMovie);

    return ResponseEntity.ok(movieDTOpage);
  }
}
