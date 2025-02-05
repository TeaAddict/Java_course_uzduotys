package lt.techin.movie_studio_41.model;

import jakarta.persistence.*;

@Entity
@Table(name = "theaters")
public class Theater {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;
  private String description;


  public Theater(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Theater() {
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
}


//CREATE TABLE theaters (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        name VARCHAR(50) NOT NULL,
//        description VARCHAR(100)
//);

//CREATE TABLE theaters_movies (
//        id BIGINT AUTO_INCREMENT PRIMARY KEY,
//        theater_id BIGINT NOT NULL,
//        movie_id BIGINT NOT NULL,
//        FOREIGN KEY (theater_id) REFERENCES theaters(id),
//FOREIGN KEY (movie_id) REFERENCES movies(id)
//        );