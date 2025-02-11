package lt.techin.movie_studio_81.dto;

import lt.techin.movie_studio_81.model.Actor;

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
