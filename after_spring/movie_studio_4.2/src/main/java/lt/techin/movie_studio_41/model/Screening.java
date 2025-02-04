package lt.techin.movie_studio_41.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
public class Screening {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String theaterName;
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