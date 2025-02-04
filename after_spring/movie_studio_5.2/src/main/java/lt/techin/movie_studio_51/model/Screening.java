package lt.techin.movie_studio_51.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
public class Screening {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull(message = "Name cant be null")
  @Size(min = 2, max = 50, message = "Name size should be between 2 and 50")
  private String theaterName;

  @NotNull
  private LocalDateTime screeningTime;

  public Screening() {
  }

  public long getId() {
    return id;
  }

  public String getTheaterName() {
    return theaterName;
  }

  public void setTheaterName(String theaterName) {
    this.theaterName = theaterName;
  }

  public LocalDateTime getScreeningTime() {
    return screeningTime;
  }

  public void setScreeningTime(LocalDateTime screeningTime) {
    this.screeningTime = screeningTime;
  }
}

//CREATE TABLE screenings (
//        id BIGINT PRIMARY KEY AUTO_INCREMENT,
//        theater_name VARCHAR(50) NOT NULL,
//        screening_time datetime NOT NULL,
//        movie_id BIGINT,
//        FOREIGN KEY (movie_id) REFERENCES movies(id)
//        );


//"screenings":[  {
//        "theaterName":"asd",
//        "screeningTime":"1999-12-12T00:00:00"
//        }
//        ]