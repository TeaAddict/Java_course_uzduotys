package lt.techin.movie_studio_51.controller;

import jakarta.validation.Valid;
import lt.techin.movie_studio_51.dto.ActorDTO;
import lt.techin.movie_studio_51.dto.ActorMapper;
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
  public ResponseEntity<List<ActorDTO>> getAllActors() {
    List<Actor> actors = actorService.getAllActors();
    List<ActorDTO> actorsDTO = ActorMapper.toActorDTOLIST(actors);
    return ResponseEntity.ok().body(actorsDTO);
  }

  @PostMapping("/actors")
  public ResponseEntity<ActorDTO> saveActor(@Valid @RequestBody Actor actor) {

    Actor savedActor = actorService.saveActor(actor);
    ActorDTO savedActorDTO = ActorMapper.toActorDTO(savedActor);

    return ResponseEntity.created(ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .replacePath("/actor/{id}")
                    .buildAndExpand(actor.getId())
                    .toUri())
            .body(savedActorDTO);
  }
}
