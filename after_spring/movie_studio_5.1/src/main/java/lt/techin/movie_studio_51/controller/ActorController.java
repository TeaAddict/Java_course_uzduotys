package lt.techin.movie_studio_51.controller;

import lt.techin.movie_studio_51.model.Actor;
import lt.techin.movie_studio_51.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActorController {
  ActorService actorService;

  @Autowired
  public ActorController(ActorService actorService) {
    this.actorService = actorService;
  }

  @GetMapping("/actors")
  public ResponseEntity<List<Actor>> getAllActors() {
    List<Actor> actors = actorService.getAllActors();
    return ResponseEntity.ok().body(actors);
  }

  @PostMapping("/actors")
  public ResponseEntity<Actor> saveActor(@RequestBody Actor actor) {

    Actor savedActor = actorService.saveActor(actor);

    return ResponseEntity.created(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .replacePath("/actor/{id}")
                    .buildAndExpand(actor.getId())
                    .toUri())
            .body(savedActor);
  }
}
