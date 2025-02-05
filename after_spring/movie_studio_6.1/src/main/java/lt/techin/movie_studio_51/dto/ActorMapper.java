package lt.techin.movie_studio_51.dto;

import lt.techin.movie_studio_51.model.Actor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class ActorMapper {

  public static List<ActorDTO> toActorDTOLIST(List<Actor> actorList) {
    return actorList.stream().map(actor ->
            new ActorDTO(actor.getName(), actor.getAge())).toList();
  }

  public static ActorDTO toActorDTO(Actor actor) {
    return new ActorDTO(actor.getName(), actor.getAge());
  }

  public static Actor toActor(ActorDTO actorDTO) {
    return new Actor(actorDTO.name(), actorDTO.age());
  }

}
