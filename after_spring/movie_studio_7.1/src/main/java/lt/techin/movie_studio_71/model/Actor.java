package lt.techin.movie_studio_71.model;

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

  @Size(min = 2, max = 50)
  private String name;

  @Min(18)
  @Max(100)
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

//CREATE TABLE actors (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        name VARCHAR(50) NOT NULL,
//age INT NOT NULL
//);