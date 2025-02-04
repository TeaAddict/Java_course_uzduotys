package lt.techin.movie_studio_51.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "actors")
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Size(min = 2, max = 50, message = "Actor name size should be between 2-50 characters")
  private String name;

  @Min(value = 18, message = "Minimum age is 18")
  @Max(value = 110, message = "Maximum age is 130")
  private int age;

  public Actor(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Actor() {
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
