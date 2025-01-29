package lt.techin.demo_2_diena.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

  @GetMapping("/hello")
  public ResponseEntity<String> getHello() {
    return ResponseEntity.ok("Hello, Spring Web!");
  }
}
