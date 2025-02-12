package lt.techin.movie_studio_81.controller;

import lt.techin.movie_studio_81.model.Movie;
import lt.techin.movie_studio_81.security.SecurityConfig;
import lt.techin.movie_studio_81.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@WebMvcTest(controllers = MovieController.class)
@Import(SecurityConfig.class)
public class MovieControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private MovieService movieService;

  @Test
  @WithMockUser
  void getMovies_whenFindAll_thenReturnAlland200() throws Exception {
    // given
    List<Movie> movies = List.of(
            new Movie("Titan", "Jerry"),
            new Movie("Planetx", "Thomas"),
            new Movie("TheForest", "Jerry")
    );

    BDDMockito.given(movieService.getAllMovies()).willReturn(movies);

    // when


  }
}
