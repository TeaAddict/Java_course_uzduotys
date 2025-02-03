package lt.techin.movie_studio_41.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String description;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "movie_id")
  private List<Screening> screenings;

//  @ManyToMany
//  @JoinTable(
//          name = "theaters_movies",
//          joinColumns = @JoinColumn(name = "movie_id"),
//          inverseJoinColumns = @JoinColumn(name = "theater_id")
//  )
//  private List<Theater> theaters;

  public Movie(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Movie() {
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Screening> getScreenings() {
    return screenings;
  }

  public void setScreenings(List<Screening> screenings) {
    this.screenings = screenings;
  }
}

//CREATE TABLE movies (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        name VARCHAR(50) NOT NULL,
//description VARCHAR(100)
//);