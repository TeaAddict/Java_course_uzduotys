package lt.techin.movie_studio_81.controller;

import lt.techin.movie_studio_81.model.Movie;
import lt.techin.movie_studio_81.security.SecurityConfig;
import lt.techin.movie_studio_81.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = MovieController.class)
@Import({SecurityConfig.class, TestJwtConfig.class})
public class MovieControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private TestJwtConfig testJwtConfig;

  @MockitoBean
  private MovieService movieService;

  // Happy path
  @Test
  @WithMockUser
  void getMovies_whenFindAll_thenReturnAlland200() throws Exception {

    // given
    List<Movie> movies = List.of(
            new Movie("Titan", "Jerry", "Best movie ever"),
            new Movie("Planetx", "Thomas"),
            new Movie("TheForest", "Jerry")
    );

    BDDMockito.given(movieService.getAllMovies()).willReturn(movies);

    String token = testJwtConfig.generateTestToken("test", "ROLE_USER");

    // WHEN
    mockMvc.perform(MockMvcRequestBuilders.get("/api/movies")
                    .header("Authorization", "Bearer " + token))
            // THEN
            .andExpect(status().isOk())
            .andExpect(jsonPath("length()").value(2))
            .andExpect(jsonPath("[0].id").exists())
            .andExpect(jsonPath("[0].name").value("Titan"));

    Mockito.verify(movieService, times(1)).getAllMovies();
  }
}
