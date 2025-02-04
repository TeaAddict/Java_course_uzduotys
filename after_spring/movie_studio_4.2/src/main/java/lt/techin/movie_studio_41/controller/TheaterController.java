package lt.techin.movie_studio_41.controller;

import lt.techin.movie_studio_41.model.Theater;
import lt.techin.movie_studio_41.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TheaterController {
  private final TheaterService theaterService;

  @Autowired
  public TheaterController(TheaterService theaterService) {
    this.theaterService = theaterService;
  }

  @GetMapping("/theaters")
  public List<Theater> getAllTheaters() {
    return theaterService.getAllTheaters();
  }

  
}
